
package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "roles")
public class Roles {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idrol;
    
    @Column(name = "rol")
    private String rol;
    
    @Column(name = "estado")
    private int estado;

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idrol;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Roles other = (Roles) obj;
        if (this.idrol != other.idrol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Roles{" + "idrol=" + idrol + '}';
    }
    
    
    
}
