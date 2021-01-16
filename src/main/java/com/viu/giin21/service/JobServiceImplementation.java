package com.viu.giin21.service;

import com.viu.giin21.dto.JobDTO;
import com.viu.giin21.model.Job;
import com.viu.giin21.model.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImplementation implements JobService {

    private final JobRepository repository;

    public JobServiceImplementation(JobRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<JobDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Integer save(JobDTO job) {
        Job entity = new Job(job.getId(), job.getOwner(), job.getWorkplace(), job.getName(), job.getSize(), job.isExecuted());
        repository.save(entity);
        return entity.getId();
    }

    @Override
    public JobDTO get(Integer id) {
        Job entity = repository.getOne(id);
        return toDto(entity);
    }

    private JobDTO toDto(Job entity) {
        return new JobDTO(entity.getId(), entity.getOwner(), entity.getWorkplace(), entity.getName(), entity.getSize(), entity.isExecuted());
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


