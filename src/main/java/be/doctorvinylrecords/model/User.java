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
    @NotNull
    @Column(length = 25)
    private String username;
    @NotNull
    @Column(length = 50)
    public String email;
    @NotNull
    @Column(length = 120)
    public String password;
    @NotNull
    @Column(length = 120)
    public String name;
    @NotNull
    @Column(length = 120)
    public String famName;
    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable (name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }



    //    public Account(String username, String password, String name, String famName, String dateOfBirth, String street, String nr, String city, String postCode, String country, String email, String phoneNr) {
//        this.username = username;
//        this.password = password;
//        this.name = name;
//        this.famName = famName;
//        this.dateOfBirth = dateOfBirth;
//        this.street = street;
//        this.nr = nr;
//        this.city = city;
//        this.postCode = postCode;
//        this.country = country;
//        this.email = email;
//        this.phoneNr = phoneNr;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUserName(String usernameame) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getFamName() {
//        return famName;
//    }
//
//    public void setFamName(String famName) {
//        this.famName = famName;
//    }
//
//    public String getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getNr() {
//        return nr;
//    }
//
//    public void setNr(String nr) {
//        this.nr = nr;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getPostCode() {
//        return postCode;
//    }
//
//    public void setPostCode(String postCode) {
//        this.postCode = postCode;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
    public boolean isValidEmail(String email){
        String pattern = "^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$";
        return email.matches(pattern);
    }
//    public String getPhoneNr() {
//        return phoneNr;
//    }
//
//    public void setPhoneNr(String phoneNr) {
//        this.phoneNr = phoneNr;
//    }
}
