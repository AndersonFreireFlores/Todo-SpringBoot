package andersonfflores.Services;

import andersonfflores.Models.User;
import andersonfflores.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }


    public Optional<User> findById(UUID id) {
        return  userRepository.findById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User update(UUID id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userOptional.get().setName(user.getName());
            userOptional.get().setEmail(user.getEmail());
            return userRepository.save(userOptional.get());
        }
        return null;
    }


    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

}
