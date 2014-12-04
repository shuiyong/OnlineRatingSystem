package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.Course;
import edu.baylor.ecs.softproj.repository.CourseRepository;
import edu.baylor.ecs.softproj.service.CourseService;
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
public class CourseServiceImplTest {
    
    @Autowired
    CourseService courseService;
    
    @Autowired
    CourseRepository courseRepository;

    @Test
    public void testGetById() {
        Course c1 = new Course();
        c1.setName("name");
        courseRepository.save(c1);
        Course c2 = courseService.getById(c1.getId());
        assertEquals(c1.getName(), c2.getName());
    }
    
    @Test
    public void testCreate() {
        Course c1 = new Course();
        c1.setName("name");
        courseService.create(c1);
        Course c2 = courseRepository.findAll().iterator().next();
        assertEquals(c1.getName(), c2.getName());
    }
    
}
