package base_datos_oo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.List;


public class ConexionDb40 {

    public static void conexionDb40(List<ObjetosDb4o> objetos){

        ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "HeroesBd");
            ObjetosDb4o condecorados = new ObjetosDb4o(null,null,null, null,null);
        ObjectSet conde = bd.queryByExample(condecorados);

        while (conde.hasNext()){
            System.out.println(conde.next());
        }

        try {

            for (ObjetosDb4o objeto : objetos) {
                bd.store(objeto);
            }
        } finally {

            bd.close();
        }

        }
    }


