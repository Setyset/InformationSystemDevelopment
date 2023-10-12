package ru.sfu.nivanova.lab6.service.impl;

import ru.sfu.nivanova.lab6.entity.User;
import ru.sfu.nivanova.lab6.repository.RoleRepository;
import ru.sfu.nivanova.lab6.repository.UserRepository;
import ru.sfu.nivanova.lab6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void SaveUser(User user) {
        user.getRoles().add(roleRepository.findByRole("USER"));
        userRepository.save(user);
    }

    @Override
    public User FindByName(String name){
        return userRepository.findByName(name).orElse(null);
    }

    @Override
    public User FindById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
