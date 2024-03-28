package org.tutoria.tutoria.Service;

import org.springframework.stereotype.Service;
import org.tutoria.tutoria.entities.AgendaEntity;
import org.tutoria.tutoria.entities.MaterialEntity;
import org.tutoria.tutoria.exceptions.NotFoundException;
import org.tutoria.tutoria.repositories.MaterialRepository;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository repository;
    private final AgendaService agendaService;

    public MaterialServiceImpl(AgendaService agendaService, MaterialRepository repository) {
        this.agendaService = agendaService;
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
    public List<MaterialEntity> buscarPorAgenda(Long agendaId) {
        AgendaEntity agenda = agendaService.buscarPorId(agendaId);
        return repository.findByAgenda(agenda);
    }

    @Override
    public MaterialEntity criar(MaterialEntity entity) {
        entity.setId(null);

        AgendaEntity agenda = agendaService.buscarPorId(entity.getAgenda().getId());
        entity.setAgenda(agenda);

        return repository.save(entity);
    }

    @Override
    public MaterialEntity alterar(Long id, MaterialEntity entity) {
        buscarPorId(id);
        entity.setId(id);

        AgendaEntity agenda = agendaService.buscarPorId(entity.getAgenda().getId());
        entity.setAgenda(agenda);
        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        MaterialEntity entity = buscarPorId(id);
        repository.delete(entity);
    }
}