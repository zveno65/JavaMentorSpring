package ru.plotnikov.services;

import ru.plotnikov.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User getUserById(long id);
}

