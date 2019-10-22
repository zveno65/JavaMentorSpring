package ru.plotnikov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.plotnikov.dao.UserRepository;
import ru.plotnikov.model.User;

import java.sql.SQLException;

@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userDao.findByName(name);
            if (user==null)
                throw new UsernameNotFoundException("user not found");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}