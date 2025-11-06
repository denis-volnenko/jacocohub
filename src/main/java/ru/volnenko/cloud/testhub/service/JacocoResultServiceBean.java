package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.dto.ValueDto;
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

    @Override
    @NonNull
    public Jacoco publish(@NonNull final JacocoResultDto result) {
        @NonNull Data data = process(result);
        return data.jacoco;
    }

    @lombok.Data
    private class Data {

        private JacocoResultDto result;
        private Artifact artifact;
        private Version version;
        private Branch branch;
        private Jacoco jacoco;

    }

    @NonNull
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Data process(@NonNull final JacocoResultDto result) {
        ValueDto valueDto = new ValueDto(result);

        @NonNull final String branchName = result.getBranch();
        @NonNull final Branch branch = branchService.mergeByName(branchName);
        if (branchName.isEmpty()) throw new BranchEmptyException();
        @NonNull final String groupName = result.getGroupId();
        if (groupName.isEmpty()) throw new GroupEmptyException();
        @NonNull final Group group = groupService.mergeByName(groupName);
        @NonNull final String versionName = result.getVersion();
        if (versionName.isEmpty()) throw new VersionEmptyException();
        @NonNull final Version version = versionService.mergeByName(versionName);
        @NonNull final String artifactName = result.getArtifactId();
        if (artifactName.isEmpty()) throw new ArtifactEmptyException();
        @NonNull final ArtifactType artifactType = ArtifactType.valueOf(result.getType());
        @NonNull final Artifact artifact = artifactService.merge(artifactName, group.getId(), artifactType, valueDto);
        @NonNull final Release release = releaseService.mergeByArtifactIdAndVersionId(artifact.getId(), version.getId());
        @NonNull Jacoco jacoco = jacocoService.create(artifact.getId(), version.getId(), branch.getId(), valueDto);

        @NonNull final Data data = new Data();
        data.setJacoco(jacoco);
        data.setResult(result);
        data.setBranch(branch);
        data.setVersion(version);
        data.setArtifact(artifact);
        return data;
    }

}
