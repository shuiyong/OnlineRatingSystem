/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.Iterator;
/**
 *
 * @author yong shui <yong_shui@baylor.edu>
 */
@Controller("createteamBean")
@Scope("request")
public class createTeam {
    @Autowired
    public TeamService teamService;
    
    @Autowired
    public UserService userService;
    
    @Autowired
    public CourseService courseService;
    
    private List<String> studentIds;
    private String courseId;
    private String rpmId;
    
    public Set<Course> getCourse(){
        User user = userService.getCurrentUser();
        return userService.getCourse(user);
    }
    
    public List<User> getStudents(){
        User user = userService.getCurrentUser();
        List<User> userlist= userService.getStudents(user);
        for(Iterator<User> iterator = userlist.iterator(); iterator.hasNext();){
            User tmp = iterator.next();
            if(tmp.getId().equals(user.getId()))
                iterator.remove();
        }
        return userlist;
    }
    
    public void createTeam(){
        Set<User> students = new HashSet<User>();
        for (int i = 0; i < studentIds.size();i++){
            students.add(userService.getById(Integer.parseInt(studentIds.get(i))));
        }
        
        Course course = courseService.getById(Integer.parseInt(courseId));
        User user = userService.getById(Integer.parseInt(rpmId));
        
        teamService.createTeam(course, students);
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
