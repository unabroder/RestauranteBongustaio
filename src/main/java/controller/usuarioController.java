package controller;

import ejb.BitacoraFacadeLocal;
import ejb.EmpleadoFacadeLocal;
import ejb.RolesFacadeLocal;
import ejb.UsuariosFacadeLocal;
import entity.Bitacora;
import entity.Empleado;
import entity.Roles;
import entity.Usuarios;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "usuarioController")
@SessionScoped
public class usuarioController implements Serializable {

    private String mensaje;

    @EJB
    private UsuariosFacadeLocal usuariofacade;
    private Usuarios usuarios;
    private List<Usuarios> listausuario;

    @EJB
    private BitacoraFacadeLocal bitacoraEJB;
    private Bitacora bitacora;
    private List<Bitacora> lsBitacora;

    @EJB
    private EmpleadoFacadeLocal empleadoEJB;
    private Empleado empleado;
    private List<Empleado> lsEmpleado;

    @EJB
    private RolesFacadeLocal rolEJB;
    private Roles roles;
    private List<Roles> lsRoles;

    public Bitacora getBitacora() {
        return bitacora;
    }

    public void setBitacora(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

    public List<Bitacora> getLsBitacora() {
        return lsBitacora;
    }

    public void setLsBitacora(List<Bitacora> lsBitacora) {
        this.lsBitacora = lsBitacora;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuarios> getListausuario() {
        listausuario = usuariofacade.findAll();
        return listausuario;
    }

    public void setListausuario(List<Usuarios> listausuario) {
        this.listausuario = listausuario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getLsEmpleado() {
        lsEmpleado = empleadoEJB.findAll();
        return lsEmpleado;
    }

    public void setLsEmpleado(List<Empleado> lsEmpleado) {
        this.lsEmpleado = lsEmpleado;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public List<Roles> getLsRoles() {
        lsRoles = rolEJB.findAll();
        return lsRoles;
    }

    public void setLsRoles(List<Roles> lsRoles) {
        this.lsRoles = lsRoles;
    }

    @PostConstruct
    public void inti() {
        usuarios = new Usuarios();
        bitacora = new Bitacora();
        empleado = new Empleado();
        roles = new Roles();
    }

    public String login() {
        Usuarios us;
        String redireccion = null;
        try {
            us = usuariofacade.Sesion(usuarios);

            if (us != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", us);
                String accion = "inicio de sesion por " + usuarios.getUsuario();
                bitacora.setAccion(accion);
                bitacora.setUsuario(us);
                bitacoraEJB.create(bitacora);
                redireccion = "modulos?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usuario o clave incorrecta"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error" + e));
        }
        return redireccion;
    }

    public String cerrar() {
        try {
            SesionController.iniciarSesion(FacesContext.getCurrentInstance());
            SesionController.cerrarSesion();

            return "index?faces-redirect=true";
        } catch (Exception e) {
            throw e;
        }
    }

    public String cerrar2() {
        try {
            SesionController.iniciarSesion(FacesContext.getCurrentInstance());
            SesionController.cerrarSesion();

            return "/index?faces-redirect=true";
        } catch (Exception e) {
            throw e;
        }
    }

    public String validacion1() {
        String redireccion = null;
        try {
            Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            if (us == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
                redireccion = "../../index?faces-redirect=true";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return redireccion;
    }

    public String validacion2() {
        String redireccion = null;
        try {
            Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            if (us == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                redireccion = "index?faces-redirect=true";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return redireccion;
    }

    public void validacionRol() {
        Usuarios us;
        try {
            us = usuariofacade.Sesion(usuarios);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", us);
            if (us != null) {
                String cargo = us.getIdtipo().getRol();
                System.out.println(cargo);
                switch (cargo) {
                    case "Administrador":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("Administrador/Venta.xhtml");
                        break;
                    case "TI":
//                       FacesContext.getCurrentInstance().getExternalContext().redirect("modulos.xhtml");
                        break;
                    case "Gerente":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("mantenimiento.xhtml?faces-redirect=true");
                        break;
                    case "Vendedor":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("Ventas/venta.xhtml");
                        break;
                    case "Cocinero":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("Proveedores/Producto.xhtml?faces-redirect=true");
                        break;
                    default:
                        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                        System.out.println("Ocurrio un error");
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //return redireccion;

    }

    public void guardar() {
        try {
            usuarios.setIdtipo(roles);
            usuarios.setIdempleado(empleado);
            usuariofacade.create(usuarios);
            mensaje = "Se guardo el usuario";
        } catch (Exception e) {
            mensaje = "No se guardo " + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void leerId(Usuarios us) {
        roles.setIdrol(us.getIdtipo().getIdrol());
        empleado.setIdempleado(us.getIdempleado().getIdempleado());
        usuarios = us;
    }

    public void modificar() {
        try {
            usuarios.setIdtipo(roles);
            usuarios.setIdempleado(empleado);
            usuariofacade.edit(usuarios);
            mensaje = "Se modifico el usuario";
        } catch (Exception e) {
            mensaje = "No se modifico " + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void eliminar(Usuarios us) {
        try {
            usuarios = us;
            usuariofacade.remove(usuarios);
            mensaje = "Se elimino el usuario";
        } catch (Exception e) {
            mensaje = "No se elimino " + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void limpiar() {
        empleado = new Empleado();
        usuarios = new Usuarios();
        roles = new Roles();
    }
}
