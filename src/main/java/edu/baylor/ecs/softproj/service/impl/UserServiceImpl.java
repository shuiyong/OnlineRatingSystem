package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.model.Course;
import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.model.TeamMember;
import edu.baylor.ecs.softproj.repository.CourseRepository;
import edu.baylor.ecs.softproj.repository.TeamRepository;
import edu.baylor.ecs.softproj.repository.UserRepository;
import edu.baylor.ecs.softproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 * @author yong shui <yong_shui@baylor.edu>
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CourseRepository courserepository;
    
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public User create(String email, String password, String firstName, String lastName, Boolean isAdmin) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return userRepository.save(new User(email, encoder.encode(password), firstName, lastName, isAdmin));
    }

    @Override
    public User getById(Integer userId) {
        return userRepository.findOne(userId);
    }
    
    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByEmail(email);
    }
    
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void changePassword(User u, String newPlainPassword) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode(newPlainPassword);
        u.setPassword(encoded);
        userRepository.save(u);
    }
    
    @Override
    public List<User> getStudents(User user, Integer courseId){
        List<User> result = userRepository.findByIsAdmin(Boolean.FALSE);
        result.remove(user);
        Course c = courserepository.findOne(courseId);
        Set<Team> teams = c.getTeams();
        for (Team team : teams) {
            for (TeamMember tm : team.getTeamMembers()) {
                result.remove(tm.getUser());
            }
        }
        return result;
    }
    
    @Override
    public Set<Course> getCourse(User user){
        //This is completely wrong!!!
        return user.getLecturerOf();
    }

    @Override
    public Set<TeamMember> getAvailableRPMs(Integer teamId) {
        Set<TeamMember> users = new HashSet<TeamMember>();
        Team team = teamRepository.findOne(teamId);
        Course course = team.getCourse();
        Set<Team> teams = course.getTeams();
        teams.remove(team);
        for (Team t : teams) {
            Set<TeamMember> tms = t.getTeamMembers();
            for (TeamMember tm : tms) {
                users.add(tm);
            }
        }
        return users;
    }
}
