import java.util.Objects;

public class Ip {

    String primeraParteIP;
    String segundaParteIP;
    String tercceraParteIP;
    String cuartaParteIP;


    public Ip(String primeraParteIP, String segundaParteIP, String tercceraParteIP, String cuartaParteIP) {

        this.primeraParteIP = primeraParteIP;
        this.segundaParteIP = segundaParteIP;
        this.tercceraParteIP = tercceraParteIP;
        this.cuartaParteIP = cuartaParteIP;

    }

    public String getPrimeraParteIP() {
        return primeraParteIP;
    }

    public String getSegundaParteIP() {
        return segundaParteIP;
    }

    public String getTercceraParteIP() {
        return tercceraParteIP;
    }

    public String getCuartaParteIP() {
        return cuartaParteIP;
    }

    public void setPrimeraParteIP(String primeraParteIP) {
        this.primeraParteIP = primeraParteIP;
    }

    public void setSegundaParteIP(String segundaParteIP) {
        this.segundaParteIP = segundaParteIP;
    }

    public void setTercceraParteIP(String tercceraParteIP) {
        this.tercceraParteIP = tercceraParteIP;
    }

    public void setCuartaParteIP(String cuartaParteIP) {
        this.cuartaParteIP = cuartaParteIP;
    }

    @Override
    public String toString() {
        return "ip{" + "primeraParteIP='" + primeraParteIP + '\'' + ", segundaParteIP='" + segundaParteIP + '\'' + ", tercceraParteIP='" + tercceraParteIP + '\'' + ", cuartaParteIP='" + cuartaParteIP + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ip ip = (Ip) o;
        return Objects.equals(primeraParteIP, ip.primeraParteIP) && Objects.equals(segundaParteIP, ip.segundaParteIP) && Objects.equals(tercceraParteIP, ip.tercceraParteIP) && Objects.equals(cuartaParteIP, ip.cuartaParteIP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primeraParteIP, segundaParteIP, tercceraParteIP, cuartaParteIP);
    }
}
