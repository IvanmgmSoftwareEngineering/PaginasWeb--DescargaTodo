import java.util.ArrayList;

public class Pdf {

    String nombrePdf;
    String urlPdf;
    String tamanoPdf;

    ArbolCarpetasSitioWeb arbolCarpetas;

    ArrayList pdfs;

    public Pdf() {
        this.pdfs = new ArrayList<Pdf>();
    }

    public Pdf(ArbolCarpetasSitioWeb arbolCarpetas) {
        this.arbolCarpetas = arbolCarpetas;
        this.pdfs = new ArrayList<Pdf>();
    }

    public Pdf(String nombrePdf, String urlPdf, String tamanoPdf) {
        this.nombrePdf = nombrePdf;
        this.urlPdf = urlPdf;
        this.tamanoPdf = tamanoPdf;
        this.pdfs = new ArrayList<Pdf>();
    }

    public String getNombrePdf() {
        return nombrePdf;
    }

    public String getUrlPdf() {
        return urlPdf;
    }

    public String getTamanoPdf() {
        return tamanoPdf;
    }
}
