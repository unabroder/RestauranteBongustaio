/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Usuarios;
import java.util.Enumeration;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author josue.vasquezusam
 */
@Named(value = "sesionController")
@ViewScoped
public class SesionController {

    private static HttpSession httpSession;
    private static Boolean sesionActiva;

    public static void iniciarSesion(FacesContext fc) {
        httpSession = (HttpSession) fc.getExternalContext().getSession(false);
    }

    public static void cerrarSesion() {
        Enumeration<String> atributos = null;

        try {
            if (httpSession != null && httpSession.getId() != null && !httpSession.getId().isEmpty()) {
                sesionActiva = false;

                atributos = httpSession.getAttributeNames();

                while (atributos.hasMoreElements()) {
                    String atributo = atributos.nextElement();

                    httpSession.removeAttribute(atributo);
                }

                httpSession.invalidate();
            } else {
                throw new Exception("Error en el cierre de sesin");
                // TODO Agregar excepciones de sistema
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

   
}
