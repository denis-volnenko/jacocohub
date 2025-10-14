package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Artifact;
import ru.volnenko.cloud.testhub.repository.ArtifactRepository;

import java.util.List;

@Service
public class ArtifactServiceBean implements ArtifactService {

    @Autowired
    private ArtifactRepository artifactRepository;

    @NonNull
    @Override
    @Transactional(readOnly = true)
    public List<Artifact> findAll() {
        return artifactRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return artifactRepository.count();
    }

    @Override
    @NonNull
    @Transactional
    public Artifact save(@NonNull final Artifact artifact) {
        return artifactRepository.save(artifact);
    }

}
