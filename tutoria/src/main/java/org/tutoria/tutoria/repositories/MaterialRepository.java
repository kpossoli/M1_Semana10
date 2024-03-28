package org.tutoria.tutoria.repositories;

import org.tutoria.tutoria.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoria.tutoria.entities.MaterialEntity;

import java.util.List;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {

    List<MaterialEntity> findByAgenda(AgendaEntity agenda);

}
