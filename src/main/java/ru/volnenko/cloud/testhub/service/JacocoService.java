package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Jacoco;

import java.util.List;

@Service
public interface JacocoService {

    @NonNull
    Jacoco create(
            @NonNull String releaseId,
            @NonNull String artifactId,
            @NonNull String versionId,
            @NonNull String branchId,
            @NonNull Float coverage,
            @NonNull Float instructions,
            @NonNull Float branches
    );

    @NonNull
    @Transactional(readOnly = true)
    List<Jacoco> findAllByArtifactId(@NonNull String artifactId);
}
