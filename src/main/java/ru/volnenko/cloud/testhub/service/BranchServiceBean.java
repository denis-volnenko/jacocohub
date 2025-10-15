package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volnenko.cloud.testhub.model.Branch;
import ru.volnenko.cloud.testhub.repository.BranchRepository;

import java.util.List;

@Service
public class BranchServiceBean implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Override
    @Transactional(readOnly = true)
    public Branch findByName(@NonNull final String name) {
        return branchRepository.findByName(name);
    }

    @NonNull
    @Override
    public Branch mergeByName(@NonNull final String name) {
        final Branch branch = findByName(name);
        if (branch != null) return branch;
        return saveByName(name);
    }

    @NonNull
    @Override
    public Branch saveByName(@NonNull final String name) {
        @NonNull final Branch branch = new Branch();
        branch.setName(name);
        return branchRepository.save(branch);
    }

    @NonNull
    public Branch save(@NonNull final Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    @Transactional(readOnly = true)
    public Branch findById(@NonNull final String id) {
        return branchRepository.findById(id).orElse(null);
    }

    @Override
    @Cacheable(value = "branch", key = "id")
    public Branch cacheById(@NonNull String id) {
        return findById(id);
    }

    @Override
    @NonNull
    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

}
