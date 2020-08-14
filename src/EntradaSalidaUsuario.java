import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class EntradaSalidaUsuario {

    String nombreSitioWeb;
    String pathAlmacenamiento;

    public void mensajeBienvenida(){

        System.out.println();
        System.out.println("-------------------------- BIENVENIDO--------------------------------");
        System.out.println();
        esperar(1);
        System.out.println("Este programa te resultará de utilidad para descargar todo el contenido de una página web");
        System.out.println();
        esperar(3);
    }

    public void mensajeInstrucciones(String muestraInstrucciones) {
        if(muestraInstrucciones.equals("Si")) {
            System.out.println("INTRUCCIONES DE USO");
            System.out.println();
            System.out.println("--> PASO 1) Introducir nombre del Sitio Web que desea descargar (Ej: www.google.com)");
            System.out.println();
            esperar(2);
            System.out.println("--> PASO 2) Introducir el path donde desea almacenar el contenido del sitio dentro de tu computadora.");
            System.out.println();
            esperar(3);
            System.out.println("----------> Para conocer el path sigue los siguientes pasos:");
            System.out.println();
            esperar(1);
            System.out.println("-----------------> 1) Abre la app Terminal");
            System.out.println();
            esperar(1);
            System.out.println("-----------------> 2) Utilizando el comando 'ls' para listar el contenido del directorio");
            System.out.println();
            esperar(2);
            System.out.println("-----------------> 3) Utilizando el comando 'cd nombreDirectorio' para acceder algún directorio contenido en el directorio actual");
            System.out.println();
            esperar(2);
            System.out.println("-----------------> 4) Una vez que estes en el directorio donde deseas almacenar el Sitio Web utiliza el comando 'pxd' que te mostrará el path");
            System.out.println();
            esperar(2);
            System.out.println("-----------------> 5) Copia el path que se muestra seleccionando el path con el ratón haciendo clip derecho");
            System.out.println();
            esperar(5);
        }else {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println("EMPEZAMOS");
            System.out.println();
            esperar(3);
        }




    }

    public void muestraTiempos(long inicio, long fin, String mode){

        double tiempo = (double) ((fin - inicio)/1000);
        if(mode.equals("datosEntrada")) {
            System.out.println();
            System.out.print("-------------- TIEMPO QUE HA TARDADO EL PROGRAMA");
            System.out.println();
            System.out.println();
            esperar(1);
            System.out.print("----------------- Tiempo que ha tardado el usuario en introducir los valores de entrada: " + tiempo + " segundos");
            System.out.println();
            esperar(2);
        } else if (mode.equals("ejecucionPrograma")) {
            System.out.print("----------------- Tiempo que ha tardado el programa en ejecutarse: " + tiempo + " segundos");
            System.out.println();
            esperar(2);
        } else if (mode.equals("tiempoTotal")){
            System.out.print("----------------- Tiempo total: " + tiempo + " segundos");
            System.out.println();
            esperar(2);
        }


    }

    public void procesaEntradaTeclado1() {
        boolean primeraVez = true;
        boolean entradaValida = false;
        while (!entradaValida) {
            if (primeraVez) {
                primeraVez = false;
                System.out.print(" Introduce dirección del sitio web (Ej: www.google.com) y pulse enter: ");

                String entradaTeclado = "";
                Scanner entradaEscaner = new Scanner(System.in);
                entradaTeclado = entradaEscaner.nextLine();
                if (this.existeSitioWeb("http://" + entradaTeclado)) {
                    entradaValida = true;
                    System.out.println();
                    System.out.print("    ENHORABUENA! "+entradaTeclado+" es una direccion válida");
                    System.out.println();
                    esperar(2);
                    this.nombreSitioWeb = entradaTeclado;
                } else {

                }
            }else{
                System.out.println();
                System.out.print("    Direccion no válida, pruebe de nuevo: ");
                String entradaTeclado = "";
                Scanner entradaEscaner = new Scanner(System.in);
                entradaTeclado = entradaEscaner.nextLine();
                if (this.existeSitioWeb("http://" + entradaTeclado)) {
                    entradaValida = true;
                    System.out.println();
                    System.out.print("    ENHORABUENA! "+entradaTeclado+" es una direccion válida");
                    System.out.println();
                    esperar(2);
                    this.nombreSitioWeb = entradaTeclado;
                } else {

                }

            }
        }
    }

    public void procesaEntradaTeclado2() {
        boolean primeraVez = true;
        boolean entradaValida = false;
        while (!entradaValida) {
            if (primeraVez) {
                primeraVez = false;
                System.out.println();
                System.out.println();
                System.out.print(" Introduce path donde se almacenará el contenido y pulse enter: ");
                String entradaTeclado = "";
                Scanner entradaEscaner = new Scanner(System.in);
                entradaTeclado = entradaEscaner.nextLine();
                if (this.pathCorrecto(entradaTeclado)) {
                    entradaValida = true;
                    System.out.println();
                    System.out.print("    ENHORABUENA! "+entradaTeclado+" es un path válido");
                    System.out.println();
                    System.out.println();
                    esperar(2);
                    System.out.print("-------------------------------------------------------------------------------------");
                    System.out.println();
                    esperar(1);
                    this.pathAlmacenamiento = entradaTeclado;
                } else {

                }
            }else{
                System.out.println();
                System.out.print("    Path no válido, pruebe de nuevo: ");
                String entradaTeclado = "";
                Scanner entradaEscaner = new Scanner(System.in);
                entradaTeclado = entradaEscaner.nextLine();
                if (this.pathCorrecto(entradaTeclado)) {
                    entradaValida = true;
                    System.out.println();
                    System.out.print("    ENHORABUENA! "+entradaTeclado+" es un path válido");
                    System.out.println();
                    System.out.println();
                    esperar(2);
                    System.out.print("-------------------------------------------------------------------------------------");
                    System.out.println();
                    esperar(1);

                    this.pathAlmacenamiento = entradaTeclado;
                } else {

                }
            }
        }
    }

    public boolean pathCorrecto(String path) {
        try {
            File file = new File(path);
            boolean exist = file.exists();
            if(exist) {
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        }

    }

    public boolean existeSitioWeb (String urlSitioWeb){

        try{

            URL url = new URL(urlSitioWeb);
            InputStream in = new BufferedInputStream(url.openStream());
            in.close();
            return true;

        } catch (
                FileNotFoundException e) {
            return false;
        } catch (MalformedURLException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }






    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


