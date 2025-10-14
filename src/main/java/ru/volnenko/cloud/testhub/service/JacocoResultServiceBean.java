package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;
import ru.volnenko.cloud.testhub.enumerated.ArtifactType;
import ru.volnenko.cloud.testhub.model.Artifact;
import ru.volnenko.cloud.testhub.model.Group;
import ru.volnenko.cloud.testhub.model.Jacoco;
import ru.volnenko.cloud.testhub.model.Version;

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

    @Override
    @NonNull
    public Jacoco publish(@NonNull final JacocoResultDto result) {
        @NonNull final String groupName = result.getGroup();
        @NonNull final Group group = groupService.mergeByName(groupName);
        @NonNull final String versionName = result.getVersion();
        @NonNull final Version version = versionService.mergeByName(versionName);
        @NonNull final String artifactName = result.getArtifact();
        @NonNull final ArtifactType artifactType = ArtifactType.valueOf(result.getType());
        @NonNull final Artifact artifact = artifactService.merge(artifactName, group.getId(), artifactType);
        return new Jacoco();
    }

}
