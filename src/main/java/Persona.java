import java.util.ArrayList;

public class Persona {
    private String nombreCompleto;
    private String rut;
    private ArrayList<Automovil> automoviles = new ArrayList<>();
    private ArrayList<CorreoElectronico> correosElectronicos = new ArrayList<>();

    //Constructor
    public Persona(String nombreCompleto, String rut) {
        setNombreCompleto(nombreCompleto);
        setRut(rut);
    }

    //Agregar Correo y Automovil a la persona
    public void agregarAutomovil(String marca, String modelo, String añoDeFabricacion, String precio, String numeroDeMotor, String centimetrosCubicos, String numeroDeChasis, String tipoDeMaterial){
        Chasis chasis = new Chasis(numeroDeChasis, tipoDeMaterial);
        Motor motor = new Motor(numeroDeMotor, centimetrosCubicos);
        Automovil auto = new Automovil(marca, modelo, añoDeFabricacion, precio, motor, chasis);
        automoviles.add(auto);
    }
    public void agragarCorreoElectronico(String direccionCorreo, String proveedorCorreo){
        CorreoElectronico correo = new CorreoElectronico(direccionCorreo, proveedorCorreo);
        correosElectronicos.add(correo);
    }

    //Setters
    private void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    private void setRut(String rut){
        try {
            validarRut(rut);
            this.rut = quitarPuntosYGuion(rut);
        }catch (Exception e){
            System.out.println("Ha ocurrido un error, ingrese el RUT de nuevo.");
        }

    }

    //Getters
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public String getRut() {
        return rut;
    }

    public ArrayList<Automovil> getAutomoviles() {
        return automoviles;
    }

    public ArrayList<CorreoElectronico> getCorreosElectronicos() {
        return correosElectronicos;
    }

    //Validacion de RUT
    private void validarRut(String rut) throws Exception{
        String rutSinPuntosNiGuion = quitarPuntosYGuion(rut);
        String mensajeError = "Ingrese un RUT valido.";

        if (rutSinPuntosNiGuion.length() > 9){
            throw new Exception(mensajeError);
        }

        if(!rutSinPuntosNiGuion.substring(8,9).equalsIgnoreCase("k")){
            try {
                Integer.parseInt(rut.substring(8,9));
            }catch (Exception e){
                throw new Exception(mensajeError);
            }
        }

        try {
            Integer.parseInt(rutSinPuntosNiGuion.substring(0,8));
        }catch (Exception e){
            throw new Exception(mensajeError);
        }
    }
    private String quitarPuntosYGuion(String rut){
        String rutSinPuntos;
        rutSinPuntos = rut.replace(".", "");
        String rutSinPuntosNiGuion = rutSinPuntos.replace("-", "");
        String rutLimpio = rutSinPuntosNiGuion.replace(" ", "");
        return rutLimpio;
    }

    //toString
    @Override
    public String toString() {
        if(automoviles == null & correosElectronicos == null){
            return "Personas{" +
                    "Nombre: " + nombreCompleto + "\n" +
                    "RUT: " + rut + "}";
        }
        if(automoviles == null & correosElectronicos != null){
            return "Personas{" +
                    "Nombre: " + nombreCompleto + "\n" +
                    "RUT: " + rut + "\n" +
                    "Correo(s) Electronico: " + correosElectronicos + "\n" + "}";
        }
        if(correosElectronicos == null & automoviles != null){
            return "Personas{" +
                    "Nombre: " + nombreCompleto + "\n" +
                    "RUT: " + rut + "\n" +
                    "Automovil(es): " + automoviles + "\n" + "}";
        }
        if(automoviles != null & correosElectronicos != null){
            return "Personas{" +
                    "Nombre: " + nombreCompleto + "\n" +
                    "RUT: " + rut + "\n" +
                    "Correo(s) Electronico: " + correosElectronicos  + "\n" +
                    "Automovil(es): " + automoviles+ "}";
        }
        return null;
    }
}
