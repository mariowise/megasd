/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.Servers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mario
 */
@Stateless
public class ServersFacade extends AbstractFacade<Servers> implements ServersFacadeLocal {
    @PersistenceContext(unitName = "MegasdEnterpriseApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServersFacade() {
        super(Servers.class);
    }
    
}
