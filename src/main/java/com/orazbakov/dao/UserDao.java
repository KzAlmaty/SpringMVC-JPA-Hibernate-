package com.orazbakov.dao;

import com.orazbakov.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

}
