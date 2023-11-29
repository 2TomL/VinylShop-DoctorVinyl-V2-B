package be.doctorvinylrecords.service;

import be.doctorvinylrecords.model.User;
import be.doctorvinylrecords.payload.request.UpdateUserRequest;
import be.doctorvinylrecords.payload.response.MessageResponse;
import be.doctorvinylrecords.repository.UserRepository;
import be.doctorvinylrecords.repository.VinylRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    private PasswordEncoder PasswordEncoder;
    private UserRepository userRepository;
    private VinylRepository vinylRepository;
    @Autowired
    public UserService(PasswordEncoder encoder, UserRepository userRepository, VinylRepository vinylRepository) {
        PasswordEncoder = encoder;
        this.userRepository = userRepository;
        this.vinylRepository = vinylRepository;
    }
    public Optional<User> getUserByUserName(String userName) {
        return UserRepository.findByUsername(userName);
    }
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> searchUser(String query){
        return userRepository.searchUsers(query);
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public ResponseEntity<?> updateUser(UpdateUserRequest updateUserRequest) {
        Optional<User> OptionalUser = getUserById(updateUserRequest.getId()).stream().findFirst();


        if (OptionalUser.isEmpty()){
            return ResponseEntity.badRequest().body(new MessageResponse("User not found"));
        }

        User user = OptionalUser.get();

        System.out.println("update" + updateUserRequest.getUserName());

        System.out.println(user);


        // update username
        if (!(null == updateUserRequest.getUserName()) && !updateUserRequest.getUserName().isBlank()) {
            user.setUsername(updateUserRequest.getUserName());
        }

        // update email
        if (!(null == updateUserRequest.getEmail()) && !updateUserRequest.getEmail().isBlank()) {
            user.setEmail(updateUserRequest.getEmail());
        }

        // password
        if (!(null == updateUserRequest.getPassword()) && !updateUserRequest.getPassword().isBlank()) {
            user.setPassword(encoder.encode(updateUserRequest.getPassword()));
        }

        System.out.println(user);

        update(user);

        return ResponseEntity.ok(new MessageResponse("updated successfully"));
    }

    public boolean checkPassword(Long id, String password) {
        return encoder.matches(password,
                userRepository
                        .findById(id)
                        .orElseThrow(NoSuchElementException::new)
                        .getPassword());
    }
    // methods
}
