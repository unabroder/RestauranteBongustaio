/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Usuarios;
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
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "bongustaio")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
     
    @Override
    public Usuarios Sesion(Usuarios us){
        Usuarios user = null;
        String sql;
        try {
            sql = "SELECT u FROM Usuarios u WHERE u.usuario = ?1 and  u.clave = ?2";
            Query query = em.createQuery(sql);
            
            query.setParameter(1, us.getUsuario());
            query.setParameter(2, us.getClave());
            
            List<Usuarios> lista = query.getResultList();
            if (!lista.isEmpty()) {
                user = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return user;
    }
    
   @Override
    public List<Usuarios> obtenerEmp(int idusuario) {
        Query query = em.createQuery("SELECT u FROM Usuarios u join u.idempleado e where u.idusuario = :id");
        query.setParameter("id", idusuario);
        List<Usuarios> lsUsuario = query.getResultList();
        return lsUsuario;
    }  
}
