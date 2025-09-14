package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public void saveUser(User user) {
        System.out.println("Saving user: " + user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
        System.out.println("User id: " + user.getId());

        if(user.getId() == null){  // check for null
            System.out.println("Inserting new user");
            entityManager.persist(user); // insert
        } else {
            System.out.println("Updating existing user");
            entityManager.merge(user);   // update
        }
    }

    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    public void deleteUser(Long id) {
        User user = getUser(id);
        if(user != null){
            entityManager.remove(user);
        }
    }
}
