package Parte2_VectoresDeObjetos.Registro_ConsumoResidencial;

public class Apartamento {
    // ===== ATRIBUTOS (privados = encapsulados) =====
    private int numero;
    private int tipo;
    private double consumoAgua;
    private double consumoEnergia;

    // ===== CONSTRUCTOR COMPLETO =====
    public Apartamento(int numero, int tipo, double consumoAgua, double consumoEnergia) {
        this.numero = numero;
        this.tipo = tipo;
        this.consumoAgua = consumoAgua;
        this.consumoEnergia = consumoEnergia;
    }

    // ===== GETTERS =====
    public int getNumero() {
        return numero;
    }

    public int getTipo() {
        return tipo;
    }

    public double getConsumoAgua() {
        return consumoAgua;
    }

    public double getConsumoEnergia() {
        return consumoEnergia;
    }

    // ===== TARIFAS (abstracción) =====
    public double obtenerTarifaAgua() {
        if (tipo == 1) {
            return 1200;
        } else if (tipo == 2) {
            return 1500;
        } else if (tipo == 3) {
            return 2000;
        } else {
            return 0;
        }
    }

    public double obtenerTarifaEnergia() {
        if (tipo == 1) {
            return 450;
        } else if (tipo == 2) {
            return 520;
        } else if (tipo == 3) {
            return 700;
        } else {
            return 0;
        }
    }

    // ===== CÁLCULOS =====
    public double calcularValorAgua() {
        return consumoAgua * obtenerTarifaAgua();
    }

    public double calcularValorEnergia() {
        return consumoEnergia * obtenerTarifaEnergia();
    }

    public double calcularFacturaTotal() {
        return calcularValorAgua() + calcularValorEnergia();
    }

    // ===== VALIDACIÓN =====
    public boolean tieneConsumoCero() {
        return consumoAgua == 0 && consumoEnergia == 0;
    }

    // ===== VALORES ALEATORIOS PARA PRECARGAR DATOS (static) =====
    public static int getTipoRandom() {
        int tipoRandom = (int) (Math.random() * 3 + 1);                 // 1 a 3
        return tipoRandom;
    }

    public static double getConsumoAguaRandom() {
        int aguaRandom = (int) (Math.random() * (30 - 5 + 1) + 5);      // 5 a 30 m³
        return aguaRandom;
    }

    public static double getConsumoEnergiaRandom() {
        int energiaRandom = (int) (Math.random() * (400 - 50 + 1) + 50); // 50 a 400 kWh
        return energiaRandom;
    }
}