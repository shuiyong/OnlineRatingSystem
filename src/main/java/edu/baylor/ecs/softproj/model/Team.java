/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author yong shui <yong_shui@baylor.edu>
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Entity
public class Team extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "rpm_id")
    private User rpm;

    @ManyToMany
    @JoinTable(
        name="team_member",
        joinColumns=@JoinColumn(name="team_id"),
        inverseJoinColumns=@JoinColumn(name="user_id")
    )
    private Set<User> teamMembers;

    @OneToMany(mappedBy = "team")
    private Set<Artifact> artifacts;

    public Team() {
    }
    
    public Set<User> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Set<User> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Set<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(Set<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public Team(Course course, User rpm) {
        this.course = course;
        this.rpm = rpm;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getRpm() {
        return rpm;
    }

    public void setRpm(User rpm) {
        this.rpm = rpm;
    }

}
