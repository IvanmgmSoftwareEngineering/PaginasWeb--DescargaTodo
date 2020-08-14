import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Html {

    String nombreHtml;
    String urlHtml;
    String tamanoHtml;

    ArbolCarpetasSitioWeb arbolCarpetas;

    ArrayList htmls;

    int cantidadURLsEnCola=0;


    public Html() {
        this.htmls = new ArrayList<Html>();
    }

    public Html(ArbolCarpetasSitioWeb arbolCarpetas) {
        this.arbolCarpetas = arbolCarpetas;
        this.htmls = new ArrayList<Html>();
    }

    public Html(String nombreHtml, String urlHtml, String tamanoHtml) {
        this.nombreHtml = nombreHtml;
        this.urlHtml = urlHtml;
        this.tamanoHtml = tamanoHtml;
        this.htmls = new ArrayList<Html>();
    }

    public String getNombreHtml() {
        return nombreHtml;
    }

    public String getUrlHtml() {
        return urlHtml;
    }

    public String getTamanoHtml() {
        return tamanoHtml;
    }

    public ArrayList getHtmls() {
        return htmls;
    }

    public void descargaRestoHTMLs() throws IOException {

        System.out.println();
        System.out.println();
        System.out.print("-------------- COMENZAMOS CON LA BÚSQUEDA Y DERCARGA DE TODOS LOS HTMLs DEL SITIO WEB  "+arbolCarpetas.getNombreSitioWeb());
        System.out.println();
        System.out.println();
        //int tamanoActualCarpetaHtml;
        //int tamanoNuevoCarpetaHTML=0;

        //tamanoActualCarpetaHtml = htmls.size();

        //while (true) {
            for (int i = 0; i<htmls.size();i++) {
                Html html = (Html)this.htmls.get(i);
                this.descargaHTMLsQueHayEnFicheroTexto(html.getNombreHtml());
            }





        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.print("-------------- FIN DESCARGA DE TODOS LOS HTMLs DEL SITIO WEB "+arbolCarpetas.getNombreSitioWeb());
        System.out.println();
        System.out.println();
    }

    public void descargaIndex(){
        try {
            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.print("-------------- DESCARGANDO HTML index SITIO WEB: " + arbolCarpetas.getUrlSitioWeb().getURL());
            esperar(1);
            System.out.println();

            URL url = new URL(arbolCarpetas.getUrlSitioWeb().getURL());
            InputStream in = new BufferedInputStream(url.openStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream(arbolCarpetas.pathHtmls + "/" + "index.html.txt"));


            for (int i; (i = in.read()) != -1; ) {
                out.write(i);
            }
            in.close();
            out.close();

            System.out.println();

            this.nombreHtml = "index.html.txt";
            System.out.print("----------------- Nombre HTML:   " + this.nombreHtml);
            esperar(1);
            System.out.println();



            this.urlHtml = arbolCarpetas.getUrlSitioWeb().getURL();
            System.out.print("----------------- url:           " + this.urlHtml);
            esperar(1);
            System.out.println();



            long tamanoHtml = this.obtenTamanoHTML();
            this.tamanoHtml = String.valueOf(tamanoHtml);
            System.out.print("----------------- Tamaño html:   " + this.tamanoHtml + " bytes");
            esperar(1);
            System.out.println();
            System.out.print("----------------- Guardando....");
            esperar(1);
            System.out.print(". ");
            esperar(1);
            System.out.print("OK!");
            System.out.println();
            System.out.println();
            esperar(1);



            this.htmls.add(new Html(this.nombreHtml, this.urlHtml, this.tamanoHtml));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //Este método localiza y descarga todos los ficheros .html presentes en un fichero .html.txt y los almacena en la carpeta html
    public void descargaHTMLsQueHayEnFicheroTexto(String nombreHTML) throws IOException {

        this.buscaURLHTMLs(arbolCarpetas.pathHtmls+"/"+nombreHTML);
        esperar(1);
        this.limpia();
        String nombreHtml="";
        int j = 0;
        String lineaux="";
        try {
            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.print("-------------- DESCARGANDO HTMLs SITIO WEB: ");
            esperar(1);
            System.out.println();
            System.out.print("----------------- En total quedan por descargar "+ cantidadURLsEnCola + " ficheros .html");
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

            FileReader fr = new FileReader(arbolCarpetas.getPathHtmls()+"/"+"urlsHTMLsLimpias.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            Boolean yaEsta;


            while ((linea = br.readLine()) != null) {
                lineaux = linea;
                yaEsta = false;
                for (int r = 0; r < this.htmls.size(); r++) {
                    Html html1 = (Html)this.htmls.get(r);
                    if (html1.getUrlHtml().equals(linea)) {
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
                    int indice = linea.indexOf(".html") - 1;
                    for (int t = indice; !String.valueOf(linea.charAt(t)).equals("/"); t--) {
                        nombreAlReves = nombreAlReves + linea.charAt(t);
                    }

                    for (int y = nombreAlReves.length() - 1; y >= 0; y--) {
                        nombreHtml = nombreHtml + nombreAlReves.charAt(y);
                    }


                    nombreHtml = nombreHtml + ".html.txt";


                    URL url = new URL(linea);
                    InputStream in = new BufferedInputStream(url.openStream());
                    OutputStream out = new BufferedOutputStream(new FileOutputStream(arbolCarpetas.pathHtmls + "/" + nombreHtml));


                    for (int i; (i = in.read()) != -1; ) {
                        out.write(i);
                    }
                    in.close();
                    out.close();


                    this.nombreHtml = nombreHtml;
                    /*
                    nombreHtml = "";
                    System.out.print("--------------------- Nombre HTML:   " + this.nombreHtml);
                    esperar(1);
                    System.out.println();

                     */

                    this.urlHtml = linea;
                    /*
                    System.out.print("--------------------- url:           " + this.urlHtml);
                    esperar(1);
                    System.out.println();

                     */

                    long tamanoHtml = this.obtenTamanoHTML();
                    this.tamanoHtml = String.valueOf(tamanoHtml);
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

                    this.htmls.add(new Html(this.nombreHtml, this.urlHtml, this.tamanoHtml));
                    this.cantidadURLsEnCola--;
                    j++;
                }
            }

        } catch(FileNotFoundException e){
            System.out.print("----------------- Error en \"descargaHTMLsQueHayEnFicheroTexto()\": FileNotFoundException: "+ lineaux);
            System.out.println();
        } catch(MalformedURLException e){
            e.printStackTrace();
        } catch(IOException e){
            System.out.print("----------------- Error en \"descargaHTMLsQueHayEnFicheroTexto()\": IOException: "+ lineaux);
            System.out.println();

        }

        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();

        //this.borraFicheros();
        this.creaFicheroInfoHTMLsTXT();





    }

    public void borraFicheros (){

        //Borra ficheros de texto con las urls de los HTMLs de la carpeta del html
        System.out.print("-------------- BORRANDO FICHEROS INECESARIOS");
        System.out.println();
        esperar(2);

        File ficherotexto1 = new File(arbolCarpetas.getPathHtmls()+"/"+"urlsHTMLs.txt");
        File ficherotexto2 = new File(arbolCarpetas.getPathHtmls()+"/"+"urlsHTMLsLimpias.txt");

        if(ficherotexto1.exists() && ficherotexto2.exists()){
            System.out.print("----------------- Borrando fichero: "+ arbolCarpetas.getPathHtmls()+"/"+ "urlsHTMLs.txt");
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

            System.out.print("----------------- Borrando fichero: "+ arbolCarpetas.getPathHtmls()+"/"+"urlsHTMLsLimpias.txt");
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

    public void creaFicheroInfoHTMLsTXT(){
        //Si existe el fichero lo borrar para crear uno nuevo actualizado
        File ficheroTXT = new File (this.arbolCarpetas.pathHtmls+"/"+"infoHTML.txt");
        if(ficheroTXT.exists()){
            ficheroTXT.setReadable(true, false);
            ficheroTXT.setExecutable(true, false);
            ficheroTXT.setWritable(true, false);
            ficheroTXT.delete();
        }
        esperar(5);


        //Crear fichero de texto con la informacion de las imagenes

        System.out.print("-------------- CREANDO FICHERO CON INFORMACION DE LOS HTMLs");
        System.out.println();
        esperar(2);
        System.out.print("----------------- Creando fichero: "+this.arbolCarpetas.pathHtmls+"/"+"infoHTML.txt");
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
        this.guardaTextoFicheroTXT("----- Información de los ficheros .html contenidos en esta carpeta -----",this.arbolCarpetas.pathHtmls+"/"+"infoHTML.txt");
        this.guardaTextoFicheroTXT("",this.arbolCarpetas.pathHtmls+"/"+"infoHTML.txt");

        File carpetaHTMLs = new File (arbolCarpetas.getPathHtmls());

        int numTotalHTMLs = carpetaHTMLs.listFiles().length-1;
        this.guardaTextoFicheroTXT("-> Número total de HTMLs: " + numTotalHTMLs,this.arbolCarpetas.pathHtmls+"/"+"infoHTML.txt");
        int tamanoCarpeta = 0;
        Html html1;
        for (int y = 0;y<this.htmls.size();y++){
            html1 = (Html) this.htmls.get(y);
            tamanoCarpeta = tamanoCarpeta + Integer.parseInt(html1.getTamanoHtml());
        }
        this.guardaTextoFicheroTXT("-> Tamaño total carpeta:     " + tamanoCarpeta +" KB",this.arbolCarpetas.pathHtmls+"/"+"infoHTML.txt");
        this.guardaTextoFicheroTXT("",this.arbolCarpetas.pathHtmls+"/"+"infoHTML.txt");
        this.guardaTextoFicheroTXT("",this.arbolCarpetas.pathHtmls+"/"+"infoHTML.txt");

        int q = 0;
        for (int w=0;w<this.htmls.size();w++){

            q = w+1;
            this.guardaTextoFicheroTXT("------------ HTML " + q+") ------------",this.arbolCarpetas.pathHtmls+"/"+"infoHTML.txt");
            Html html2 = (Html)htmls.get(w);
            this.guardaTextoFicheroTXT("---- Nombre:           "+html2.getNombreHtml(),this.arbolCarpetas.pathHtmls+"/"+"infoHTML.txt");
            this.guardaTextoFicheroTXT("---- URL:              "+html2.getUrlHtml(),this.arbolCarpetas.pathHtmls+"/"+"infoHTML.txt");
            this.guardaTextoFicheroTXT("---- Tamaño HTML:      "+html2.getTamanoHtml() +" KB",this.arbolCarpetas.pathHtmls+"/"+"infoHTML.txt");
            this.guardaTextoFicheroTXT("",this.arbolCarpetas.pathHtmls+"/"+"infoHTML.txt");

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



    public void buscaURLHTMLs(String pathHTML){

        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.print("-------------- ANALIZANDO FICHERO DE TEXTO EN BUSCA DE FICHEROS HTMLs: " + pathHTML);
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

            FileReader fr = new FileReader(pathHTML);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            String simbolo ="\"";
            String simbolo1 = "\'";
            String subLinea = "";
            String urlHtml1 ="";
            String urlHtml2 ="";
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

                    this.guardaTextoFicheroTXT(urlHtml2,arbolCarpetas.getPathHtmls()+"/"+"urlsHTMLs.txt");


                    m++;


                    urlHtml1 = "";
                    urlHtml2 = "";
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

                if (linea.contains(".html")) {
                    k = linea.indexOf(".html");
                    for ( i = k+4; i >=0; i--) {
                        if(String.valueOf(linea.charAt(i)).equals(simbolo) || String.valueOf(linea.charAt(i)).equals(simbolo1)) {
                            break;
                        }else {
                            urlHtml1 = urlHtml1 + linea.charAt(i);
                        }
                    }

                    //le damos la vuelta
                    for (int l = urlHtml1.length()-1; l>=0;l--){
                        urlHtml2 = urlHtml2 + urlHtml1.charAt(l);
                    }
                    //urlNoCompleta = false;
                    guarda = true;
                }
            }

            System.out.print("----------------- Encontradas  "+ j +" URLs con extensión .html" );
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
        System.out.print("-------------- LIMPIANDO URLs DE LOS HTMLs");
        System.out.println();
        System.out.println();
        esperar(1);

        ArrayList urlsHTMLs = new ArrayList<String>();
        ArrayList urlsHTMLsSinRepeticiones = new ArrayList<String>();
        ArrayList urlsHTMLsLimpios = new ArrayList<String>();

        boolean repetido = false;



        try {
            FileReader fr = new FileReader(arbolCarpetas.getPathHtmls() + "/" + "urlsHTMLs.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                urlsHTMLs.add(linea);
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
            urlsHTMLsSinRepeticiones.add(urlsHTMLs.get(0));
            for (int i = 1; i < urlsHTMLs.size(); i++) {
                for (int g = 0; g < urlsHTMLsSinRepeticiones.size(); g++) {
                    if (urlsHTMLs.get(i).equals(urlsHTMLsSinRepeticiones.get(g))) {
                        contador = contador + 1;
                        repetido = true;
                    }
                }

                if (!repetido) {
                    urlsHTMLsSinRepeticiones.add(urlsHTMLs.get(i));
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
            int contador1 = urlsHTMLs.size() - contador;
            System.out.print("----------------- Quedan " +contador1 + " URLs sin repetir");
            esperar(1);
            System.out.println();

            //añade http://... si no lo tiene
            String cadena;
            int indiceSubcadena;
            String auxCadena;

            for (int g = 0; g < urlsHTMLsSinRepeticiones.size(); g++) {
                cadena = (String) urlsHTMLsSinRepeticiones.get(g);
                if (cadena.contains("http")) {
                    indiceSubcadena = cadena.indexOf(".html");
                    auxCadena = cadena.substring(0,indiceSubcadena-1);
                    urlsHTMLsLimpios.add(auxCadena);
                }else{
                    indiceSubcadena = cadena.indexOf(".html");
                    auxCadena = cadena.substring(0,indiceSubcadena-1);
                    urlsHTMLsLimpios.add(arbolCarpetas.getUrlSitioWeb().getURL() +"/"+ auxCadena);
                }


                /*

                if (cadena.contains("index.html")) {

                } else if (cadena.contains("http")) {
                    urlsHTMLsLimpios.add(cadena);

                } else if (cadena.contains("//")) {
                    urlsHTMLsLimpios.add("https:" + cadena);


                } else if (!String.valueOf(cadena.charAt(0)).equals("/")) {
                    //No hacemos nada. Nos deshacemos de esta línea

                } else {
                    urlsHTMLsLimpios.add(arbolCarpetas.getUrlSitioWeb().getURL() + cadena);
                }

                 */
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

            if (urlsHTMLsLimpios.size() != 0) {
                for (int i = 0; i < urlsHTMLsLimpios.size(); i++) {
                    try {
                        URL url = new URL(urlsHTMLsLimpios.get(i).toString());
                        InputStream in = new BufferedInputStream(url.openStream());
                        OutputStream out = new BufferedOutputStream(new FileOutputStream(arbolCarpetas.pathHtmls + "/" + "temporal"+ i));
                        File file = new File(arbolCarpetas.pathHtmls + "/" + "temporal" + i);
                        esperar(1);
                        file.delete();
                        in.close();
                        out.close();

                    } catch (FileNotFoundException e) {
                        contador2 = contador2 +1;
                        /*
                        System.out.println();
                        System.out.print("            ------- Error en \"limpia()\": FileNotFoundException: " + urlsHTMLsLimpios.get(i).toString());
                        urlsHTMLsLimpios.remove(i);
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

                        System.out.print("            ----- Error en \"limpia()\" IOException:            " + urlsHTMLsLimpios.get(i).toString());
                        urlsHTMLsLimpios.remove(i);
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
                int contador3 = urlsHTMLs.size() - contador;
                System.out.print("----------------- Quedan " +contador3 + " URLs válidas");
                esperar(1);
                System.out.println();
                System.out.println();
                for (int k = 0; k < urlsHTMLsLimpios.size(); k++) {
                    this.guardaTextoFicheroTXT(urlsHTMLsLimpios.get(k).toString(), arbolCarpetas.getPathHtmls() + "/" + "urlsHTMLsLimpias.txt");
                }
                this.cantidadURLsEnCola = this.cantidadURLsEnCola + urlsHTMLsLimpios.size();
            }
        } catch (FileNotFoundException e) {
            System.out.print("----------------- Error en limpia(): FileNotFoundException: no se ha creado fichero urlsHTMLs.txt");
            System.out.println();
        }
    }

    //Obtiene el tamaño del fichero html que esta descargándose
    //
    public long obtenTamanoHTML() throws IOException {
        File html = new File(this.arbolCarpetas.pathHtmls+"/"+nombreHtml);
        return html.length();

    }

    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }




}






