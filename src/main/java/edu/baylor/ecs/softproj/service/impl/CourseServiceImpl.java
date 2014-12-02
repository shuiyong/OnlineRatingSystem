package edu.baylor.ecs.softproj.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.baylor.ecs.softproj.repository.CourseRepository;
import edu.baylor.ecs.softproj.service.CourseService;
import edu.baylor.ecs.softproj.model.Course;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author yong shui <yong_shui@baylor.edu>
 */
@Transactional
@Service("courseService")
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;
    
    @Override
    public Course getById(Integer id){
        return courseRepository.findOne(id);
    }
}
