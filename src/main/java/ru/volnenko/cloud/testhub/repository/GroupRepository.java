package ru.volnenko.cloud.testhub.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.volnenko.cloud.testhub.model.Group;

public interface GroupRepository extends JpaRepository<Group, String> {

    Group findByName(@NonNull String name);

}
