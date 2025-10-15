package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;
import ru.volnenko.cloud.testhub.enumerated.ArtifactType;
import ru.volnenko.cloud.testhub.exception.ArtifactEmptyException;
import ru.volnenko.cloud.testhub.exception.BranchEmptyException;
import ru.volnenko.cloud.testhub.exception.GroupEmptyException;
import ru.volnenko.cloud.testhub.exception.VersionEmptyException;
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

    @Autowired
    private PathService pathService;

    @Autowired
    private ParentService parentService;

    @Autowired
    private ChildService childService;

    @Override
    @NonNull
    @Transactional
    public Jacoco publish(@NonNull final JacocoResultDto result) {
        @NonNull final Float branches = result.getBranches();
        @NonNull final Float instructions = result.getInstructions();
        @NonNull final Float coverage = (branches + instructions) / 2;
        @NonNull final String branchName = result.getBranch();
        @NonNull final Branch branch = branchService.mergeByName(branchName);
        if (branchName.isEmpty()) throw new BranchEmptyException();
        @NonNull final String groupName = result.getGroup();
        if (groupName.isEmpty()) throw new GroupEmptyException();
        @NonNull final Group group = groupService.mergeByName(groupName);
        @NonNull final String versionName = result.getVersion();
        if (versionName.isEmpty()) throw new VersionEmptyException();
        @NonNull final Version version = versionService.mergeByName(versionName);
        @NonNull final String artifactName = result.getArtifact();
        if (artifactName.isEmpty()) throw new ArtifactEmptyException();
        @NonNull final ArtifactType artifactType = ArtifactType.valueOf(result.getType());
        @NonNull final Artifact artifact = artifactService.merge(artifactName, group.getId(), artifactType, coverage, instructions, branches);
        @NonNull final Release release = releaseService.mergeByArtifactIdAndVersionId(artifact.getId(), version.getId());
        @NonNull Jacoco jacoco = jacocoService.create(release.getId(), branch.getId(), coverage, instructions, branches);

        final Artifact parent = parent(result);
        if (parent != null) {
            final Artifact child = child(artifact);
        }

        return jacoco;
    }

    @NonNull
    private Artifact child(@NonNull final Artifact artifact) {
        childService.merge(artifact);
        return artifact;
    }

    private Artifact parent(@NonNull final JacocoResultDto result) {
        @NonNull final String branchName = result.getBranch();
        if (branchName.isEmpty()) return null;
        @NonNull final Branch branch = branchService.mergeByName(branchName);

        @NonNull final String groupName = result.getParentGroup();
        if (groupName.isEmpty()) return null;
        @NonNull final Group group = groupService.mergeByName(groupName);

        @NonNull final String versionName = result.getParentVersion();
        if (versionName.isEmpty()) return null;
        @NonNull final Version version = versionService.mergeByName(versionName);

        @NonNull final String artifactName = result.getParentArtifact();
        if (artifactName.isEmpty()) return null;

        @NonNull final ArtifactType artifactType = ArtifactType.valueOf(result.getParentType());
        @NonNull final Artifact artifact = artifactService.merge(artifactName, group.getId(), artifactType);
        @NonNull final Release release = releaseService.mergeByArtifactIdAndVersionId(artifact.getId(), version.getId());

        parentService.merge(artifactName);

        return artifact;
    }

}
