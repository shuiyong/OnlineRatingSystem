package edu.baylor.ecs.softproj.web.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import edu.baylor.ecs.softproj.service.UserService;
import edu.baylor.ecs.softproj.service.TeamService;
import edu.baylor.ecs.softproj.service.CourseService;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.model.Course;
import edu.baylor.ecs.softproj.model.RPM;
import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.model.TeamMember;
import edu.baylor.ecs.softproj.web.helper.FacesMessages;
/**
 *
 * @author yong shui <yong_shui@baylor.edu>
 * @author yong shui <Vaclav_Cibur@baylor.edu>
 * 
 */
@Controller("assignRpmBean")
@Scope("session")
public class AssignRpm {
    @Autowired
    public TeamService teamService;
    
    @Autowired
    public UserService userService;
    
    @Autowired
    public CourseService courseService;
    
    private String teamId;
    private String rpmId;
    
    public Set<TeamMember> getRpms() {
        return userService.getAvailableRPMs(Integer.parseInt(teamId));
    }
    
    public String assignRpm() {
        Team team = teamService.getTeam(Integer.parseInt(teamId));
        teamService.assignRpm(team, Integer.parseInt(rpmId));
        FacesMessages.addInfoMessage("RPM assigned.");
        return "/dashboard.xhtml?faces-redirect=true";
    }

    public String getRpmId() {
        return rpmId;
    }

    public void setRpmId(String rpmId) {
        this.rpmId = rpmId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    
}
