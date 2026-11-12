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

            // hola


        }







    }
}
