package com.viu.giin21.service;

import com.viu.giin21.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    Integer save(UserDTO user);

    UserDTO get(Integer id);

    void delete(Integer id);

    long count();
}
