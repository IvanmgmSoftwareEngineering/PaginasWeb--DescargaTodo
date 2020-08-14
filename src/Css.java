import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Css {

    String nombreCss;
    String urlCss;
    String tamanoCss;

    ArbolCarpetasSitioWeb arbolCarpetas;

    ArrayList csss;
    ArrayList htmls;

    int cantidadURLsEnCola=0;


    public Css() {
        this.csss = new ArrayList<Css>();
    }

    public Css(ArbolCarpetasSitioWeb arbolCarpetas, ArrayList<Html> htmls) {
        this.arbolCarpetas = arbolCarpetas;
        this.csss = new ArrayList<Css>();
        this.htmls = htmls;

    }

    public Css(String nombreCss, String urlCss, String tamanoCss) {
        this.nombreCss = nombreCss;
        this.urlCss = urlCss;
        this.tamanoCss = tamanoCss;
        this.csss = new ArrayList<Css>();
    }

    public String getNombreCss() {
        return nombreCss;
    }

    public String getUrlCss() {
        return urlCss;
    }

    public String getTamanoCss() {
        return tamanoCss;
    }

    public ArrayList getCsss() {
        return csss;
    }

    public void descargaTodosCss() throws IOException {

        System.out.println();
        System.out.println();
        System.out.print("-------------- COMENZAMOS CON LA BÚSQUEDA Y DERCARGA DE TODOS LOS CSSs DEL SITIO WEB  "+arbolCarpetas.getNombreSitioWeb());
        System.out.println();
        System.out.println();
        //int tamanoActualCarpetaHtml;
        //int tamanoNuevoCarpetaHTML=0;

        //tamanoActualCarpetaHtml = htmls.size();

        //while (true) {
        System.out.print("--------------- RECORREMOS TODOS LOS FICHEROS HTMLs EN BUSCA DE CSSs");
        System.out.println();
        System.out.println();
        for(int j = 0; j<this.htmls.size();j++){
            Html html = (Html)this.htmls.get(j);
            this.descargaCSSsQueHayEnFicheroTexto(html.getNombreHtml());
        }
        System.out.print("--------------- FIN: TODOS LOS FICHEROS HTMLs HAN SIDO ANALIZADOS");
        System.out.println();
        System.out.println();
        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();

        System.out.print("--------------- RECORREMOS TODOS LOS FICHEROS CSSs EN BUSCA DE CSSs");
        System.out.println();
        System.out.println();
        for (int i = 0; i<csss.size();i++) {
            Css css = (Css)this.csss.get(i);
            this.descargaCSSsQueHayEnFicheroTexto(css.getNombreCss());
        }
        System.out.print("--------------- FIN: TODOS LOS FICHEROS CSSs HAN SIDO ANALIZADOS");
        System.out.println();
        System.out.println();
        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();



        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.print("-------------- FIN DESCARGA DE TODOS LOS CSSs DEL SITIO WEB "+arbolCarpetas.getNombreSitioWeb());
        System.out.println();
        System.out.println();
    }
    //Este método localiza y descarga todos los ficheros .html presentes en un fichero .html.txt y los almacena en la carpeta html
    public void descargaCSSsQueHayEnFicheroTexto(String nombreFicheroTXT) throws IOException {
        if (nombreFicheroTXT.contains(".html")) {
            this.buscaURLsCSSs(arbolCarpetas.getPathHtmls() + "/" + nombreFicheroTXT);
            esperar(1);
        } else if (nombreFicheroTXT.contains(".css")){
            this.buscaURLsCSSs(arbolCarpetas.getPathCsss() + "/" + nombreFicheroTXT);
            esperar(1);
        }
        this.limpia();
        String nombreCss="";
        int j = 0;
        String lineaux="";
        try {
            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.print("-------------- DESCARGANDO CSSs SITIO WEB: ");
            esperar(1);
            System.out.println();
            System.out.print("----------------- En total quedan por  descargar "+ cantidadURLsEnCola + " ficheros .css");
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

            FileReader fr = new FileReader(arbolCarpetas.getPathCsss()+"/"+"urlsCSSsLimpias.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            Boolean yaEsta;


            while ((linea = br.readLine()) != null) {
                lineaux = linea;
                yaEsta = false;
                for (int r = 0; r < this.csss.size(); r++) {
                    Css css1 = (Css)this.csss.get(r);
                    if (css1.getUrlCss().equals(linea)) {
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
                    int indice = linea.indexOf(".css") - 1;
                    for (int t = indice; !String.valueOf(linea.charAt(t)).equals("/"); t--) {
                        nombreAlReves = nombreAlReves + linea.charAt(t);
                    }

                    for (int y = nombreAlReves.length() - 1; y >= 0; y--) {
                        nombreCss = nombreCss + nombreAlReves.charAt(y);
                    }


                    nombreCss = nombreCss + ".css.txt";


                    URL url = new URL(linea);
                    InputStream in = new BufferedInputStream(url.openStream());
                    OutputStream out = new BufferedOutputStream(new FileOutputStream(arbolCarpetas.getPathCsss() + "/" + nombreCss));


                    for (int i; (i = in.read()) != -1; ) {
                        out.write(i);
                    }
                    in.close();
                    out.close();


                    this.nombreCss = nombreCss;
                    /*
                    nombreCss = "";
                    System.out.print("--------------------- Nombre HTML:   " + this.nombreCss);
                    esperar(1);
                    System.out.println();

                     */

                    this.urlCss = linea;
                    /*
                    System.out.print("--------------------- url:           " + this.urlHtml);
                    esperar(1);
                    System.out.println();

                     */

                    long tamanoCss = this.obtenTamanoCSS();
                    this.tamanoCss = String.valueOf(tamanoCss);
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

                    this.csss.add(new Css(this.nombreCss, this.urlCss, this.tamanoCss));
                    this.cantidadURLsEnCola--;
                    j++;
                }
            }

        } catch(FileNotFoundException e){
            System.out.print("----------------- Error en \"descargaCSSsQueHayEnFicheroTexto()\": FileNotFoundException: "+ lineaux);
            System.out.println();
        } catch(MalformedURLException e){
            e.printStackTrace();
        } catch(IOException e){
            System.out.print("----------------- Error en \"descargaCSSsQueHayEnFicheroTexto()\": IOException: "+ lineaux);
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

        File ficherotexto1 = new File(arbolCarpetas.getPathCsss()+"/"+"urlsCSSs.txt");
        File ficherotexto2 = new File(arbolCarpetas.getPathCsss()+"/"+"urlsCSSsLimpias.txt");

        if(ficherotexto1.exists() && ficherotexto2.exists()){
            System.out.print("----------------- Borrando fichero: "+ arbolCarpetas.getPathCsss()+"/"+ "urlsCSSs.txt");
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

            System.out.print("----------------- Borrando fichero: "+ arbolCarpetas.getPathCsss()+"/"+"urlsCSSsLimpias.txt");
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
        File ficheroTXT = new File (this.arbolCarpetas.getPathCsss()+"/"+"infoCSS.txt");
        if(ficheroTXT.exists()){
            ficheroTXT.setReadable(true, false);
            ficheroTXT.setExecutable(true, false);
            ficheroTXT.setWritable(true, false);
            ficheroTXT.delete();
        }
        esperar(5);


        //Crear fichero de texto con la informacion de las imagenes

        System.out.print("-------------- CREANDO FICHERO CON INFORMACION DE LOS CSSs");
        System.out.println();
        esperar(2);
        System.out.print("----------------- Creando fichero: "+this.arbolCarpetas.getPathCsss()+"/"+"infoCSS.txt");
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
        this.guardaTextoFicheroTXT("----- Información de los ficheros .css contenidos en esta carpeta -----",this.arbolCarpetas.getPathCsss()+"/"+"infoCSS.txt");
        this.guardaTextoFicheroTXT("",this.arbolCarpetas.getPathCsss()+"/"+"infoCSS.txt");

        File carpetaCSSs = new File (arbolCarpetas.getPathCsss());

        int numTotalCSSs = carpetaCSSs.listFiles().length-1;
        this.guardaTextoFicheroTXT("-> Número total de CSSs: " + numTotalCSSs,this.arbolCarpetas.getPathCsss()+"/"+"infoCSS.txt");
        int tamanoCarpeta = 0;
        Css css1;
        for (int y = 0;y<this.csss.size();y++){
            css1 = (Css) this.csss.get(y);
            tamanoCarpeta = tamanoCarpeta + Integer.parseInt(css1.getTamanoCss());
        }
        this.guardaTextoFicheroTXT("-> Tamaño total carpeta:     " + tamanoCarpeta +" KB",this.arbolCarpetas.getPathCsss()+"/"+"infoCSS.txt");
        this.guardaTextoFicheroTXT("",this.arbolCarpetas.getPathCsss()+"/"+"infoCSS.txt");
        this.guardaTextoFicheroTXT("",this.arbolCarpetas.getPathCsss()+"/"+"infoCSS.txt");

        int q = 0;
        for (int w=0;w<this.csss.size();w++){

            q = w+1;
            this.guardaTextoFicheroTXT("------------ CSS " + q+") ------------",this.arbolCarpetas.getPathCsss()+"/"+"infoCSS.txt");
            Css css2 = (Css)csss.get(w);
            this.guardaTextoFicheroTXT("---- Nombre:           "+css2.getNombreCss(),this.arbolCarpetas.getPathCsss()+"/"+"infoCSS.txt");
            this.guardaTextoFicheroTXT("---- URL:              "+css2.getUrlCss(),this.arbolCarpetas.getPathCsss()+"/"+"infoCSS.txt");
            this.guardaTextoFicheroTXT("---- Tamaño CSS:       "+css2.getTamanoCss() +" KB",this.arbolCarpetas.getPathCsss()+"/"+"infoCSS.txt");
            this.guardaTextoFicheroTXT("",this.arbolCarpetas.getPathCsss()+"/"+"infoCSS.txt");

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



    public void buscaURLsCSSs(String pathTXT){

        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.print("-------------- ANALIZANDO FICHERO DE TEXTO EN BUSCA DE FICHEROS CSSs: " + pathTXT);
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

                    this.guardaTextoFicheroTXT(urlCss2,arbolCarpetas.getPathCsss()+"/"+"urlsCSSs.txt");


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

                if (linea.contains(".css")) {
                    k = linea.indexOf(".css");
                    for ( i = k+3; i >=0; i--) {
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

            System.out.print("----------------- Encontradas  "+ j +" URLs con extensión .css" );
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
        System.out.print("-------------- LIMPIANDO URLs DE LOS CSSs");
        System.out.println();
        System.out.println();
        esperar(1);

        ArrayList urlsCSSs = new ArrayList<String>();
        ArrayList urlsCSSsSinRepeticiones = new ArrayList<String>();
        ArrayList urlsCSSsLimpios = new ArrayList<String>();

        boolean repetido = false;



        try {
            FileReader fr = new FileReader(arbolCarpetas.getPathCsss() + "/" + "urlsCSSs.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                urlsCSSs.add(linea);
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
            urlsCSSsSinRepeticiones.add(urlsCSSs.get(0));
            for (int i = 1; i < urlsCSSs.size(); i++) {
                for (int g = 0; g < urlsCSSsSinRepeticiones.size(); g++) {
                    if (urlsCSSs.get(i).equals(urlsCSSsSinRepeticiones.get(g))) {
                        contador = contador + 1;
                        repetido = true;
                    }
                }

                if (!repetido) {
                    urlsCSSsSinRepeticiones.add(urlsCSSs.get(i));
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
            int contador1 = urlsCSSs.size() - contador;
            System.out.print("----------------- Quedan " +contador1 + " URLs sin repetir");
            esperar(1);
            System.out.println();

            //añade http://... si no lo tiene
            String cadena;
            for (int g = 0; g < urlsCSSsSinRepeticiones.size(); g++) {
                cadena = (String) urlsCSSsSinRepeticiones.get(g);
                if (cadena.contains("index.html")) {

                } else if (cadena.contains("http")) {
                    urlsCSSsLimpios.add(cadena);

                } else if (cadena.contains("//")) {
                    urlsCSSsLimpios.add("https:" + cadena);


                } else if (!String.valueOf(cadena.charAt(0)).equals("/")) {
                    //No hacemos nada. Nos deshacemos de esta línea

                } else {
                    urlsCSSsLimpios.add(arbolCarpetas.getUrlSitioWeb().getURL() + cadena);
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

            if (urlsCSSsLimpios.size() != 0) {
                for (int i = 0; i < urlsCSSsLimpios.size(); i++) {
                    try {
                        URL url = new URL(urlsCSSsLimpios.get(i).toString());
                        InputStream in = new BufferedInputStream(url.openStream());
                        OutputStream out = new BufferedOutputStream(new FileOutputStream(arbolCarpetas.getPathCsss()+ "/" + "temporal"+ i));
                        File file = new File(arbolCarpetas.getPathCsss() + "/" + "temporal" + i);
                        file.delete();
                        in.close();
                        out.close();

                    } catch (FileNotFoundException e) {
                        contador2 = contador2 +1;
                        /*
                        System.out.println();
                        System.out.print("            ------- Error en \"limpia()\": FileNotFoundException: " + urlsCSSsLimpios.get(i).toString());
                        urlsCSSsLimpios.remove(i);
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

                        System.out.print("            ----- Error en \"limpia()\" IOException:            " + urlsCSSsLimpios.get(i).toString());
                        urlsCSSsLimpios.remove(i);
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
                int contador3 = urlsCSSs.size() - contador;
                System.out.print("----------------- Quedan " +contador3 + " URLs válidas");
                esperar(1);
                System.out.println();
                System.out.println();
                for (int k = 0; k < urlsCSSsLimpios.size(); k++) {
                    this.guardaTextoFicheroTXT(urlsCSSsLimpios.get(k).toString(), arbolCarpetas.getPathCsss() + "/" + "urlsCSSsLimpias.txt");
                }

                this.cantidadURLsEnCola = this.cantidadURLsEnCola + urlsCSSsLimpios.size();
            }
        } catch (FileNotFoundException e) {
            System.out.print("----------------- Error en limpia(): FileNotFoundException: no se ha creado fichero urlsCSSs.txt");
            System.out.println();
        }
    }

    //Obtiene el tamaño del fichero html que esta descargándose
    //
    public long obtenTamanoCSS() throws IOException {
        File css = new File(this.arbolCarpetas.getPathCsss()+"/"+this.nombreCss);
        return css.length();

    }

    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
