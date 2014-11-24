/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.service;
import edu.baylor.ecs.softproj.model.ReviewAssignment;
/**
 *
 * @author yong shui <yong_shui@baylor.edu>
 */
public interface ReviewService {
    public boolean createReview(String content, ReviewAssignment reviewAssignment, Integer rating);
}
