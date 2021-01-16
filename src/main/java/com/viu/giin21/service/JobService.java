package com.viu.giin21.service;

import com.viu.giin21.dto.JobDTO;

import java.util.List;

public interface JobService {

    List<JobDTO> findAll();

    Integer save(JobDTO job);

    JobDTO get(Integer id);

    void delete(Integer id);

    long count();
}
