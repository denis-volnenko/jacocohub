package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.model.Artifact;
import ru.volnenko.cloud.testhub.model.Child;

@Service
public interface ChildService {

    Child findById(@NonNull String id);

    @NonNull
    Child merge(@NonNull Artifact artifact);

    @NonNull Child save(@NonNull Child child);

    @NonNull
    Child save(@NonNull String id);

}
