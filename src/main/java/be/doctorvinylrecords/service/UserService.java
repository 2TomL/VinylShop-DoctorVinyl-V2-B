package be.doctorvinylrecords.service;

import be.doctorvinylrecords.repository.AccountRepository;
import be.doctorvinylrecords.repository.VinylRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private PasswordEncoder PasswordEncoder;
    private AccountRepository accountRepository;
    private VinylRepository vinylRepository;


}
