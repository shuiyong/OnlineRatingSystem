package edu.baylor.ecs.softproj.web.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import edu.baylor.ecs.softproj.service.UserService;
import edu.baylor.ecs.softproj.service.TeamService;
import edu.baylor.ecs.softproj.service.CourseService;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import edu.baylor.ecs.softproj.model.User;
import edu.baylor.ecs.softproj.model.Course;
/**
 *
 * @author yong shui <yong_shui@baylor.edu>
 * @author yong shui <Vaclav_Cibur@baylor.edu>
 * 
 */
@Controller("createteamBean")
@Scope("session")
public class CreateTeam {
    @Autowired
    public TeamService teamService;
    
    @Autowired
    public UserService userService;
    
    @Autowired
    public CourseService courseService;
    
    private List<String> studentIds;
    private String courseId;
    private String rpmId;
    private String name;

    public String getName() {
        return courseService.getById(Integer.parseInt(courseId)).getName();
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Set<Course> getCourse(){
        User user = userService.getCurrentUser();
        return userService.getCourse(user);
    }
    
    public List<User> getStudents(){
        return userService.getStudents(userService.getCurrentUser(), Integer.parseInt(courseId));
    }
    
    public String createTeam(){
        Set<User> students = new HashSet<User>();
        for (int i = 0; i < studentIds.size();i++){
            students.add(userService.getById(Integer.parseInt(studentIds.get(i))));
        }
        Course course = courseService.getById(Integer.parseInt(courseId));        
        teamService.createTeam(course, students);
        return "/dashboard.xhtml?faces-redirect=true";
    }
    
    public void setStudentIds(List<String> studentIds) {
        this.studentIds = studentIds;
    }

    public List<String> getStudentIds() {
        return studentIds;
    }
    
    public void setCourseId(String courseId){
        this.courseId = courseId;
    }
    
    public String getCourseId(){
        return courseId;
    }
    
    public void setRpmId(String rpmId){
        this.rpmId = rpmId;
    }
    
    public String getRpmId(){
        return rpmId;
    }
}
