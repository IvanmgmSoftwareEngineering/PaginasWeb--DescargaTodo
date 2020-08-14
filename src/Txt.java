import java.util.ArrayList;

public class Txt {

    String nombreTxt;
    String urlTxt;
    String tamanoTxt;

    ArbolCarpetasSitioWeb arbolCarpetas;

    ArrayList txts;

    public Txt() {
        this.txts = new ArrayList<Txt>();
    }

    public Txt(ArbolCarpetasSitioWeb arbolCarpetas) {
        this.arbolCarpetas = arbolCarpetas;
        this.txts = new ArrayList<Txt>();
    }

    public Txt(String nombreTxt, String urlTxt, String tamanoTxt) {
        this.nombreTxt = nombreTxt;
        this.urlTxt = urlTxt;
        this.tamanoTxt = tamanoTxt;
        this.txts = new ArrayList<Txt>();
    }
}

