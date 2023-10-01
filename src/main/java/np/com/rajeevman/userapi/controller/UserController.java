package np.com.rajeevman.userapi.controller;

import np.com.rajeevman.userapi.model.User;
import np.com.rajeevman.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {


    /**
     * Autowired instance of the UserService to facilitate user-related operations.
     */
    @Autowired
    UserService userService;

    /**
     * Handles GET requests to retrieve a list of all users.
     * This method can be accessed via the URL ("/users/") or ("/users").
     *
     * @return A ResponseEntity containing the list of users and an HTTP status code.
     */
    @GetMapping(value = {"/", ""})
    public ResponseEntity<Object> getAllUsers() {
        return userService.getAllUsers();
    }


    /**
     * Handles GET requests to retrieve a user by their unique identifier i.e. id.
     *
     * @param id The unique identifier of the user to retrieve.
     * @return A ResponseEntity containing the user's information and an HTTP status code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    /**
     * Handles POST requests to add a new user.
     *
     * @param user The user object to be added.
     * @return A ResponseEntity indicating the success or failure of the user creation.
     */
    @PostMapping("add")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * Handles PUT requests to update a user by their unique identifier i.e. id.
     *
     * @param id   The unique identifier of the user to update.
     * @param user The updated user object.
     * @return A ResponseEntity indicating the success or failure along with the data of the updated user.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserById(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUserById(id, user);
    }

    /**
     * Handles DELETE requests to delete a user by their unique identifier i.e. id.
     *
     * @param id The unique identifier of the user to delete.
     * @return A ResponseEntity indicating the success or failure of the user deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }
}
