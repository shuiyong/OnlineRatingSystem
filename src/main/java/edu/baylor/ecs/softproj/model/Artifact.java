package edu.baylor.ecs.softproj.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * This class represents the Artifact in the database
 *
 * @author yong shui <yong_shui@baylor.edu, shuiyong90@gmail.com>
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Entity
public class Artifact extends AbstractEntity {

    @Column(length = 50, nullable = false)
    private String name;

    private int lecturerRating;

    @Column(length = 200, nullable = false)
    private String filePath;

    @OneToMany(mappedBy = "artifact")
    private Set<RPMAssignment> rpmAssginments;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "submitter_id")
    private User submitter;

    public Artifact() {
    }

    public Artifact(String name, String path, Team team, User submitter) {
        this.name = name;
        this.filePath = path;
        this.team = team;
        this.submitter = submitter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getLecturerRating() {
        return lecturerRating;
    }

    public void setLecturerRating(int lecturerRating) {
        this.lecturerRating = lecturerRating;
    }

    public Set<RPMAssignment> getRpmAssginments() {
        return rpmAssginments;
    }

    public void setRpmAssginments(Set<RPMAssignment> rpmAssginments) {
        this.rpmAssginments = rpmAssginments;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public User getSubmitter() {
        return submitter;
    }

    public void setSubmitter(User submitter) {
        this.submitter = submitter;
    }
}
