package be.doctorvinylrecords.controllers;

import be.doctorvinylrecords.model.User;
import be.doctorvinylrecords.payload.request.UpdateUserRequest;
import be.doctorvinylrecords.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }
    @GetMapping("/getuser/username")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<User> getUserByUserName(String userName){
        return userService.getUserByUserName(userName);
    }

    @GetMapping("/get/id")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Optional<User> getUserById(long id){
        return userService.getUserById(id);
    }

    @GetMapping("/getall")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('USER')")
    public void deleteUser(long id){
        userService.deleteUser(id);
    }


    @GetMapping("/search")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> searchUser(String query){return userService.searchUser(query);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest user){
        return userService.updateUser(user);
    }

    @GetMapping("/checkpassword")
    @PreAuthorize("hasRole('USER')")
    public boolean searchUser(Long id, String password){return userService.checkPassword(id, password);
    }
}
