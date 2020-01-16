package ejb;

import entity.Proveedor;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author joqtan.marmolusam
 */
@Stateless
public class ProveedorFacade extends AbstractFacade<Proveedor> implements ProveedorFacadeLocal{
        
    @PersistenceContext(unitName = "bongustaio")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }        
    public ProveedorFacade(){
        super(Proveedor.class);
    }        
    
    public List<Proveedor> consulta(){
        String sql = "select p from proveedor p";
        List<Proveedor> lista = new LinkedList<>();
        try {
            Query q = em.createQuery(sql);
            lista = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return lista;
        }
        return lista;
    }
    
    public List<Proveedor> consultaXid(int id){
        String sql = "select p from proveedor p where p.idproveedor = ?";
        List<Proveedor> lista = new LinkedList<>();
        try {
            Query q = em.createQuery(sql);
            q.setParameter(1, id);
            lista = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return lista;
        }
        return lista;
    }
}
