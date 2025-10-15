package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Branch;

import java.util.List;
import java.util.Optional;

@Service
public interface BranchService {

    @Transactional(readOnly = true)
    Branch findByName(@NonNull String name);

    @NonNull
    @Transactional
    Branch mergeByName(@NonNull String name);

    @NonNull
    @Transactional
    Branch saveByName(@NonNull String name);

    @Transactional(readOnly = true)
    Branch findById(@NonNull String id);

    Branch cacheById(@NonNull String id);

    @NonNull List<Branch> findAll();

}
