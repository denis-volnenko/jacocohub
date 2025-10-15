package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Group;

import java.util.List;
import java.util.Optional;

@Service
public interface GroupService {

    Group cacheById(@NonNull String id);

    Group findById(@NonNull String id);

    @NonNull
    Group mergeByName(@NonNull String name);

    @NonNull
    Group saveByName(@NonNull String name);

    @Transactional(readOnly = true)
    Group findByName(@NonNull String name);

    @NonNull
    @Transactional(readOnly = true)
    List<Group> findAll();

}
