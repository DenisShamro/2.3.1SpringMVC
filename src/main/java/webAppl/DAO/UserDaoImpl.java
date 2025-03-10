package webAppl.DAO;


import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import webAppl.Entity.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.
                createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public void deleteUserById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User userUp) {
        entityManager.merge(userUp);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }


}