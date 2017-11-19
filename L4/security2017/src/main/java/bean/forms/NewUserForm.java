package bean.forms;

import bean.forms.annotations.PasswordValidationConstraint;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@PasswordValidationConstraint(filedOne = "password", filedTwo = "repeatedPassword")
public class NewUserForm {

    @NotBlank
    private String username;
    @NotBlank
    @Length(min = 5)
    private String password;
    @NotBlank
    private String repeatedPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
