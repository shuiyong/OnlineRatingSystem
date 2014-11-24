/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.web.bean;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.model.Team;
import edu.baylor.ecs.softproj.model.TeamMember;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.service.ReviewService;
import edu.baylor.ecs.softproj.service.UserService;
import edu.baylor.ecs.softproj.service.ArtifactService;
import edu.baylor.ecs.softproj.service.FileService;
import edu.baylor.ecs.softproj.service.TeamService;
import java.util.Set;
import java.io.IOException;
import java.io.InputStream;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
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
    
    public StreamedContent file;
    
    private String content;
    private int myArtifactId;
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
    
    public int getMyArtifactId(){
        return myArtifactId;
    }
    
    public void setMyArtifactId(int myArtifactId){
        this.myArtifactId = myArtifactId;
    }
    
    public void setMyArtifactId(String myArtifactId){
        this.myArtifactId = Integer.parseInt(myArtifactId);
    }
    
    public Artifact getArtifact() {
        if (artifact == null || artifact.getId() != myArtifactId) {
            artifact = artifactService.findById(myArtifactId);
        }
        return artifact;
    }
    
    public Set<ReviewAssignment> getUnreviewedArtifacts(Team team){
        User user = userService.getCurrentUser();
        TeamMember tm = teamService.getTeamMemberByUserAndTeam(user, team);
        return reviewService.getReviewAssignment(tm);
    }
    
    public void createReview(Team team){
        TeamMember tm = teamService.getTeamMemberByUserAndTeam(userService.getCurrentUser(), team);
        ReviewAssignment ra = artifactService.getAssignment(
                tm, 
                myArtifactId);
        if(ra != null)
            reviewService.createReview(content, ra, Integer.parseInt(rating));
        else{
            //do something to show the error
        }
    }
    
}
