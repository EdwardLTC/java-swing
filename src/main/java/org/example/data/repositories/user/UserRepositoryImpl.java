package org.example.data.repositories.user;

import com.j256.ormlite.dao.Dao;
import org.example.data.models.User;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {

    private final Dao<User, Integer> userDao;

    @Inject
    public UserRepositoryImpl(Dao<User, Integer> userDao) {this.userDao = userDao;}

    @Override
    public ArrayList<User> findAll() throws SQLException {return new ArrayList<>(userDao.queryForAll());}

    @Override
    public void addUser(User user) throws SQLException {userDao.create(user);}

    @Override
    public User findUser(int id) throws SQLException {return userDao.queryForId(id);}

    @Override
    public void updateUser(User user) throws SQLException {userDao.update(user);}

    @Override
    public void deleteUser(int id) throws SQLException {userDao.deleteById(id);}

}
