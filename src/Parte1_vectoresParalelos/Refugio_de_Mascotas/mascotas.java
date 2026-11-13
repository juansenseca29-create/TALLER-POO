package Parte1_vectoresParalelos.Refugio_de_Mascotas;
import java.util.Scanner;

public class mascotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int TAM = 15;

        int []codigos={69, 67, 77, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String[] nombres = {"pepo", "rayo", "max", "lola", null, null, null, null, null, null, null, null, null, null, null};
        int[] especies = {1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] edades = {4, 7, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean[] vacunado = {true, true, true, false, false, false, false, false, false, false, false, false, false, false, false};
        boolean[] disponible = {true, true, true, true, false, false, false, false, false, false, false, false, false, false, false};
        int cantDisponibles = 4;
        int totalRegistradas = 4;

        int cantPerrosAdop = 0;
        int cantGatosAdop = 0;
        int cantVacunados= 3;
        int cantAdoptados = 0;


        // ===== Numeral 2: menú =====
        int opcion;
        do {
            System.out.println("\n--- MENÚ GESTIÓN DE MASCOTAS ---");
            System.out.println("1. Consultar mascotas disponibles");
            System.out.println("2. Registrar una vacunación");
            System.out.println("3. Realizar una adopción");
            System.out.println("4. Registrar mascota nueva");
            System.out.println("5. Realizar busqueda por especie y edad máxima");
            System.out.println("6. Terminar");
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

                    System.out.print("\nDigite el código de la mascota que desea vacunar: ");
                    int codigo = sc.nextInt();
                    int posicion = -1;
                    for(int i = 0; i < totalRegistradas; i ++){
                        if(codigos[i] == codigo){
                            posicion = i;
                            vacunado[posicion] = true;
                        }
                    }
                    if(posicion == -1){
                        System.out.println("El codigo digitado no corresponde a ninguna mascota");
                    }else{
                        System.out.println("Registro de vacunación realizado de " + nombres[posicion]);
                    }

                    if(vacunado[posicion])
                        cantVacunados++;

                    // ---------------------------------------------------------------------------------------
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

                    System.out.print("Digite el codigo de la mascota que desea adoptar: ");
                    int codigoParaAdoptar = sc.nextInt();
                    int posAdoptar = -1;

                    for(int i = 0; i < totalRegistradas; i++){
                        if(codigos[i] == codigoParaAdoptar){
                            posAdoptar = i;
                            disponible[posAdoptar] = false;
                        }
                    }
                    if(posAdoptar == -1){
                        System.out.println("El codigo digitado no corresponde a ninguna mascota disponible para adoptar");
                    }else{
                        System.out.println("Adocpión realizada con exito!");
                    }

                    if(!disponible[posAdoptar]){
                        if(especies[posAdoptar] == 1){
                            cantPerrosAdop++;
                        }else{
                            cantGatosAdop++;
                        }
                    }

                    cantDisponibles--;
                    cantAdoptados++;

                    //---------------------------------------------------------------------------------------------
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
                case 5:
                    System.out.print("\nDigite la especie que desea buscar (1: Perro | 2: Gato): ");
                    int especieBuscada = sc.nextInt();

                    System.out.print("Digite la edad máxima (en meses): ");
                    int edadMaxima = sc.nextInt();

                    boolean encontro = false;
                    System.out.println("\n--- RESULTADOS DE BÚSQUEDA ---");
                    for (int j = 0; j < totalRegistradas; j++) {
                        if (especies[j] == especieBuscada && edades[j] <= edadMaxima) {
                            String especie = (especies[j] == 1) ? "Perro" : "Gato";
                            String vacuna = vacunado[j] ? "Sí" : "No";
                            System.out.println("Código: " + codigos[j]
                                    + " | Nombre: " + nombres[j]
                                    + " | Especie: " + especie
                                    + " | Edad: " + edades[j] + " meses"
                                    + " | Vacunada: " + vacuna);
                            encontro = true;
                        }
                    }

                    if (!encontro) {
                        System.out.println("No se encontraron mascotas que cumplan los criterios.");
                    }
                    break;
                case 6:
                    System.out.println("\n--- REPORTE DE ACCIONES ---");
                    System.out.println("Perros adoptados: " + cantPerrosAdop);
                    System.out.println("Gatos adoptados: " + cantGatosAdop);
                    System.out.println("Hay " + cantDisponibles + " mascotas disponibles, de las cuales "
                    + (cantDisponibles - cantVacunados) + " aun no estan vacunadas");

                    int posEdadMayor = 0;
                    int edadMayor = 0;
                    for(int j = 0; j < totalRegistradas; j++){
                        if(edades[j] > edadMayor){
                            edadMayor = edades[j];
                            posEdadMayor = j;
                        }
                    }

                    System.out.println("\nLa mascota(s) con mayor edad: ");
                    for(int j = 0; j < totalRegistradas; j++){
                        if(edades[j] == edadMayor){
                            System.out.println("Nombre: " + nombres[j] + " | Edad: " + edades[j] + " meses");
                        }
                    }

                    System.out.println("\nEl porcentaje de mascotas adoptadas es: " + ( (float)cantAdoptados / (float)totalRegistradas) * 100);
                    break;
                default:
                    System.out.println("\nOpcion invalida, digite una opcion correcta ");
            }
        } while (opcion != 6);

        sc.close();
    }
}