package bean.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User implements UserDetails{
    private static final long serialVersionUID = -8998307817499676750L;
    @Id
    @GeneratedValue
    private int Id;
    @Column(length = 50)
    private String username;
    private String encodedPassword;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "APP_USER_USER_PROFILE",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
    private final Set<UserProfile> userProfiles = new HashSet<>(Arrays.asList(new UserProfile()));
    private boolean isEnabled=false;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userProfiles;
    }

    @Override
    public String getPassword() {
        return encodedPassword;
    }

    public void setPassword(String password) {
        this.encodedPassword = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

}
