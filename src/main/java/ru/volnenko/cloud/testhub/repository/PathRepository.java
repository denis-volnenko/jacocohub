package ru.volnenko.cloud.testhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.volnenko.cloud.testhub.model.Path;

public interface PathRepository extends JpaRepository<Path, String> {

}
