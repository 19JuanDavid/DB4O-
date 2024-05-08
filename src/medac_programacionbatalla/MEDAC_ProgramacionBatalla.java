/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package medac_programacionbatalla;

import base_datos_oo.ConexionDb40;
import base_datos_oo.GestionarCsv;
import base_datos_oo.ObjetosDb4o;
import java.util.List;



/**
 * @author danie
 */
public class MEDAC_ProgramacionBatalla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String csvFile = "Heroes.csv";
        GestionarCsv csvReader = new GestionarCsv();
        List<ObjetosDb4o> objetos = csvReader.leerCsv(csvFile);
        ConexionDb40.conexionDb40(objetos);

       // String test = ExploradorFicheros.leerFichero();
        // Batalla batalla = new Batalla();

    }
}

    

 
