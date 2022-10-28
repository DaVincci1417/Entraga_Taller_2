import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class GestorPersonal {
    public static void main(String[] args) {
        principal();
    }

    public static void principal() {
        ArrayList<Persona> registro = new ArrayList<>();
        Scanner leer = new Scanner(System.in);
        int opc = -1;
        do {
            menuPrincipal();
            opc = leer.nextInt();
            segunPrincipal(opc, registro);
        } while (opc != 0);
        System.out.println("Ha salido.");
    }

    public static void menuPrincipal() {
        System.out.println(
                "Bienvenido. Ingrese opción según corresponda:\n" +
                        "0. Salir\n" +
                        "1. Agregar persona.\n" +
                        "2. Agregar automovil a una persona.\n" +
                        "3. Agregar correo electronico a una persona.\n" +
                        "4. Buscar persona (por el rut).\n" +
                        "5. Buscar personas que tengan un mismo nombre en concreto.\n" +
                        "6. Buscar personas que tengan una marca de automovil en concreto.\n"
        );
    }

    public static void segunPrincipal(int opc, ArrayList<Persona> registro) {
        switch (opc) {
            case 0:
                break;
            case 1:
                try {
                    agregarPersona(registro);
                } catch (Exception e) {
                    System.out.println("Has ingresadoa algo mal, vuelve a intentarlo");
                }
                break;
            case 2:
                agregarAutomovilAPersona(registro);
                break;
            case 3:
                agregarCorreoElectronicoAPersona(registro);
                break;
            case 4:
                imprimirPersonaBuscadaPorRut(registro);
                break;
            case 5:
                imprimirPersonasConUnNombreEnComun(registro);
                break;
            case 6:

                break;
            default:
                System.out.println("Agregue una opción valida");
        }
    }

    //Agregar Persona
    public static void agregarPersona(ArrayList<Persona> registro) {
        Scanner leer = new Scanner(System.in);

        String nombreCompleto;
        String rut;

        do{
            System.out.println("Ingre el nombre (completo) de la persona");
            nombreCompleto = leer.nextLine();
            System.out.println("Ingre el RUT");
            rut = leer.nextLine();

            rut = validarRut(registro ,rut);
        }while(rut != null);

        Persona persona = new Persona(nombreCompleto, rut);
        registro.add(persona);

        System.out.println("Ha agregado con exito a una persona: ");
        System.out.println(persona.toString());
    }

    //Agregar Auto a persona
    public static void agregarAutomovilAPersona(ArrayList<Persona> registro) {
        Scanner leer = new Scanner(System.in);

        String marca;
        String modelo;
        String añoDeFabricacion;
        String precio; //Especificaciones del Automovil
        String numeroDeMotor;
        String centimetrosCubicos; //Especificaciones del Motor
        String numeroDeChasis;
        String tipoDeMaterial; //Especificaciones del Chasis
        String rut;

        System.out.println("Ingrese el RUT de la persona a la cual desea agregarle un auto");
        rut = leer.nextLine();

        if (encontrarPersonaPorRut(rut, registro) != null) {

            System.out.println("Ingrese la marca del automovil.");
            marca = leer.nextLine();
            System.out.println("Ingrese el modelo del automovil.");
            modelo = leer.nextLine();
            System.out.println("Ingrese el año de fabricacion del automovil.");
            añoDeFabricacion = leer.nextLine();
            System.out.println("Ingrese el precio del automovil.");
            precio = leer.nextLine();
            System.out.println("Ingrese el numero del motor");
            numeroDeMotor = leer.nextLine();
            System.out.println("Ingrese los centimetros cubicos del motor");
            centimetrosCubicos = leer.nextLine();
            System.out.println("Ingrese el numero del chasis");
            numeroDeChasis = leer.nextLine();
            System.out.println("Ingrese el tipo de material del chasis");
            tipoDeMaterial = leer.nextLine();

            encontrarPersonaPorRut(rut, registro).agregarAutomovil(marca, modelo, añoDeFabricacion, precio, numeroDeMotor, centimetrosCubicos, numeroDeChasis, tipoDeMaterial);
            System.out.println("Ha agregado con exito el siguiente auto a la persona: " + encontrarPersonaPorRut(rut, registro));
            System.out.println(encontrarPersonaPorRut(rut, registro).getAutomoviles().toString());
        } else {
            System.out.println("No se ha encontrado al paciente.");
        }
    }

    //Agregar Correo Electronico a persona
    public static void agregarCorreoElectronicoAPersona(ArrayList<Persona> registro) {
        Scanner leer = new Scanner(System.in);

        String direccionCorreo;
        String proveedorCorreo; //Especificaciones Correo
        String rut;

        System.out.println("Ingrese el RUT de la persona a la cual desea agregarle un auto");
        rut = leer.nextLine();

        if (encontrarPersonaPorRut(rut, registro) != null) {

            System.out.println("Ingrese la direccion de correo electronico.");
            direccionCorreo = leer.nextLine();
            System.out.println("Ingrese el proveedor de correo electronico.");
            proveedorCorreo = leer.nextLine();

            encontrarPersonaPorRut(rut, registro).agragarCorreoElectronico(direccionCorreo, proveedorCorreo);
            System.out.println("Ha agregado con exito el siguiente correo a la persona: " + encontrarPersonaPorRut(rut, registro));
            System.out.println(encontrarPersonaPorRut(rut, registro).getCorreosElectronicos().toString());
        } else {
            System.out.println("No se ha encontrado a la persona.");
        }
    }

    //Encontrar a Persona por el RUT
    public static void imprimirPersonaBuscadaPorRut(ArrayList<Persona> registro) {
        Scanner leer = new Scanner(System.in);
        String rut;
        System.out.println("Ingrese el RUT de la persona a la cual desesa buscar.");
        rut = leer.nextLine();
        if (encontrarPersonaPorRut(rut, registro) != null) {
            System.out.println(
                    "Se ha encontrado a la persona: " +
                            encontrarPersonaPorRut(rut, registro)
            );
        } else {
            System.out.println("No se ha encontrado a la persona.");
        }
    }

    public static Persona encontrarPersonaPorRut(String rut, ArrayList<Persona> registro) {
        int posicion = -1;
        for (int i = 0; i < registro.size(); i++) {
            if (registro.get(i).getRut() == rut) {
                posicion = i;
            }
        }
        if (posicion != -1) {
            return registro.get(posicion);
        } else {
            return null;
        }
    }

    //Encontrar Personas con el nombre en comun
    public static void imprimirPersonasConUnNombreEnComun(ArrayList<Persona> registro) {
        Scanner leer = new Scanner(System.in);
        String nombre;

        System.out.println("Ingrese un nombre");
        nombre = leer.nextLine();

        if (encontrarPersonasConUnNombreEnComun(nombre, registro) != null) {
            System.out.println(
                    "Se ha encontrado a la(s) persona(s): " +
                            encontrarPersonasConUnNombreEnComun(nombre, registro)
            );
        } else {
            System.out.println("No se ha encontrado a la(s) persona(s).");
        }

    }

    public static ArrayList<Persona> encontrarPersonasConUnNombreEnComun(String nombre, ArrayList<Persona> registro) {
        ArrayList<Persona> personasConNombreEnComun = new ArrayList<>();
        if (registro == null) {
            return null;
        } else {
            int posicion = -1;
            for (int i = 0; i < registro.size(); i++) {
                if (registro.get(i).getNombreCompleto().equalsIgnoreCase(nombre)) {
                    personasConNombreEnComun.add(registro.get(posicion));
                }
            }
            if (posicion != -1) {
                return personasConNombreEnComun;
            } else {
                return null;
            }
        }
    }

    //Encontrar Personas que posean un automovil de marca en comun
    public static void imprimirPersonasConUnAutoDeMarcaEnComun(ArrayList<Persona> registro) {
        Scanner leer = new Scanner(System.in);
        String marca;

        System.out.println("Ingrese una marca de auto");
        marca = leer.nextLine();

        if (encontrarPersonasConUnAutoDeMarcaEnComun(marca, registro) != null) {
            System.out.println(
                    "Se ha encontrado a la(s) persona(s): " +
                            encontrarPersonasConUnAutoDeMarcaEnComun(marca, registro)
            );
        } else {
            System.out.println("No se ha encontrado a la(s) persona(s).");
        }

    }

    public static ArrayList<Persona> encontrarPersonasConUnAutoDeMarcaEnComun(String marca, ArrayList<Persona> registro) {
        ArrayList<Persona> personaConAutoDeMarcaEnComun = new ArrayList<>();
        if (registro == null) {
            return null;
        } else {
            int posicion = -1;
            for (int i = 0; i < registro.size(); i++) {
                for (int j = 0; j < registro.get(i).getAutomoviles().size(); j++) {
                    if (registro.get(i).getAutomoviles().get(j).equals(marca)) {
                        personaConAutoDeMarcaEnComun.add(registro.get(posicion));
                    }
                }
            }
            if (posicion != -1) {
                return personaConAutoDeMarcaEnComun;
            } else {
                return null;
            }
        }
    }

    public static String validarRut(ArrayList<Persona> registro, String rut) {
        if (encontrarPersonaPorRut(rut, registro) == null) {
            return rut;
        }
        return null;
    }
}
