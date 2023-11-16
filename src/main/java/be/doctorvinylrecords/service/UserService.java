package be.doctorvinylrecords.service;

import be.doctorvinylrecords.repository.UserRepository;
import be.doctorvinylrecords.repository.VinylRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private PasswordEncoder PasswordEncoder;
    private UserRepository userRepository;
    private VinylRepository vinylRepository;


}
