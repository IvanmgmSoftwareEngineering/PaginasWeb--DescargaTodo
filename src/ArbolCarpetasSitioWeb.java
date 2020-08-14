import java.io.*;

public class ArbolCarpetasSitioWeb {

    String nombreSitioWeb;
    url    urlSitioWeb;
    String pathSitioWeb;
    String pathHtmls;
    String pathCsss;
    String pathJss;
    String pathImagenes;
    String pathPngs;
    String pathJpgs;
    String pathIcos;
    String pathGifs;
    String pathSvgs;
    String pathVideos;
    String pathDocs;
    String pathPdfs;
    String pathTxts;



    public ArbolCarpetasSitioWeb(String path,url urlSitioWeb) {
        this.nombreSitioWeb = urlSitioWeb.nombreSitioWeb;
        this.urlSitioWeb = urlSitioWeb;
        this.pathSitioWeb = path+"/" + nombreSitioWeb;
        this.pathHtmls = this.pathSitioWeb+"/html";
        this.pathCsss = this.pathSitioWeb+"/css";
        this.pathJss = this.pathSitioWeb+"/js";
        this.pathImagenes = this.pathSitioWeb+"/imagenes";
        this.pathPngs = this.pathImagenes+"/png";
        this.pathJpgs = this.pathImagenes+"/jpg";
        this.pathIcos = this.pathImagenes+"/ico";
        this.pathGifs = this.pathImagenes+"/gif";
        this.pathSvgs = this.pathImagenes+"/svg";
        this.pathVideos = this.pathSitioWeb+"/videos";
        this.pathDocs = this.pathSitioWeb+"/doc";
        this.pathPdfs = this.pathDocs+"/pdf";
        this.pathTxts = this.pathDocs+"/txt";
    }

    public String getNombreSitioWeb() {
        return nombreSitioWeb;
    }
    public url getUrlSitioWeb()       { return urlSitioWeb;    }
    public String getPathSitioWeb()   { return pathSitioWeb;   }
    public String getPathHtmls()      {return pathHtmls;       }
    public String getPathCsss()       {return pathCsss;        }
    public String getPathJss()        {return pathJss;         }
    public String getPathImagenes()   {return pathImagenes;    }
    public String getPathPngs()       {return pathPngs;        }
    public String getPathJpgs()       {return pathJpgs;        }
    public String getPathIcos()       {return pathIcos;        }
    public String getPathGifs()       {return pathGifs;        }
    public String getPathSvgs()       {return pathSvgs;        }
    public String getPathVideos()     {return pathVideos;      }
    public String getPathDocs()       {return pathDocs;        }
    public String getPathPdfs()       {return pathPdfs;        }
    public String getPathTxts()       {return pathTxts;        }

