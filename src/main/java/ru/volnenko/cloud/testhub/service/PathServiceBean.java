package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Child;
import ru.volnenko.cloud.testhub.model.Parent;
import ru.volnenko.cloud.testhub.model.Path;
import ru.volnenko.cloud.testhub.repository.PathRepository;

@Service
public class PathServiceBean implements PathService {

    @Autowired
    private PathRepository pathRepository;

    @Transactional(readOnly = true)
    public Path find(@NonNull final String parentId, @NonNull final String childId) {
        return pathRepository.findOne(parentId, childId);
    }

    @Override
    public Path find(@NonNull final Parent parent, @NonNull final Child child) {
        @NonNull final String parentId = parent.getId();
        @NonNull final String childId = child.getId();
        return find(parentId, childId);
    }

    @NonNull
    public Path save(@NonNull final Path path) {
        return pathRepository.save(path);
    }

    @NonNull
    @Override
    public Path save(@NonNull final Parent parent, @NonNull final Child child) {
        @NonNull final String parentId = parent.getId();
        @NonNull final String childId = child.getId();
        @NonNull final Path path = new Path();
        path.setParentId(parentId);
        path.setChildId(childId);
        return save(path);
    }

    @NonNull
    @Override
    public Path merge(@NonNull final Parent parent, @NonNull final Child child) {
        final Path path = find(parent, child);
        if (path != null) return path;
        return save(parent, child);
    }

}
