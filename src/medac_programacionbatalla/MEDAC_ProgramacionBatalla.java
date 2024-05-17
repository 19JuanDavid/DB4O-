
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

import static base_datos_oo.ConexionDb40.conexionDb40;
import static base_datos_oo.ConsultarDb4o.*;
import static base_datos_oo.GestionarCsv.leerCsv;


/**
 * @author danie
 */
public class MEDAC_ProgramacionBatalla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    // Profesor cuando borres la bbdd y quieras volver a llenar la bbdd ejecuta este metodo
    //  conexionDb40(leerCsv("Heroes.csv"));

     Batalla batalla = new Batalla();
      //  vergeneralganador();

        }
    }

 
