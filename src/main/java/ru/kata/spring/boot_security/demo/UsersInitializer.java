package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.List;

@Component
public class UsersInitializer implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final UserService userService;

    @Autowired
    public UsersInitializer(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.createRolesIfNotExist();
        userService.add(new User("user", "user", "user@mail.ru", List.of(roleRepository.getById(1L))));
        userService.add(new User("admin", "admin", "admin@mail.ru", List.of(roleRepository.getById(2L))));

    }
}
