package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.enumerated.ArtifactType;
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

    @NonNull
    @Override
    @Transactional(readOnly = true)
    public List<Artifact> findAllArtifact() {
        return artifactRepository.findAllArtifact();
    }

    @NonNull
    @Override
    @Transactional(readOnly = true)
    public List<Artifact> findAllApplication() {
        return artifactRepository.findAllApplication();
    }

    @NonNull
    @Override
    @Transactional(readOnly = true)
    public List<Artifact> findAllLibrary() {
        return artifactRepository.findAllLibrary();
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

    @NonNull
    @Override
    @Transactional
    public Artifact save(@NonNull final String name, @NonNull final String groupId) {
        @NonNull final Artifact artifact = new Artifact();
        artifact.setGroupId(groupId);
        artifact.setName(name);
        return save(artifact);
    }

    @NonNull
    @Override
    @Transactional
    public Artifact merge(
            @NonNull final String name,
            @NonNull final String groupId,
            @NonNull final ArtifactType artifactType,
            @NonNull final Float coverage,
            @NonNull final Float instructions,
            @NonNull final Float branches
    ) {
        final Artifact artifact = findByNameAndGroupId(name, groupId);
        if (artifact != null) return artifact;
        return save(name, groupId, artifactType, coverage, instructions, branches);
    }

    @Override
    @Transactional
    public Artifact save(
            @NonNull final String name,
            @NonNull final String groupId,
            @NonNull final ArtifactType artifactType,
            @NonNull final Float coverage,
            @NonNull final Float instructions,
            @NonNull final Float branches
    ) {
        @NonNull final Artifact artifact = new Artifact();
        artifact.setGroupId(groupId);
        artifact.setName(name);
        artifact.setType(artifactType);
        artifact.setCoverage(coverage);
        artifact.setInstructions(instructions);
        artifact.setBranches(branches);
        return save(artifact);
    }

    @Override
    @Transactional(readOnly = true)
    public Artifact findByNameAndGroupId(@NonNull final String name, @NonNull final String groupId) {
        return artifactRepository.findByNameAndGroupId(name, groupId);
    }

    @Override
    @Transactional(readOnly = true)
    public Artifact findById(@NonNull final String id) {
        return artifactRepository.findById(id).orElse(null);
    }

}
