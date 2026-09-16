package com.ecommerce.user_service.service;

import com.ecommerce.user_service.entity.User;
import com.ecommerce.user_service.exception.UserNotFoundException;
import com.ecommerce.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(int id, User user){
        User existingUser = userRepository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        existingUser.setStatus(user.getStatus());

        return userRepository.save(existingUser);
    }

    public void deleteUser(int id){
        User user = userRepository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        userRepository.delete(user);

    }
}
