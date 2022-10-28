public class Automovil {
    private String marca;
    private String modelo;
    private String añoDeFabricacion;
    private String precio;

    private Motor motor;

    private Chasis chasis;

    //Constructor
    public Automovil(String marca, String modelo, String añoDeFabricacion, String precio, Motor motor, Chasis chasis) {
        setMarca(marca);
        setModelo(modelo);
        setAñoDeFabricacion(añoDeFabricacion);
        setPrecio(precio);
        setMotor(motor);
        setChasis(chasis);
    }

    //Getters
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public String getAñoDeFabricacion() {
        return añoDeFabricacion;
    }
    public String getPrecio() {
        return precio;
    }

    //Setters
    private void setMarca(String marca) {
        this.marca = marca;
    }
    private void setModelo(String modelo) {
        this.modelo = modelo;
    }
    private void setAñoDeFabricacion(String añoDeFabricacion) {
        validacion(añoDeFabricacion);
        this.añoDeFabricacion = añoDeFabricacion;
    }
    private void setPrecio(String precio) {
        validacion(quitarPuntosYOComas(precio));
        this.precio = precio;
    }

    private void setMotor(Motor motor) {
        this.motor = motor;
    }

    private void setChasis(Chasis chasis) {
        this.chasis = chasis;
    }

    //Validar numeros
    private void validacion(String numero){
        try {
            Integer.parseInt(numero);
        }catch (Exception e){
            System.out.println("Ingrese una fecha valida");
        }

    }

    //Quitar al precio puntos y/o comas
    private String quitarPuntosYOComas(String precio){
        String precioSinPuntos;
        precioSinPuntos = precio.replace(".", "");
        String precioSinPuntosNiComas = precioSinPuntos.replace(",", "");
        String precioLimpio = precioSinPuntosNiComas.replace(" ", "");
        return precioLimpio;
    }

    public String toString() {
        return "Automovil{" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo+ "\n" +
                "Año De Fabricacion: " + añoDeFabricacion + "\n" +
                "Precio: " + precio +  "\n" +
                "Motor: " + motor + "\n" +
                "Chasis: " + chasis + "\n" + "}";
    }
}
