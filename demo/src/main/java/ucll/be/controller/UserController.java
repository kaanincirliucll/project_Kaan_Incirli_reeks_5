package ucll.be.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ucll.be.services.UserService;
import ucll.be.exception.ServiceException;
import ucll.be.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.allUsers();
    }

    @GetMapping("/adults")
    public List<User> getAllAdults() {
        return userService.getAllAdults();
    }

    @GetMapping("/search/age/{min}/{max}")
    public ResponseEntity<List<User>> getUsersWithinAgeRange(@PathVariable int min, @PathVariable int max) {
        try {
            List<User> users = userService.getUsersWithinAgeRange(min, max);
            return ResponseEntity.ok(users);
        } catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<User>> getUsers(@RequestParam(required = false) String name) {
        if (name != null && !name.isEmpty()) {
            try {
                List<User> users = userService.getUsersByName(name);
                return ResponseEntity.ok(users);
            } catch (ServiceException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            } // Copywrite kaan_Incirli
        } else {
            List<User> users = userService.allUsers();
            return ResponseEntity.ok(users);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        // Register the user
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.OK);
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> updateUser(@PathVariable String email, @RequestBody User updatedUser) {
        try {
            User updatedUserData = userService.updateUser(email, updatedUser);
            return new ResponseEntity<>(updatedUserData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}