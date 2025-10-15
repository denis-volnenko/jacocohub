package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Version;
import ru.volnenko.cloud.testhub.repository.VersionRepository;

@Service
public class VersionServiceBean implements VersionService {

    @Autowired
    private VersionRepository versionRepository;

    @Override
    @Transactional(readOnly = true)
    public Version findByName(@NonNull final String name) {
        return versionRepository.findByName(name);
    }

    @NonNull
    @Override
    @Transactional
    public Version save(@NonNull final Version version) {
        return versionRepository.save(version);
    }

    @NonNull
    @Override
    @Transactional
    public Version saveByName(@NonNull String name) {
        @NonNull final Version version = new Version();
        version.setName(name);
        return save(version);
    }

    @NonNull
    @Override
    @Transactional
    public Version mergeByName(@NonNull String name) {
        final Version version = findByName(name);
        if (version != null) return version;
        return saveByName(name);
    }

    @Override
    @Transactional
    public Version findById(@NonNull final String id) {
        return versionRepository.findById(id).orElse(null);
    }

    @Override
    @Cacheable(cacheNames = "version", key = "id")
    public Version cacheById(@NonNull final String id) {
        return findById(id);
    }

}
