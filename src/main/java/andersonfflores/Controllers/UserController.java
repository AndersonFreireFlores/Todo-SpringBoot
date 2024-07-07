package andersonfflores.Controllers;

import andersonfflores.Models.User;
import andersonfflores.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(name = "/{id}")
    public Optional<User> getUserById(@PathVariable UUID id) {
        return userService.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping(name = "/{id}")
    public User updateUser(@PathVariable UUID id,@RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping(name = "/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.delete(id);
    }

}
