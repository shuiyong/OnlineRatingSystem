/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.model;

import javax.persistence.AttributeOverride;
import javax.persistence.*;

/**
 * This class represents the Artifact in the database
 * @author yong shui <yong_shui@baylor.edu, shuiyong90@gmail.com>
 */
@Table(name = "artifact")
@AttributeOverride(name = "id", column = @Column(name = "artifactId"))
public class Artifact extends AbstractEntity {
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Column(name = "lecturerRating")
    private int lecturerRating; // double or integer?
    @Column(name = "path", length = 200, nullable = false)
    private String path;
    
    @OneToMany
    private RPMAssignment rpmAssginment;
    
    public Artifact(){}
    
    public Artifact(String name, int lecturerRating, String path,RPMAssignment rpmAssginment){
        this.name = name;
        this.lecturerRating = lecturerRating;
        this.path = path;
        this.rpmAssginment = rpmAssginment;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getPath(){
        return path;
    }
    
    public void setPath(String path){
        this.path = path;
    }
    
    public int getLecturerRating(){
        return lecturerRating;
    }
    
    public void setLecturerRating(int lecturerRating){
        this.lecturerRating = lecturerRating;
    }
}
