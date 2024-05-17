package base_datos_oo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para gestionar el Csv
 */

public class GestionarCsv {

    //Un ArrayList que se guardan los objetos condecorados
    private static final List<Condecorados> objetos = new ArrayList<>();

    public static List<Condecorados> leerCsv(String file) {


        String linea;
        String csvSplitBy = ";";

        //Leemos el fichero que registra cada columna con un indice
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            linea = br.readLine();
            String[] encabezado = linea.split(csvSplitBy);
            int indiceLastName = 0;
            int indiceFirstName = 1;
            int indiceOfficerOrEnlisted = 5;
            int indiceTypeOfAction = 13;
            int indiceNameOfApproved = 23;


            // Mientras lee cada columna si es diferente de null devuelve un true y me separa las columnas por un ;
            // luego de eso crea un objeto(condecorados) en cada columna
            while ((linea = br.readLine()) != null) {
                String[] columna = linea.split(csvSplitBy);

                Condecorados objeto = new Condecorados(
                        columna[indiceLastName].trim(),
                        columna[indiceFirstName].trim(),
                        columna[indiceOfficerOrEnlisted].trim(),
                        columna[indiceTypeOfAction].trim(),
                        columna[indiceNameOfApproved].trim()
                );

                objetos.add(objeto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objetos;

    }

    public static List<Condecorados> getObjetos() {
        return objetos;
    }
}
