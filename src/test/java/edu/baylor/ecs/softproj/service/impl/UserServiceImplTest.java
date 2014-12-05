package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.Course;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.repository.CourseRepository;
import edu.baylor.ecs.softproj.repository.UserRepository;
import edu.baylor.ecs.softproj.service.UserService;
import java.util.List;
import java.util.Set;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context-test.xml"})
public class UserServiceImplTest {
    
    @Autowired
    UserService userService;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    CourseRepository courseRepository;
    
    @Test
    public void testCreate() {
        String username = "username1";
        String plainPassword = "password1";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User u = userService.create(username, plainPassword, "a", "b", true);
        u = userService.getById(u.getId());
        assertEquals(username, u.getEmail());
        assertTrue(encoder.matches(plainPassword, u.getPassword()));
    }
    
    @Test
    public void testGetById() {
        String username = "username1";
        String plainPassword = "password1";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User u = userService.create(username, plainPassword, "a", "b", true);
        u = userService.getById(u.getId());
        assertEquals(username, u.getEmail());
        assertTrue(encoder.matches(plainPassword, u.getPassword()));
    }
    
    @Test
    public void testGetByEmail() {
        String username = "username1";
        String plainPassword = "password1";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User u = userService.create(username, plainPassword, "a", "b", true);
        u = userService.getByEmail(username);
        assertEquals(username, u.getEmail());
        assertTrue(encoder.matches(plainPassword, u.getPassword()));
    }
    
    @Test
    public void testGetCurrentUser() {
        try {
            User u = userService.getCurrentUser();
            assert false;
        } catch (NullPointerException e) {
        }
    }
    
    @Test
    public void testGetAll() {
        userRepository.save(new User("random", "random", "random", "random", true));
        userRepository.save(new User("random", "random", "random", "random", true));
        userRepository.save(new User("random", "random", "random", "random", true));
        userRepository.save(new User("random", "random", "random", "random", true));
        List<User> all = userService.getAll();
        assertEquals(4, all.size());
    }
    
    @Test
    public void testChangePassword() {
        String username = "username1";
        String plainPassword = "password1";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User u = userService.create(username, plainPassword, "a", "b", true);
        u = userService.getById(u.getId());
        assertEquals(username, u.getEmail());
        assertTrue(encoder.matches(plainPassword, u.getPassword()));
        String newPass = "trololo";
        userService.changePassword(u, newPass);
        u = userService.getById(u.getId());
        assertTrue(encoder.matches(newPass, u.getPassword()));
    }
    
    @Test
    public void testGetStudents() {
        User u = new User("random", "random", "random", "random", true);
        u = userRepository.save(u);
        Course c = new Course("random", u);
        c = courseRepository.save(c);
        List<User> students = userService.getStudents(u, c.getId());
        assertTrue(students.isEmpty());
    }
    
    @Test
    public void testGetCourse() {
        User u = new User("random", "random", "random", "random", true);
        u = userRepository.save(u);
        Set<Course> course = userService.getCourse(u);
        assertNull(course);
    }

}
