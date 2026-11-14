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

        System.out.printf("\n%-3s %-8s %-10s %-15s %-18s %-18s %-8s%n",
                "#", "Clave", "CostoMP", "Mano de obra", "GastoFabricacion", "CostoProduccion", "precioVenta");
        System.out.println("---------------------------------------------------------------------------------------------");
        for(int i = 0; i < cantArticulos; i++){
            Articulo impresion = articulos[i];
            if(impresion != null)
                System.out.printf("%-5d %-6d %-10.2f %-15.2f %-19.2f %-20.2f %-10.2f%n",
                        i,
                        impresion.getClave(),
                        impresion.getCostoMP(),
                        impresion.getManoDeObra(),
                        impresion.getGastosDeFabricacion(),
                        impresion.getCostoDeProduccion(),
                        impresion.getPrecioDeVenta());
        }


        double sumatoriaPorClave[] = new double[6];
        int contadorPorClave[] = new int[6];

        for(int i = 0; i < cantArticulos; i++){
            int clave = articulos[i].getClave();

            if(clave >= 1 && clave <= 6){
                sumatoriaPorClave[clave-1] += articulos[i].getPrecioDeVenta();
                contadorPorClave[clave-1]++;
            }
        }

        for(int i = 0; i < 6; i++){
            if(contadorPorClave[i] > 0){
                System.out.print("El promedio del Precio de venta de (Clave "+ (i+1)+ "): ");
                System.out.printf("%.2f", (sumatoriaPorClave[i]/contadorPorClave[i]) );
                System.out.println(" ");
            }else{
                System.out.println("El promedio del Precio de venta de (Clave "+ i+"): --- Sin datos" );
            }
        }

        double articuloMasCaro = 0;
        int posArticuloMasCaro = 0;
        for(int i = 0; i < cantArticulos; i++){
            if(articulos[i].getPrecioDeVenta() > articuloMasCaro){
                articuloMasCaro =  articulos[i].getPrecioDeVenta();
                posArticuloMasCaro = i;
            }
        }

        System.out.printf("Articulo mas caro: #%d PV= %.2f%n", (posArticuloMasCaro + 1), articuloMasCaro);



    }
}
