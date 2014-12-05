package edu.baylor.ecs.softproj.web.bean;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.Course;
import edu.baylor.ecs.softproj.model.RPM;
import edu.baylor.ecs.softproj.model.RPMAssignment;
import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.model.TeamMember;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.service.ArtifactService;
import edu.baylor.ecs.softproj.service.RPMAssignmentService;
import edu.baylor.ecs.softproj.service.TeamService;
import edu.baylor.ecs.softproj.service.UserService;
import edu.baylor.ecs.softproj.web.helper.FacesMessages;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Handles user authentication.
 * 
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Controller("dashboardBean")
@Scope("request")
public class Dashboard {
    
    @Autowired
    public UserService userService;
    
    @Autowired
    public TeamService teamService;
    
    @Autowired
    public ArtifactService artifactService;
    
    @Autowired
    public RPMAssignmentService rpmAssignmentService;
    
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }
        
    public Set<TeamMember> getTeamMembers() {
        return userService.getCurrentUser().getTeamMembers();
    }
    
    public Set<Artifact> getUnassignedArtifacts(RPM rpm) {
        Set<Artifact> artifacts = new HashSet<Artifact>();
        if (rpm != null) {
            for (RPMAssignment ass: rpm.getRPMAssignments()) {
                if (ass.getReviewAssignments().isEmpty()) {
                    artifacts.add(ass.getArtifact());
                }
            }
        }
        return artifacts;
    }
    
    public Set<RPMAssignment> getUnratedRpmAssignments(RPM rpm) {
        Set<RPMAssignment> rpmAssignemnts = new HashSet<RPMAssignment>();
        if (rpm != null) {
            // for each artifact
            artifact:
            for (RPMAssignment ass: rpm.getRPMAssignments()) {
                // if rpm hasn't rated yet
                if (ass.getRPMToArtifactRating() == null && !ass.getReviewAssignments().isEmpty()) {
                    // check whether all reviewers posted review
                    for (ReviewAssignment ra: ass.getReviewAssignments()) {
                        if (ra.getReviews().isEmpty()) {
                            continue artifact;
                        }
                    }
                    rpmAssignemnts.add(ass);
                }
            }
        }
        return rpmAssignemnts;
    }
    
    public Set<RPMAssignment> getLecturerUnratedRpmAssignments(Course c) {
        Set<RPMAssignment> rpmAssignemnts = new HashSet<RPMAssignment>();
        if (c != null) {
            for (Team t: c.getTeams()) {
                for (RPM rpm: t.getRpms()) {
                    for (RPMAssignment ass: rpm.getRPMAssignments()) {
                        if (ass.getLecturerToRPMRating() == null && ass.getRPMToArtifactRating() != null) {
                            rpmAssignemnts.add(ass);
                        }
                    }
                }
            }
        }
        return rpmAssignemnts;
    }
    
    public boolean hasRpm(Integer id) {
        return teamService.hasRpm(id);
    }
}
