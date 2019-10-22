package ru.plotnikov.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.plotnikov.model.Role;
import ru.plotnikov.model.User;

import javax.annotation.Resource;
import java.sql.SQLException;

@Transactional
@Repository("roleRepository")
public class RoleRepository {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Role findByName(String name) throws SQLException {
        return (Role) sessionFactory.getCurrentSession().createQuery("from Role where name = :name")
                .setParameter("name", name)
                .uniqueResult();
    }
}
