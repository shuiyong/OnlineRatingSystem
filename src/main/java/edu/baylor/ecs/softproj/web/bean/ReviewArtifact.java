package edu.baylor.ecs.softproj.web.bean;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.model.TeamMember;
import edu.baylor.ecs.softproj.service.ReviewService;
import edu.baylor.ecs.softproj.service.UserService;
import edu.baylor.ecs.softproj.service.ArtifactService;
import edu.baylor.ecs.softproj.service.FileService;
import edu.baylor.ecs.softproj.service.ReviewAssignmentService;
import edu.baylor.ecs.softproj.service.TeamService;
import edu.baylor.ecs.softproj.web.helper.FacesMessages;
import java.util.Set;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author yong shui <yong_shui@baylor.edu>
 */
@Controller("reviewartifactBean")
@Scope("request")
public class ReviewArtifact {
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
    public ReviewAssignmentService reviewAssignmentService;
    
    public StreamedContent file;
    
    private String content;
    private int reviewAssignmentId;
    private Artifact artifact;
    private String artifactData;
    private String rating;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public String getContent(){
        return content;
    }
    
    public String getArtifactData(){
        return artifactData;
    }
    
    public void init(String artifactId) {
        
    }

    public StreamedContent getArtifactFile(Integer artifactId) throws IOException {
        Artifact a = artifactService.findById(artifactId);
        InputStream stream = fileService.downloadFile(a.getFilePath());
        file = new DefaultStreamedContent(stream, null, a.getFilePath());
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
    
    public void setArtifactData(String artifactData){
        this.artifactData = artifactData;
    }
    
    public void setContent(String content){
        this.content = content;
    }
    
    public int getReviewAssignmentId(){
        return reviewAssignmentId;
    }
    
    public void setReviewAssignmentId(int myArtifactId){
        this.reviewAssignmentId = myArtifactId;
    }
    
    public Artifact getArtifact() {
        if (artifact == null || artifact.getId() != reviewAssignmentId) {
            artifact = artifactService.findById(reviewAssignmentId);
        }
        return artifact;
    }
    
    public Set<ReviewAssignment> getUnreviewedReviewAssignments(TeamMember teamMember){
        Set<ReviewAssignment> ras = new HashSet<ReviewAssignment>();
        for (ReviewAssignment ra: reviewService.getReviewAssignment(teamMember)) {
            // if rpm hasn't finished rating yet
            if (ra.getRpmAssignment().getRPMToArtifactRating() == null) {
                ras.add(ra);
            }
        }
        return ras;
    }
    
    public String createReview(){        
        reviewService.createReview(content, reviewAssignmentService.getById(reviewAssignmentId), Integer.parseInt(rating));
        FacesMessages.addInfoMessage("Review submitted.");
        return "/dashboard.xhtml?faces-redirect=true";
    }
    
}
