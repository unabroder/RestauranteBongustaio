/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tiposucursal;
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
public class TiposucursalFacade extends AbstractFacade<Tiposucursal> implements TiposucursalFacadeLocal {

    @PersistenceContext(unitName = "bongustaio")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposucursalFacade() {
        super(Tiposucursal.class);
    }

    @Override
    public List<Tiposucursal> findAllActivo() {

        List<Tiposucursal> lista = null;
        String sql;

        try {
            sql = "SELECT ts FROM tiposucursal ts WHERE estado=1";
            Query query = em.createQuery(sql);
            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    @Override
    public void removeEstado(Tiposucursal tsucursal) {

        String sql;
        try {
            sql = "UPDATE tiposucursal us set estado=0 WHERE idtiposucursal=?1";
            Query query = em.createQuery(sql);
            query.setParameter(1, tsucursal.getIdtiposucursal());
        } catch (Exception e) {
            throw e;
        }
    }

}
