public class Motor {
    private String numeroDeMotor;
    private String centimetrosCubicos;

    //Constructor
    public Motor(String numeroDeMotor, String centimetrosCubicos) {
        setNumeroDeMotor(numeroDeMotor);
        setCentimetrosCubicos(centimetrosCubicos);
    }

    //Setters
    private void setNumeroDeMotor(String numeroDeMotor) {
        this.numeroDeMotor = numeroDeMotor;
    }
    private void setCentimetrosCubicos(String centimetrosCubicos) {
        this.centimetrosCubicos = centimetrosCubicos;
    }

    //Getters
    public String getNumeroDeMotor() {
        return numeroDeMotor;
    }
    public String getCentimetrosCubicos() {
        return centimetrosCubicos;
    }

    public String toString() {
        return "Motor{" +
                "Numero de Motor: " + numeroDeMotor + "\n" +
                "Centimetros Cubicos: " + centimetrosCubicos + "}";
    }
}
