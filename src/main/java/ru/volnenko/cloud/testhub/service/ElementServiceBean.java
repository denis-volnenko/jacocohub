package ru.volnenko.cloud.testhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.repository.ElementRepository;

@Service
public class ElementServiceBean implements ElementService {

    @Autowired
    private ElementRepository elementRepository;

}
