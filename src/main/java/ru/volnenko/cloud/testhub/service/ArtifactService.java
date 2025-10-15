package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.apache.tomcat.jni.Library;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.enumerated.ArtifactType;
import ru.volnenko.cloud.testhub.model.Artifact;

import java.util.List;
import java.util.Optional;

@Service
public interface ArtifactService {

    @NonNull
    @Transactional
    Artifact save(@NonNull String name, @NonNull String groupId);

    @NonNull
    @Transactional
    Artifact save(@NonNull String name, @NonNull String groupId, @NonNull ArtifactType artifactType);

    @NonNull
    @Transactional
    Artifact merge(@NonNull String name, @NonNull String groupId, @NonNull ArtifactType artifactType);

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
    List<Library> findAllLibrary();

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
