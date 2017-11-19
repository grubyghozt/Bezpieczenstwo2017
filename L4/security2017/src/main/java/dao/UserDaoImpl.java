package dao;

import bean.security.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByUsername(String username) {
        try {
            return entityManager.createQuery("FROM " + User.class.getName() + " uc WHERE uc.username='" +  username + "'", User.class)
                    .getSingleResult();
        }
        catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
}
