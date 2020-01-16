package ejb;

import entity.Venta;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class VentaFacade extends AbstractFacade<Venta> implements VentaFacadeLocal {

    @PersistenceContext(unitName = "bongustaio")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaFacade() {
        super(Venta.class);
    }

    public List<Venta> consultaEstado(int estado) {
        String sql = "SELECT v FROM Venta v where v.estado=1";

        List<Venta> lista = new LinkedList<>();
        try {
            Query q = em.createQuery(sql);
            q.setParameter(1, estado);
            lista = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return lista;
        }
        return lista;
    }

    @Override
    public List<Venta> consultarVenta(Date date1, Date date2) {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        List<Venta> lista = new LinkedList<>();
        try {
            String date = formato.format(date2);

            int dia = Integer.parseInt(date.substring(8, 10)) + 1;
            System.out.println("el sumado es " + dia);
            String resto = date.substring(0, 8) + dia;
            System.out.println("resto de la fecha es " + resto);
            Date fecha2 = formato.parse(resto);
            String sql = "Select v from Venta v where v.fecha between ?1 and ?2";
            Query q = em.createQuery(sql);
            q.setParameter(1, date1);
            q.setParameter(2, fecha2);
            lista = q.getResultList();
            return lista;

        } catch (Exception e) {
            String sql = "Select v from Venta v";
            Query q = em.createQuery(sql);
            lista = q.getResultList();
            return lista;
        }
    }

}
