package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class takes care of the authentification process and decides which roles
 * users have.
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Transactional
@Service("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    /**
     * This method is used by Spring Security to determine roles of a user.
     *
     * @param string username of the user
     * @return Spring Security UserDetails object containing username, password
     * and roles of the user with given username.
     * @throws UsernameNotFoundException if there is no user with given username
     */
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(string);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        if (user != null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            org.springframework.security.core.userdetails.User springUser;
            springUser = new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(), authorities);
            return springUser;

        } else {
            throw new UsernameNotFoundException("User not found:" + string);
        }
    }

}
