package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.model.Jacoco;

@Service
public interface JacocoService {

    @NonNull
    Jacoco create(String releaseId, Float instructions, Float branches);

}
