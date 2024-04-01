package ucll.be.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ucll.be.repository.UsersRepository;
import ucll.be.model.*;

@Service
public class UserService {
    private UsersRepository userRepository;

    UserService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.allUsers();
    }
}