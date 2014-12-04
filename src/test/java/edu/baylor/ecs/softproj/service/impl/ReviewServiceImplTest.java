package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.Review;
import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.model.TeamMember;
import edu.baylor.ecs.softproj.repository.ReviewAssignmentRepository;
import edu.baylor.ecs.softproj.repository.ReviewRepository;
import edu.baylor.ecs.softproj.repository.TeamMemberRepository;
import edu.baylor.ecs.softproj.service.ReviewService;
import java.util.Date;
import java.util.List;
import java.util.Set;
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
public class ReviewServiceImplTest {
    
    @Autowired
    ReviewService reviewService;
    
    @Autowired
    ReviewAssignmentRepository reviewAssignmentRepository;
    
    @Autowired
    ReviewRepository reviewRepository;
    
    @Autowired
    TeamMemberRepository teamMemberRepository;

    @Test
    public void testCreateReview() {
        ReviewAssignment ra = new ReviewAssignment();
        ra.setDeadline(new Date());
        reviewAssignmentRepository.save(ra);
        reviewService.createReview("content", ra, 10);
        List<Review> all = reviewRepository.findAll();
        assertEquals(1, all.size());
        Review first = all.iterator().next();
        assertEquals("content", first.getContent());
        assertEquals(10, (int)first.getReviewerToArtifactRating());
    }
    
    @Test
    public void testGetReviewAssignment() {
        TeamMember tm = new TeamMember();
        teamMemberRepository.save(tm);
        ReviewAssignment ra = new ReviewAssignment();
        ra.setDeadline(new Date());
        ra.setLecturerToReviewRating(11);
        ra.setReviewer(tm);
        reviewAssignmentRepository.save(ra);
        Set<ReviewAssignment> reviewAssignments = reviewService.getReviewAssignment(tm);
        ReviewAssignment next = reviewAssignments.iterator().next();
        assertEquals(1, reviewAssignments.size());
        assertEquals(11, (int)next.getLecturerToReviewRating());
    }
    
}
