package Parte2_VectoresDeObjetos.Registro_ConsumoResidencial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== ARREGLO DE OBJETOS =====
        Apartamento[] edificio = new Apartamento[6];

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

        // ===== VALIDACIÓN: ¿TODOS LOS CONSUMOS SON CERO? =====
        int aptosSinConsumo = 0;
        for (int i = 0; i < edificio.length; i++) {
            if (edificio[i].tieneConsumoCero()) {
                aptosSinConsumo++;
            }
        }

        if (aptosSinConsumo == edificio.length) {
            System.out.println("\n⚠ ALERTA: todos los consumos registrados son cero.");
            System.out.println("Datos inválidos: no se puede generar el reporte.");
        } else {

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

            // ===== ESTADÍSTICAS =====
            double totalRecaudado = 0;

            double sumaTipo1 = 0;
            double sumaTipo2 = 0;
            double sumaTipo3 = 0;
            int cantidadTipo1 = 0;
            int cantidadTipo2 = 0;
            int cantidadTipo3 = 0;

            int posMayor = 0;
            int posMenor = 0;

            for (int i = 0; i < edificio.length; i++) {
                double factura = edificio[i].calcularFacturaTotal();

                // Total recaudado
                totalRecaudado += factura;

                // Acumuladores y contadores por tipo
                if (edificio[i].getTipo() == 1) {
                    sumaTipo1 += factura;
                    cantidadTipo1++;
                } else if (edificio[i].getTipo() == 2) {
                    sumaTipo2 += factura;
                    cantidadTipo2++;
                } else if (edificio[i].getTipo() == 3) {
                    sumaTipo3 += factura;
                    cantidadTipo3++;
                }

                // Mayor y menor consumo energético
                if (edificio[i].getConsumoEnergia() > edificio[posMayor].getConsumoEnergia()) {
                    posMayor = i;
                }
                if (edificio[i].getConsumoEnergia() < edificio[posMenor].getConsumoEnergia()) {
                    posMenor = i;
                }
            }

            // Promedios por tipo (evitando dividir entre cero)
            double promedioTipo1 = 0;
            double promedioTipo2 = 0;
            double promedioTipo3 = 0;
            if (cantidadTipo1 > 0) {
                promedioTipo1 = sumaTipo1 / cantidadTipo1;
            }
            if (cantidadTipo2 > 0) {
                promedioTipo2 = sumaTipo2 / cantidadTipo2;
            }
            if (cantidadTipo3 > 0) {
                promedioTipo3 = sumaTipo3 / cantidadTipo3;
            }

            // ===== MOSTRAR ESTADÍSTICAS =====
            System.out.println("\n========== ESTADÍSTICAS ==========");
            System.out.printf("Factura promedio Estudio (tipo 1):          $%.0f  (%d apto(s))%n", promedioTipo1, cantidadTipo1);
            System.out.printf("Factura promedio Dos habitaciones (tipo 2): $%.0f  (%d apto(s))%n", promedioTipo2, cantidadTipo2);
            System.out.printf("Factura promedio Penthouse (tipo 3):        $%.0f  (%d apto(s))%n", promedioTipo3, cantidadTipo3);
            // Mayor consumo energético (incluye empates)
            double consumoMayor = edificio[posMayor].getConsumoEnergia();
            System.out.printf("Mayor consumo energético (%.2f kWh): Apto(s)", consumoMayor);
            for (int i = 0; i < edificio.length; i++) {
                if (edificio[i].getConsumoEnergia() == consumoMayor) {
                    System.out.print(" " + edificio[i].getNumero());
                }
            }
            System.out.println();

            // Menor consumo energético (incluye empates)
            double consumoMenor = edificio[posMenor].getConsumoEnergia();
            System.out.printf("Menor consumo energético (%.2f kWh): Apto(s)", consumoMenor);
            for (int i = 0; i < edificio.length; i++) {
                if (edificio[i].getConsumoEnergia() == consumoMenor) {
                    System.out.print(" " + edificio[i].getNumero());
                }
            }
            System.out.println();
            System.out.printf("Total recaudado por el edificio: $%.0f%n", totalRecaudado);
        }

        sc.close();
    }
}