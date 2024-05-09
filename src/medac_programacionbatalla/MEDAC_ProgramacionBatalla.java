/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package medac_programacionbatalla;

import base_datos_oo.ConexionDb40;
import base_datos_oo.GestionarCsv;
import base_datos_oo.ObjetosDb4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.List;



/**
 * @author danie
 */
public class MEDAC_ProgramacionBatalla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "HeroesBd");

        // Llamar al método para verificar si la base de datos está vacía
        boolean vacia = bases(bd);

            if (vacia){
                System.out.println("La base de datos está vacía");
            } else {
                System.out.println("La base de datos contiene objetos");
        }

            bd.close();
    }

    public static boolean bases(ObjectContainer bd) {
            return bd.queryByExample(ObjetosDb4o.class).isEmpty();
        }

//        String csvFile = "Heroes.csv";
//        GestionarCsv csvReader = new GestionarCsv();
//        List<ObjetosDb4o> objetos = csvReader.leerCsv(csvFile);
//        ConexionDb40.conexionDb40(objetos);

        // String test = ExploradorFicheros.leerFichero();
        // Batalla batalla = new Batalla();

    }


 
