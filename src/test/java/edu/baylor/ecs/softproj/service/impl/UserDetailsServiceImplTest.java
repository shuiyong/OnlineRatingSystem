package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context-test.xml"})
public class UserDetailsServiceImplTest {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserService userService;
    
    @Test
    public void testLoadUserByUsername() {
        String username = "username1";
        String plainPassword = "password1";
        userService.create(username, plainPassword, "a", "b", true);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        GrantedAuthority authority = userDetails.getAuthorities().iterator().next();
        assertEquals("ROLE_ADMIN", authority.getAuthority());
    }

    @Test
    public void testLoadNonExistingUser() {
        String username = "username1";
        String plainPassword = "password1";
        userService.create(username, plainPassword, "a", "b", true);
        try {
            userDetailsService.loadUserByUsername(username + "aaa");
            assertTrue(false);
        } catch (UsernameNotFoundException e) {
            
        }
    }

}
