package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    boolean add(User user);

    boolean update(User updatedUser, List<Role> roles);

    User readUser(long id);

    void delete(long id);

    User findByUsername(String username);

    void createRolesIfNotExist();
}
