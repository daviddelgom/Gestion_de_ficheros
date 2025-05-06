package view.console;

import java.util.Scanner;
import model.Funciones;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String opcion;

        do {
            System.out.println("\n-- Menú Principal --");
            System.out.println("1. Crear Carpeta");
            System.out.println("2. Crear Archivo");
            System.out.println("3. Listar Archivos");
            System.out.println("4. Leer Archivo");
            System.out.println("5. Sobrescribir Archivo");
            System.out.println("6. Borrar Archivo");
            System.out.println("7. Contar Caracteres");
            System.out.println("8. Contar Palabras");
            System.out.println("9. Reemplazar Palabras");
            System.out.println("10. Generar PDF");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1" : {
                    System.out.print("Nombre carpeta: ");
                    Funciones.crearCarpeta(sc.nextLine());
                    break;
                }
                case "2" : {
                    System.out.print("Ruta: ");
                    String ruta = sc.nextLine();
                    System.out.print("Nombre archivo: ");
                    String nombre = sc.nextLine();
                    System.out.print("Contenido: ");
                    String texto = sc.nextLine();
                    Funciones.crearArchivo(ruta, nombre, texto);
                    break;
                }
                case "3" : {
                    System.out.print("Ruta: ");
                    for (String archivo : Funciones.listarArchivos(sc.nextLine())) {
                        System.out.println(archivo);
                    }
                    break;
                }
                case "4" : {
                    System.out.print("Ruta: ");
                    String r = sc.nextLine();
                    System.out.print("Nombre archivo: ");
                    System.out.println(Funciones.leerArchivo(r, sc.nextLine()));
                    break;
                }
                case "5" : {
                    System.out.print("Ruta: ");
                    String r = sc.nextLine();
                    System.out.print("Archivo: ");
                    String a = sc.nextLine();
                    System.out.print("Nuevo contenido: ");
                    boolean ok = Funciones.sobreescribir(r, a, sc.nextLine());
                    System.out.println(ok ? "Archivo actualizado." : "Error.");
                    break;
                }
                case "6" : {
                    System.out.print("Ruta: ");
                    String r = sc.nextLine();
                    System.out.print("Archivo: ");
                    Funciones.borrarArchivo(r, sc.nextLine());
                    break;
                }
                case "7" : {
                    System.out.print("Ruta: ");
                    String r = sc.nextLine();
                    System.out.print("Archivo: ");
                    System.out.println("Caracteres: " + Funciones.contarCaracteres(r, sc.nextLine()));
                    break;
                }
                case "8" : {
                    System.out.print("Ruta: ");
                    String r = sc.nextLine();
                    System.out.print("Archivo: ");
                    System.out.println("Palabras: " + Funciones.contarPalabras(r, sc.nextLine()));
                    break;
                }
                case "9" : {
                    System.out.print("Ruta: ");
                    String r = sc.nextLine();
                    System.out.print("Archivo: ");
                    String a = sc.nextLine();
                    System.out.print("Palabra antigua: ");
                    String vieja = sc.nextLine();
                    System.out.print("Palabra nueva: ");
                    System.out.println(Funciones.reemplazarPalabra(r, a, vieja, sc.nextLine()));
                    break;
                }
                case "10" : {
                    System.out.print("Ruta: ");
                    String r = sc.nextLine();
                    System.out.print("Archivo: ");
                    Funciones.generarPDF(r, sc.nextLine());
                    break;
                }
                case "0" : System.out.println("Hasta luego!");
                break;
                default : System.out.println("Opción inválida.");
                break;
            }

        } while (!opcion.equals("0"));
    }
}
