/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.model;

import javax.persistence.*;

/**
 *
 * @author yong shui <yong_shui@baylor.edu>
 */
@Entity
@Table(name = "team")
@AttributeOverride(name = "id", column = @Column(name = "teamid"))
public class Team extends AbstractEntity {
    @ManyToOne
    private Course course;
    
    @OneToOne // I assume every team has one RPM
    private User RPM;
    public Team(Course course, User RPM){
        this.course = course;
        this.RPM = RPM;
    }
}
