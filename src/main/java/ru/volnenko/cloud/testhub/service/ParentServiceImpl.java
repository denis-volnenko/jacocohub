package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.model.Parent;
import ru.volnenko.cloud.testhub.repository.ParentRepository;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public Parent findById(@NonNull final String id) {
        return parentRepository.findById(id).orElse(null);
    }

    @Override
    public Parent merge(@NonNull final String id) {
        final Parent parent = findById(id);
        if (parent != null) return parent;
        return save(id);
    }

    @Override
    public Parent save(@NonNull final String id) {
        @NonNull final Parent parent = new Parent();
        parent.setId(id);
        return parentRepository.save(parent);
    }

}
