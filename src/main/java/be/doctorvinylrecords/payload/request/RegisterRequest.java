package be.doctorvinylrecords.payload.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Set;

public class RegisterRequest {
    @NotNull
    @Size(min = 3)
    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @NotBlank
    @Column(name = "email", nullable = false, length = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6)
    @Column(name = "password", nullable = false, length = 20)
    private String password;

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

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
