/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.model;
import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author yong shui<yong_shui@baylor.edu>
 */
@Entity
@Table(name = "review")
@AttributeOverride(name = "id", column = @Column(name = "reviewid"))
public class Review extends AbstractEntity{
    @Column(name = "submitted")
    private Date submitted;
    @Column(name = "reviewtoartifact")
    private Integer reviewToArtifact;
    @Column(name = "content")
    private String content;
    
    public Review(Date submitted, Integer reviewToArtifact, String content){
        this.submitted = submitted;
        this.reviewToArtifact = reviewToArtifact;
        this.content = content;
    }
    
    public Date getDate(){
        return submitted;
    }
    
    public void setDate(Date submitted){
        this.submitted = submitted;
    }
    
    public Integer getReviewToArtifact(){
        return reviewToArtifact;
    }
    
    public void setReviewToArtifact(Integer reviewToArtifact){
        this.reviewToArtifact = reviewToArtifact;
    }
    
    public String getContent(){
        return content;
    }
    
    public void setContent(String content){
        this.content = content;
    }
}
