/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Complemento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author claudia.santosusam
 */
@Local
public interface ComplementoFacadeLocal {

    void create(Complemento complemento);

    void edit(Complemento complemento);

    void remove(Complemento complemento);

    Complemento find(Object id);

    List<Complemento> findAll();

    List<Complemento> findRange(int[] range);

    int count();
    
    List<Complemento> precioComplemento(Complemento c);
}
