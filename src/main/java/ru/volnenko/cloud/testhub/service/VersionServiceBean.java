package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    @NonNull
    @Transactional
    public Version save(@NonNull final Version version) {
        return versionRepository.save(version);
    }

}
