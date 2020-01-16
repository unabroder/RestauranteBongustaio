/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tiposucursal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author josue.vasquezusam
 */


@Local
public interface TiposucursalFacadeLocal {

    void create(Tiposucursal tsucursal);

    void edit(Tiposucursal tsucursal);

    void remove(Tiposucursal tsucursal);

    Tiposucursal find(Object id);

    List<Tiposucursal> findAll();

    List<Tiposucursal> findRange(int[] range);

    int count();

    List<Tiposucursal> findAllActivo();

    void removeEstado(Tiposucursal tsucursal);

}
