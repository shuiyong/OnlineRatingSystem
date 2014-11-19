/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.repository;

import edu.baylor.ecs.softproj.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yong shui<yong_shui@baylor.edu>
 */
public interface CourseRepository extends JpaRepository<Course, Integer>{
    
}
