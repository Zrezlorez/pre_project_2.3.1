package web.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }
}
