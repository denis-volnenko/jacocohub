package ru.volnenko.cloud.testhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.volnenko.cloud.testhub.model.Group;

public interface GroupRepository extends JpaRepository<String, Group> {

}
