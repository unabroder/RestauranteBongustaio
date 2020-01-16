/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.TipoEmpleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author roberto.alferesusam
 */
@Local
public interface TipoEmpleadoFacadeLocal {

    void create(TipoEmpleado tipo);

    void edit(TipoEmpleado tipo);

    void remove(TipoEmpleado tipo);

    TipoEmpleado find(Object id);

    List<TipoEmpleado> findAll();

    List<TipoEmpleado> findRange(int[] range);

    int count();
}
