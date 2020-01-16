
package ejb;

import entity.Venta;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;


@Local
public interface VentaFacadeLocal {
    
    void create(Venta venta);
    
    void edit(Venta venta);
    
    void remove(Venta venta);
    
    Venta find(Object id);
    
    List<Venta> findAll();
    
    List<Venta> findRange(int[] range);
    
    int count();
    
    List<Venta> consultarVenta(Date date1, Date date2);
    
}
