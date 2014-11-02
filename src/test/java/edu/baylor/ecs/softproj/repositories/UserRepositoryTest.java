package edu.baylor.ecs.softproj.repositories;

import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.repository.UserRepository;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context-test.xml"})
public class UserRepositoryTest {
    
    @Autowired
    UserRepository userRepository;
    
    @Test
    public void testFindAll() {
        userRepository.save(new User("a", "b", "b", "b", true));
        userRepository.save(new User("a", "b", "b", "b", true));
        userRepository.save(new User("a", "b", "b", "b", true));
        int count = userRepository.findAll().size();
        assertEquals(3, count);
    }

}
