package ru.plotnikov.dao;


import ru.plotnikov.model.User;

import java.sql.SQLException;

public interface UserRepository extends Dao<User>{
    User findByName(String name) throws SQLException;
}
