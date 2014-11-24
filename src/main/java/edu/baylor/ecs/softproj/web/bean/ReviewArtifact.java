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
import edu.baylor.ecs.softproj.service.FileService;
import java.util.Set;
import java.io.File;
import java.io.FileReader;
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
    
    public StreamedContent file;
    
    private String content;
    private String myArtifactId;
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

    public StreamedContent getFile() throws IOException {
        if (file == null && myArtifactId != null) {
            Artifact a = artifactService.findById(Integer.parseInt(myArtifactId));
            InputStream stream = fileService.downloadFile(a.getFilePath());
            file = new DefaultStreamedContent(stream, null, a.getName());
        }
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
            reviewService.createReview(content, ra, Integer.parseInt(rating));
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
