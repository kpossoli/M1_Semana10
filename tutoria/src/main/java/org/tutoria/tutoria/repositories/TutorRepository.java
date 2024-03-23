package org.tutoria.tutoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoria.tutoria.entities.TutorEntity;

public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
}
