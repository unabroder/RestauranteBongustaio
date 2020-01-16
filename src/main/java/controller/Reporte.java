/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ejb.BitacoraFacadeLocal;
import ejb.OrdenCompraFacadeLocal;
import ejb.VentaFacadeLocal;
import entity.Bitacora;
import entity.OrdenCompra;
import entity.Venta;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author roberto.alferesusam
 */
@Named("reporteController")
@SessionScoped
public class Reporte implements Serializable {

    @EJB
    private VentaFacadeLocal ventaEJB;
    private Venta venta;
    private List<Venta> lsventa;

    @EJB
    private BitacoraFacadeLocal BitaEJB;
    private Bitacora bita;
    private List<Bitacora> lsBitacora;

    @EJB
    private OrdenCompra orden;
    private OrdenCompraFacadeLocal ordenEJB;
    private List<OrdenCompra> listaorde;

    public void reporte(List<Venta> lista2) {
        try {
            System.out.println("reporte de pdf ");
            // Creacion del documento con los margenes
            Document document = new Document(PageSize.A4, 35, 30, 50, 50);
            try {
                //String path= new File(".").;
                //String File_name=path+"/reporte.pdf";
                // El archivo pdf que vamos a generar
                Date fecha = new Date();

                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

                FileOutputStream fileOutputStream = new FileOutputStream("C:/reportes/Reporte_Venta_" + format.format(fecha) + ".pdf");

                // Obtener la instancia del PdfWriter
                PdfWriter.getInstance(document, fileOutputStream);

                // Abrir el documento
                document.open();

                // Crear las fuentes para el contenido y los titulos
                Font fontContenido = FontFactory.getFont(
                        FontFactory.TIMES_ROMAN.toString(), 11, Font.NORMAL,
                        BaseColor.DARK_GRAY);
                Font fontTitulos = FontFactory.getFont(
                        FontFactory.TIMES_BOLDITALIC, 11, Font.UNDERLINE,
                        BaseColor.RED);

                lsventa = lista2;

                Paragraph paragraph = new Paragraph();
//
                // Agregar un titulo con su respectiva fuente
                paragraph.add(new Phrase("Bitacora de ventas \n \n", fontTitulos));
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);

                document.add(paragraph);
                PdfPTable table = new PdfPTable(7);
                table.addCell("ID");
                table.addCell("Nombre Empleado");
                table.addCell("Platillo");
                table.addCell("Complemento");
                table.addCell("Cantidad");
                table.addCell("Fecha");
                table.addCell("Total");

                Iterator iter = lsventa.listIterator();

                while (iter.hasNext()) {
                    System.out.println("while");
                    venta = (Venta) iter.next();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    table.addCell("" + venta.getIdventa());
                    table.addCell(venta.getEmpleado().getNombres() + " \n" + venta.getEmpleado().getApellidos());
                    table.addCell(venta.getPlatoCompleto().getNombre());
                    table.addCell(venta.getComplemento().getNombre());
                    table.addCell("" + venta.getCantidad());
                    table.addCell(formato.format(venta.getFecha()));
                    table.addCell("" + venta.getTotal());

                }
                // Creacion de una tabla

                document.add(table);

                document.close();

                // Abrir el archivo
                File file = new File("C:/reportes/reporte_" + format.format(fecha) + ".pdf");
                System.out.println(file.getAbsolutePath());
            } catch (DocumentException | FileNotFoundException ex) {
                System.out.println("error " + ex.getMessage());
            }
            //return true;
            System.out.println("se creo el reporte");
        } catch (Exception e) {
            // return false;
        }

    }

