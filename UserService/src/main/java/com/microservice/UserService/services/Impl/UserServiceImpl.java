package com.microservice.UserService.services.Impl;

import com.microservice.UserService.entities.User;
import com.microservice.UserService.repositories.UserRepo;
import com.microservice.UserService.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public User saveUser(User user) {
        //generate unique userid
        String randomUserID = UUID.randomUUID().toString();
        user.setUserId(randomUserID);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepo.findById(userId).orElseThrow(()-> new ResourceAccessException("No user with given id:" +userId));
    }
}
