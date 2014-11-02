package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.repository.UserRepository;
import edu.baylor.ecs.softproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(String email, String password, String firstName, String lastName, Boolean isAdmin) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return userRepository.save(new User(email, encoder.encode(password), firstName, lastName, isAdmin));
    }

    @Override
    public User getById(Integer userId) {
        return userRepository.findOne(userId);
    }
    
    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByEmail(email);
    }

    @Override
    public void changePassword(User u, String newPlainPassword) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode(newPlainPassword);
        u.setPassword(encoded);
        userRepository.save(u);
    }

}
