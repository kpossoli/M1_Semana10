package org.tutoria.tutoria.Service;

import org.tutoria.tutoria.entities.TutorEntity;

import java.util.List;

public interface TutorService {

    List<TutorEntity> buscarTodos();

    TutorEntity buscarPorId(Long id);

    TutorEntity criar(TutorEntity entity);

    TutorEntity alterar(Long id, TutorEntity entity);

    void excluir(Long id);

}
