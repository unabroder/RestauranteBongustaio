/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.OrdenCompra;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
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
public class OrdenCompraFacade extends AbstractFacade<OrdenCompra> implements OrdenCompraFacadeLocal {

    @PersistenceContext(unitName = "bongustaio")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenCompraFacade() {
        super(OrdenCompra.class);
    }
    @Override
    public List<OrdenCompra> consultaOrden(Date date1, Date date2) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        List<OrdenCompra> lista = new LinkedList<>();

        try {
            System.out.println("///////////cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
            String date = formato.format(date2);

            int dia = Integer.parseInt(date.substring(8, 10)) + 1;
            String resto = date.substring(0, 8) + dia;
            Date fecha2 = formato.parse(resto);

            String sql = "Select v from OrdenCompra v where v.fecha between ?1 and ?2";
            Query q = em.createQuery(sql);
            q.setParameter(1, date1);
            q.setParameter(2, fecha2);
            lista = q.getResultList();
            return lista;
            
        } catch (Exception e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            String sql = "Select v from OrdenCompra v";
            Query q = em.createQuery(sql);
            lista = q.getResultList();
            return lista;
        }
    }
}
