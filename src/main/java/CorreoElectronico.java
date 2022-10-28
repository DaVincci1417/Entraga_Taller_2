public class CorreoElectronico {
    private String direccionCorreo;
    private String proveedorCorreo;

    //Constructor
    public CorreoElectronico(String direccionCorreo, String proveedorCorreo){
        setDireccionCorreo(direccionCorreo);
        setProveedorCorreo(proveedorCorreo);
    }

    //Setters
    private void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }
    private void setProveedorCorreo(String proveedorCorreo) {
        this.proveedorCorreo = proveedorCorreo;
    }

    //Getters
    public String getDireccionCorreo() {
        return direccionCorreo;
    }
    public String getProveedorCorreo() {
        return proveedorCorreo;
    }

    public String toString() {
        return "CorreoElectronico{" +
                "Direccion de correo electronico: " + direccionCorreo + "\n" +
                "Proveedor de correo electronico: " + proveedorCorreo + "}";
    }
}