//    public static void main(String[] args) {
//        Reporte pdf = new Reporte();
//        pdf.reporte();
//    }
    public void reporteOrden(List<OrdenCompra> lista2) {
        try {
            System.out.println("reporte de pdf de ordenes");
            // Creacion del documento con los margenes
            Document document = new Document(PageSize.A4, 35, 30, 50, 50);
            try {
                //String path= new File(".").;
                //String File_name=path+"/reporte.pdf";
                // El archivo pdf que vamos a generar
                Date fecha = new Date();

                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

                FileOutputStream fileOutputStream = new FileOutputStream("C:/reportes/Reporte_Compra_" + format.format(fecha) + ".pdf");

                // Obtener la instancia del PdfWriter
                PdfWriter.getInstance(document, fileOutputStream);

                // Abrir el documento
                document.open();

                // Crear las fuentes para el contenido y los titulos
                Font fontContenido = FontFactory.getFont(
                        FontFactory.TIMES_ROMAN.toString(), 11, Font.NORMAL,
                        BaseColor.DARK_GRAY);
                Font fontTitulos = FontFactory.getFont(
                        FontFactory.TIMES_BOLDITALIC, 11, Font.UNDERLINE,
                        BaseColor.RED);

                listaorde = lista2;

                Paragraph paragraph = new Paragraph();
//
                // Agregar un titulo con su respectiva fuente
                paragraph.add(new Phrase("Bitacora de orden de compras \n \n", fontTitulos));
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);

                document.add(paragraph);
                PdfPTable table = new PdfPTable(6);
                table.addCell("ID");
                table.addCell("Nombre Provedor");
                table.addCell("Nombre de Producto");
                table.addCell("Nombre de Sucursal");
                table.addCell("Cantidad");
                table.addCell("Fecha");

                Iterator iter = listaorde.listIterator();

                while (iter.hasNext()) {
                    System.out.println("while");
                    orden = (OrdenCompra) iter.next();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    table.addCell("" + orden.getIdorden_compra());
                    table.addCell(orden.getIdsucursal().getNombre());
                    table.addCell(orden.getIdproveedor().getNombre());
                    table.addCell(orden.getIdproducto().getNombre());
                    table.addCell("" + orden.getCantidad());
                    table.addCell(formato.format(orden.getFecha()));

                }
                // Creacion de una tabla

                document.add(table);

                document.close();

                // Abrir el archivo
                File file = new File("C:/reportes/reporte/" + format.format(fecha) + ".pdf");
                System.out.println(file.getAbsolutePath());
            } catch (DocumentException | FileNotFoundException ex) {
                System.out.println("error " + ex.getMessage());
            }
            //return true;
            System.out.println("se creo el reporte");
        } catch (Exception e) {
            // return false;
        }

    }

//    public static void main(String[] args) {
//        Reporte pdf = new Reporte();
//        pdf.reporte();
//    }
//    }
    public void reporteBitacora(List<Bitacora> lista2) {
        try {
            System.out.println("reporte de pdf de ordenes");
            // Creacion del documento con los margenes
            Document document = new Document(PageSize.A4, 35, 30, 50, 50);
            try {
                //String path= new File(".").;
                //String File_name=path+"/reporte.pdf";
                // El archivo pdf que vamos a generar
                Date fecha = new Date();

                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

                FileOutputStream fileOutputStream = new FileOutputStream("C:/reportes/Reporte_Bitacora_" + format.format(fecha) + ".pdf");

                // Obtener la instancia del PdfWriter
                PdfWriter.getInstance(document, fileOutputStream);

                // Abrir el documento
                document.open();

                // Crear las fuentes para el contenido y los titulos
                Font fontContenido = FontFactory.getFont(
                        FontFactory.TIMES_ROMAN.toString(), 11, Font.NORMAL,
                        BaseColor.DARK_GRAY);
                Font fontTitulos = FontFactory.getFont(
                        FontFactory.TIMES_BOLDITALIC, 11, Font.UNDERLINE,
                        BaseColor.RED);

                lsBitacora = lista2;

                Paragraph paragraph = new Paragraph();
//
                // Agregar un titulo con su respectiva fuente
                paragraph.add(new Phrase("Bitacora de usuarios \n \n", fontTitulos));
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);

                document.add(paragraph);
                PdfPTable table = new PdfPTable(4);
                table.addCell("ID");
                table.addCell("Fecha");
                table.addCell("Nombre de usuario");
                table.addCell("Acciones");

                Iterator iter = lsBitacora.listIterator();

                while (iter.hasNext()) {
                    System.out.println("while");
                    bita = (Bitacora) iter.next();

                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    table.addCell("" + bita.getIdbitacora());
                    table.addCell(formato.format(bita.getFecha()));
                    table.addCell(bita.getUsuario().getUsuario());
                    table.addCell(bita.getAccion());

                }
                // Creacion de una tabla

                document.add(table);

                document.close();

                // Abrir el archivo
                File file = new File("C:/reportes/reporte/" + format.format(fecha) + ".pdf");
                System.out.println(file.getAbsolutePath());
            } catch (DocumentException | FileNotFoundException ex) {
                System.out.println("error " + ex.getMessage());
            }
            //return true;
            System.out.println("se creo el reporte");
        } catch (Exception e) {
            // return false;
        }

    }

//    public static void main(String[] args) {
//        Reporte pdf = new Reporte();
//        pdf.reporte();
//    }
}
