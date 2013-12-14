package controllers;

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
    
    @PostConstruct
    public void init() {
        if (mbAuth.isLogued()) {

            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

//            if (request.isUserInRole("JefePlanta")) {
//                ag.goToPage("/faces/jefePlanta/inicio.xhtml");
//            }
//            if (request.isUserInRole("Basculista")) {
//                ag.goToPage("/faces/basculista/registros.xhtml");
//            }
        }
    }

    public void login() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        if (mbAuth.login(username, password)) {

//            if (request.isUserInRole("JefePlanta")) {
//                ag.goToPage("/faces/jefePlanta/inicio.xhtml");
//            }
//            if (request.isUserInRole("Basculista")) {
//                ag.goToPage("/faces/basculista/registros.xhtml");
//            }
        } 
    }
}
