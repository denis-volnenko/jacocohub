package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Version;

@Service
public interface VersionService {

    @Transactional(readOnly = true)
    Version findByName(@NonNull String name);

    @NonNull
    @Transactional
    Version save(@NonNull Version version);

    @NonNull
    @Transactional
    Version saveByName(@NonNull String name);

    @NonNull
    @Transactional
    Version mergeByName(@NonNull String name);

    @Transactional
    Version findById(@NonNull String id);
}
