/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.model;
import javax.persistence.*;
/**
 *
 * @author yong
 */
@Entity
@Table(name = "course")
@AttributeOverride(name = "id", column = @Column(name = "courseid"))
public class Course extends AbstractEntity{
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    
    @OneToOne
    private User lecturer;
    
    public Course(String name, User lecturer){
        this.name = name;
        this.lecturer = lecturer;
    }
    
    public void setUser(User lecturer){
        this.lecturer = lecturer;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public User getLecturer(){
        return lecturer;
    }
}
