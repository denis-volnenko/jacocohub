package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.model.Parent;
import ru.volnenko.cloud.testhub.repository.ParentRepository;

import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public Optional<Parent> findById(String s) {
        return parentRepository.findById(s);
    }

    @Override
    public Parent merge(@NonNull String id) {
        return null;
    }

}
