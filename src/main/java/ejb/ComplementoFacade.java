package ejb;

import entity.Complemento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ComplementoFacade extends AbstractFacade<Complemento> implements ComplementoFacadeLocal {

    @PersistenceContext(unitName = "bongustaio")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComplementoFacade() {
        super(Complemento.class);
    }

    @Override
    public List<Complemento> precioComplemento(Complemento c) {
        Query query = em.createQuery("SELECT c FROM Complemento c where c.idcomplemento = :id");
        query.setParameter("id", c.getIdcomplemento());
        List<Complemento> lsComp = query.getResultList();
        return lsComp;
    }
}
