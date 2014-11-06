/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.baylor.ecs.softproj.model;
import javax.persistence.*;
/**
 *
 * @author yong shui
 */
@Entity
@Table(name = "viewpermission")
@AttributeOverride(name = "id", column = @Column(name = "viewpermissionid"))
public class ViewPermission extends AbstractEntity{
    
}
