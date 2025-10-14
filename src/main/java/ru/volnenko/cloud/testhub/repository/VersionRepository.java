package ru.volnenko.cloud.testhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.volnenko.cloud.testhub.model.Version;

public interface VersionRepository extends JpaRepository<String, Version> {

}
