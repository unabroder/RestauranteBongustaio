
package ejb;

import entity.Plato_Completo;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class Plato_CompletoFacade extends AbstractFacade<Plato_Completo> implements Plato_CompletoFacadeLocal{
    
    @PersistenceContext(unitName = "bongustaio")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
    public Plato_CompletoFacade(){
        super(Plato_Completo.class);
    }
    
    public List<Plato_Completo> consultaEstado(int estado){
        String sql="select pc from plato_completo where pc.estado=1";
        
        List<Plato_Completo> lista=new LinkedList<>();
        try {
            Query q=em.createQuery(sql);
            q.setParameter(1, estado);
            lista=q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return lista;
        }
        return lista;
    }

    @Override
    public List<Plato_Completo> obtenerPlatoCompletoPorTipoProducto(int idTipoProducto) {
        Query query = em.createQuery("SELECT pc FROM Plato_Completo pc join pc.idcatalogo ca join ca.idtipoproduc tp where tp.idtipoproducto = :idTipoProducto");
        query.setParameter("idTipoProducto", idTipoProducto);
        List<Plato_Completo> platosCompletos = query.getResultList();
        return platosCompletos;
    }
    
     @Override
    public List<Plato_Completo> platoPrecio(Plato_Completo pp){
        Query query = em.createQuery("SELECT pc FROM Plato_Completo pc join pc.idcatalogo ca join ca.idtipoproduc tp where pc.idplato_completo = :idplato");
        query.setParameter("idplato", pp.getIdplato_completo());
        List<Plato_Completo> platosCompletos = query.getResultList();
        return platosCompletos;
    }
}
