package com.viu.giin21.service;

import com.viu.giin21.dto.WorkplaceDTO;
import com.viu.giin21.model.Workplace;
import com.viu.giin21.model.repository.WorkplaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkplaceServiceImplementation implements WorkplaceService {

    private final WorkplaceRepository repository;

    public WorkplaceServiceImplementation(WorkplaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<WorkplaceDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Integer save(WorkplaceDTO workplace) {
        Workplace entity = new Workplace(workplace.getId(), workplace.getOwner(), workplace.getName(), workplace.getProcessability(), workplace.getMaximumQueueSize());
        repository.save(entity);
        return entity.getId();
    }

    @Override
    public WorkplaceDTO get(Integer id) {
        Workplace entity = repository.getOne(id);
        return toDto(entity);
    }

    private WorkplaceDTO toDto(Workplace entity) {
        return new WorkplaceDTO(entity.getId(), entity.getOwner(), entity.getName(), entity.getProcessability(), entity.getMaximumQueueSize());
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }
}


