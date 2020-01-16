/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Tipoproducto;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "catalogo")
public class Catalogo implements Serializable{
    
  @Id  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idcatalogo;
  
   @Column(name = "nombre", nullable = true)
   private String nombre; 
   /*
<<<<<<< HEAD
=======

> */
   @ManyToOne
   @JoinColumn(name = "idtipoproduc", referencedColumnName = "idtipoproducto")
   private Tipoproducto idtipoproduc;

    public int getIdcatalogo() {
        return idcatalogo;
    }

    public void setIdcatalogo(int idcatalogo) {
        this.idcatalogo = idcatalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/*
<<<<<<< HEAD
=======
*/

    public Tipoproducto getIdtipoproduc() {
        return idtipoproduc;
    }

    public void setIdtipoproduc(Tipoproducto idtipoproduc) {
        this.idtipoproduc = idtipoproduc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idcatalogo;
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
        final Catalogo other = (Catalogo) obj;
        if (this.idcatalogo != other.idcatalogo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Catalogo{" + "idcatalogo=" + idcatalogo + ", nombre=" + nombre + ", idtipoproduc=" + idtipoproduc + '}';
    }
   
   
   
}
