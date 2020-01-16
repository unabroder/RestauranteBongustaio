package entity;

import entity.Catalogo;
import entity.Especialidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-15T09:33:56")
@StaticMetamodel(Plato_Completo.class)
public class Plato_Completo_ { 

    public static volatile SingularAttribute<Plato_Completo, Double> precio;
    public static volatile SingularAttribute<Plato_Completo, Integer> estado;
    public static volatile SingularAttribute<Plato_Completo, Integer> idplato_completo;
    public static volatile SingularAttribute<Plato_Completo, Catalogo> idcatalogo;
    public static volatile SingularAttribute<Plato_Completo, Especialidad> idespecialidad;
    public static volatile SingularAttribute<Plato_Completo, String> nombre;

}