package Online.piggy.bank.example.Online.piggy.bank.service;

import Online.piggy.bank.example.Online.piggy.bank.entity.User;
import Online.piggy.bank.example.Online.piggy.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
//
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
