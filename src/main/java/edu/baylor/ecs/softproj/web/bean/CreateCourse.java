package edu.baylor.ecs.softproj.web.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import edu.baylor.ecs.softproj.service.UserService;
import edu.baylor.ecs.softproj.service.CourseService;
import java.util.List;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.model.Course;
import edu.baylor.ecs.softproj.web.helper.FacesMessages;
/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 */
@Controller("createcourseBean")
@Scope("request")
public class CreateCourse {
    @Autowired
    public UserService userService;
    
    @Autowired
    public CourseService courseService;

    private int lecturerId;
    private String name;

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<User> getUsers(){
        return userService.getAll();
    }
    
    public String createCourse(){
        Course course = new Course(name, userService.getById(lecturerId));
        
        courseService.create(course);
        FacesMessages.addInfoMessage("Course created.");
        return "/dashboard.xhtml?faces-redirect=true";
    }
}
