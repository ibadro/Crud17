package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    public List<User> getUserList(int count) {
        return userDao.getUserList(count);
    }

    @Transactional
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

}
