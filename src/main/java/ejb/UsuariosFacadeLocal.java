/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Roles;
import entity.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author josue.vasquezusam
 */
@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();
    
    Usuarios Sesion(Usuarios us);
    
    List<Usuarios> obtenerEmp(int idusuario);
}
