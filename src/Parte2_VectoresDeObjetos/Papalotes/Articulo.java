package Parte2_VectoresDeObjetos.Papalotes;

public class Articulo {

    private int clave;
    private double costoMP;

    public Articulo(int clave, double costoMP){
        this.clave = clave;
        this.costoMP = costoMP;
    }

    public int getClave(){
        return clave;
    }
    public double getCostoMP(){
        return costoMP;
    }
    public double getManoDeObra(){
        return switch (clave) {
            case 3, 4: yield costoMP * 0.75;
            case 1, 5: yield costoMP * 0.80;
            case 2, 6: yield costoMP * 0.85;
            default: yield 0;
        };
    }
    public double getGastosDeFabricacion(){
        return switch (clave) {
            case 2, 5: yield costoMP * 0.30;
            case 3, 6: yield costoMP * 0.35;
            case 1, 4: yield costoMP * 0.28;
            default: yield 0;
        };
    }
    public double getCostoDeProduccion(){
        return ( costoMP + getManoDeObra() + getGastosDeFabricacion());
    }
    public double getPrecioDeVenta(){
        return (getCostoDeProduccion() * 1.45);
    }

}
