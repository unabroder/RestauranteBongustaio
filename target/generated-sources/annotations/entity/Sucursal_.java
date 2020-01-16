package entity;

import entity.Tiposucursal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-15T09:33:56")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile SingularAttribute<Sucursal, Integer> estado;
    public static volatile SingularAttribute<Sucursal, String> direccion;
    public static volatile SingularAttribute<Sucursal, Integer> idsucursal;
    public static volatile SingularAttribute<Sucursal, Tiposucursal> idtipo;
    public static volatile SingularAttribute<Sucursal, String> telefono;
    public static volatile SingularAttribute<Sucursal, String> nombre;

}