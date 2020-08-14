import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Imagen {

    String nombreImagen;
    String urlImagen;
    String tamanoImagen;

    ArbolCarpetasSitioWeb arbolCarpetas;

    ArrayList imagenes;
    ArrayList htmls;
    ArrayList csss;
    ArrayList jss;


    int cantidadURLsEnCola=0;

    public Imagen() {
        this.imagenes = new ArrayList<Imagen>();
    }

    public Imagen(ArbolCarpetasSitioWeb arbolCarpetas, ArrayList<Html>  htmls,ArrayList<Css>  csss,ArrayList<Js>  jss) {
        this.arbolCarpetas = arbolCarpetas;
        this.imagenes = new ArrayList<Imagen>();
        this.htmls = htmls;
        this.csss=csss;
        this.jss = jss;
    }

    public Imagen(String nombreImagen, String urlImagen, String tamanoImagen) {
        this.nombreImagen = nombreImagen;
        this.urlImagen = urlImagen;
        this.tamanoImagen = tamanoImagen;
        this.imagenes = new ArrayList<Imagen>();
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public String getTamanoImagen() {
        return tamanoImagen;
    }

    public ArrayList getImagenes() {
        return imagenes;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public void setUrlSitioWeb(String urlSitioWeb) {
        this.urlImagen = urlSitioWeb;
    }

    public void setTamanoImagen(String tamanoImagen) {
        this.tamanoImagen = tamanoImagen;
    }

    public void setImagenes(ArrayList imagenes) {
        this.imagenes = imagenes;
    }



    public void descargaTodosImagenes() throws IOException {

        System.out.println();
        System.out.println();
        System.out.print("-------------- COMENZAMOS CON LA BÚSQUEDA Y DERCARGA DE TODOS LAS IMÁGENEs DEL SITIO WEB  "+arbolCarpetas.getNombreSitioWeb());
        System.out.println();
        System.out.println();
        //int tamanoActualCarpetaHtml;
        //int tamanoNuevoCarpetaHTML=0;

        //tamanoActualCarpetaHtml = htmls.size();

        //while (true) {
        System.out.print("--------------- RECORREMOS TODOS LOS FICHEROS HTMLs EN BUSCA DE IMÁGENEs");
        System.out.println();
        System.out.println();


        for(int j = 0; j<this.htmls.size();j++){
            Html html = (Html)this.htmls.get(j);
            this.descargaIMAGENESsQueHayEnFicheroTexto(html.getNombreHtml());
        }
        System.out.print("--------------- FIN: TODOS LOS FICHEROS HTMLs HAN SIDO ANALIZADOS EN BUSCA DE IMÁGENEs");
        System.out.println();
        System.out.println();
        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();

        System.out.print("--------------- RECORREMOS TODOS LOS FICHEROS CSSs EN BUSCA DE IMÁGENEs");
        System.out.println();
        System.out.println();
        for(int j = 0; j<this.csss.size();j++){
            Css css = (Css)this.csss.get(j);
            this.descargaIMAGENESsQueHayEnFicheroTexto(css.getNombreCss());
        }

        System.out.print("--------------- FIN: TODOS LOS FICHEROS CSSs HAN SIDO ANALIZADOS EN BUSCA DE IMÁGENEs");
        System.out.println();
        System.out.println();
        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();

        System.out.print("--------------- RECORREMOS TODOS LOS FICHEROS JSs EN BUSCA DE IMÁGENEs");
        System.out.println();
        System.out.println();
        for(int j = 0; j<this.jss.size();j++){
            Js js = (Js)this.jss.get(j);
            this.descargaIMAGENESsQueHayEnFicheroTexto(js.getNombreJs());
        }
        System.out.print("--------------- FIN: TODOS LOS FICHEROS JSs HAN SIDO ANALIZADOS EN BUSCA DE IMÁGENEs");
        System.out.println();
        System.out.println();
        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();



        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.print("-------------- FIN DESCARGA DE TODAS LOS IMÁGENES DEL SITIO WEB "+arbolCarpetas.getNombreSitioWeb());
        System.out.println();
        System.out.println();
        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();

        File fileImg = new File (arbolCarpetas.getPathImagenes());
        String[] ficheros = fileImg.list();
        ArrayList lineas = new ArrayList<String>();
        for(int i =0; i<ficheros.length-1;i++) {
            if (ficheros[i].length() > 4)

                if (ficheros[i].contains("png")) {
                    FileReader fr = new FileReader(arbolCarpetas.getPathImagenes()+"/"+ficheros[i]);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        lineas.add(linea);
                    }
                    for (int k = 0; k < lineas.size(); k++) {
                        this.guardaTextoFicheroTXT(lineas.get(k).toString(), arbolCarpetas.getPathPngs()+ "/" +ficheros[i] );
                    }
                    this.creaFicheroInfoIMAGENESsTXT(arbolCarpetas.getPathPngs());
                }else if (ficheros[i].contains("jpg")){
                    FileReader fr = new FileReader(arbolCarpetas.getPathImagenes()+"/"+ficheros[i]);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        lineas.add(linea);
                    }
                    for (int k = 0; k < lineas.size(); k++) {
                        this.guardaTextoFicheroTXT(lineas.get(k).toString(), arbolCarpetas.getPathJpgs()+ "/" +ficheros[i] );
                    }
                    this.creaFicheroInfoIMAGENESsTXT(arbolCarpetas.getPathJpgs());

                }else if (ficheros[i].contains("ico")){
                    FileReader fr = new FileReader(arbolCarpetas.getPathImagenes()+"/"+ficheros[i]);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        lineas.add(linea);
                    }
                    for (int k = 0; k < lineas.size(); k++) {
                        this.guardaTextoFicheroTXT(lineas.get(k).toString(), arbolCarpetas.getPathIcos()+ "/" +ficheros[i] );
                    }
                    this.creaFicheroInfoIMAGENESsTXT(arbolCarpetas.getPathIcos());

                }else if (ficheros[i].contains("gif")){
                    FileReader fr = new FileReader(arbolCarpetas.getPathImagenes()+"/"+ficheros[i]);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        lineas.add(linea);
                    }
                    for (int k = 0; k < lineas.size(); k++) {
                        this.guardaTextoFicheroTXT(lineas.get(k).toString(), arbolCarpetas.getPathGifs()+ "/" +ficheros[i] );
                    }
                    this.creaFicheroInfoIMAGENESsTXT(arbolCarpetas.getPathGifs());

                }else if (ficheros[i].contains("svg")){
                    FileReader fr = new FileReader(arbolCarpetas.getPathImagenes()+"/"+ficheros[i]);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        lineas.add(linea);
                    }
                    for (int k = 0; k < lineas.size(); k++) {
                        this.guardaTextoFicheroTXT(lineas.get(k).toString(), arbolCarpetas.getPathSvgs()+ "/" +ficheros[i] );
                    }
                    this.creaFicheroInfoIMAGENESsTXT(arbolCarpetas.getPathSvgs());

                }
        }

        for(int i =0; i<imagenes.size();i++) {
            Imagen img = (Imagen)imagenes.get(i);
            File file = new File (arbolCarpetas.getPathImagenes()+img.getNombreImagen());
            if(file.exists()){
                file.delete();
            }
        }
    }

    //Este método localiza y descarga todos los ficheros .html presentes en un fichero .html.txt y los almacena en la carpeta html
    public void descargaIMAGENESsQueHayEnFicheroTexto(String nombreFicheroTXT) throws IOException {


        if (nombreFicheroTXT.contains(".html")) {
            this.buscaURLsIMAGENEs(arbolCarpetas.getPathHtmls() + "/" + nombreFicheroTXT);
            esperar(1);
        } else if (nombreFicheroTXT.contains(".css")){
            this.buscaURLsIMAGENEs(arbolCarpetas.getPathCsss() + "/" + nombreFicheroTXT);
            esperar(1);
        }else if (nombreFicheroTXT.contains(".js")){
            this.buscaURLsIMAGENEs(arbolCarpetas.getPathJss() + "/" + nombreFicheroTXT);
            esperar(1);
        }
        esperar(1);
        this.limpia();
        String nombreImagen="";
        int j = 0;
        String lineaux="";
        try {
            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.print("-------------- DESCARGANDO IMAGENEs SITIO WEB: ");
            esperar(1);
            System.out.println();
            System.out.print("----------------- En total quedan por  descargar "+ cantidadURLsEnCola + " ficheros .png o .jpg");
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

            FileReader fr = new FileReader(arbolCarpetas.getPathImagenes()+"/"+"urlsIMAGENESsLimpias.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            Boolean yaEsta;


            while ((linea = br.readLine()) != null) {
                lineaux = linea;
                yaEsta = false;
                for (int r = 0; r < this.imagenes.size(); r++) {
                    Imagen img1 = (Imagen)this.imagenes.get(r);
                    if (img1.getUrlImagen().equals(linea)) {
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
                    int indice=0;
                    if(linea.contains(".jpg")){
                        indice = linea.indexOf(".jpg") - 1;
                    } else if (linea.contains(".png")){
                        indice = linea.indexOf(".png") - 1;
                    } else if (linea.contains(".ico")){
                        indice = linea.indexOf(".ico") - 1;
                    }else if (linea.contains(".gif")){
                        indice = linea.indexOf(".gif") - 1;
                    }else if (linea.contains(".svg")){
                        indice = linea.indexOf(".svg") - 1;
                    }
                    for (int t = indice; !String.valueOf(linea.charAt(t)).equals("/"); t--) {
                        nombreAlReves = nombreAlReves + linea.charAt(t);
                    }

                    for (int y = nombreAlReves.length() - 1; y >= 0; y--) {
                        nombreImagen = nombreImagen + nombreAlReves.charAt(y);
                    }

                    if(linea.contains(".jpg")){
                        nombreImagen = nombreImagen + ".jpg";
                    } else if (linea.contains(".png")){
                        nombreImagen = nombreImagen + ".png";
                    } else if (linea.contains(".ico")){
                        nombreImagen = nombreImagen + ".ico";
                    }else if (linea.contains(".gif")){
                        nombreImagen = nombreImagen + ".gif";
                    }else if (linea.contains(".svg")){
                        nombreImagen = nombreImagen + ".svg";
                    }

                    URL url = new URL(linea);
                    InputStream in = new BufferedInputStream(url.openStream());
                    OutputStream out = new BufferedOutputStream(new FileOutputStream(arbolCarpetas.getPathImagenes() + "/" + nombreImagen));


                    for (int i; (i = in.read()) != -1; ) {
                        out.write(i);
                    }
                    in.close();
                    out.close();


                    this.nombreImagen = nombreImagen;
                    /*
                    nombreImagen = "";
                    System.out.print("--------------------- Nombre HTML:   " + this.nombreImagen);
                    esperar(1);
                    System.out.println();

                     */

                    this.urlImagen = linea;
                    /*
                    System.out.print("--------------------- url:           " + this.urlHtml);
                    esperar(1);
                    System.out.println();

                     */

                    long tamanoImagen = this.obtenTamanoIMAGEN();
                    this.tamanoImagen = String.valueOf(tamanoImagen);
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

                    this.imagenes.add(new Imagen(this.nombreImagen, this.urlImagen, this.tamanoImagen));
                    this.cantidadURLsEnCola--;
                    j++;
                }
            }

        } catch(FileNotFoundException e){
            System.out.print("----------------- Error en \"descargaIMAGENESsQueHayEnFicheroTexto()\": FileNotFoundException: "+ lineaux);
            System.out.println();
        } catch(MalformedURLException e){
            e.printStackTrace();
        } catch(IOException e){
            System.out.print("----------------- Error en \"descargaIMAGENESsQueHayEnFicheroTexto()\": IOException: "+ lineaux);
            System.out.println();

        }

        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();

        //this.borraFicheros();
        this.creaFicheroInfoIMAGENESsTXT(this.arbolCarpetas.getPathImagenes());






    }

    public void borraFicheros (){

        //Borra ficheros de texto con las urls de los HTMLs de la carpeta del html
        System.out.print("-------------- BORRANDO FICHEROS INECESARIOS");
        System.out.println();
        esperar(2);

        File ficherotexto1 = new File(arbolCarpetas.getPathImagenes()+"/"+"urlsIMAGENES.txt");
        File ficherotexto2 = new File(arbolCarpetas.getPathImagenes()+"/"+"urlsIMAGENEsLimpias.txt");

        if(ficherotexto1.exists() && ficherotexto2.exists()){
            System.out.print("----------------- Borrando fichero: "+ arbolCarpetas.getPathImagenes()+"/"+ "urlsIMAGENES.txt");
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

            System.out.print("----------------- Borrando fichero: "+ arbolCarpetas.getPathImagenes()+"/"+"urlsIMAGENEsLimpias.txt");
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

    public void creaFicheroInfoIMAGENESsTXT(String path) {
        //Si existe el fichero lo borrar para crear uno nuevo actualizado
        File ficheroTXT = new File(path + "/" + "infoIMAGENES.txt");
        if (ficheroTXT.exists()) {
            ficheroTXT.setReadable(true, false);
            ficheroTXT.setExecutable(true, false);
            ficheroTXT.setWritable(true, false);
            ficheroTXT.delete();
        }
        esperar(5);


        //Crear fichero de texto con la informacion de las imagenes

        System.out.print("-------------- CREANDO FICHERO CON INFORMACION DE LAS IMAGENEs");
        System.out.println();
        esperar(2);
        System.out.print("----------------- Creando fichero: " + path + "/" + "infoIMAGENES.txt");
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
        this.guardaTextoFicheroTXT("----- Información de los ficheros .JPG, .PNG, .ICO, .GIF, SVG contenidos en esta carpeta -----", path + "/" + "infoIMAGENES.txt");
        this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");

        File carpetaIMAGENEs = new File(path);

        int numTotalIMAGENEs = carpetaIMAGENEs.listFiles().length - 1;
        this.guardaTextoFicheroTXT("-> Número total de IMAGENEs: " + numTotalIMAGENEs, path + "/" + "infoIMAGENES.txt");
        int tamanoCarpeta = 0;
        Imagen img1;
        if (path.equals(arbolCarpetas.getPathImagenes())) {
            for (int y = 0; y < this.imagenes.size(); y++) {
                img1 = (Imagen) this.imagenes.get(y);
                tamanoCarpeta = tamanoCarpeta + Integer.parseInt(img1.getTamanoImagen());
            }
            this.guardaTextoFicheroTXT("-> Tamaño total carpeta:     " + tamanoCarpeta + " KB", path + "/" + "infoIMAGENES.txt");
            this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");
            this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");

            int q = 0;
            for (int w = 0; w < this.imagenes.size(); w++) {

                q = w + 1;
                this.guardaTextoFicheroTXT("------------ IMG " + q + ") ------------", this.arbolCarpetas.getPathImagenes() + "/" + "infoIMAGENES.txt");
                Imagen img2 = (Imagen) imagenes.get(w);
                this.guardaTextoFicheroTXT("---- Nombre:           " + img2.getNombreImagen(), this.arbolCarpetas.getPathImagenes() + "/" + "infoIMAGENES.txt");
                this.guardaTextoFicheroTXT("---- URL:              " + img2.getUrlImagen(), this.arbolCarpetas.getPathImagenes() + "/" + "infoIMAGENES.txt");
                this.guardaTextoFicheroTXT("---- Tamaño IMAGEN:      " + img2.getTamanoImagen() + " KB", this.arbolCarpetas.getPathImagenes() + "/" + "infoIMAGENES.txt");
                this.guardaTextoFicheroTXT("", this.arbolCarpetas.getPathImagenes() + "/" + "infoIMAGENES.txt");

            }
            esperar(1);
            System.out.print("OK!");
            System.out.println();
            System.out.println();
            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println();
            esperar(5);

        } else if (path.contains("png")) {
            for (int y = 0; y < this.imagenes.size(); y++) {
                img1 = (Imagen) this.imagenes.get(y);
                if (img1.getNombreImagen().contains(".png")) {
                    tamanoCarpeta = tamanoCarpeta + Integer.parseInt(img1.getTamanoImagen());
                }
            }
            this.guardaTextoFicheroTXT("-> Tamaño total carpeta:     " + tamanoCarpeta + " KB", path + "/" + "infoIMAGENES.txt");
            this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");
            this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");

            int q = 0;
            for (int w = 0; w < this.imagenes.size(); w++) {
                Imagen img2 = (Imagen) imagenes.get(w);
                if (img2.getNombreImagen().contains(".png")) {
                    q = w + 1;
                    this.guardaTextoFicheroTXT("------------ IMG " + q + ") ------------", path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- Nombre:           " + img2.getNombreImagen(), path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- URL:              " + img2.getUrlImagen(), path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- Tamaño IMAGEN:    " + img2.getTamanoImagen() + " KB", path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");
                }
            }
        } else if (path.contains("jpg")) {
            for (int y = 0; y < this.imagenes.size(); y++) {
                img1 = (Imagen) this.imagenes.get(y);
                if (img1.getNombreImagen().contains(".jpg")) {
                    tamanoCarpeta = tamanoCarpeta + Integer.parseInt(img1.getTamanoImagen());
                }
            }
            this.guardaTextoFicheroTXT("-> Tamaño total carpeta:     " + tamanoCarpeta + " KB", path + "/" + "infoIMAGENES.txt");
            this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");
            this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");

            int q = 0;
            for (int w = 0; w < this.imagenes.size(); w++) {
                Imagen img2 = (Imagen) imagenes.get(w);
                if (img2.getNombreImagen().contains(".jpg")) {
                    q = w + 1;
                    this.guardaTextoFicheroTXT("------------ IMG " + q + ") ------------", path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- Nombre:           " + img2.getNombreImagen(), path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- URL:              " + img2.getUrlImagen(), path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- Tamaño IMAGEN:    " + img2.getTamanoImagen() + " KB", path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");
                }
            }

        }else if (path.contains("ico")) {
            for (int y = 0; y < this.imagenes.size(); y++) {
                img1 = (Imagen) this.imagenes.get(y);
                if (img1.getNombreImagen().contains(".ico")) {
                    tamanoCarpeta = tamanoCarpeta + Integer.parseInt(img1.getTamanoImagen());
                }
            }
            this.guardaTextoFicheroTXT("-> Tamaño total carpeta:     " + tamanoCarpeta + " KB", path + "/" + "infoIMAGENES.txt");
            this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");
            this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");

            int q = 0;
            for (int w = 0; w < this.imagenes.size(); w++) {
                Imagen img2 = (Imagen) imagenes.get(w);
                if (img2.getNombreImagen().contains(".ico")) {
                    q = w + 1;
                    this.guardaTextoFicheroTXT("------------ IMG " + q + ") ------------", path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- Nombre:           " + img2.getNombreImagen(), path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- URL:              " + img2.getUrlImagen(), path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- Tamaño IMAGEN:    " + img2.getTamanoImagen() + " KB", path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");
                }
            }

        }else if (path.contains("gif")) {
            for (int y = 0; y < this.imagenes.size(); y++) {
                img1 = (Imagen) this.imagenes.get(y);
                if (img1.getNombreImagen().contains(".gif")) {
                    tamanoCarpeta = tamanoCarpeta + Integer.parseInt(img1.getTamanoImagen());
                }
            }
            this.guardaTextoFicheroTXT("-> Tamaño total carpeta:     " + tamanoCarpeta + " KB", path + "/" + "infoIMAGENES.txt");
            this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");
            this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");

            int q = 0;
            for (int w = 0; w < this.imagenes.size(); w++) {
                Imagen img2 = (Imagen) imagenes.get(w);
                if (img2.getNombreImagen().contains(".gif")) {
                    q = w + 1;
                    this.guardaTextoFicheroTXT("------------ IMG " + q + ") ------------", path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- Nombre:           " + img2.getNombreImagen(), path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- URL:              " + img2.getUrlImagen(), path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- Tamaño IMAGEN:    " + img2.getTamanoImagen() + " KB", path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");
                }
            }

        }else if (path.contains("svg")) {
            for (int y = 0; y < this.imagenes.size(); y++) {
                img1 = (Imagen) this.imagenes.get(y);
                if (img1.getNombreImagen().contains(".svg")) {
                    tamanoCarpeta = tamanoCarpeta + Integer.parseInt(img1.getTamanoImagen());
                }
            }
            this.guardaTextoFicheroTXT("-> Tamaño total carpeta:     " + tamanoCarpeta + " KB", path + "/" + "infoIMAGENES.txt");
            this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");
            this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");

            int q = 0;
            for (int w = 0; w < this.imagenes.size(); w++) {
                Imagen img2 = (Imagen) imagenes.get(w);
                if (img2.getNombreImagen().contains(".svg")) {
                    q = w + 1;
                    this.guardaTextoFicheroTXT("------------ IMG " + q + ") ------------", path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- Nombre:           " + img2.getNombreImagen(), path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- URL:              " + img2.getUrlImagen(), path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("---- Tamaño IMAGEN:    " + img2.getTamanoImagen() + " KB", path + "/" + "infoIMAGENES.txt");
                    this.guardaTextoFicheroTXT("", path + "/" + "infoIMAGENES.txt");
                }
            }

        }
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



    public void buscaURLsIMAGENEs(String pathTXT){

        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.print("-------------- ANALIZANDO FICHERO DE TEXTO EN BUSCA DE FICHEROS .PNG Y .JPG: " + pathTXT);
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
            String urlImg1 ="";
            String urlImg2 ="";
            boolean lineaNoAcabada = false;
            boolean urlNoCompleta = false;
            boolean guarda = false;
            int i;
            int j=0;
            int k=0;
            int m =1;


            while((linea = br.readLine()) !=null) {
                if (guarda) {
                    j=j+1;

                    this.guardaTextoFicheroTXT(urlImg2,arbolCarpetas.getPathImagenes()+"/"+"urlsIMAGENEs.txt");


                    m++;


                    urlImg1 = "";
                    urlImg2 = "";
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
                boolean lineaContieneImagen = false;
                if (linea.contains(".jpg")||linea.contains(".png")||linea.contains(".ico")||linea.contains(".gif")||linea.contains(".svg")) {
                    if (linea.contains(".jpg")) {
                        k = linea.indexOf(".jpg");
                        lineaContieneImagen = true;
                    } else if (linea.contains(".png")) {
                        k = linea.indexOf(".png");
                        lineaContieneImagen = true;
                    } else if (linea.contains(".ico")) {
                        k = linea.indexOf(".ico");
                        lineaContieneImagen = true;
                    } else if (linea.contains(".gif")) {
                        k = linea.indexOf(".gif");
                        lineaContieneImagen = true;
                    } else if (linea.contains(".svg")) {
                        k = linea.indexOf(".svg");
                        lineaContieneImagen = true;
                    }

                }
                if(lineaContieneImagen){


                    for ( i = k+3; i >=0; i--) {
                        if(String.valueOf(linea.charAt(i)).equals(simbolo) || String.valueOf(linea.charAt(i)).equals(simbolo1)) {
                            break;
                        }else {
                            urlImg1 = urlImg1 + linea.charAt(i);
                        }
                    }

                    //le damos la vuelta
                    for (int l = urlImg1.length()-1; l>=0;l--){
                        urlImg2 = urlImg2 + urlImg1.charAt(l);
                    }
                    //urlNoCompleta = false;
                    guarda = true;
                }
            }

            System.out.print("----------------- Encontradas  "+ j +" URLs con extensión .png o .jpg" );
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
        System.out.print("-------------- LIMPIANDO URLs DE LAS IMAGENEs");
        System.out.println();
        System.out.println();
        esperar(1);

        ArrayList urlsIMAGENEs = new ArrayList<String>();
        ArrayList urlsIMAGENEsSinRepeticiones = new ArrayList<String>();
        ArrayList urlsIMAGENEsLimpios = new ArrayList<String>();

        boolean repetido = false;



        try {
            FileReader fr = new FileReader(arbolCarpetas.getPathImagenes() + "/" + "urlsIMAGENEs.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                urlsIMAGENEs.add(linea);
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
            urlsIMAGENEsSinRepeticiones.add(urlsIMAGENEs.get(0));
            for (int i = 1; i < urlsIMAGENEs.size(); i++) {
                for (int g = 0; g < urlsIMAGENEsSinRepeticiones.size(); g++) {
                    if (urlsIMAGENEs.get(i).equals(urlsIMAGENEsSinRepeticiones.get(g))) {
                        contador = contador + 1;
                        repetido = true;
                    }
                }

                if (!repetido) {
                    urlsIMAGENEsSinRepeticiones.add(urlsIMAGENEs.get(i));
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
            int contador1 = urlsIMAGENEs.size() - contador;
            System.out.print("----------------- Quedan " +contador1 + " URLs sin repetir");
            esperar(1);
            System.out.println();

            //añade http://... si no lo tiene
            String cadena;
            String auxCadena;
            int empiezaCadena;
            for (int g = 0; g < urlsIMAGENEsSinRepeticiones.size(); g++) {
                cadena = (String) urlsIMAGENEsSinRepeticiones.get(g);
                 if (!cadena.contains("http")){
                     if(cadena.contains("..")){
                         empiezaCadena = cadena.indexOf("url");
                         auxCadena = cadena.substring(empiezaCadena+3);
                         urlsIMAGENEsLimpios.add(arbolCarpetas.getUrlSitioWeb().getURL() +"/"+ auxCadena);

                     }else{
                         if(cadena.contains("url")) {
                             empiezaCadena = cadena.indexOf("url");
                             auxCadena = cadena.substring(empiezaCadena + 4);
                             urlsIMAGENEsLimpios.add(arbolCarpetas.getUrlSitioWeb().getURL() + "/" + auxCadena);
                         }else{
                             urlsIMAGENEsLimpios.add(arbolCarpetas.getUrlSitioWeb().getURL() + "/" + cadena);
                         }
                     }
                 }else{
                     urlsIMAGENEsLimpios.add(cadena);

                 }
                 /*
                 if (cadena.contains("..")) {
                     int indice = cadena.indexOf("..");
                     String cadena2 = cadena.substring(indice+2,cadena.length()-1);
                    urlsIMAGENEsLimpios.add(arbolCarpetas.getUrlSitioWeb().getURL() +cadena2);


                }else if (cadena.contains("index.html")) {

                } else if (cadena.contains("http")) {
                    urlsIMAGENEsLimpios.add(cadena);

                } else if (cadena.contains("//")) {
                    urlsIMAGENEsLimpios.add("https:" + cadena);


                } else if (!String.valueOf(cadena.charAt(0)).equals("/")) {
                    //No hacemos nada. Nos deshacemos de esta línea

                } else {
                    urlsIMAGENEsLimpios.add(arbolCarpetas.getUrlSitioWeb().getURL() + cadena);
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
/*
            if (urlsIMAGENEsLimpios.size() != 0) {
                for (int i = 0; i < urlsIMAGENEsLimpios.size(); i++) {
                    try {
                        URL url = new URL(urlsIMAGENEsLimpios.get(i).toString());
                        InputStream in = new BufferedInputStream(url.openStream());
                        OutputStream out = new BufferedOutputStream(new FileOutputStream(arbolCarpetas.getPathImagenes()+ "/" + "temporal"+ i));
                        File file = new File(arbolCarpetas.getPathImagenes() + "/" + "temporal" + i);
                        file.delete();
                        in.close();
                        out.close();

                    } catch (FileNotFoundException e) {
                        contador2 = contador2 +1;
                        /*
                        System.out.println();
                        System.out.print("            ------- Error en \"limpia()\": FileNotFoundException: " + urlsIMAGENEsLimpios.get(i).toString());
                        urlsIMAGENEsLimpios.remove(i);
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
/*
                    } catch (IOException e) {
                        contador2 = contador2 +1;
                        /*
                        System.out.println();

                        System.out.print("            ----- Error en \"limpia()\" IOException:            " + urlsIMAGENEsLimpios.get(i).toString());
                        urlsIMAGENEsLimpios.remove(i);
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
/*
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
                int contador3 = urlsIMAGENEs.size() - contador;
                System.out.print("----------------- Quedan " +contador3 + " URLs válidas");
                esperar(1);
                System.out.println();
                System.out.println();
                for (int k = 0; k < urlsIMAGENEsLimpios.size(); k++) {
                    this.guardaTextoFicheroTXT(urlsIMAGENEsLimpios.get(k).toString(), arbolCarpetas.getPathImagenes() + "/" + "urlsIMAGENEsLimpias.txt");
                }


                this.cantidadURLsEnCola = this.cantidadURLsEnCola + urlsIMAGENEsLimpios.size();
            }
            */
        } catch (FileNotFoundException e) {
            System.out.print("----------------- Error en limpia(): FileNotFoundException: no se ha creado fichero urlsIMAGENEs.txt");
            System.out.println();
        }
    }

    //Obtiene el tamaño del fichero html que esta descargándose
    //
    public long obtenTamanoIMAGEN() throws IOException {
        File img = new File(this.arbolCarpetas.getPathImagenes()+"/"+this.nombreImagen);
        return img.length();

    }

    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }




}




