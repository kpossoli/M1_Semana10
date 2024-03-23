package org.tutoria.tutoria.Service;

import org.tutoria.tutoria.entities.MaterialEntity;

import java.util.List;

public interface MaterialService {

    List<MaterialEntity> buscarTodos();

    MaterialEntity buscarPorId(Long id);

    MaterialEntity criar(MaterialEntity entity);

    MaterialEntity alterar(Long id, MaterialEntity entity);

    void excluir(Long id);

}
