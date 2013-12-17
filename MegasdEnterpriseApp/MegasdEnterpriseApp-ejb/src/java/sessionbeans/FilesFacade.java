/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.Files;
import entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mario
 */
@Stateless
public class FilesFacade extends AbstractFacade<Files> implements FilesFacadeLocal {
    @PersistenceContext(unitName = "MegasdEnterpriseApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilesFacade() {
        super(Files.class);
    }

    @Override
    public List<Files> findByUserId(int userid) {
        try {
            Query q = em.createNamedQuery("Files.findByUserId");
            q.setParameter("userId", new Users(userid));
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Problemas en el findByuserId("+ userid +")");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
