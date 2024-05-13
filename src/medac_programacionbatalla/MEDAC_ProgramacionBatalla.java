
package medac_programacionbatalla;

import base_datos_oo.Condecorados;
import base_datos_oo.ConexionDb40;
import base_datos_oo.ConsultarDb4o;
import base_datos_oo.GestionarCsv;
import batallas.Batalla;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import static base_datos_oo.ConsultarDb4o.consultaHeroe;
import static base_datos_oo.ConsultarDb4o.verbbdd;


/**
 * @author danie
 */
public class MEDAC_ProgramacionBatalla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      //  ConsultarDb4o.consultarDb4o();

    //        GestionarCsv.leerCsv("./Heroes.csv");
    //       ConexionDb40.conexionDb40(GestionarCsv.getObjetos());
  // ConsultarDb4o.consultarDb4o();
        consultaHeroe();
      //  Batalla batalla = new Batalla();

        }
    }

 
