package services;

import bean.forms.NewUserForm;
import bean.security.User;

public interface SignUpService {
    void addUser(NewUserForm newUserForm);
    User getUserByUsername(String username);
    User getUserById(int id);
}
