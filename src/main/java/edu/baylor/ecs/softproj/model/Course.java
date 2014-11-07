package edu.baylor.ecs.softproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author yong
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 */
@Entity
public class Course extends AbstractEntity {

    @Column(length = 50, nullable = false)
    private String name;

    @ManyToOne
    private User lecturer;

    public Course(String name, User lecturer) {
        this.name = name;
        this.lecturer = lecturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getLecturer() {
        return lecturer;
    }

    public void setLecturer(User lecturer) {
        this.lecturer = lecturer;
    }
}
