import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        List<Perro> perrosDisponibles = new ArrayList<>();

        int op;
        do {
            System.out.println("""
                    MENU DE ADOPCION
                    1. Registrar persona
                    2. Registrar perro
                    3. Ver personas registradas
                    4. Ver perros disponibles
                    5. Adoptar perro
                    6. Consultar perro mas viejo adoptado
                    7. Salir
                    """);
            op = teclado.nextInt();
            teclado.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.println("Registro persona");
                    System.out.print("Ingrese el nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Ingrese el apellido: ");
                    String apellido = teclado.nextLine();

                    System.out.print("Ingrese la edad: ");
                    int edad = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Ingrese el documento: ");
                    String documento = teclado.nextLine();

                    personas.add(new Persona(nombre, apellido, edad, documento));
                    System.out.println("Persona registrada con éxito.");
                }

                case 2 -> {
                    System.out.println("Registro perro");
                    System.out.print("Ingrese la placa: ");
                    String placa = teclado.nextLine();

                    System.out.print("Ingrese el nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Ingrese la raza: ");
                    String raza = teclado.nextLine();

                    System.out.print("Ingrese la edad: ");
                    int edad = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Ingrese el tamaño: ");
                    String tamanio = teclado.nextLine();

                    perrosDisponibles.add(new Perro(placa, nombre, raza, edad, tamanio));
                    System.out.println("Perro registrado con éxito.");
                }

                case 3 -> {
                    System.out.println("--- Personas Registradas ---");
                    if (personas.isEmpty()) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        for (Persona p : personas) {
                            System.out.println(p);
                        }
                    }
                }

                case 4 -> {
                    System.out.println("--- Perros Disponibles ---");
                    if (perrosDisponibles.isEmpty()) {
                        System.out.println("No hay perros disponibles.");
                    } else {
                        for (Perro p : perrosDisponibles) {
                            System.out.println(p);
                        }
                    }
                }

                case 5 -> {
                    System.out.print("Ingrese el documento de la persona: ");
                    String documento = teclado.nextLine();

                    Persona persona = null;
                    for (Persona p : personas) {
                        if (p.getDocumento().equals(documento)) {
                            persona = p;
                            break;
                        }
                    }

                    if (persona == null) {
                        System.out.println("Persona no encontrada.");
                        break;
                    }

                    if (persona.getPerrosAdoptados().size() >= 3) {
                        System.out.println("Esta persona ya ha adoptado el máximo de perros.");
                        break;
                    }

                    System.out.print("Ingrese la placa del perro a adoptar: ");
                    String placa = teclado.nextLine();

                    Perro perro = null;
                    for (Perro p : perrosDisponibles) {
                        if (p.getPlaca().equals(placa)) {
                            perro = p;
                            break;
                        }
                    }

                    if (perro == null) {
                        System.out.println("Perro no disponible o no existe.");
                        break;
                    }

                    persona.adoptarPerro(perro);
                    perrosDisponibles.remove(perro);
                    System.out.println("Adopción realizada con éxito.");
                }

                case 6 -> {
                    System.out.print("Ingrese el documento de la persona: ");
                    String documento = teclado.nextLine();

                    Persona persona = null;
                    for (Persona p : personas) {
                        if (p.getDocumento().equals(documento)) {
                            persona = p;
                            break;
                        }
                    }

                    if (persona == null) {
                        System.out.println("Persona no encontrada.");
                        break;
                    }

                    Perro masViejo = persona.perroMasGrande();
                    if (masViejo != null) {
                        System.out.println("El perro más viejo adoptado por " + persona.getNombre() + " es:");
                        System.out.println(masViejo);
                    } else {
                        System.out.println("Esta persona no ha adoptado perros.");
                    }
                }

                case 7 -> System.out.println("Saliendo del programa...");

                default -> System.out.println("Opción inválida.");
            }
        } while (op != 7);

        teclado.close();
    }
}
