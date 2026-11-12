package Parte1_vectoresParalelos.Refugio_de_Mascotas;
import java.util.Scanner;

public class mascotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int TAM = 1; // cambiar a 15 para la entrega

        String[] codigos = new String[TAM];
        String[] nombres = new String[TAM];
        int[] especies = new int[TAM];
        int[] edades = new int[TAM];
        boolean[] vacunado = new boolean[TAM];
        boolean[] disponible = new boolean[TAM];

        // ===== Numeral 1: registro inicial =====
        for (int i = 0; i < TAM; i++) {
            System.out.print("Digite el codigo de la mascota #" + (i + 1) + ": ");
            codigos[i] = sc.nextLine();

            System.out.print("Digite el nombre de la mascota #" + (i + 1) + ": ");
            nombres[i] = sc.nextLine();

            System.out.print("Digite la especie (1:Perro 2:Gato): ");
            especies[i] = sc.nextInt();
            while (especies[i] != 1 && especies[i] != 2) {
                System.out.print("Especie inválida. Digite 1 o 2: ");
                especies[i] = sc.nextInt();
            }

            System.out.print("Digite la edad en meses: ");
            edades[i] = sc.nextInt();
            while (edades[i] <= 0) {
                System.out.print("La edad debe ser mayor que 0. Digite la edad: ");
                edades[i] = sc.nextInt();
            }

            System.out.print("¿Está vacunada? (true/false): ");
            vacunado[i] = sc.nextBoolean();
            sc.nextLine(); // limpia el Enter antes del próximo nextLine()

            disponible[i] = true; // todas inician disponibles
            System.out.println();
        }

        // ===== Numeral 2: menú =====
        int opcion;
        do {
            System.out.println("\n--- MENÚ GESTIÓN DE MASCOTAS ---");
            System.out.println("1. Consultar mascotas disponibles");
            System.out.println("2. Registrar una vacunación");
            System.out.println("3. Realizar una adopción");
            System.out.println("4. Terminar");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- MASCOTAS DISPONIBLES ---");
                    boolean hayDisponibles = false;
                    for (int i = 0; i < TAM; i++) {
                        if (disponible[i]) {
                            String especie = (especies[i] == 1) ? "Perro" : "Gato";
                            String vacuna = vacunado[i] ? "Sí" : "No";
                            System.out.println("Código: " + codigos[i]
                                    + " | Nombre: " + nombres[i]
                                    + " | Especie: " + especie
                                    + " | Edad: " + edades[i] + " meses"
                                    + " | Vacunada: " + vacuna);
                            hayDisponibles = true;
                        }
                    }
                    if (!hayDisponibles) {
                        System.out.println("No hay mascotas disponibles.");
                    }
                    break;
                case 2:
                    System.out.println("\n[Acción] Registrando vacunación...");
                    // Numeral 3
                    break;
                case 3:
                    System.out.println("\n[Acción] Realizando adopción...");
                    // Numeral 4
                    break;
                case 4:
                    System.out.println("\nFinalizando programa. ¡Generando reporte final!");
                    // Numerales 6 y 7
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);

        sc.close();
    }
}