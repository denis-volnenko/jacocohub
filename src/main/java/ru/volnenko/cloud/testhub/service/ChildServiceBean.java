package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.model.Artifact;
import ru.volnenko.cloud.testhub.model.Child;
import ru.volnenko.cloud.testhub.repository.ChildRepository;

@Service
public class ChildServiceBean implements ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Override
    public Child findById(@NonNull final String id) {
        return childRepository.findById(id).orElse(null);
    }

    @NonNull
    @Override
    public Child merge(@NonNull final Artifact artifact) {
        final Child child = findById(artifact.getId());
        if (child != null) return child;
        return save(artifact.getId());
    }

    @NonNull
    @Override
    public Child save(@NonNull final Child child) {
        return childRepository.save(child);
    }

    @NonNull
    @Override
    public Child save(@NonNull final String id) {
        @NonNull final Child child = new Child();
        child.setId(id);
        return save(child);
    }

}
