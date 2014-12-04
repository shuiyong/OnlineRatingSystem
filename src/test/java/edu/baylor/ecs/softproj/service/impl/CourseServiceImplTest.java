package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.service.UserService;
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
public class CourseServiceImplTest {

    @Test
    public void testSomeMethod() {
    }
    
}
