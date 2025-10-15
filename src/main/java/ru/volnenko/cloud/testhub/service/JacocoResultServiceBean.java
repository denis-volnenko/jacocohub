package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;
import ru.volnenko.cloud.testhub.enumerated.ArtifactType;
import ru.volnenko.cloud.testhub.model.*;

@Service
public class JacocoResultServiceBean implements JacocoResultService {

    @Autowired
    private ArtifactService artifactService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private VersionService versionService;

    @Autowired
    private ReleaseService releaseService;

    @Autowired
    private JacocoService jacocoService;

    @Autowired
    private BranchService branchService;

    @Override
    @NonNull
    @Transactional
    public Jacoco publish(@NonNull final JacocoResultDto result) {
        @NonNull final Float branches = result.getBranches();
        @NonNull final Float instructions = result.getInstructions();
        @NonNull final Float coverage = (branches + instructions) / 2;
        @NonNull final String branchName = result.getBranch();
        @NonNull final Branch branch = branchService.mergeByName(branchName);
        @NonNull final String groupName = result.getGroup();
        @NonNull final Group group = groupService.mergeByName(groupName);
        @NonNull final String versionName = result.getVersion();
        @NonNull final Version version = versionService.mergeByName(versionName);
        @NonNull final String artifactName = result.getArtifact();
        @NonNull final ArtifactType artifactType = ArtifactType.valueOf(result.getType());
        @NonNull final Artifact artifact = artifactService.merge(artifactName, group.getId(), artifactType, coverage, instructions, branches);
        @NonNull final Release release = releaseService.mergeByArtifactIdAndVersionId(artifact.getId(), version.getId());
        return jacocoService.create(release.getId(), branch.getId(), coverage, instructions, branches);
    }

}
