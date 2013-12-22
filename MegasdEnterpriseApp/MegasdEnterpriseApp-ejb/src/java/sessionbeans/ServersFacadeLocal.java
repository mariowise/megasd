/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.Servers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mario
 */
@Local
public interface ServersFacadeLocal {

    void create(Servers servers);

    void edit(Servers servers);

    void remove(Servers servers);

    Servers find(Object id);

    List<Servers> findAll();

    List<Servers> findRange(int[] range);

    int count();
    
}
