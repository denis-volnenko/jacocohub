package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Group;
import ru.volnenko.cloud.testhub.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceBean implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    @Transactional(readOnly = true)
    public Group findByName(@NonNull String name) {
        return groupRepository.findByName(name);
    }

    @Override
    @NonNull
    @Transactional(readOnly = true)
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @NonNull
    @Override
    public Group saveByName(@NonNull final String name) {
        @NonNull final Group group = new Group();
        group.setName(name);
        return save(group);
    }

    @Override
    @Cacheable(value = "group", key = "id")
    public Group cacheById(@NonNull final String id) {
        return findById(id);
    }

    @Override
    public Group findById(@NonNull final String id) {
        return groupRepository.findById(id).orElse(null);
    }

    @NonNull
    @Override
    public Group mergeByName(@NonNull final String name) {
        final Group group = findByName(name);
        if (group != null) return group;
        return saveByName(name);
    }

}
