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
    default Version mergeByName(@NonNull String name) {
        final Version version = findByName(name);
        if (version != null) return version;
        return saveByName(name);
    }

    @NonNull
    @Transactional
    Version save(@NonNull Version version);

    @NonNull
    @Transactional
    default Version saveByName(@NonNull String name) {
        @NonNull final Version version = new Version();
        version.setName(name);
        return save(version);
    }

}
