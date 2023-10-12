package ru.sfu.nivanova.lab6.service;

import ru.sfu.nivanova.lab6.entity.User;

public interface UserService {
    User FindById(int id);
    User FindByName(String name);
    void SaveUser(User user);
    }
