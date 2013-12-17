/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.Files;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mario
 */
@Local
public interface FilesFacadeLocal {

    void create(Files files);

    void edit(Files files);

    void remove(Files files);

    Files find(Object id);
    
    Files findByUserId(int userid);

    List<Files> findAll();

    List<Files> findRange(int[] range);

    int count();
    
}
