package org.tutoria.tutoria.Service;

import org.springframework.stereotype.Service;
import org.tutoria.tutoria.entities.MaterialEntity;
import org.tutoria.tutoria.exceptions.NotFoundException;
import org.tutoria.tutoria.repositories.MaterialRepository;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository repository;

    public MaterialServiceImpl(MaterialRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MaterialEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public MaterialEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Material não encontrado com id: " + id
                ));
    }

    @Override
    public MaterialEntity criar(MaterialEntity entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Override
    public MaterialEntity alterar(Long id, MaterialEntity entity) {
        buscarPorId(id);
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        MaterialEntity entity = buscarPorId(id);
        repository.delete(entity);
    }
}