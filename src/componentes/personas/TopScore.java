package componentes.personas;

public class TopScore extends Persona{
    public TopScore() {super();}

    @Override
    public String toString() {
        return "El gran vencedor " + this.getNombre() + " con un ataque de " + this.getAtaque()  +
                ", con una defensa de " + this.getDefensa()  +
                ", y por ultimo una salud de " + this.getSalud() ;
    }
}
