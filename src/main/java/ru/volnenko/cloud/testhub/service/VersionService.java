package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.model.Version;

@Service
public interface VersionService {

    @NonNull
    Version mergeByName(@NonNull String name);

}
