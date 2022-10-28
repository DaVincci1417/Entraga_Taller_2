public class Chasis {
    private String numeroDeChasis;
    private String tipoDeMaterial;

    //Constructor
    public Chasis(String numeroDeChasis, String tipoDeMaterial){
        setNumeroDeChasis(numeroDeChasis);
        setTipoDeMaterial(tipoDeMaterial);
    }

    //Setters
    private void setNumeroDeChasis(String numeroDeChasis) {
        this.numeroDeChasis = numeroDeChasis;
    }
    private void setTipoDeMaterial(String tipoDeMaterial) {
        this.tipoDeMaterial = tipoDeMaterial;
    }

    //Getters
    public String getNumeroDeChasis() {
        return numeroDeChasis;
    }
    public String getTipoDeMaterial() {
        return tipoDeMaterial;
    }

    public String toString() {
        return "Chasis{" +
                    "Numero de Chasis: " + numeroDeChasis + "\n" +
                    "Tipo de Material: " + tipoDeMaterial + "}";
    }
}
