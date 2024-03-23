package org.tutoria.tutoria.repositories;

import org.tutoria.tutoria.entities.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
}
