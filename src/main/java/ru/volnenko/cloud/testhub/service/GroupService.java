package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Group;

import java.util.List;

@Service
public interface GroupService {

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
