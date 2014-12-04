package edu.baylor.ecs.softproj.service;

import edu.baylor.ecs.softproj.model.Course;
/**
 *
 * @author Petr Smrcek <Petr_Smrcek@baylor.edu>
 * @author yong shui <yong_shui@baylor.edu>
 */
public interface CourseService {
    public Course getById(Integer id);
    public void create(Course course);
}
