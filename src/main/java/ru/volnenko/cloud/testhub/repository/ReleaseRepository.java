package ru.volnenko.cloud.testhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.volnenko.cloud.testhub.model.Release;

public interface ReleaseRepository extends JpaRepository<String, Release> {

}
