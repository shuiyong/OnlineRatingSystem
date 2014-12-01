package edu.baylor.ecs.softproj.service.impl;

import edu.baylor.ecs.softproj.model.ReviewAssignment;
import edu.baylor.ecs.softproj.repository.ReviewAssignmentRepository;
import edu.baylor.ecs.softproj.service.ReviewAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Transactional
@Service("reviewAssignmentService")
public class ReviewAssignmentServiceImpl implements ReviewAssignmentService {
    
    @Autowired
    private ReviewAssignmentRepository reviewAssignmentRepository;

    @Override
    public ReviewAssignment getById(Integer id) {
        return reviewAssignmentRepository.findOne(id);
    }
    
}
