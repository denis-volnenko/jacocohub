package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.dto.ValueDto;
import ru.volnenko.cloud.testhub.model.Jacoco;

import java.util.List;

@Service
public interface JacocoService {

    @NonNull
    Jacoco create(
            @NonNull String artifactId,
            @NonNull String versionId,
            @NonNull String branchId,
            @NonNull ValueDto valueDto
    );

    @NonNull
    @Transactional(readOnly = true)
    List<Jacoco> findAllByArtifactId(@NonNull String artifactId);
}
