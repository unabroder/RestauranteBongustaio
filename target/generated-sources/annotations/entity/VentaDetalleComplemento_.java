package entity;

import entity.Complemento;
import entity.Venta_Detalle;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-15T09:33:56")
@StaticMetamodel(VentaDetalleComplemento.class)
public class VentaDetalleComplemento_ { 

    public static volatile SingularAttribute<VentaDetalleComplemento, Complemento> idcomplemento;
    public static volatile SingularAttribute<VentaDetalleComplemento, Venta_Detalle> idventa_detalle;
    public static volatile SingularAttribute<VentaDetalleComplemento, Integer> idventaDetalle_complemento;
    public static volatile SingularAttribute<VentaDetalleComplemento, Integer> cantidad;

}