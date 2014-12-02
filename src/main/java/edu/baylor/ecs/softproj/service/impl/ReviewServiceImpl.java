package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.service.ReviewService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.model.Review;
import edu.baylor.ecs.softproj.model.TeamMember;
import edu.baylor.ecs.softproj.repository.ReviewAssignmentRepository;
import edu.baylor.ecs.softproj.repository.ReviewRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author yong shui <yong_shui@baylor.edu>
 */
@Transactional
@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;
    
    @Autowired
    private ReviewAssignmentRepository reviewAssignmentRepository;
    
    @Override
    public boolean createReview(String content, ReviewAssignment reviewAssignment, Integer rating){
        reviewRepository.save(new Review(content, reviewAssignment, rating));
        return true;
    }
    
    @Override
    public Set<ReviewAssignment> getReviewAssignment(TeamMember teamMember) {
        return reviewAssignmentRepository.findByReviewer(teamMember);
    }
}
