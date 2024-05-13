package base_datos_oo;

public class Condecorados {

    private String lastName;
    private String firstName;
    private String offiOrEnli;
    private String typOfAction;
    private String nameOfApprov;

    public Condecorados(String lastName, String firstName, String offiOrEnli, String typOfAction, String nameOfApprov) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.offiOrEnli = offiOrEnli;
        this.typOfAction = typOfAction;
        this.nameOfApprov = nameOfApprov;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOffiOrEnli() {
        return offiOrEnli;
    }

    public void setOffiOrEnli(String offiOrEnli) {
        this.offiOrEnli = offiOrEnli;
    }

    public String getTypOfAction() {
        return typOfAction;
    }

    public void setTypOfAction(String typOfAction) {
        this.typOfAction = typOfAction;
    }

    public String getNameOfApprov() {
        return nameOfApprov;
    }

    public void setNameOfApprov(String nameOfApprov) {
        this.nameOfApprov = nameOfApprov;
    }

    @Override
    public String toString() {
        return "Condecorados{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", offiOrEnli='" + offiOrEnli + '\'' +
                ", typOfAction='" + typOfAction + '\'' +
                ", nameOfApprov='" + nameOfApprov + '\'' +
                '}';
    }
}
