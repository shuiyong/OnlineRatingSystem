package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.Course;
import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.model.TeamMember;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.repository.CourseRepository;
import edu.baylor.ecs.softproj.repository.TeamMemberRepository;
import edu.baylor.ecs.softproj.repository.TeamRepository;
import edu.baylor.ecs.softproj.repository.UserRepository;
import edu.baylor.ecs.softproj.service.TeamService;
import java.util.HashSet;
import java.util.Set;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context-test.xml"})
public class TeamServiceImplTest {
    
    @Autowired
    TeamService teamService;
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    TeamRepository teamRepository;
    
    @Autowired
    TeamMemberRepository teamMemberRepository;
    
    @Test
    public void testCreateTeam(){
        Course course = new Course();
        course.setName("name");
        course = courseRepository.save(course);
        User u = new User("nic", "nic", "nic", "nic", true);
        u.setTeamMembers(new HashSet<TeamMember>());
        userRepository.save(u);
        Set<User> users = new HashSet(userRepository.findAll());
        teamService.createTeam(course, users);
    }

    @Test
    public void testGetTeam() {
        Team t1 = new Team();
        teamRepository.save(t1);
        Team t2 = teamService.getTeam(t1.getId());
        assertEquals(t1.getId(), t2.getId());
    }

    @Test
    public void testGetTeamMemberById() {
        Team t = new Team();
        teamRepository.save(t);
        TeamMember tm1 = new TeamMember();
        tm1.setTeam(t);
        teamMemberRepository.save(tm1);
        TeamMember tm2 = teamService.getTeamMemberById(tm1.getId());
        assertEquals(tm1.getId(), tm2.getId());
    }

    @Test
    public void testGetTeamMemberByUserAndTeam() {
        User user = new User("nic", "nic", "nic", "nic", true);
        userRepository.save(user);
        Team team = new Team();
        teamRepository.save(team);
        TeamMember tm1 = new TeamMember(user, team);
        tm1 = teamMemberRepository.save(tm1);
        TeamMember tm2 = teamService.getTeamMemberByUserAndTeam(user, team);
        assertEquals("nic", tm2.getUser().getEmail());
    }
    
}
