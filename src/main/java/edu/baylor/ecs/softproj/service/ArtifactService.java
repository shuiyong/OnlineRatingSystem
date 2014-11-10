/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.service;
import  edu.baylor.ecs.softproj.model.Artifact;
import edu.baylor.ecs.softproj.model.RPMAssignment;
import  edu.baylor.ecs.softproj.model.User;
import java.util.Date;
/**
 *
 * @author yong shui <yong_shui@baylor.edu>
 * @author  Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
public interface ArtifactService {
    
    public void assgnArtifact(RPMAssignment rpmAssignment, User u, Date deadline);
    
    public Artifact findById(Integer id);
    
}
