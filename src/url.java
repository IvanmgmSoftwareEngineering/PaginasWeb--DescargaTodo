import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class url {
    /*
        URL: Uniform Resources Locator
            Partes de una URL:
                1ªParte) https:                                             protocolo de comunicación entre el servidor y el navegador web
                2ªParte) dos puntos(:):                                     mecanismo de separación entre el protocolo y el resto de la dirección URL
                3ªParte) barras inclinadas(//):                             iniciación para el contacto
                4ªParte) www:                                               World Wide Web
                5ªParte) Nombre del sitioWeb:                               nombreSitioWeb
                6ªParte) TLDs, extensión o terminación:
                    Tipo I: Dominios de nivel superior genéricos(gTLD):   .com, .net, .org, .info, etc
                    Tipo II: Dominios de nivel superior geográficos(gccTLD):.es, .mx, .ar, etc
     */

    String protocolo;
    String dosPuntos;
    String barrasInclinadas;
    String www;
    String nombreSitioWeb;
    String extensión;
    public url(String nombreSitioWeb) {
        this.protocolo = "https";
        this.dosPuntos =":";
        this.barrasInclinadas="//";
        this.www = "www.";
        this.nombreSitioWeb = nombreSitioWeb;
        //this.extensión = extension;
    }



    public String getNombreSitioWeb() {
        return nombreSitioWeb;
    }

    public String getURL(){
        return protocolo + dosPuntos+barrasInclinadas + this.nombreSitioWeb;
    }

    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
