package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
//        print users to console
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println(user.getFirstName());
            System.out.println(user.getLastName());
            System.out.println(user.getEmail());
        }
        return userDao.getAllUsers();
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}

