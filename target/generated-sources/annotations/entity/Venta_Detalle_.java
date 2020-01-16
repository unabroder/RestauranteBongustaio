package entity;

import entity.Plato_Completo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-15T09:33:56")
@StaticMetamodel(Venta_Detalle.class)
public class Venta_Detalle_ { 

    public static volatile SingularAttribute<Venta_Detalle, Integer> estado;
    public static volatile SingularAttribute<Venta_Detalle, Integer> codigo;
    public static volatile SingularAttribute<Venta_Detalle, Integer> idventa_detalle;
    public static volatile SingularAttribute<Venta_Detalle, Plato_Completo> idplato_completo;
    public static volatile SingularAttribute<Venta_Detalle, Integer> cantidad;

}