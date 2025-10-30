package com.infoeste.codecash.service;

import com.infoeste.codecash.dto.CreateUserInput;
import com.infoeste.codecash.model.Account;
import com.infoeste.codecash.model.User;
import com.infoeste.codecash.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserInput input) {
        User user = new User();
        user.setName(input.name());
        user.setEmail(input.email());
        user.setPassword(input.password());
        user.setDocument(input.document());
        user.setCreatedAt(Instant.now().toString());

        Account account = new Account();
        account.setUser(user);
        account.setBalance(BigDecimal.ZERO);

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
