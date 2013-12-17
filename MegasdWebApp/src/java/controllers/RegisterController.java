package controllers;

import controllers.util.JsfUtil;
import entities.Users;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import managedbeans.MBAuth;
import sessionbeans.UsersFacadeLocal;

/**
 *
 * @author mario
 */
@Named(value = "registerController")
@RequestScoped
public class RegisterController {

    @Inject
    private MBAuth mbAuth;
    @EJB
    private UsersFacadeLocal ejbFacade;
    private String username;
    private String password;
    private String passwordConfirm;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
    public RegisterController() {
        
    }
    
    public void create() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if(password.compareTo(passwordConfirm) == 0) {
            ejbFacade.create(new Users(username, password, 1));
            mbAuth.setFlashMessage("Register successfully");
            JsfUtil.redirect("/faces/login.xhtml");
        } else {
            System.out.println("* Error: las contraseñas no coinciden "+ password +"!="+ passwordConfirm +".");
            mbAuth.setFlashMessage("Password don't match, try again.");
            JsfUtil.redirect("/faces/register.xhtml");
        }
    }
    
}
