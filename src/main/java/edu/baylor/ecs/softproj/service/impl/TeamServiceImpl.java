package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.model.Course;
import edu.baylor.ecs.softproj.model.TeamMember;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.repository.TeamMemberRepository;
import edu.baylor.ecs.softproj.repository.TeamRepository;
import edu.baylor.ecs.softproj.service.TeamService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 * @author yong shui <yong_shui@baylor.edu>
 */
@Transactional
@Service("teamService")
public class TeamServiceImpl implements TeamService {
    
    @Autowired
    private TeamRepository teamRepository;
    
    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Override
    public Team createTeam(Course course, Set<User> users){
        Team team = new Team(course);
        Set<TeamMember> teamMembers = new HashSet<TeamMember>();
        for(User user: users) {
            TeamMember tm = new TeamMember(user, team);
            user.getTeamMembers().add(tm);
            teamMembers.add(tm);
        }
        team.setTeamMembers(teamMembers);
        teamRepository.save(team);
        return team;
    }

    @Override
    public Team getTeam(Integer teamId) {
        return teamRepository.findOne(teamId);
    }

    @Override
    public TeamMember getTeamMemberById(Integer id) {
        return teamMemberRepository.findOne(id);
    }

    @Override
    public TeamMember getTeamMemberByUserAndTeam(User user, Team team) {
        return teamMemberRepository.findByUserAndTeam(user, team);
    }
    
}
