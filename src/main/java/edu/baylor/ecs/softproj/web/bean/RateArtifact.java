package edu.baylor.ecs.softproj.web.bean;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.RPMAssignment;
import edu.baylor.ecs.softproj.service.ReviewService;
import edu.baylor.ecs.softproj.service.UserService;
import edu.baylor.ecs.softproj.service.ArtifactService;
import edu.baylor.ecs.softproj.service.FileService;
import edu.baylor.ecs.softproj.service.RPMAssignmentService;
import edu.baylor.ecs.softproj.service.TeamService;
import edu.baylor.ecs.softproj.web.helper.FacesMessages;
import java.io.IOException;
import java.io.InputStream;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 */
@Controller("rateartifactBean")
@Scope("request")
public class RateArtifact {
    @Autowired
    public ReviewService reviewService;
    
    @Autowired
    public ArtifactService artifactService;
    
    @Autowired
    public UserService userService;
    
    @Autowired
    public FileService fileService;
    
    @Autowired
    public TeamService teamService;
    
    @Autowired
    public RPMAssignmentService rpmAssignmentService;
    
    public StreamedContent file;
    
    private int rpmAssignmentId;
    private int rating;

    public StreamedContent getArtifactFile(Integer artifactId) throws IOException {
        Artifact a = artifactService.findById(artifactId);
        InputStream stream = fileService.downloadFile(a.getFilePath());
        file = new DefaultStreamedContent(stream, null, a.getFilePath());
        return file;
    }

    public int getRpmAssignmentId() {
        return rpmAssignmentId;
    }

    public void setRpmAssignmentId(int rpmAssignmentId) {
        this.rpmAssignmentId = rpmAssignmentId;
    }

    public RPMAssignment getRpmAssignment() {
        return rpmAssignmentService.getById(rpmAssignmentId);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
    
    public String postRating(){        
        RPMAssignment ass = getRpmAssignment();
        ass.setRPMToArtifactRating(rating);
        rpmAssignmentService.update(ass);
        FacesMessages.addInfoMessage("Rating submitted.");
        return "/dashboard.xhtml?faces-redirect=true";
    }
    
}
