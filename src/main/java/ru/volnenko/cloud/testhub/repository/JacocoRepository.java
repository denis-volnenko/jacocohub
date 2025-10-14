package ru.volnenko.cloud.testhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.volnenko.cloud.testhub.model.Jacoco;

public interface JacocoRepository extends JpaRepository<Jacoco, String> {

}
