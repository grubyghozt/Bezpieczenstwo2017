package services;

import bean.forms.NewUserForm;
import bean.security.User;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private Pbkdf2PasswordEncoder pbkdf2PasswordEncoder;

    @Override
    public void addUser(NewUserForm newUserForm) {
        User user = new User();
        user.setUsername(newUserForm.getUsername());
        user.setPassword(pbkdf2PasswordEncoder.encode(newUserForm.getPassword()));
        user.setEnabled(true);

        userDao.addUser(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
