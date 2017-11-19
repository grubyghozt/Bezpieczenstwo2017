package dao;

import bean.security.User;

public interface UserDao {
    User getUserByUsername(String username);
    void addUser(User user);
    User getUserById(int id);
}
