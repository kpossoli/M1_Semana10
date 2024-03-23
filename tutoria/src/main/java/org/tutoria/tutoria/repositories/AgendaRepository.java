package org.tutoria.tutoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoria.tutoria.entities.AgendaEntity;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
}
