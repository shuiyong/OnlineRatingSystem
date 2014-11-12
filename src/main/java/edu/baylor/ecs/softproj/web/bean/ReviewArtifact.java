/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.web.bean;

import edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.service.ReviewService;
import edu.baylor.ecs.softproj.service.UserService;
import edu.baylor.ecs.softproj.service.ArtifactService;
import java.util.Set;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    
    private String content;
    private String myArtifactId;
    private String artifactData;
    
    public String getContent(){
        return content;
    }
    
    public String getArtifactData(){
        return artifactData;
    }
    
    public void setArtifactData(String artifactData){
        this.artifactData = artifactData;
    }
    
    public void setContent(String content){
        this.content = content;
    }
    
    public String getMyArtifactId(){
        return myArtifactId;
    }
    
    public void setMyArtifactId(String myArtifactId){
        this.myArtifactId = myArtifactId;
    }
    
    public Set<Artifact> getUnreviewedArtifacts(){
        User user= userService.getCurrentUser();
        return artifactService.getArtifacts(user);
    }
    
    public void createReview(){
        ReviewAssignment ra = artifactService.getAssignment(
                userService.getCurrentUser(), 
                Integer.parseInt(myArtifactId));
        if(ra != null)
            reviewService.createReview(content, ra);
        else{
            //do something to show the error
        }
    }
    
    public void loadData(){
        String filepath = artifactService.getFilePath(Integer.parseInt(myArtifactId));
        File file = new File(filepath); //for ex foo.txt
        try {
            FileReader reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            artifactData = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
