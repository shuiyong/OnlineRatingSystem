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
@Table(name = "teammember")
@AttributeOverride(name = "id", column = @Column(name = "teammemberid"))
public class TeamMember extends AbstractEntity {
    @ManyToOne
    private Team team;
    
    public TeamMember(Team team){
        this.team = team;
    }
}
