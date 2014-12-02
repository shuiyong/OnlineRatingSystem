package edu.baylor.ecs.softproj.repository;

import edu.baylor.ecs.softproj.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author yong shui <yong_shui@baylor.edu>
 */
public interface ReviewRepository extends JpaRepository<Review, Integer>{
    
}
