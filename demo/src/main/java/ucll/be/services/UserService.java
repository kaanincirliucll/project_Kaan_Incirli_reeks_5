package ucll.be.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ucll.be.repository.*;
import ucll.be.model.*;
import ucll.be.exception.*;

@Service
public class UserService {
    private UserRepositoryJpa userRepository;

    UserService(UserRepositoryJpa userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllAdults() {
        return userRepository.findByAge(18);
    }

    public List<User> getUsersWithinAgeRange(int minAge, int maxAge) {
        if (minAge > maxAge) {
            throw new ServiceException("Minimum age cannot be greater than maximum age.");
        }
        if (minAge < 0 || maxAge > 150) {
            throw new ServiceException("Invalid age range. Age must be between 0 and 150.");
        }
        return userRepository.findByAgeBetween(minAge, maxAge);
    }

    public List<User> getUsersByName(String name) {
        List<User> users = userRepository.findByNameContainingIgnoreCase(name);
        if (users.isEmpty()) {
            throw new ServiceException("No users found with the specified name.");
        }
        return users;
    }

    public User registerUser(User user) {
        // Check if the user already exists
        if (userRepository.findByNameContainingIgnoreCase(user.getName()) != null) {
            throw new ServiceException("User already exists.");
        }

        // Save the user in the repository
        return userRepository.save(user);
    }

    public User updateUser(String email, User updatedUser) {
        // Check if the user exists
        User existingUser = userRepository.findByEmail(email).get(0);
        if (existingUser == null) {
            throw new ServiceException("User does not exist.");
        }

        // Check if the email address is being changed
        if (!email.equals(updatedUser.getEmail())) {
            throw new ServiceException("Email cannot be changed.");
        }

        // Validate updated user fields
        // Add your validation logic here

        // Update user details
        existingUser.setName(updatedUser.getName());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setAge(updatedUser.getAge());

        // Save updated user to repository
        return userRepository.save(existingUser);
    }
}