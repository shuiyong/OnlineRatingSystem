package edu.baylor.ecs.softproj.repository;

import edu.baylor.ecs.softproj.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
public interface TeamRepository extends JpaRepository<Team, Integer> {

}
