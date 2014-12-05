package edu.baylor.ecs.softproj.web.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import edu.baylor.ecs.softproj.service.UserService;
import edu.baylor.ecs.softproj.web.helper.FacesMessages;
/**
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
@Controller("createUserBean")
@Scope("request")
public class CreateUser {
    
    @Autowired
    public UserService userService;
    
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private boolean admin;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public String createUser() {
        userService.create(username, password, firstname, lastname, admin);
        FacesMessages.addInfoMessage("User created.");
        return "/dashboard.xhtml?faces-redirect=true";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
