package Parte2_VectoresDeObjetos.Registro_ConsumoResidencial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== ARREGLO DE OBJETOS =====
        Apartamento[] edificio = new Apartamento[2];

        // ===== INGRESO DE DATOS =====
        for (int i = 0; i < edificio.length; i++) {
            System.out.println("\n--- Apartamento " + (i + 1) + " de " + edificio.length + " ---");

            System.out.print("Número de apartamento: ");
            int numero = sc.nextInt();

            System.out.print("Tipo (1 = Estudio, 2 = Dos habitaciones, 3 = Penthouse): ");
            int tipo = sc.nextInt();

            System.out.print("Consumo de agua (m³): ");
            double agua = sc.nextDouble();

            System.out.print("Consumo de energía (kWh): ");
            double energia = sc.nextDouble();

            edificio[i] = new Apartamento(numero, tipo, agua, energia);
        }
        // ===== TABLA DE RESULTADOS =====
        System.out.println("\n================================== REPORTE DE CONSUMOS ==================================");
        System.out.printf("%-6s%-6s%12s%15s%15s%16s%16s%n",
                "Apto", "Tipo", "Agua (m³)", "Energía (kWh)", "Valor agua", "Valor energía", "Factura total");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (int i = 0; i < edificio.length; i++) {
            System.out.printf("%-6d%-6d%12.2f%15.2f%15.0f%16.0f%16.0f%n",
                    edificio[i].getNumero(),
                    edificio[i].getTipo(),
                    edificio[i].getConsumoAgua(),
                    edificio[i].getConsumoEnergia(),
                    edificio[i].calcularValorAgua(),
                    edificio[i].calcularValorEnergia(),
                    edificio[i].calcularFacturaTotal());
        }




        sc.close();
    }
}