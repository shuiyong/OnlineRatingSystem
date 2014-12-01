package edu.baylor.ecs.softproj.repository;

import edu.baylor.ecs.softproj.model.RPMAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vaclav Cibur <ciburvac@fel.cvut.cz>
 */
public interface RPMAssignmentRepository extends JpaRepository<RPMAssignment, Integer> {
    
    public RPMAssignment findByArtifactId(Integer artifactId);

}
