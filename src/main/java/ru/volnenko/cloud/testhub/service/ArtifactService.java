package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.dto.ValueDto;
import ru.volnenko.cloud.testhub.enumerated.ArtifactType;
import ru.volnenko.cloud.testhub.model.Artifact;
import ru.volnenko.cloud.testhub.model.Jacoco;

import java.util.List;

@Service
public interface ArtifactService {

    @NonNull
    @Transactional
    Artifact save(@NonNull String name, @NonNull String groupId);

    @NonNull
    @Transactional
    Artifact save(
            @NonNull String name,
            @NonNull String groupId,
            @NonNull ArtifactType artifactType
    );

    @NonNull
    @Transactional
    Artifact merge(
            @NonNull String name,
            @NonNull String groupId,
            @NonNull ArtifactType artifactType
    );

    @NonNull
    @Transactional
    Artifact save(
            @NonNull String name,
            @NonNull String groupId,
            @NonNull ArtifactType artifactType,
            @NonNull ValueDto valueDto
    );

    @NonNull
    @Transactional
    Artifact merge(
            @NonNull String name,
            @NonNull String groupId,
            @NonNull ArtifactType artifactType,
            @NonNull ValueDto valueDto
    );

    @NonNull
    @Transactional(readOnly = true)
    List<Artifact> findAll();

    @NonNull
    @Transactional(readOnly = true)
    List<Artifact> findAllArtifact();

    @NonNull
    @Transactional(readOnly = true)
    List<Artifact> findAllApplication();

    @NonNull
    @Transactional(readOnly = true)
    List<Artifact> findAllLibrary();

    @Transactional(readOnly = true)
    long count();

    @NonNull
    @Transactional
    Artifact save(@NonNull Artifact artifact);

    @Transactional(readOnly = true)
    Artifact findByNameAndGroupId(@NonNull String name, @NonNull String groupId);

    @Transactional(readOnly = true)
    Artifact findById(@NonNull String id);
}
