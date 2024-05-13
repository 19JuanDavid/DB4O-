package base_datos_oo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.List;

/**
 * Clase conectada a la BDOO
 */

public class ConexionDb40 {

    public static void conexionDb40(List<Condecorados> objetos) {

        //Creamos una base de datos con las columnas que hemos sacado de un fichero CSV
        ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "HeroesBD");
        Condecorados condecorados = new Condecorados(null, null, null, null, null);
        ObjectSet<Condecorados> conde = bd.queryByExample(condecorados);

        while (conde.hasNext()) {
            System.out.println(conde.next());
        }

        //Bucle que guarda un objeto en la base de datos luego de haberlos creado
        for (Condecorados objeto : objetos) {
            bd.store(objeto);
        }
            bd.close();



      bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "HeroesBD");

        // Llamar al método para verificar si la base de datos está vacía
        boolean vacia = bases(bd);

        if (vacia) {
            System.out.println("La base de datos está vacía");
        } else {
            System.out.println("La base de datos contiene objetos");
            }
                bd.close();
        }

    public static boolean bases(ObjectContainer bd) {
        return bd.queryByExample(Condecorados.class).isEmpty();
    }

}



