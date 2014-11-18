/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.service;
import edu.baylor.ecs.softproj.model.Course;
/**
 *
 * @author yong shui <yong_shui@baylor.edu>
 */
public interface CourseService {
    public Course getById(Integer id);
}
