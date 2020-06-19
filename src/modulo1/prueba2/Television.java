package modulo1.prueba2;

public class Television extends Electrodomestico{

    private final static int RESOLUCION_DEF=20;

    private int resolucion;
    
    private boolean sintonizadorTDT;

    public double precioFinal(){

        double valor=super.precioFinal();

        if (resolucion>40){
            valor+=precio *1.3;
        }
        if (sintonizadorTDT){
            valor+=50;
        }
  
        return valor;
    }
  
    public Television(){
        this(PRECIOBASE, PESO, CONSUMO, COLOR, RESOLUCION_DEF, false);
    }
  
    public Television(double precioBase, double peso){
        this(precioBase, peso, CONSUMO, COLOR, RESOLUCION_DEF, false);
    }

    public Television(double precioBase, double peso, char consumoEnergetico, String color, int resolucion, boolean sintonizadorTDT){
        super(precioBase, peso, consumoEnergetico, color);
        this.resolucion=resolucion;
        this.sintonizadorTDT=sintonizadorTDT;
    }
}
