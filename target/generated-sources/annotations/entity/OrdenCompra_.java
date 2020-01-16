package entity;

import entity.Producto;
import entity.Proveedor;
import entity.Sucursal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-15T09:33:56")
@StaticMetamodel(OrdenCompra.class)
public class OrdenCompra_ { 

    public static volatile SingularAttribute<OrdenCompra, Proveedor> idproveedor;
    public static volatile SingularAttribute<OrdenCompra, Date> fecha;
    public static volatile SingularAttribute<OrdenCompra, Integer> estado;
    public static volatile SingularAttribute<OrdenCompra, Sucursal> idsucursal;
    public static volatile SingularAttribute<OrdenCompra, Integer> idorden_compra;
    public static volatile SingularAttribute<OrdenCompra, Integer> cantidad;
    public static volatile SingularAttribute<OrdenCompra, Producto> idproducto;

}