package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Release;
import ru.volnenko.cloud.testhub.repository.ReleaseRepository;

@Service
public class ReleaseServiceBean implements ReleaseService {

    @Autowired
    private ReleaseRepository releaseRepository;

    @Override
    @Transactional(readOnly = true)
    public Release findByArtifactIdAndVersionId(@NonNull final String artifactId, @NonNull final String versionId) {
        return releaseRepository.findByArtifactIdAndVersionId(artifactId, versionId);
    }

    @NonNull
    @Override
    @Transactional
    public Release mergeByArtifactIdAndVersionId(@NonNull final String artifactId, @NonNull final String versionId) {
        final Release release = findByArtifactIdAndVersionId(artifactId, versionId);
        if (release != null) return release;
        return saveByArtifactIdAndVersionId(artifactId, versionId);
    }

    @NonNull
    @Override
    @Transactional
    public Release saveByArtifactIdAndVersionId(@NonNull final String artifactId, @NonNull final String versionId) {
        @NonNull final Release release = new Release();
        release.setArtifactId(artifactId);
        release.setVersionId(versionId);
        return releaseRepository.save(release);
    }

}
