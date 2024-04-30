package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void add(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> listUsers() {
        List<User> users = userDao.findAll();
        users.forEach(System.out::println);
        return users;
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    public void delete(Long id) {
        userDao.delete(userDao.findById(id));
    }

    @Transactional
    public User findById(Long id) {
        return userDao.findById(id);
    }
}
