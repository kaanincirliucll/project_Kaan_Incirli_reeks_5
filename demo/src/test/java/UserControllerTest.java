import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserControllerTest {

    // private UserController userController;

    // @BeforeEach
    // public void setUp() {
    // // Create an instance of the controller with a stubbed UserService
    // UserService userService = new StubUserService();
    // userController = new UserController(userService);
    // }

    // @Test
    // public void testGetAllUsers() {
    // // Calling the controller method
    // ResponseEntity<List<User>> responseEntity = userController.getAllUsers();

    // // Verifying the result
    // assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    // List<User> returnedUsers = responseEntity.getBody();
    // assertEquals(2, returnedUsers.size());
    // assertEquals(1L, returnedUsers.get(0).getId());
    // assertEquals("John", returnedUsers.get(0).getName());
    // assertEquals(2L, returnedUsers.get(1).getId());
    // assertEquals("Alice", returnedUsers.get(1).getName());
    // }

    // // Stubbed UserService implementation for testing
    // private static class StubUserService implements UserService {

    // @Override
    // public List<User> allUsers() {
    // // Stubbed list of users
    // User user1 = new User(1L, "John");
    // User user2 = new User(2L, "Alice");
    // return Arrays.asList(user1, user2);
    // }
    // }
}
