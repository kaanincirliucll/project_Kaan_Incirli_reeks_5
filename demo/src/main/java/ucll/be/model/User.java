package ucll.be.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
    private String name;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private int age;

    public User(String name, String password, String email, int age) {
        setName(name);
        setPassword(password);
        setEmail(email);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new RuntimeException("Name is required.");
        }
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 3) {
            throw new RuntimeException("Password must be at least 3 characters long.");
        }
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new RuntimeException("E-mail must be a valid email format.");
        }
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new RuntimeException("Age must be a positive integer between 0 and 100.");
        }
        this.age = age;
    }

}