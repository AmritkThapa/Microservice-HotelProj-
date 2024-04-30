package com.microservice.UserService.repositories;

import com.microservice.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {

    //
}
