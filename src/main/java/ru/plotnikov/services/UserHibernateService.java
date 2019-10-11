package ru.plotnikov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.plotnikov.dao.UserHibernateDao;
import ru.plotnikov.models.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserHibernateService implements UserService {

    private UserHibernateDao userHibernateDao;

    @Autowired
    public void setUserHibernateDao(UserHibernateDao userHibernateDao) {
        this.userHibernateDao = userHibernateDao;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            users = userHibernateDao.findAll();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void addUser(User user) {
        try {
            userHibernateDao.save(user);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            userHibernateDao.update(user);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        try {
            userHibernateDao.delete(user);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(long id) {
        try {
            return userHibernateDao.find(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
