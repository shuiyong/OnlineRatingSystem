package edu.baylor.ecs.softproj.service;

import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.model.Course;
import edu.baylor.ecs.softproj.model.TeamMember;
import edu.baylor.ecs.softproj.model.User;
import java.util.Set;

/**
 * Interface for the service layer providing operations with users.
 * 
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 * @author yong shui <yong_shui@baylor.edu>
 */
public interface TeamService {
    public Team createTeam(Course course, Set<User> users);
    public Team getTeam(Integer teamId);
    public TeamMember getTeamMemberById(Integer id);
    public TeamMember getTeamMemberByUserAndTeam(User user, Team team);
}
