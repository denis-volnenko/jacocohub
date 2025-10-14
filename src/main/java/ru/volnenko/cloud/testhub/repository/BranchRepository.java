package ru.volnenko.cloud.testhub.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.volnenko.cloud.testhub.model.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String> {

    Branch findByName(@NonNull String name);

}
