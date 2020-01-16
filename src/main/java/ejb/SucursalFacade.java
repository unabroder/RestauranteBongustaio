package ejb;

import entity.Sucursal;
import entity.Tiposucursal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class SucursalFacade extends AbstractFacade<Sucursal> implements SucursalFacadeLocal {

    @PersistenceContext(unitName = "bongustaio")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SucursalFacade() {
        super(Sucursal.class);
    }

    public void Estado(Sucursal sucursal) {
        String sql;
        System.out.println(sucursal.getIdsucursal());
        try {
            sql = "UPDATE Sucursal s set s.estado=?1 WHERE s.idsucursal=?2";
            Query query = em.createQuery(sql);
            query.setParameter(1, sucursal.getEstado());
            query.setParameter(2, sucursal.getIdsucursal());
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public List<Sucursal> findAllActivo() {

        List<Sucursal> lista = null;
        String sql;

        try {
            sql = "SELECT s FROM sucursal s WHERE estado=1";
            Query query = em.createQuery(sql);
            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return lista;

    }

  

}
