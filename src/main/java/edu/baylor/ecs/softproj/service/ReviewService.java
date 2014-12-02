package edu.baylor.ecs.softproj.service;

import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.model.TeamMember;
import java.util.Set;
/**
 *
 * @author yong shui <yong_shui@baylor.edu>
 */
public interface ReviewService {
    public boolean createReview(String content, ReviewAssignment reviewAssignment, Integer rating);
    public Set<ReviewAssignment> getReviewAssignment(TeamMember teamMember);
}
