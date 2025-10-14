package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Artifact;

import java.util.List;

@Service
public interface ArtifactService {

    @NonNull
    @Transactional(readOnly = true)
    List<Artifact> findAll();

    @Transactional(readOnly = true)
    long count();

    @NonNull
    @Transactional
    Artifact save(@NonNull Artifact artifact);

}
