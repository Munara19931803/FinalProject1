package company.service.impl;

import company.dao.UserDao;
import company.model.User;
import company.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDao();

    @Override
    public void addUser(User user) {
        userDao.getUsers().add(user);
    }

    @Override
    public User getById(int id) {
        for (int i = 0; i < userDao.getUsers().size(); i++) {
            if (userDao.getUsers().get(i).getId() == id) {
                return userDao.getUsers().get(i);
            }
        }
        throw new MyException("user not with this id: " + id);
    }


    @Override
    public void deleteById(int id) {
        boolean bool = true;
        for (int i = 0; i < userDao.getUsers().size(); i++) {
            if (userDao.getUsers().get(i).getId() == id) {
                userDao.getUsers().remove(userDao.getUsers().get(i));
                bool = false;
            }
        }

        if (bool) {
            throw new MyException("User with id: " + id + " not found!");
        }
    }


    @Override
    public List<User> getAllUsers() {
        return userDao.getUsers();
    }
}