    //Crea arbol de carpetas del Sitio Web
    public void creaArbolCarpetas() throws IOException {
        //Creo carpeta del "Sitio Web" que recibe el nombre del Sitio Web
        File carpeta1 = new File(this.pathSitioWeb);
        carpeta1.mkdir();
        //Creo carpeta "html" dentro del Sitio Web
        File carpeta2 = new File(this.pathHtmls);
        carpeta2.mkdir();
        //Creo carpeta "css" dentro del Sitio Web
        File carpeta3 = new File(this.pathCsss);
        carpeta3.mkdir();
        //Creo carpeta "js" dentro del Sitio Web
        File carpeta4 = new File(this.pathJss);
        carpeta4.mkdir();
        //Creo carpeta "imagenes" dentro del Sitio Web
        File carpeta5 = new File(this.pathImagenes);
        carpeta5.mkdir();
        //Creo carpeta "png" dentro de la carpeta imagenes
        File carpeta6 = new File(this.pathPngs);
        carpeta6.mkdir();
        //Creo carpeta "jpg" dentro de la carpeta imagenes
        File carpeta7 = new File(this.pathJpgs);
        carpeta7.mkdir();
        //Creo carpeta "ico" dentro de la carpeta imagenes
        File carpeta8 = new File(this.pathIcos);
        carpeta8.mkdir();
        //Creo carpeta "gif" dentro de la carpeta imagenes
        File carpeta9 = new File(this.pathGifs);
        carpeta9.mkdir();
        //Creo carpeta "svg" dentro de la carpeta imagenes
        File carpeta10 = new File(this.pathSvgs);
        carpeta10.mkdir();
        //Creo carpeta "videos" dentro del Sitio Web
        File carpeta11 = new File(this.pathVideos);
        carpeta11.mkdir();
        //Creo carpeta "doc" dentro del Sitio Web
        File carpeta12 = new File(this.pathDocs);
        carpeta12.mkdir();
        //Creo carpeta "pdf" dentro de la carpeta doc
        File carpeta13 = new File(this.pathPdfs);
        carpeta13.mkdir();
        //Creo carpeta "txt" dentro de la carpeta doc
        File carpeta14 = new File(this.pathTxts);
        carpeta14.mkdir();



        System.out.print("-------------- CREANDO ARBOL DE CARPETAS PARA EL SITIO WEB: "+urlSitioWeb.getURL());
        esperar(1);
        System.out.println();
        System.out.print("------------------- Creando .");
        esperar(1);
        System.out.print(".");
        esperar(1);
        System.out.print(".");
        esperar(1);
        System.out.print(".");
        esperar(1);
        System.out.print(". ");
        System.out.print("    OK");
        System.out.println();
        System.out.println();
        esperar(2);

        System.out.println();
        System.out.println();
        System.out.print("                                                              "+this.nombreSitioWeb+"                                                                                         ");
        System.out.println();
        esperar(1);
        System.out.print("                                                             "+"        |        "+"                                                                                          ");
        System.out.println();
        esperar(1);
        System.out.print("                                                             "+"        |        "+"                                                                                          ");
        System.out.println();
        esperar(1);
        esperar(1);
        System.out.print("  _____________________________________________________________________________________________________________________________________________________________________       ");
        System.out.println();
        System.out.print("  |                |                  |                   |                                       |                                   |                               |       ");
        System.out.println();
        esperar(1);
        System.out.print("  |                |                  |                   |                                       |                                   |                               |        ");
        System.out.println();
        esperar(1);
        System.out.print(" ____             ___                 __               ________                                 ______                               ___                           ______      ");
        System.out.println();
        esperar(1);
        System.out.print("|html|           |css|               |js|             |imagenes|                               |videos|                             |doc|                         |audios|      ");
        System.out.println();
        System.out.print(" ----             ---                 --               --------                                 ------                               ---                           ______       ");
        esperar(1);
        System.out.println();
        System.out.print("                                                          |                                       |                                   |                               |         ");
        System.out.println();
        esperar(1);
        System.out.print("                                                          |                                       |                                   |                               |         ");
        System.out.println();
        esperar(1);
        System.out.print("                                              _____________________________          _____________________________                __________                     __________     ");
        System.out.println();
        System.out.print("                                              |      |      |      |      |          |      |      |      |      |                |        |                     |        |     ");
        System.out.println();
        esperar(1);
        System.out.print("                                              |      |      |      |      |          |      |      |      |      |                |        |                     |        |     ");
        System.out.println();
        esperar(1);
        System.out.print("                                             ___    ___    ___    ___    ___        ___    ___    ___    ___    ___              ___      ___                   ___      ___    ");
        System.out.println();
        esperar(1);
        System.out.print("                                            |png|  |jpg|  |ico|  |gif|  |svg|      |   |  |   |  |   |  |   |  |   |            |pdf|    |txt|                 |   |    |   |   ");
        System.out.println();
        System.out.print("                                             ___    ___    ___    ___    ___        ___    ___    ___    ___    ___              ---      ---                   ---      ---    ");
        System.out.println();
        esperar(1);

        esperar(10);
        System.out.println();
        System.out.println();


    }

     /*
     Permite pausar la ejecución del programa para mostrar adecuadamente los datos en la Consola
     y dar tiempo para escribir en fichero
     */
    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
