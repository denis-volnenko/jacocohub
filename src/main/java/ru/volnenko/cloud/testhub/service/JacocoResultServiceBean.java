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

    @Override
    @NonNull
    @Transactional
    public Jacoco publish(@NonNull final JacocoResultDto result) {
        @NonNull final String groupName = result.getGroup();
        @NonNull final Group group = groupService.mergeByName(groupName);
        @NonNull final String versionName = result.getVersion();
        @NonNull final Version version = versionService.mergeByName(versionName);
        @NonNull final String artifactName = result.getArtifact();
        @NonNull final ArtifactType artifactType = ArtifactType.valueOf(result.getType());
        @NonNull final Artifact artifact = artifactService.merge(artifactName, group.getId(), artifactType);
        @NonNull final Release release = releaseService.mergeByArtifactIdAndVersionId(artifact.getId(), version.getId());
        return jacocoService.create(release.getId(), result.getInstructions(), result.getBranches());
    }

}
