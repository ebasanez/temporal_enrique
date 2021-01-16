package com.viu.giin21.service;

import com.viu.giin21.dto.UserDTO;
import com.viu.giin21.model.User;
import com.viu.giin21.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository repository;

    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Integer save(UserDTO user) {
        User entity = new User(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
        repository.save(entity);
        return entity.getId();
    }

    @Override
    public UserDTO get(Integer id) {
        User entity = repository.getOne(id);
        return toDto(entity);
    }

    private UserDTO toDto(User entity) {
        return new UserDTO(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getRole());
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


