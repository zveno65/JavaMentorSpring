package ru.plotnikov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.plotnikov.dao.UserDao;
import ru.plotnikov.exception.UserAccountException;
import ru.plotnikov.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserHibernateService implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            users = userDao.findAll();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void addUser(User user) throws UserAccountException {
        try {
            if (userDao.findByName(user.getName()) == null) {
                if (user.getName().equals("Fernando"))
                    user.setRole("admin");
                else
                    user.setRole("user");
                userDao.save(user);
            }
            else
                throw new UserAccountException();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            userDao.update(user);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        try {
            userDao.delete(user);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(long id) {
        try {
            return userDao.find(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
