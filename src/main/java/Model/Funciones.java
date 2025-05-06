package model;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;


public class Funciones {

    public static void crearCarpeta(String nombre) {
        File carpeta = new File(System.getProperty("user.dir"), nombre);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
    }

    public static void crearArchivo(String ruta, String nombre, String texto) {
        File archivo = new File(ruta, nombre);
        try (FileWriter fw = new FileWriter(archivo, true)) {
            fw.write(texto + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error escribiendo archivo: " + e.getMessage());
        }
    }

    public static String[] listarArchivos(String ruta) {
        File carpeta = new File(ruta);
        if (!carpeta.isDirectory()) {
            return new String[]{"Ruta inválida."};
        }
        File[] archivos = carpeta.listFiles();
        if (archivos == null || archivos.length == 0) {
            return new String[]{"Vacío"};
        }
        String[] lista = new String[archivos.length];
        for (int i = 0; i < archivos.length; i++) {
            lista[i] = archivos[i].getName();
        }
        return lista;
    }

    public static String leerArchivo(String ruta, String nombre) {
        StringBuilder contenido = new StringBuilder();
        File archivo = new File(ruta, nombre);
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
        return contenido.toString();
    }

    public static boolean sobreescribir(String ruta, String nombre, String nuevoContenido) {
        File archivo = new File(ruta, nombre);
        if (!archivo.exists()) {
            return false;
        }
        try (FileWriter fw = new FileWriter(archivo, false)) {
            fw.write(nuevoContenido);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void borrarArchivo(String ruta, String nombre) {
        File archivo = new File(ruta, nombre);
        if (archivo.exists()) {
            archivo.delete();
        }
    }

    public static int contarCaracteres(String ruta, String nombre) {
        return leerArchivo(ruta, nombre).length();
    }

    public static int contarPalabras(String ruta, String nombre) {
        String texto = leerArchivo(ruta, nombre).trim();
        return texto.isEmpty() ? 0 : texto.split("\\s+").length;
    }

    public static String reemplazarPalabra(String ruta, String nombre, String vieja, String nueva) {
        String original = leerArchivo(ruta, nombre);
        String actualizado = original.replace(vieja, nueva);
        sobreescribir(ruta, nombre, actualizado);
        return actualizado;
    }

    public static void generarPDF(String ruta, String nombreArchivo) {
        File archivo = new File(ruta, nombreArchivo);
        if (!archivo.exists()) {
            System.out.println("Archivo no encontrado.");
            return;
        }

        String contenido = leerArchivo(ruta, nombreArchivo);
        if (contenido.isBlank()) {
            System.out.println("El archivo está vacío, no se generará el PDF.");
            return;
        }

        String nombrePDF = nombreArchivo.replace(".txt", "") + ".pdf";
        File salida = new File(ruta, nombrePDF);

        // Crear la carpeta si no existe
        File carpeta = new File(ruta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        try {
            Document documento = new Document(); 
            PdfWriter.getInstance(documento, new FileOutputStream(salida));
            documento.open();
            documento.add(new Paragraph(contenido));
            documento.close();
            System.out.println("PDF generado en: " + salida.getAbsolutePath());
        } catch (DocumentException | IOException e) {
            System.out.println("Error generando PDF: " + e.getMessage());
        }
    }
}
