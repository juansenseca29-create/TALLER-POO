package Parte1_vectoresParalelos.Refugio_de_Mascotas;
import java.util.Scanner;
public class mascotas {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] especies = new int [15];
        int[] edades = new int[15];

        String[] codigos = new String[15];
        String[] nombres = new String[15];

        boolean[] disponible = new boolean[15];
        boolean[] vacunado = new boolean[15];

        for(int i = 0; i<15; i++){
            disponible[i] = true;

            System.out.print("Digite el codigo de su mascota #" + i + ": ");
            codigos[i] = sc.nextLine();
            sc.next();
            System.out.print("Digite el nombre de su mascota #" + i + ": ");
            nombres[i] = sc.nextLine();
            sc.next();
            System.out.print("Digite la especie de su mascota #" + i + " (1:Perro 2:Gato): ");
            especies[i] = sc.nextInt();
            sc.next();
            System.out.print("Digite la edad de su mascota#" + i + ": ");
            edades[i] = sc.nextInt();

            while (edades[i] <= 0){
                System.out.print("Digite la edad de su mascota #" + i + ": ");
                edades[i] = sc.nextInt();
            }

            System.out.print("Digite el estado de vacunación (true o false): ");
            vacunado[i] = sc.nextBoolean();
            System.out.print("\n");

                if(edades[i] < 3 || vacunado[i] == false) {
                    disponible[i] = false;
                }
        }
        int opcion = 0;
        System.out.println("\n--- MENÚ GESTIÓN DE MASCOTAS ---");
        System.out.println("1. Consultar mascotas disponibles");
        System.out.println("2. Registrar una vacunación");
        System.out.println("3. Realizar una adopción");
        System.out.println("4. Terminar");
        System.out.print("Seleccione una opción: ");

        opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer de entrada

        // Evaluar la opción seleccionada
        switch (opcion) {
            case 1:
                System.out.println("\n[Acción] Consultando mascotas disponibles...");
                // Aquí llamarías a tu lógica o método de consulta (Punto 5)
                break;
            case 2:
                System.out.println("\n[Acción] Registrando vacunación...");
                // Aquí llamarías a tu lógica de búsqueda y vacunación (Punto 3)
                break;
            case 3:
                System.out.println("\n[Acción] Realizando adopción...");
                // Aquí llamarías a tu lógica de validación y adopción (Punto 4)
                break;
            case 4:
                System.out.println("\nFinalizando programa. ¡Generando reporte final!");
                // Aquí mostrarías las estadísticas finales (Puntos 6 y 7)
                break;
            default:
                System.out.println("\nOpción inválida. Intente de nuevo.");
        }






    }
}
