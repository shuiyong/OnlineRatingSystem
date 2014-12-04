package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.repository.ReviewAssignmentRepository;
import edu.baylor.ecs.softproj.service.ReviewAssignmentService;
import java.util.Date;
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
public class ReviewAssignmentServiceImplTest {
    
    @Autowired
    ReviewAssignmentService reviewAssignmentService;
    
    @Autowired
    ReviewAssignmentRepository reviewAssignmentRepository;

    @Test
    public void testGetById() {
        ReviewAssignment ra = new ReviewAssignment();
        ra.setDeadline(new Date());
        reviewAssignmentRepository.save(ra);
        ReviewAssignment ra2 = reviewAssignmentService.getById(ra.getId());
        assertEquals(ra.getDeadline(), ra2.getDeadline());
    }
    
}
