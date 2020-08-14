import java.util.ArrayList;

public class BaseDatosURLs {

    ArrayList baseDatosURLs;
    ArrayList baseDatos = new ArrayList<String>();;

    public BaseDatosURLs() {

        this.baseDatosURLs = new ArrayList<url>();

    }

    public void generaURLs (){

        char[] letras1 = new char[27];
        int j = 0;
        for (int i = 97; i<=122 ; i++){
            letras1[j]= (char)i;
            j++;
        }

        String[]letras = new String [27];

        for (int i = 0; i<= letras1.length-1 ; i++){
            letras[i]= String.valueOf(letras1[i]);
        }

        int n = 0;
        int k = 0;
        int l = 0;
        int m = 0;
        int z = 0;
        String palabra;

        while(n<letras.length) {
            while (k < letras.length - 1) {
                while (l < letras.length ) {
                    while (m < letras.length ) {
                        while (z < letras.length ) {


                            if (n != 0 )  {                                                    //Palabras tamaño 5 letras
                                palabra = letras[n]+letras[k]+letras[l]+letras[m]+letras[z];

                            }else if  (k != 0) {                                           //Palabras tamaño 4 letras
                                palabra = letras[k]+letras[l]+letras[m]+letras[z];

                            } else if (l != 0) {                                            //Palabras tamaño 3 letras
                                palabra = letras[l] + letras[m] + letras[z];

                            } else if (m != 0) {                                            //Palabras tamaño 2 letras
                                palabra = letras[m]+letras[z] ;

                            } else{                                                         //palabras tamaño 1 letra
                                palabra = letras[z];
                            }



                            baseDatos.add(palabra);








                            z++;
                        }
                        z = 0;
                        m++;

                    }
                    m = 0;
                    l++;
                }
                l = 0;
                k++;
            }
            k = 0;
        }

        for (int i = 0 ; i< baseDatos.size(); i++){
            if (baseDatosURLs.get(i) != ""){
                baseDatosURLs.add(baseDatos.get(i));
            }
        }



    }


}

