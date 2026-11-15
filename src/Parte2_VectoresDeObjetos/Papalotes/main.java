package Parte2_VectoresDeObjetos.Papalotes;
import java.util.Scanner;
public class main {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

        Articulo[] articulos = new Articulo[40];

        int cantArticulosPreCargados = 35;
        for(int i = 0; i < cantArticulosPreCargados; i++){
            int clav = Articulo.getValoresRandomClaves();
            double costMP = Articulo.getValoresRandomCostoMP();
            articulos[i] = new Articulo(clav,costMP);
        }



        int cantArticulos = 0;
        System.out.print("Cuantos articulos desea ingresar: ");
        cantArticulos = sc.nextInt();

        for(int i = 0; i < cantArticulos; i++){

            if(cantArticulos > 40 - cantArticulosPreCargados){
                System.out.println("El numero de articulos que desea registrar supera el limite permitido");
                break;
            }else {
                System.out.print("\nDigite la clave de su producto (1-6): ");
                int clav = sc.nextInt();
                if(clav < 1 || clav > 6) {
                    System.out.println("Clave ingresada denegada");
                    System.out.print("Ingrese nuevamente la clave: ");
                    clav = sc.nextInt();
                }
                System.out.print("Digite el costo de la matera prima: ");
                double costMP = sc.nextDouble();
                articulos[cantArticulosPreCargados + i] = new Articulo(clav, costMP);
            }
        }

        System.out.println("\n---------------------------------ARTICULOS REGISTRADOS---------------------------------------");
        System.out.printf("\n%-3s %-8s %-10s %-15s %-18s %-18s %-8s%n",
                "#", "Clave", "CostoMP", "Mano de obra", "GastoFabricacion", "CostoProduccion", "precioVenta");
        System.out.println("---------------------------------------------------------------------------------------------");
        for(int i = 0; i < cantArticulosPreCargados + cantArticulos; i++){
            Articulo impresion = articulos[i];
            if(impresion != null)
                System.out.printf("%-5d %-6d %-10.2f %-15.2f %-19.2f %-20.2f %-10.2f%n",
                        i+1,
                        impresion.getClave(),
                        impresion.getCostoMP(),
                        impresion.getManoDeObra(),
                        impresion.getGastosDeFabricacion(),
                        impresion.getCostoDeProduccion(),
                        impresion.getPrecioDeVenta());
        }


        double sumatoriaPorClave[] = new double[6];
        int contadorPorClave[] = new int[6];

        for(int i = 0; i < cantArticulos + cantArticulosPreCargados; i++){
            int clave = articulos[i].getClave();

            if(clave >= 1 && clave <= 6){
                sumatoriaPorClave[clave-1] += articulos[i].getPrecioDeVenta();
                contadorPorClave[clave-1]++;
            }
        }

        System.out.println(" ");
        for(int i = 0; i < 6; i++){
            if(contadorPorClave[i] > 0){
                System.out.print("El promedio del Precio de venta de (Clave "+ (i+1)+ "): ");
                System.out.printf("%.2f", (sumatoriaPorClave[i]/contadorPorClave[i]) );
                System.out.println(" ");
            }else{
                System.out.println("El promedio del Precio de venta de (Clave "+ (i+1) +"): --- Sin datos" );
            }
        }

        double articuloMasCaro = Double.MIN_VALUE;
        int posArticuloMasCaro = 0;
        for(int i = 0; i < cantArticulos + cantArticulosPreCargados; i++){
            if(articulos[i].getPrecioDeVenta() > articuloMasCaro){
                articuloMasCaro =  articulos[i].getPrecioDeVenta();
                posArticuloMasCaro = i;
            }
        }
        System.out.printf("\nArticulo mas caro: #%d PV= %.2f%n", (posArticuloMasCaro + 1), articuloMasCaro);

        double articuloMasBarato = Double.MAX_VALUE;
        int posArticuloMasBarato = 0;
        for(int i = 0; i < cantArticulos + cantArticulosPreCargados; i++){
            if(articulos[i].getPrecioDeVenta() < articuloMasBarato){
                articuloMasBarato =  articulos[i].getPrecioDeVenta();
                posArticuloMasBarato = i;
            }
        }
        System.out.printf("Articulo mas Barato: #%d PV= %.2f%n", (posArticuloMasBarato + 1), articuloMasBarato);

        double acumuladoMP = 0;
        double acumuladoPV = 0;
        for(int i = 0; i < cantArticulos + cantArticulosPreCargados; i++){
            acumuladoMP += articulos[i].getCostoMP();
            acumuladoPV += articulos[i].getPrecioDeVenta();
        }
        System.out.printf("\nTotal MP: %.2f", acumuladoMP);
        System.out.printf("\nTotal PV: %.2f", acumuladoPV);



    }
}
