package webAppl.dao;

import webAppl.entity.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    List<User> listUsers();
    void deleteUserById(long id);
    void updateUser(User userUp);
    User getUserById(long id);
}
