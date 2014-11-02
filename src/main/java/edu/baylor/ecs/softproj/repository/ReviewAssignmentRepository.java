package edu.baylor.ecs.softproj.repository;

import edu.baylor.ecs.softproj.model.ReviewAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vaclav Cibur <ciburvac@fel.cvut.cz>
 */
public interface ReviewAssignmentRepository extends JpaRepository<ReviewAssignment, Integer> {

}
