package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.model.Child;
import ru.volnenko.cloud.testhub.model.Parent;
import ru.volnenko.cloud.testhub.model.Path;

@Service
public interface PathService {

    Path find(@NonNull Parent parent, @NonNull Child child);

    @NonNull
    Path save(@NonNull Parent parent, @NonNull Child child);

    @NonNull
    Path merge(@NonNull Parent parent, @NonNull Child child);

}
