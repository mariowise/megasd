/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import controllers.UsersController;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aldo
 */
@Named(value = "mbAuth")
@SessionScoped
public class MBAuth implements Serializable {

//    @EJB
//    private AuditoriaLocal auditoria;
//    @EJB
//    private UsersController userController;
    private String username;
    
    private String flashMessage;
    
    private Boolean flash;

    public Boolean getFlash() {
        return flash;
    }

    public void setFlash(Boolean flash) {
        this.flash = flash;
    }

    public String getFlashMessage() {
        String response = flashMessage;
        flashMessage = "";
        flash = false;
        return response;
    }

    public void setFlashMessage(String flashMessage) {
        flash = true;
        this.flashMessage = flashMessage;
    }
       

    
    public String getRutRecuperar() {
        return username;
    }

    public void setRutRecuperar(String username) {
        this.username = username;
    }

    public MBAuth() {
    }

    public boolean login(String _username, String _password) {

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        try {
            if(!hasIdentity()) {
                request.login(_username, _password);
            }
            return true;
            
        } catch (Exception e) {
            System.out.println("Usuario o contraseña inválidos");
            // mc.mensajeRetroalimentacion("Error", "Usuario y/o contraseña incorrecta");
        }
        return false;
    }

    public void logout() {
        // registrarAccion("Cierre de sesión");
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.invalidateSession();
        
        try {

            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(MBAuth.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean hasIdentity(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        
        if(request.getRemoteUser()==null){
            return false;
        }
        return true;
    }

}
