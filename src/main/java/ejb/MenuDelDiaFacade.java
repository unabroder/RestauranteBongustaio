/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.MenuDelDia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mirian.floresusam
 */
@Stateless
public class MenuDelDiaFacade extends AbstractFacade<MenuDelDia> implements MenuDelDiaFacadeLocal {

    @PersistenceContext(unitName = "bongustaio")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuDelDiaFacade() {
        super(MenuDelDia.class);
    }
    
}
