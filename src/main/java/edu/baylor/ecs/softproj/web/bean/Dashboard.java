package edu.baylor.ecs.softproj.web.bean;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.RPMAssignment;
import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.service.ArtifactService;
import edu.baylor.ecs.softproj.service.RPMAssignmentService;
import edu.baylor.ecs.softproj.service.ReviewService;
import edu.baylor.ecs.softproj.service.UserService;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Handles user authentication.
 * 
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Controller("dashboardBean")
@Scope("request")
public class Dashboard {
    
    @Autowired
    public UserService userService;
    
    @Autowired
    public ArtifactService artifactService;
    
    @Autowired
    public RPMAssignmentService rpmAssignmentService;
    
    private List<String> reviewerIds;
    
    private Date deadline;
    
    private Integer artifactId;
        
    public Set<Team> getTeams() {
        return userService.getCurrentUser().getRpmOf();
    }
    
    public Set<Artifact> getUnassignedArtifacts(Team team) {
        Set<Artifact> artifacts = team.getArtifacts();
        for (Iterator<Artifact> iterator = artifacts.iterator(); iterator.hasNext();) {
            Artifact next = iterator.next();
            if (!next.getRpmAssginments().isEmpty()) {
                iterator.remove();
            }
        }
        return artifacts;
    }
    
    public String assignArtifact() {
        RPMAssignment rpmAssignment = rpmAssignmentService.create(artifactService.findById(artifactId));
        for (String id : reviewerIds) {
            User u = userService.getById(Integer.parseInt(id));
            artifactService.assgnArtifact(rpmAssignment, u, deadline);
        }
        
        return "/dashboard.xhtml?faces-redirect=true";
    }
    
    public Set<User> getCandidateReviewers() {
        return userService.getCurrentUser().getMemeberOf().iterator().next().getTeamMembers();
    }

    public void setReviewerIds(List<String> reviewerIds) {
        this.reviewerIds = reviewerIds;
    }

    public List<String> getReviewerIds() {
        return reviewerIds;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Integer getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(Integer artifactId) {
        this.artifactId = artifactId;
    }
}
