package componentes.animales;

import java.util.List;

public class Heroes extends Animal{

    public static final int PESO_TIGRE = 5;

    public Heroes() {
        super();
        setMultiplicador(1.5f);
        setPeso(PESO_TIGRE);

        List<Integer> atributos = generarAtributos(150);
        setAtaque((int) Math.ceil(atributos.get(0) * getMultiplicador()));
        setDefensa((int) Math.ceil(atributos.get(1) * getMultiplicador()));
        setSalud((int) Math.ceil(atributos.get(2) * getMultiplicador()));
    }

    @Override
    public String toString() {
        return "Heroes {" +
                "Nombre='" + this.getNombre() + '\'' +
                ", Ataque='" + this.getAtaque() + '\'' +
                ", Defensa='" + this.getDefensa() + '\'' +
                ", Salud='" + this.getSalud() + '\'' +
                ", Peso='" + this.getPeso() + '\'' +
                '}';
    }
}



