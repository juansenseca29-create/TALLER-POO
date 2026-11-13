package Parte1_vectoresParalelos.Refugio_de_Mascotas;
import java.util.Scanner;

public class mascotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int TAM = 15;

        int []codigos={1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String[] nombres = {"pepo", "rayo", "max", "lola", null, null, null, null, null, null, null, null, null, null, null};
        int[] especies = {1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] edades = {4, 3, 1, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean[] vacunado = {true, true, true, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] disponible = {true, true, true, true, false, false, false, false, false, false, false, false, false, false, false};
        int cantDisponibles = 4;
        int totalRegistradas = 4; // posiciones ocupadas en los arreglos


        // ===== Numeral 2: menú =====
        int opcion;
        do {
            System.out.println("\n--- MENÚ GESTIÓN DE MASCOTAS ---");
            System.out.println("1. Consultar mascotas disponibles");
            System.out.println("2. Registrar una vacunación");
            System.out.println("3. Realizar una adopción");
            System.out.println("4. Registrar mascota nueva");
            System.out.println("5. Terminar");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- MASCOTAS DISPONIBLES ---");
                    boolean hayDisponibles = false;
                    for (int i = 0; i < 15; i++) {
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
                    System.out.println("\n --- MASCOTAS DISPONIBLES PARA VACUNACION ---");
                    for(int i = 0; i < totalRegistradas; i++){
                        if(!vacunado[i] && disponible[i]){
                            System.out.println("Código: " + codigos[i]
                                    + " | Nombre: " + nombres[i]);
                        }
                    }
                    int codigo = 0;
                    System.out.println("Digite el código de la mascota que desea vacunar?: ");
                    codigo = sc.nextInt();
                    vacunado[codigo - 1] = true;
                    System.out.println("Registro de vacunación realizado de " + nombres[codigo - 1]);

                    break;
                case 3:
                    System.out.println("\n--- MASCOTAS DISPONIBLES PARA ADOPTAR ---");
                    for(int i = 0; i < totalRegistradas; i++){
                        if(disponible[i] && edades[i] >= 3 && vacunado[i] == true){
                            String especie = (especies[i] == 1) ? "Perro" : "Gato";
                            String vacuna = vacunado[i] ? "Sí" : "No";
                            System.out.println("Código: " + codigos[i]
                                    + " | Nombre: " + nombres[i]
                                    + " | Especie: " + especie
                                    + " | Edad: " + edades[i] + " meses"
                                    + " | Vacunada: " + vacuna);
                        }
                    }
                    int codigoParaAdoptar = 0;
                    System.out.print("Digite el codigo de la mascota que desea adoptar: ");
                    codigoParaAdoptar = sc.nextInt();
                    disponible[codigoParaAdoptar - 1] = false;
                    if(disponible[codigoParaAdoptar - 1] == false){
                        cantDisponibles -= 1;
                    }

                    break;
                case 4:
                    if (totalRegistradas >= TAM) {
                        System.out.println("El refugio está lleno. No se pueden registrar más mascotas.");
                        break;
                    }

                    int i = totalRegistradas;
                    System.out.print("Digite el codigo de la mascota #" + (i + 1) + ": ");
                    codigos[i] = sc.nextInt();
                    sc.nextLine();

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
                    sc.nextLine();

                    disponible[i] = true;
                    totalRegistradas++;
                    cantDisponibles++;
                    System.out.println();

                    break;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);

        sc.close();
    }
}