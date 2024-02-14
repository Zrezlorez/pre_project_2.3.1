package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User getById(Long id);
    void add(User user);
    void delete(Long id);
    void update(User user);
    List<User> getAllUsers();
}
