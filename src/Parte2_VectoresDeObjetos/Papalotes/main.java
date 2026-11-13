package Parte2_VectoresDeObjetos.Papalotes;
import java.util.Scanner;
public class main {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

        Articulo[] articulos = new Articulo[10];

        int cantArticulos = 0;
        System.out.print("Cuantos articulos desea ingresar: ");
        cantArticulos = sc.nextInt();

        for(int i = 0; i < cantArticulos; i++){

            System.out.print("\nDigite la clave de su producto (1-6): ");
            int clav = sc.nextInt();
            System.out.print("Difigte el costo de la matera prima: ");
            double costMP = sc.nextDouble();

            articulos[i] = new Articulo(clav,costMP);

        }

        System.out.printf("%-5s, %-5s, %-10s, %-10s, %-10s, %-10s, %-10s%n,",
                "#", "Clave", "CostoMP", "Mano de obra", "Gasto fabricacion", "Costo produccion", "precio venta");
        System.out.print("---------------------------------------------------------------------------------------------");



    }
}
