package ejb;

import entity.Proveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author joqtan.marmolusam
 */
@Local
public interface ProveedorFacadeLocal {
    void create(Proveedor proveedor);
    
    void edit(Proveedor proveedor);
    
    void remove(Proveedor proveedor);
    
    Proveedor find(Object id);
    
    List<Proveedor> findAll();
    
    List<Proveedor> findRange(int[] range);
    
    int count();
    
}
