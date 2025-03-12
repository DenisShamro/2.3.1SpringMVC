package webAppl.service;

import webAppl.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void deleteUserById(long id);
    void updateUser(User userUp);
    User getUserById(long id);
}
