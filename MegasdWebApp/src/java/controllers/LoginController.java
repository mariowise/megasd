package controllers;

import controllers.util.JsfUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import managedbeans.MBAuth;

/**
 *
 * @author mario
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController {

    @Inject
    private MBAuth mbAuth;
    private String username;
    private String password;

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


    public LoginController() {
        
    }
    
//    @PostConstruct
//    public void init() {
//        System.out.println("\n\nIniciando LoginController");
//        if (mbAuth.isLogued()) {
//
//            FacesContext context = FacesContext.getCurrentInstance();
//            ExternalContext externalContext = context.getExternalContext();
//            HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
//            System.out.println("El usuario ya esta logeado y esta intentando denuevo");
//
//        } else {
//            System.out.println("El usuario no esta logeado");
//        }
//    }

    public void login() {
        System.out.println("Iniciando método de login");
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        if (mbAuth.login(username, password)) {
            System.out.println("Usuaro logeado de forma exitosa: " + username);
            JsfUtil.redirect("/faces/files/List.xhtml");
        } else {
            mbAuth.setFlashMessage("User or password don't match on database.");
            System.out.println("LOGIN FAIL!");
        }
    }
    
    public void logout() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.invalidateSession();
        System.out.println("El usuario ha realizado LOGOUT!");
        JsfUtil.redirect("/faces/login.xhtml");
    }
}
