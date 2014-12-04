package edu.baylor.ecs.softproj.repository;

import edu.baylor.ecs.softproj.model.RPM;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yong
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
public interface RPMRepository extends JpaRepository<RPM, Integer> {
    
}
