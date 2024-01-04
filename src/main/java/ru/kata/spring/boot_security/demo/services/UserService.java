package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    boolean add(User user);

    void update(User updatedUser);

    User readUser(long id);

    void delete(long id);

    User findByEmail(String email);

    void createRolesIfNotExist();
}
