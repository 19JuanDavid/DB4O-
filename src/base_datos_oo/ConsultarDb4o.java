package base_datos_oo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import componentes.animales.Heroes;
import componentes.personas.General;

import java.util.ArrayList;
import java.util.List;

public class ConsultarDb4o {

    public static List<General> consultarDb4o(){
        List<General> consultaCondecorados = new ArrayList<>();
        ObjectContainer db = null;

        try {

            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "HeroesBD");

            // Consulta para sacar los "HEROIC" con "BRONZE STAR MEDAL" o "MEDAL OF HONOR"
            Query condeGen = db.query();
            condeGen.constrain(Condecorados.class);
            condeGen.descend("typOfAction").constrain("HEROIC");
            condeGen.descend("nameOfApprov").constrain("BRONZE STAR MEDAL").or(condeGen.descend("nameOfApprov").constrain("MEDAL OF HONOR"));
            ObjectSet<Condecorados> resultBronzeStar = condeGen.execute();

            while (resultBronzeStar.hasNext()) {
                Condecorados objeto = resultBronzeStar.next();
                General general = new General();
                general.setNombre(objeto.getFirstName() +" "+ objeto.getLastName());
                System.out.println(general);

                consultaCondecorados.add(general);
            }
        } catch (Exception e) {
            // Manejar excepciones
            e.printStackTrace();
        } finally {
            // Cierra la base de datos
            if (db != null)
                db.close();
        }

        return consultaCondecorados;
    }
    public static void verbbdd(){
        ObjectContainer db = null;

        try {

            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "HeroesBD");
            Query condEnlisted = db.query();
            condEnlisted.constrain(Condecorados.class);
            condEnlisted.descend("lastName");
            ObjectSet<Condecorados> resultBronzeStar = condEnlisted.execute();
            while (resultBronzeStar.hasNext()) {
                Condecorados objeto = resultBronzeStar.next();
                System.out.println(objeto);
            }
    }catch (Exception e){e.getMessage();}
    }

    public static List<Heroes> consultaHeroe(){
        List<Heroes> consultaCondecorados = new ArrayList<>();
        ObjectContainer db = null;

        try {

            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "HeroesBD");

            // Consulta para sacar los "HEROIC" con "BRONZE STAR MEDAL" o "MEDAL OF HONOR"
            Query condEnlisted = db.query();
            condEnlisted.constrain(Condecorados.class);
            condEnlisted.descend("offiOrEnli").constrain("ENLISTED");
            ObjectSet<Condecorados> resultBronzeStar = condEnlisted.execute();

            while (resultBronzeStar.hasNext()) {
                Condecorados objeto = resultBronzeStar.next();
                Heroes heroes = new Heroes();
                heroes.setNombre(objeto.getFirstName() +" "+ objeto.getLastName());
                System.out.println(objeto);

                consultaCondecorados.add(heroes);
            }
        } catch (Exception e) {
            // Manejar excepciones
            e.printStackTrace();
        } finally {
            // Cierra la base de datos
            if (db != null)
                db.close();
        }

        return consultaCondecorados;
    }







}



