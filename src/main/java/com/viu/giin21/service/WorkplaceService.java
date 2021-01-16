package com.viu.giin21.service;

import com.viu.giin21.dto.WorkplaceDTO;

import java.util.List;

public interface WorkplaceService {

    List<WorkplaceDTO> findAll();

    Integer save(WorkplaceDTO workplace);

    WorkplaceDTO get(Integer id);

    void delete(Integer id);

    long count();
}

