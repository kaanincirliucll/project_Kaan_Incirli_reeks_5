package ucll.be.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ucll.be.repository.UsersRepository;
import ucll.be.model.*;
import ucll.be.exception.*;

@Service
public class UserService {
    private UsersRepository userRepository;

    UserService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.allUsers();
    }

    public List<User> getAllAdults() {
        return userRepository.allUsers(18);
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
}