package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Jacoco;
import ru.volnenko.cloud.testhub.repository.JacocoRepository;

import java.util.List;

@Service
public class JacocoServiceBean implements JacocoService {

    @Autowired
    private JacocoRepository jacocoRepository;

    @NonNull
    @Override
    public Jacoco create(
            @NonNull final String releaseId,
            @NonNull final String branchId,
            @NonNull final Float instructions,
            @NonNull final Float branches
    ) {
        @NonNull final Jacoco jacoco = new Jacoco();
        jacoco.setReleaseId(releaseId);
        @NonNull final Float percent = (branches + instructions) / 2;
        jacoco.setBranches(branches);
        jacoco.setInstructions(instructions);
        jacoco.setPercent(percent);
        jacoco.setBranchId(branchId);
        return jacocoRepository.save(jacoco);
    }

    @Override
    @NonNull
    @Transactional(readOnly = true)
    public List<Jacoco> findAllByArtifactId(@NonNull final String artifactId) {
        return jacocoRepository.findAllByArtifactId(artifactId);
    }

}
