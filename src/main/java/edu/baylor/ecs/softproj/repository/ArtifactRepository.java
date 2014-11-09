/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.repository;

import edu.baylor.ecs.softproj.model.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yong
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
public interface ArtifactRepository extends JpaRepository<Artifact, Integer> {
    
}
