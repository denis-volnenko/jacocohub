package ru.volnenko.cloud.testhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.volnenko.cloud.testhub.model.Child;

public interface ChildRepository extends JpaRepository<String, Child> {

}
