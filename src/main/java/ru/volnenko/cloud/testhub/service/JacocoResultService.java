package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;
import ru.volnenko.cloud.testhub.model.Jacoco;

@Service
public class JacocoResultService {

    @Autowired
    private ArtifactService artifactService;

    @NonNull
    public Jacoco publish(@NonNull final JacocoResultDto result) {
        return new Jacoco();
    }

}
