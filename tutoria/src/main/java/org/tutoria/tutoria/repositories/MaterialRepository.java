package org.tutoria.tutoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoria.tutoria.entities.MaterialEntity;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
}
