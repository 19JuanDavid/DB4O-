/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package medac_programacionbatalla;

import base_datos_oo.ConexionDb40;
import base_datos_oo.GestionarCsv;
import base_datos_oo.ObjetosDb4o;
import batallas.Batalla;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;

import java.util.HashSet;
import java.util.List;



/**
 * @author danie
 */
public class MEDAC_ProgramacionBatalla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ObjectContainer db = null;
        try {
            // Abre la base de datos
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "HeroesBD");

            // Consulta para "HEROIC" con "BRONZE STAR MEDAL" o "MEDAL OF HONOR"
            Query condeGen = db.query();
            condeGen.constrain(ObjetosDb4o.class);
            condeGen.descend("typOfAction").constrain("HEROIC");
            condeGen.descend("nameOfApprov").constrain("BRONZE STAR MEDAL").or(condeGen.descend("nameOfApprov").constrain("MEDAL OF HONOR"));
            ObjectSet<ObjetosDb4o> resultBronzeStar = condeGen.execute();

            // Imprime los resultados
            while (resultBronzeStar.hasNext()) {
                ObjetosDb4o objeto = resultBronzeStar.next();
                // Procesar el objeto
                System.out.println(objeto);
            }
        } catch (Exception e) {
            // Manejar excepciones
            e.printStackTrace();
        } finally {
            // Cierra la base de datos
            if (db != null)
                db.close();
        }


            //Batalla batalla = new Batalla();

        }
    }

 
