package base_datos_oo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionarCsv {

    public List<ObjetosDb4o> leerCsv() {

        List<ObjetosDb4o> objetos = new ArrayList<>();
        String csvFile = "Heroes.csv";
        String linea;
        String csvSplitBy = ";";


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            linea = br.readLine();
            String[] encabezado = linea.split(csvSplitBy);
            int indiceLastName = 0;
            int indiceFirstName = 1;
            int indiceOfficerOrEnlisted = 5;
            int indiceTypeOfAction = 13;
            int indiceNameOfApproved = 23;

            while ((linea = br.readLine()) != null) {
                String[] columna = linea.split(csvSplitBy);

                ObjetosDb4o objeto = new ObjetosDb4o(
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
    }
