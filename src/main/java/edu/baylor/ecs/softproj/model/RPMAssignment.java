/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.model;

import javax.persistence.*;

/**
 *
 * @author yong shui <yong_shui@baylor.edu
 */

@Table(name = "rpmassignment")
@AttributeOverride(name = "id", column = @Column(name = "rpmassignmentid"))
public class RPMAssignment extends AbstractEntity {
    @Column(name = "lecturerToRPMRating")
    private Integer lecturerToRPMRating;
    
    @Column(name = "RPMToArtifactRating")
    private Integer RPMToArtifactRating;
    
    @Column(name = "commend")
    private String commend;
    
    @OneToMany
    private ReviewAssignment reviewAssignment; //  add List<ReviewAssignment>
    
    public RPMAssignment(){}
    
    public RPMAssignment(Integer lecturerToRPMRating, 
            Integer RPMToArtifactRating, 
            String commend, 
            ReviewAssignment reviewAssignment){
        this.lecturerToRPMRating = lecturerToRPMRating;
        this.RPMToArtifactRating = RPMToArtifactRating;
        this.commend = commend;
        this.reviewAssignment = reviewAssignment;
    }
    
    public void setLecturerToRPMRating(int lecturerToRPMRating){
        this.lecturerToRPMRating = lecturerToRPMRating;
    }
    
    public void setRPMToArtifactRating(int RPMToArtifactRating){
        this.RPMToArtifactRating = RPMToArtifactRating;
    }
    
    public void setCommend(String commend){
        this.commend = commend;
    }
    
    public Integer getLecturerToRPMRaing(){
        return lecturerToRPMRating;
    }
    
    public Integer RPMToArtifactRating(){
        return RPMToArtifactRating;
    }
    
    public String getCommend(){
        return commend;
    }
}
