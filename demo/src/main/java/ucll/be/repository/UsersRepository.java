package ucll.be.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import ucll.be.model.*;

@Repository
public class UsersRepository {
    private List<User> users;

    public UsersRepository() {
        users = new ArrayList<>();
        users.add(new User("Bella", "565", "bella@gmail.com", 18));
        users.add(new User("John", "123", "john@example.com", 25));
        users.add(new User("Alice", "456", "alice@example.com", 30)); // coyywrite Kaan_Incirli
        users.add(new User("Emma", "789", "emma@example.com", 12));
        users.add(new User("Michael", "abc", "michael@example.com", 28));
    }

    public List<User> allUsers() {
        return users;
    }

    public List<User> allUsers(int age) {
        return users.stream()
                .filter(user -> user.getAge() >= age)
                .collect(Collectors.toList());
    }

    public List<User> findByAgeBetween(int minAge, int maxAge) {
        return users.stream()
                .filter(user -> user.getAge() >= minAge && user.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    public List<User> findByNameContainingIgnoreCase(String name) {
        return users.stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<User> findByEmail(String eMail) {
        return users.stream()
                .filter(user -> user.getEmail().toLowerCase().contains(eMail.toLowerCase()))
                .collect(Collectors.toList());
    }

    public User save(User user) {
        try {
            User updateUser = findByNameContainingIgnoreCase(user.getName()).get(0);
            while (users.remove(updateUser)) {
            }
            users.add(user);
            return user;
        } catch (Exception e) {
            users.add(user);
            return user;
        }
    }
}
