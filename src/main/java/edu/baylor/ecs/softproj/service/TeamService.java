package edu.baylor.ecs.softproj.service;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.model.Course;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.repository.ReviewRepository;
import edu.baylor.ecs.softproj.repository.TeamRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Interface for the service layer providing operations with users.
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 * @author yong shui <yong_shui@baylor.edu>
 */
public interface TeamService {
    public boolean createTeam(Course course, Set<User> users, User rpm);
}
