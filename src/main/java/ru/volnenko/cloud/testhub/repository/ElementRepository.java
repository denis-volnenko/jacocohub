package ru.volnenko.cloud.testhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.volnenko.cloud.testhub.model.Element;

@Repository
public interface ElementRepository extends JpaRepository<Element, String> {

}
