/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.UsersTypes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mario
 */
@Stateless
public class UsersTypesFacade extends AbstractFacade<UsersTypes> implements UsersTypesFacadeLocal {
    @PersistenceContext(unitName = "MegasdEnterpriseApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersTypesFacade() {
        super(UsersTypes.class);
    }
    
}
