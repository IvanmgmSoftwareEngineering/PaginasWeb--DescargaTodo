import java.util.ArrayList;

public class BaseDatosIP {

    ArrayList<Ip> ips;

    public BaseDatosIP() {
        this.ips = new ArrayList<Ip>();
    }

    public ArrayList<Ip> getIps() {
        return ips;
    }

    public void generador (){
        int j = 0;
        int k = 0;
        int l = 0;
        int m = 0;

        String primero;
        String segundo;
        String tercero;
        String cuarto;

        while(j<=255) {
                while (k <= 255) {
                    while (l <= 255) {
                        while (m <= 255) {

                            if(j<10){
                                 primero = "00"+Integer.toString(j);
                            }else if ( 9<j && j<100){
                                 primero = "0"+Integer.toString(j);
                            }else{
                                 primero = Integer.toString(j);
                            }
                            if(k<10){
                                segundo = "00"+Integer.toString(k);
                            }else if ( 9<k && k<100){
                                segundo = "0"+Integer.toString(k);
                            }else{
                                segundo = Integer.toString(k);
                            }
                            if(l<10){
                                tercero = "00"+Integer.toString(l);
                            }else if ( 9<l && l<100){
                                tercero = "0"+Integer.toString(l);
                            }else{
                                tercero = Integer.toString(l);
                            }
                            if(m<10){
                                cuarto = "00"+Integer.toString(m);
                            }else if ( 9<m && m<100){
                                cuarto = "0"+Integer.toString(m);
                            }else{
                                cuarto = Integer.toString(m);
                            }
                            ips.add(new Ip(primero, segundo, tercero, cuarto));
                            System.out.println(primero + "."+ segundo+"."+ tercero+"."+cuarto);
                            m++;
                        }
                        m = 0;
                        l++;
                    }
                    l = 0;
                    k++;
                }
                k=0;
                j++;
            }

    }
}
