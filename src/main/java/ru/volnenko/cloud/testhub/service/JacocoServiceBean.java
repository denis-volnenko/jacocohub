package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.model.Jacoco;
import ru.volnenko.cloud.testhub.repository.JacocoRepository;

@Service
public class JacocoServiceBean implements JacocoService {

    @Autowired
    private JacocoRepository jacocoRepository;

    @NonNull
    @Override
    public Jacoco create(
            @NonNull final String releaseId,
            @NonNull final Float instructions,
            @NonNull final Float branches
    ) {
        @NonNull final Jacoco jacoco = new Jacoco();
        jacoco.setReleaseId(releaseId);
        @NonNull final Float percent = (branches + instructions) / 2;
        jacoco.setBranches(branches);
        jacoco.setInstructions(instructions);
        jacoco.setPercent(percent);
        return jacocoRepository.save(jacoco);
    }

}
