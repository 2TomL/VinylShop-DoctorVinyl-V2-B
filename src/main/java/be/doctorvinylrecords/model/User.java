package be.doctorvinylrecords.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
        })

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isAdmin;
    @NotNull
    @Column(length = 25)
    private String username;
    @NotNull
    @Column(length = 50)
    private String email;
    @NotNull
    @Column(length = 120)
    private String password;
    @NotNull
    @Column(length = 120)
    private String name;
    @NotNull
    @Column(length = 120)
    private String famName;
    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable (name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(Long id, boolean isAdmin, String username, String email, String password, String name, String famName, Set<Role> roles) {
        this.id = id;
        this.isAdmin = isAdmin;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.famName = famName;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamName() {
        return famName;
    }

    public void setFamName(String famName) {
        this.famName = famName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", isAdmin=" + isAdmin +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", famName='" + famName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
