import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Js {

    String nombreJs;
    String urlJs;
    String tamanoJs;

    ArbolCarpetasSitioWeb arbolCarpetas;

    ArrayList jss;
    ArrayList htmls;

    int cantidadURLsEnCola=0;



    public Js() {
        this.jss = new ArrayList<Js>();
    }

    public Js(ArbolCarpetasSitioWeb arbolCarpetas, ArrayList<Html> htmls) {
        this.arbolCarpetas = arbolCarpetas;
        this.jss = new ArrayList<Js>();
        this.htmls = htmls;
    }

    public Js(String nombreJs, String urlJs, String tamanoJs) {
        this.nombreJs = nombreJs;
        this.urlJs = urlJs;
        this.tamanoJs = tamanoJs;
        this.jss = new ArrayList<Js>();
    }

    public String getNombreJs() {
        return nombreJs;
    }

    public String getUrlJs() {
        return urlJs;
    }

    public String getTamanoJs() {
        return tamanoJs;
    }

    public ArrayList getHtmls() {
        return htmls;
    }

    public ArrayList getJss() {
        return jss;
    }

    public void descargaTodosJs() throws IOException {

        System.out.println();
        System.out.println();
        System.out.print("-------------- COMENZAMOS CON LA BÚSQUEDA Y DERCARGA DE TODOS LOS JSs DEL SITIO WEB  "+arbolCarpetas.getNombreSitioWeb());
        System.out.println();
        System.out.println();
        //int tamanoActualCarpetaHtml;
        //int tamanoNuevoCarpetaHTML=0;

        //tamanoActualCarpetaHtml = htmls.size();

        //while (true) {
        System.out.print("--------------- RECORREMOS TODOS LOS FICHEROS HTMLs EN BUSCA DE JSs");
        System.out.println();
        System.out.println();
        for(int j = 0; j<this.htmls.size();j++){
            Html html = (Html)this.htmls.get(j);
            this.descargaJSsQueHayEnFicheroTexto(html.getNombreHtml());
        }
        System.out.print("--------------- FIN: TODOS LOS FICHEROS HTMLs HAN SIDO ANALIZADOS");
        System.out.println();
        System.out.println();
        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();

        System.out.print("--------------- RECORREMOS TODOS LOS FICHEROS CSSs EN BUSCA DE JSs");
        System.out.println();
        System.out.println();
        for (int i = 0; i< jss.size(); i++) {
            Js js = (Js)this.jss.get(i);
            this.descargaJSsQueHayEnFicheroTexto(js.getNombreJs());
        }
        System.out.print("--------------- FIN: TODOS LOS FICHEROS JSs HAN SIDO ANALIZADOS");
        System.out.println();
        System.out.println();
        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();



        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.print("-------------- FIN DESCARGA DE TODOS LOS JSs DEL SITIO WEB "+arbolCarpetas.getNombreSitioWeb());
        System.out.println();
        System.out.println();
    }
    //Este método localiza y descarga todos los ficheros .html presentes en un fichero .html.txt y los almacena en la carpeta html
    public void descargaJSsQueHayEnFicheroTexto(String nombreFicheroTXT) throws IOException {
        if (nombreFicheroTXT.contains(".html")) {
            this.buscaURLsJSs(arbolCarpetas.getPathHtmls() + "/" + nombreFicheroTXT);
            esperar(1);
        } else if (nombreFicheroTXT.contains(".js")){
            this.buscaURLsJSs(arbolCarpetas.getPathJss() + "/" + nombreFicheroTXT);
            esperar(1);
        }
        this.limpia();
        String nombreJs="";
        int j = 0;
        String lineaux="";
        try {
            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.print("-------------- DESCARGANDO JSs SITIO WEB: ");
            esperar(1);
            System.out.println();
            System.out.print("----------------- En total quedan por descargar "+ cantidadURLsEnCola + " ficheros .js");
            System.out.println();
            System.out.print("----------------- Guardando.");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.print(". ");
            esperar(1);
            System.out.print("OK!");

            System.out.println();

            esperar(1);

            FileReader fr = new FileReader(arbolCarpetas.getPathJss()+"/"+"urlsJSsLimpias.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            Boolean yaEsta;


            while ((linea = br.readLine()) != null) {
                lineaux = linea;
                yaEsta = false;
                for (int r = 0; r < this.jss.size(); r++) {
                    Js js1 = (Js)this.jss.get(r);
                    if (js1.getUrlJs().equals(linea)) {
                        yaEsta = true;
                        break;
                    }
                }
                if (!yaEsta) {
                    j = j + 1;
                    /*System.out.println();
                    System.out.print("----------------- DESCARGANDO HTML " + j + ")");
                    j = j - 1;
                    esperar(1);
                    System.out.println();

                     */

                    //Obtenemos nombre del html
                    String nombreAlReves = "";
                    int indice = linea.indexOf(".js") - 1;
                    for (int t = indice; !String.valueOf(linea.charAt(t)).equals("/"); t--) {
                        nombreAlReves = nombreAlReves + linea.charAt(t);
                    }

                    for (int y = nombreAlReves.length() - 1; y >= 0; y--) {
                        nombreJs = nombreJs + nombreAlReves.charAt(y);
                    }


                    nombreJs = nombreJs + ".js.txt";


                    URL url = new URL(linea);
                    InputStream in = new BufferedInputStream(url.openStream());
                    OutputStream out = new BufferedOutputStream(new FileOutputStream(arbolCarpetas.getPathJss() + "/" + nombreJs));


                    for (int i; (i = in.read()) != -1; ) {
                        out.write(i);
                    }
                    in.close();
                    out.close();


                    this.nombreJs = nombreJs;
                    /*
                    nombreCss = "";
                    System.out.print("--------------------- Nombre HTML:   " + this.nombreCss);
                    esperar(1);
                    System.out.println();

                     */

                    this.urlJs = linea;
                    /*
                    System.out.print("--------------------- url:           " + this.urlHtml);
                    esperar(1);
                    System.out.println();

                     */

                    long tamanoJs = this.obtenTamanoJS();
                    this.tamanoJs = String.valueOf(tamanoJs);
                    /*
                    System.out.print("--------------------- Tamaño html:   " + this.tamanoHtml + " bytes");
                    esperar(1);
                    System.out.println();
                    System.out.print("--------------------- Guardando.");
                    esperar(1);
                    System.out.print(". ");
                    esperar(1);
                    System.out.print("OK!");
                    System.out.println();
                    System.out.println();
                    esperar(1);

                     */

                    this.jss.add(new Js(this.nombreJs, this.urlJs, this.tamanoJs));
                    this.cantidadURLsEnCola--;
                    j++;
                }
            }

        } catch(FileNotFoundException e){
            System.out.print("----------------- Error en \"descargaJSsQueHayEnFicheroTexto()\": FileNotFoundException: "+ lineaux);
            System.out.println();
        } catch(MalformedURLException e){
            e.printStackTrace();
        } catch(IOException e){
            System.out.print("----------------- Error en \"descargaJSsQueHayEnFicheroTexto()\": IOException: "+ lineaux);
            System.out.println();

        }

        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();

        //this.borraFicheros();
        this.creaFicheroInfoCSSsTXT();





    }

    public void borraFicheros (){

        //Borra ficheros de texto con las urls de los HTMLs de la carpeta del html
        System.out.print("-------------- BORRANDO FICHEROS INECESARIOS");
        System.out.println();
        esperar(2);

        File ficherotexto1 = new File(arbolCarpetas.getPathJss()+"/"+"urlsJSs.txt");
        File ficherotexto2 = new File(arbolCarpetas.getPathJss()+"/"+"urlsJSsLimpias.txt");

        if(ficherotexto1.exists() && ficherotexto2.exists()){
            System.out.print("----------------- Borrando fichero: "+ arbolCarpetas.getPathJss()+"/"+ "urlsJSs.txt");
            System.out.println();
            esperar(1);
            ficherotexto1.setReadable(true, false);
            ficherotexto1.setExecutable(true, false);
            ficherotexto1.setWritable(true, false);
            System.out.print("----------------- Borrando.");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.print(". ");
            esperar(1);
            ficherotexto1.delete();
            System.out.print("OK!");
            System.out.println();
            esperar(1);

            System.out.print("----------------- Borrando fichero: "+ arbolCarpetas.getPathJss()+"/"+"urlsHTMLsLimpias.txt");
            System.out.println();
            esperar(1);
            ficherotexto2.setReadable(true, false);
            ficherotexto2.setExecutable(true, false);
            ficherotexto2.setWritable(true, false);
            System.out.print("----------------- Borrando.");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.print(". ");
            ficherotexto2.delete();
            esperar(1);
            System.out.print("OK!");
            System.out.println();
            System.out.println();
            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            esperar(1);

        }else{
            esperar(1);
            System.out.println("----------------- No hay ningún fichero que borrar");
            esperar(2);
            System.out.println();
        }

    }

    public void creaFicheroInfoCSSsTXT(){
        //Si existe el fichero lo borrar para crear uno nuevo actualizado
        File ficheroTXT = new File (this.arbolCarpetas.getPathJss()+"/"+"infoJS.txt");
        if(ficheroTXT.exists()){
            ficheroTXT.setReadable(true, false);
            ficheroTXT.setExecutable(true, false);
            ficheroTXT.setWritable(true, false);
            ficheroTXT.delete();
        }
        esperar(5);


        //Crear fichero de texto con la informacion de las imagenes

        System.out.print("-------------- CREANDO FICHERO CON INFORMACION DE LOS JSs");
        System.out.println();
        esperar(2);
        System.out.print("----------------- Creando fichero: "+this.arbolCarpetas.getPathJss()+"/"+"infoJS.txt");
        System.out.println();
        esperar(2);
        System.out.print("----------------- Creando.");
        esperar(1);
        System.out.print(".");
        esperar(1);
        System.out.print(".");
        esperar(1);
        System.out.print(".");
        esperar(1);
        System.out.print(".");
        esperar(1);
        System.out.print(".");
        esperar(1);
        System.out.print(".");
        esperar(1);
        System.out.print(".");
        esperar(1);
        System.out.print(". ");
        this.guardaTextoFicheroTXT("----- Información de los ficheros .css contenidos en esta carpeta -----",this.arbolCarpetas.getPathJss()+"/"+"infoJS.txt");
        this.guardaTextoFicheroTXT("",this.arbolCarpetas.getPathJss()+"/"+"infoJS.txt");

        File carpetaJSs = new File (arbolCarpetas.getPathJss());

        int numTotalJSs = carpetaJSs.listFiles().length-1;
        this.guardaTextoFicheroTXT("-> Número total de JSs: " + numTotalJSs,this.arbolCarpetas.getPathJss()+"/"+"infoJS.txt");
        int tamanoCarpeta = 0;
        Js js1;
        for (int y = 0;y<this.jss.size();y++){
            js1 = (Js) this.jss.get(y);
            tamanoCarpeta = tamanoCarpeta + Integer.parseInt(js1.getTamanoJs());
        }
        this.guardaTextoFicheroTXT("-> Tamaño total carpeta:     " + tamanoCarpeta +" KB",this.arbolCarpetas.getPathJss()+"/"+"infoJS.txt");
        this.guardaTextoFicheroTXT("",this.arbolCarpetas.getPathJss()+"/"+"infoJS.txt");
        this.guardaTextoFicheroTXT("",this.arbolCarpetas.getPathJss()+"/"+"infoJS.txt");

        int q = 0;
        for (int w=0;w<this.jss.size();w++){

            q = w+1;
            this.guardaTextoFicheroTXT("------------ JS " + q+") ------------",this.arbolCarpetas.getPathJss()+"/"+"infoJS.txt");
            Js js2 = (Js)jss.get(w);
            this.guardaTextoFicheroTXT("---- Nombre:           "+js2.getNombreJs(),this.arbolCarpetas.getPathJss()+"/"+"infoJS.txt");
            this.guardaTextoFicheroTXT("---- URL:              "+js2.getUrlJs(),this.arbolCarpetas.getPathJss()+"/"+"infoJS.txt");
            this.guardaTextoFicheroTXT("---- Tamaño JS:        "+js2.getTamanoJs() +" KB",this.arbolCarpetas.getPathJss()+"/"+"infoJS.txt");
            this.guardaTextoFicheroTXT("",this.arbolCarpetas.getPathJss()+"/"+"infoJS.txt");

        }
        esperar(1);
        System.out.print("OK!");
        System.out.println();
        System.out.println();
        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        esperar(5);

    }





    public void guardaTextoFicheroTXT(String texto, String pathFichero){

        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File(pathFichero);

            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo, true);

            escribir.write(texto);
            escribir.append("\r\n");


            //Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }

    }



    public void buscaURLsJSs(String pathTXT){

        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.print("-------------- ANALIZANDO FICHERO DE TEXTO EN BUSCA DE FICHEROS JSs: " + pathTXT);
        esperar(2);
        System.out.println();
        System.out.print("----------------- Buscando.");
        esperar(1);
        System.out.print(".");
        esperar(1);
        System.out.print(".");
        esperar(1);
        System.out.print(". OK");
        esperar(1);
        System.out.println();
        try {

            FileReader fr = new FileReader(pathTXT);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            String simbolo ="\"";
            String simbolo1 = "\'";
            String subLinea = "";
            String urlCss1 ="";
            String urlCss2 ="";
            boolean lineaNoAcabada = false;
            boolean urlNoCompleta = false;
            boolean guarda = false;
            int i;
            int j=0;
            int k;
            int m =1;


            while((linea = br.readLine()) !=null) {
                if (guarda) {
                    j=j+1;

                    this.guardaTextoFicheroTXT(urlCss2,arbolCarpetas.getPathJss()+"/"+"urlsJSs.txt");


                    m++;


                    urlCss1 = "";
                    urlCss2 = "";
                    guarda = false;
                    urlNoCompleta = false;
                }

                /*
                if (urlNoCompleta) {

                    if (linea.contains(".png") || linea.contains(".jpg")) {
                        if (linea.contains(".png")) {
                            k = linea.indexOf(".png");
                        } else {
                            k = linea.indexOf(".jpg");
                        }
                        for (i = 0; i < k + 5; i++) {
                            urlImagen = urlImagen + linea.charAt(i);
                        }
                        if (k + 5 < linea.length()) {
                            for (i = k + 5; i < linea.length(); i++) {
                                subLinea = subLinea + linea.charAt(i);
                            }
                        }
                        guarda = true;
                    } else {
                        for (i = 0; i < linea.length(); i++) {
                            urlImagen = urlImagen + linea.charAt(i);
                        }
                    }

                }

                 */

                if (linea.contains(".js")) {
                    k = linea.indexOf(".js");
                    for ( i = k+2; i >=0; i--) {
                        if(String.valueOf(linea.charAt(i)).equals(simbolo) || String.valueOf(linea.charAt(i)).equals(simbolo1)) {
                            break;
                        }else {
                            urlCss1 = urlCss1 + linea.charAt(i);
                        }
                    }

                    //le damos la vuelta
                    for (int l = urlCss1.length()-1; l>=0;l--){
                        urlCss2 = urlCss2 + urlCss1.charAt(l);
                    }
                    //urlNoCompleta = false;
                    guarda = true;
                }
            }

            System.out.print("----------------- Encontradas  "+ j +" URLs con extensión .js" );
            esperar(2);
            System.out.println();
            System.out.print("----------------- Guardando.");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.print(" OK");
            esperar(1);
            System.out.println();
            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();


        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }


    }

    public void limpia() throws IOException, FileNotFoundException {
        //Quitamos las urls repetidas
        //Dejamos las urls listas para usar

        esperar(2);
        System.out.println();
        System.out.println();
        System.out.print("-------------- LIMPIANDO URLs DE LOS JSs");
        System.out.println();
        System.out.println();
        esperar(1);

        ArrayList urlsJSs = new ArrayList<String>();
        ArrayList urlsJSsSinRepeticiones = new ArrayList<String>();
        ArrayList urlsJSsLimpios = new ArrayList<String>();

        boolean repetido = false;



        try {
            FileReader fr = new FileReader(arbolCarpetas.getPathJss() + "/" + "urlsJSs.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                urlsJSs.add(linea);
            }

            System.out.print("----------------- Limpiamos URLs repetidas");
            esperar(1);
            System.out.println();
            System.out.print("----------------- Limpiando.");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.println();


            int contador = 0;
            urlsJSsSinRepeticiones.add(urlsJSs.get(0));
            for (int i = 1; i < urlsJSs.size(); i++) {
                for (int g = 0; g < urlsJSsSinRepeticiones.size(); g++) {
                    if (urlsJSs.get(i).equals(urlsJSsSinRepeticiones.get(g))) {
                        contador = contador + 1;
                        repetido = true;
                    }
                }

                if (!repetido) {
                    urlsJSsSinRepeticiones.add(urlsJSs.get(i));
                } else {
                    repetido = false;
                }
            }

            System.out.println();
            System.out.print("----------------- Hay " + contador + " URLs repetidas");
            esperar(1);
            System.out.println();
            System.out.print("----------------- Eliminando.");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.print(".");
            System.out.print(".   OK");
            esperar(2);
            System.out.println();
            int contador1 = urlsJSs.size() - contador;
            System.out.print("----------------- Quedan " +contador1 + " URLs sin repetir");
            esperar(1);
            System.out.println();

            //añade http://... si no lo tiene
            String cadena;
            for (int g = 0; g < urlsJSsSinRepeticiones.size(); g++) {
                cadena = (String) urlsJSsSinRepeticiones.get(g);
                if (cadena.contains("index.html")) {

                } else if (cadena.contains("http")) {
                    urlsJSsLimpios.add(cadena);

                } else if (cadena.contains("//")) {
                    urlsJSsLimpios.add("https:" + cadena);


                } else if (!String.valueOf(cadena.charAt(0)).equals("/")) {
                    //No hacemos nada. Nos deshacemos de esta línea

                } else {
                    urlsJSsLimpios.add(arbolCarpetas.getUrlSitioWeb().getURL() + cadena);
                }
            }

            //Aqui compruebo que las urls que tenemos anteriores son urls válidas
            contador = 0;
            System.out.println();
            System.out.print("----------------- Limpiando URLs no válidas: ");
            System.out.println();
            System.out.print("----------------- Limpiando.");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.print(".");
            esperar(1);
            System.out.println();

            int contador2 = 0;

            if (urlsJSsLimpios.size() != 0) {
                for (int i = 0; i < urlsJSsLimpios.size(); i++) {
                    try {
                        URL url = new URL(urlsJSsLimpios.get(i).toString());
                        InputStream in = new BufferedInputStream(url.openStream());
                        OutputStream out = new BufferedOutputStream(new FileOutputStream(arbolCarpetas.getPathJss()+ "/" + "temporal"+ i));
                        File file = new File(arbolCarpetas.getPathJss() + "/" + "temporal" + i);
                        file.delete();
                        in.close();
                        out.close();

                    } catch (FileNotFoundException e) {
                        contador2 = contador2 +1;
                        /*
                        System.out.println();
                        System.out.print("            ------- Error en \"limpia()\": FileNotFoundException: " + urlsJSsLimpios.get(i).toString());
                        urlsJSsLimpios.remove(i);
                        System.out.println();
                        System.out.print("------------------- Eliminando.");
                        esperar(1);
                        System.out.print(".");
                        esperar(1);
                        System.out.print(".");
                        esperar(1);
                        System.out.print(".  OK");
                        esperar(1);
                        System.out.println();
                        */

                    } catch (IOException e) {
                        contador2 = contador2 +1;
                        /*
                        System.out.println();

                        System.out.print("            ----- Error en \"limpia()\" IOException:            " + urlsJSsLimpios.get(i).toString());
                        urlsJSsLimpios.remove(i);
                        System.out.println();
                        System.out.print("----------------- Eliminando.");
                        esperar(1);
                        System.out.print(".");
                        esperar(1);
                        System.out.print(".");
                        esperar(1);
                        System.out.print(".  OK");
                        System.out.println();
                         */

                    }


                }
                System.out.println();
                System.out.print("----------------- Hay " + contador2 + " URLs no validas");
                esperar(1);
                System.out.println();
                System.out.print("----------------- Eliminando.");
                esperar(1);
                System.out.print(".");
                esperar(1);
                System.out.print(".");
                esperar(1);
                System.out.print(".");
                System.out.print(".   OK");
                esperar(1);
                System.out.println();
                int contador3 = urlsJSs.size() - contador;
                System.out.print("----------------- Quedan " +contador3 + " URLs válidas");
                esperar(1);
                System.out.println();
                System.out.println();
                for (int k = 0; k < urlsJSsLimpios.size(); k++) {
                    this.guardaTextoFicheroTXT(urlsJSsLimpios.get(k).toString(), arbolCarpetas.getPathJss() + "/" + "urlsJSsLimpias.txt");
                }

                this.cantidadURLsEnCola = this.cantidadURLsEnCola + urlsJSsLimpios.size();

            }
        } catch (FileNotFoundException e) {
            System.out.print("----------------- Error en limpia(): FileNotFoundException: no se ha creado fichero urlsJSs.txt");
            System.out.println();
        }
    }

    //Obtiene el tamaño del fichero html que esta descargándose
    //
    public long obtenTamanoJS() throws IOException {
        File js = new File(this.arbolCarpetas.getPathJss()+"/"+this.nombreJs);
        return js.length();

    }

    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
