package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Release;

@Service
public interface ReleaseService {

    @Transactional(readOnly = true)
    Release findByArtifactIdAndVersionId(@NonNull String artifactId, @NonNull String versionId);

    @NonNull
    @Transactional
    Release mergeByArtifactIdAndVersionId(@NonNull String artifactId, @NonNull String versionId);

    @NonNull
    @Transactional
    Release saveByArtifactIdAndVersionId(@NonNull String artifactId, @NonNull String versionId);

    @Transactional(readOnly = true)
    Release findById(@NonNull String id);

    Release cacheById(@NonNull String id);

}
