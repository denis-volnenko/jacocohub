package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.model.Jacoco;

@Service
public interface JacocoService {

    @NonNull
    Jacoco create(
            @NonNull String releaseId,
            @NonNull String branchId,
            @NonNull Float instructions,
            @NonNull Float branches
    );

}
