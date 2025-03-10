package webAppl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webAppl.DAO.UserDAO;
import webAppl.Entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Transactional
    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Transactional
    @Override
    public void deleteUserById(long id) {
        userDAO.deleteUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(User userUp) {
        userDAO.updateUser(userUp);
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }


}
