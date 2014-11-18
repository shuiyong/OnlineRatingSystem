package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.model.Course;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.repository.TeamRepository;
import edu.baylor.ecs.softproj.service.TeamService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 * @author yong shui <yong_shui@baylor.edu>
 */
@Transactional
@Service("teamService")
public class TeamServiceImpl implements TeamService {
    
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public boolean createTeam(Course course, Set<User> users, User rpm){
        Team team = new Team(course, rpm);
        team.setTeamMembers(users);
        teamRepository.save(team);
        return true;
    }
}
