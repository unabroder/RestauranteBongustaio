/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Inventario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author josue.vasquezusam
 */
@Stateless
public class InventarioFacade extends AbstractFacade<Inventario> implements InventarioFacadeLocal {

    @PersistenceContext(unitName = "bongustaio")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventarioFacade() {
        super(Inventario.class);
    }

    @Override
    public List<Inventario> obtenerInv(String nombre) {
        try {
            Query query = em.createQuery("SELECT inv FROM Inventario inv join inv.idproducto pro where pro.nombre like '%"+nombre+"%'");
     
            List<Inventario> lsInventario = query.getResultList();
            return lsInventario;
        } catch (Exception e) {
            Query query = em.createQuery("SELECT inv FROM Inventario inv");
            List<Inventario> lsInventario = query.getResultList();
            return lsInventario;
        }

    }
}
