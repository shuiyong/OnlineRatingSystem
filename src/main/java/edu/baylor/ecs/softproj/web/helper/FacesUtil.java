package edu.baylor.ecs.softproj.web.helper;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * This class is used in the presentation layer to show primefaces growl
 * messages to the user.
 *
 * @author Vaclav Cibur <Vaclav_Cibur@baylor.edu>
 */
public class FacesUtil {

    /**
     * Adds a message to the current JSF instance.
     * 
     * @param severity severity of the message
     * @param summary summary of the message
     * @param detail detail text of the message
     */
    public static void addMessage(Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

    /**
     * Adds a message to the current JSF instance.
     * 
     * @param severity severity of the message
     * @param text text of the message
     */
    public static void addMessage(Severity severity, String text) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, text, null));
    }

    /**
     * Adds a message to the current JSF instance.
     * 
     * @param text text ot fhe message
     */
    public static void addInfoMessage(String text) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(text));
    }

}
