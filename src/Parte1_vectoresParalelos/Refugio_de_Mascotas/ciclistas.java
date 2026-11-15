package Parte1_vectoresParalelos.Refugio_de_Mascotas;

import java.util.Scanner;
public class ciclistas {
    public static void main (String[] args) {
        Scanner nacho = new Scanner(System.in);

        int[] dorsales = {4,56,34,32,67,0,0,0,0,0};
        String[] nombres = {"juan","pedro","alex","simon","camilo",null,null,null,null,null};
        int[] etapa1 = {5,10,3,4,7,0,0,0,0,0};
        int[] etapa2 = {6,9,4,3,8,0,0,0,0,0};
        int[] etapa3 = {7,8,5,2,9,0,0,0,0,0};

        int preCargados = 5;

        System.out.print("Cuantos ciclistas desea registrar?: ");
        int Total = nacho.nextInt();
        while(Total > 10 - preCargados){
            System.out.print("La cantidad de ciclistas supera el limite, digite una cantidad inferior: ");
            Total = nacho.nextInt();
        }

        for (int i = 0; i < Total; i++) {
            System.out.print("numero de dorsal: ");
            dorsales[preCargados + i] = nacho.nextInt();

            System.out.print("nombre: ");
            nombres[preCargados + i] = nacho.next();

            System.out.print("tiempo etapa 1: ");
            etapa1[preCargados + i] = nacho.nextInt();

            while (etapa1[i] < 0) {
                System.out.print("Error!Tiempo incorrecto. Vuelve a ingresar el tiempo: ");
                etapa1[preCargados + i] = nacho.nextInt();
            }
            System.out.print("tiempo etapa 2: ");
            etapa2[preCargados + i] = nacho.nextInt();

            while (etapa2[i] < 0) {
                System.out.print("Error! Tiempo incorrecto. Vuelve a ingresar el tiempo: ");
                etapa2[preCargados + i] = nacho.nextInt();
            }
            System.out.print("tiempo etapa 3: ");
            etapa3[preCargados + i] = nacho.nextInt();

            while (etapa3[i] < 0) {
                System.out.print("[Error!Tiempo incorrecto. Vuelve a ingresar el tiempo: ]");
                etapa3[preCargados + i] = nacho.nextInt();
            }
        }
        int[] TiempoTotal = new int[Total + preCargados];

        for (int i = 0; i < preCargados + Total; i++) {
            if (etapa1[i] == 0 || etapa2[i] == 0 || etapa3[i] == 0) {
                TiempoTotal[i] = 0;

            } else {
                TiempoTotal[i] = etapa1[i] + etapa2[i] + etapa3[i];
            }
        }
        System.out.println("\n Listado general de ciclistas ");
        for (int i = 0; i < Total + preCargados; i++) {
            System.out.println("Dorsal: " + dorsales[i] + "  Nombres: " + nombres[i]);
            if (TiempoTotal[i] == 0) {
                System.out.println("Retirado");
            } else {

                System.out.println("Tiempo Total: " + TiempoTotal[i]);

            }

        }
        System.out.println("\n Ganadores de cada etapa");
        int E1menor = 999999;
        for (int i = 0; i < Total + preCargados; i++) {
            if (etapa1[i] > 0 && etapa1[i] < E1menor) {
                E1menor = etapa1[i];
            }
        }
        if (E1menor == 999999) {
            System.out.println("\n Etapa 1. Nadie completo la etapa");
        } else {
            System.out.println("\n Ganador Etapa 1(tiempo:" + E1menor + "mins):");
            for (int i = 0; i < Total + preCargados; i++) {
                if (etapa1[i] == E1menor) {
                    System.out.println("-" + nombres[i] + "(Dorsal:" + dorsales[i] + ")");
                }
            }
        }
        int E2menor = 999999;
        for (int i = 0; i < Total + preCargados; i++) {
            if (etapa2[i] > 0 && etapa2[i] < E2menor) {
                E2menor = etapa2[i];
            }
        }
        if (E2menor == 999999) {
            System.out.println("\n Etapa 2. Nadie completo la etapa");
        } else {
            System.out.println("\n Ganador Etapa 2(tiempo:" + E2menor + "mins):");
            for (int i = 0; i < Total + preCargados; i++) {
                if (etapa2[i] == E2menor) {
                    System.out.println("-" + nombres[i] + "(Dorsal:" + dorsales[i] + ")");
                }
            }
        }
        int E3menor = 999999;
        for (int i = 0; i < Total + preCargados; i++) {
            if (etapa3[i] > 0 && etapa3[i] < E3menor) {
                E3menor = etapa3[i];
            }
        }
        if (E3menor == 999999) {
            System.out.println("\n Etapa 3. Nadie completo la etapa");
        } else {
            System.out.println("\n Ganador Etapa 3(tiempo:" + E3menor + "mins):");
            for (int i = 0; i < Total + preCargados; i++) {
                if (etapa3[i] == E3menor) {
                    System.out.println("-" + nombres[i] + "(Dorsal:" + dorsales[i] + ")");
                }
            }
        }
        System.out.println("\n Clasificación general");
        int menorGeneral = 999999;
        for (int i = 0; i < Total + preCargados; i++) {
            if (TiempoTotal[i] > 0 && TiempoTotal[i] < menorGeneral) {
                menorGeneral = TiempoTotal[i];
            }
        }
        if (menorGeneral == 999999) {
            System.out.println("Ningún ciclista completó las tres etapas de la carrera.");
        } else {
            System.out.println("¡Ganador de la carrera!(Tiempo Total: " + menorGeneral + "mins):");
            for (int i = 0; i < Total + preCargados; i++) {
                if (TiempoTotal[i] == menorGeneral) {
                    System.out.println("-" + nombres[i] + "(Dorsal:" + dorsales[i] + ")");
                }
            }
        }
        System.out.println("\n Ingrese el número de dorsal que desea consultar: ");
        int dorsalBuscado = nacho.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < Total + preCargados; i++) {
            if (dorsales[i] == dorsalBuscado) {
                encontrado = true;
                System.out.println("Ciclista encontrdo: " + nombres[i]);
                if (TiempoTotal[i] > 0) {
                    int diferencia = TiempoTotal[i] - menorGeneral;
                    System.out.println("Diferencia de tiempop con el ganador general: " + diferencia + "mins.");
                } else {
                    System.out.println("El ciclisa se retiro, no tiene tiempo total. ");
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ninguno" + dorsalBuscado);
        }
        System.out.println("Ciclistas que mejoraron");
        boolean Upgrade = false;
        for (int i = 0; i < Total + preCargados; i++) {
            if (etapa1[i] > 0 && etapa2[i] > 0 && etapa3[i] > 0) {
                if (etapa2[i] < etapa1[i] && etapa3[i] < etapa2[i]) {
                    Upgrade = true;
                    System.out.println("-" + nombres[i] + "(Dorsal:" + dorsales[i] + ") Tiempos Etapa 1: " + etapa1[i] + ", Etapa 2: " + etapa2[i] + ", Etapa 3: " + etapa3[i]);
                }
            }
        }
        if (!Upgrade) {
            System.out.println("\n Ningun ciclista mejoro su tiempo de manera estricta en las tres etapas");
        }
        System.out.println("\n Estadisticas finales: ");

        int RetiradosE1 = 0, RetiradosE2 = 0, RetiradosE3 = 0;
        int terminaron = 0;

        for (int i = 0; i < Total + preCargados; i++) {
            if (etapa1[i] == 0) {
                RetiradosE1++;
            }
            if (etapa2[i] == 0) {
                RetiradosE2++;
            }
            if (etapa3[i] == 0) {
                RetiradosE3++;
            }
            if (TiempoTotal[i] > 0) {
                terminaron++;
            }
        }
        double porcentaje = (terminaron * 100.0) / Total;
        System.out.println("Retirados Etapa 1: " + RetiradosE1);
        System.out.println("Retirados Etapa 2: " + RetiradosE2);
        System.out.println("Retirados Etapa 3: " + RetiradosE3);
        System.out.println("Porcentaje que completo la carrera: " + porcentaje + "%");
    }

}