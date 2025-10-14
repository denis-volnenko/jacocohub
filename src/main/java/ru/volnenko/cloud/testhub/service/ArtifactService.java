package ru.volnenko.cloud.testhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.model.Artifact;
import ru.volnenko.cloud.testhub.repository.ArtifactRepository;

import java.util.List;

@Service
public class ArtifactService {

    @Autowired
    private ArtifactRepository artifactRepository;

    public List<Artifact> findAll() {
        return artifactRepository.findAll();
    }

}
