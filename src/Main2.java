import javax.net.ssl.*;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.util.Timer;

public class Main2 {



        /**
         * @param args the command line arguments
         */

        public static void main(String[] args)  throws Exception {

            //baseDatosURLs baseDatosURLs = new baseDatosURLs();
            //baseDatosURLs.generaURLs();

            //Timer para contabilizar el tiempo que tarda el programa
            long inicioPrograma1 = System.currentTimeMillis();


            //Inicio del programa: Muestra información por consola y pide datos por teclado al usuario
            EntradaSalidaUsuario inOut = new EntradaSalidaUsuario();
            inOut.mensajeBienvenida();
            inOut.mensajeInstrucciones("No");
            inOut.procesaEntradaTeclado1();
            inOut.procesaEntradaTeclado2();

            long finPrograma1 = System.currentTimeMillis();
            long inicioPrograma2 = System.currentTimeMillis();


            //Crea URL del Sitio Web
            /* Start of Fix */
            TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() { return null; }
                public void checkClientTrusted(X509Certificate[] certs, String authType) { }
                public void checkServerTrusted(X509Certificate[] certs, String authType) { }

            } };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting Host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) { return true; }
            };
            // Install the all-trusting Host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
            /* End of the fix*/
            url url = new url (inOut.nombreSitioWeb);

            //Crea en el ordenador un arbol de directorios donde se almacenará el Sitio Web
            ArbolCarpetasSitioWeb arbol = new ArbolCarpetasSitioWeb(inOut.pathAlmacenamiento,url);
            arbol.creaArbolCarpetas();

            //Descarga todos los HTMLs del Sitio Web
            Html html = new Html(arbol);
            html.descargaIndex();
            html.descargaRestoHTMLs();

            //Descarga todos los CSSs del Sitio Web
            Css css = new Css(arbol,html.getHtmls());
            css.descargaTodosCss();

            //Descarga todos los JSs del Sitio Web
            Js js = new Js(arbol,html.getHtmls());
            js.descargaTodosJs();

            //Descarga todos las IMÁGENEs del Sitio Web
            Imagen imagen = new Imagen(arbol,html.getHtmls(),css.getCsss(),js.getJss());
            imagen.descargaTodosImagenes();

            //Descarga todos los PDFs del Sitio Web


            //Descarga todos los TXTs del Sitio Web


            //Descarga todos los VIDEOs del Sitio Web


            //Descarga todos los AUDIOs del Sitio Web






            long finPrograma2 = System.currentTimeMillis();
            inOut.muestraTiempos(inicioPrograma1,finPrograma1,"datosEntrada");
            inOut.muestraTiempos(inicioPrograma2,finPrograma2,"ejecucionPrograma");
            inOut.muestraTiempos(inicioPrograma1,finPrograma2,"tiempoTotal");










            //imagen.obtenTamanoImagenes();
            //txt.readFicheroTXT();
            //imagen imagen1 = new imagen(url.getURL() + "/images/branding/googleg/1x/googleg_standard_color_128dp.png");
            //imagen1.descargaImagen();
        }

}


