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
}
