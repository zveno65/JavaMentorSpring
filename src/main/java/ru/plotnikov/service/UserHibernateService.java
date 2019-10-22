package ru.plotnikov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.plotnikov.dao.RoleRepository;
import ru.plotnikov.dao.UserDao;
import ru.plotnikov.exception.UserAccountException;
import ru.plotnikov.model.Role;
import ru.plotnikov.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
            String autority = null;
            if (userDao.findByName(user.getName()) == null) {
                if (user.getName().equals("Fernando"))
                    autority = "ADMIN";
                else
                    autority = "USER";
                user.setRoles(Collections.singleton(new RoleRepository().findByName(autority)));
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
