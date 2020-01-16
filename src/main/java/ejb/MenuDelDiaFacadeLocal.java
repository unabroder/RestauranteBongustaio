/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.MenuDelDia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mirian.floresusam
 */
@Local
public interface MenuDelDiaFacadeLocal {

    void create(MenuDelDia menuDelDia);

    void edit(MenuDelDia menuDelDia);

    void remove(MenuDelDia menuDelDia);

    MenuDelDia find(Object id);

    List<MenuDelDia> findAll();

    List<MenuDelDia> findRange(int[] range);

    int count();
    
}
