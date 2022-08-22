package com.orazbakov.services;

import com.orazbakov.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);



}
