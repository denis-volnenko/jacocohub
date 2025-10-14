package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.model.Version;
import ru.volnenko.cloud.testhub.repository.VersionRepository;

@Service
public class VersionServiceBean implements VersionService {

    @Autowired
    private VersionRepository versionRepository;

    public Version findByName(@NonNull String name) {
        return versionRepository.findByName(name);
    }

    @NonNull
    @Override
    public Version mergeByName(@NonNull String name) {
        return null;
    }

}
