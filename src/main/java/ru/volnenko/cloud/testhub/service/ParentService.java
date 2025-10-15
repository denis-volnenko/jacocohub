package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.model.Parent;

@Service
public interface ParentService {

    Parent merge(@NonNull String id);

}
