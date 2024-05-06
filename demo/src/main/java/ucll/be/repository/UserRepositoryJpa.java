package ucll.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucll.be.model.User;

public interface UserRepositoryJpa extends JpaRepository<User, Long> {

    List<User> findByAge(int i);

    List<User> findByAgeBetween(int minAge, int maxAge);

    List<User> findByNameContainingIgnoreCase(String name);

    List<User> findByEmail(String email);

}
