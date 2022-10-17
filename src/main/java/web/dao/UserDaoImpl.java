package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }
    public List<User> getUserList(int count) {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public void updateUser(User user) {
        entityManager.merge(user);

    }

}
