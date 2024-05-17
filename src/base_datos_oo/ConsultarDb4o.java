package base_datos_oo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import componentes.animales.Heroes;
import componentes.personas.General;
import componentes.personas.TopScore;

import java.util.ArrayList;
import java.util.List;

public class ConsultarDb4o {

/*
    Metodo que guarda generales en un ArrayList, consulta en la base de datos segun la query que le paso
    y me establece un objeto condecorado de la query mientras va leyendo las columnas del archivo si encuentra
    las columnas que cumplen con lo pedido, me crea un nuevo general con su nombre y su apellido
 */

   public static void guardarganador(TopScore generalgandaor){
       ObjectContainer   db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "HeroesBD");
               db.store(generalgandaor);
   }

    public static List<General> consultarDb4o(){
        List<General> consultaCondecorados = new ArrayList<>();

        ObjectContainer db = null;

        try {

            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "HeroesBD");

            Query condeGen = db.query();
            condeGen.constrain(Condecorados.class);
            condeGen.descend("typOfAction").constrain("HEROIC");
            condeGen.descend("nameOfApprov").constrain("BRONZE STAR MEDAL").or(condeGen.descend("nameOfApprov").constrain("MEDAL OF HONOR"));
            ObjectSet<Condecorados> resultBronzeStar = condeGen.execute();

            while (resultBronzeStar.hasNext()) {

                Condecorados objeto = resultBronzeStar.next();
                General general = new General();
                general.setNombre(objeto.getFirstName() +" "+ objeto.getLastName());
               // System.out.println(general);

                consultaCondecorados.add(general);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null)
                db.close();
        }

        return consultaCondecorados;
    }

    public static void cerrarConexion() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "HeroesBD");

        db.close();
    }

    //Este método me hace una consulta a la base de datos, con el filtro de "salud" p
    public static void verGeneralganador(){
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "HeroesBD");
        try {
            Query consulta = db.query();
            consulta.constrain(TopScore.class);
            consulta.descend("salud").orderDescending();
            ObjectSet<TopScore> res = consulta.execute();
            if(res.isEmpty() ){
                System.out.println("No has jugado ninguna partida");
            }
            while (res.hasNext()) {
                System.out.println(res.next());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }}

    /*
    Metodo que guarda Heroes en un ArrayList, consulta en la base de datos segun la query que le paso
    y me establece un objeto condecorado de la query mientras va leyendo las columnas del archivo si encuentra
    las columnas que cumplen con lo pedido, me crea un nuevo Heroe con su nombre y su apellido
     */
    public static List<Heroes> consultaHeroe(){
        List<Heroes> consultaCondecorados = new ArrayList<>();
        ObjectContainer db = null;

        try {

            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "HeroesBD");

            Query condEnlisted = db.query();
            condEnlisted.constrain(Condecorados.class);
            condEnlisted.descend("offiOrEnli").constrain("ENLISTED");
            ObjectSet<Condecorados> resultBronzeStar = condEnlisted.execute();

            while (resultBronzeStar.hasNext()) {
                Condecorados objeto = resultBronzeStar.next();
                Heroes heroes = new Heroes();
                heroes.setNombre(objeto.getFirstName() +" "+ objeto.getLastName());


                consultaCondecorados.add(heroes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null)
                db.close();
        }

        return consultaCondecorados;
    }







}



