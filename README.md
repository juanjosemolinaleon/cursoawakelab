# README.md

## Código
```
/*
* A continuación se contextualiza el problema presentado,
* y se detalla cómo se va abordando en cada etapa.
*/

// Se crea la clase "padre", que aborda el problema de forma inicial y general.

package modulo1.prueba2;

public class Electrodomestico {

// Se declaran las variables estáticas, para poder fijar valores de inicio

	public final static String COLOR = "blanco";
	public final static char CONSUMO = 'F';
	public final static double PRECIOBASE = 100;
	public final static double PESO = 5;

// Se declaran variables que van a tomar valores según se vaya ejecutando el programa

	protected double precio;
	protected String color;
	protected char consumo;
	protected double peso;

// Se limitan los valores que puede tomar la variable "color",
// y en caso de que se ingrese un valor que no esté dentro del arreglo,
// se tomará el valor estático que se define para esta variable.

	private void comprobarColor(String color) {
		String colores[] = { "blanco", "negro", "rojo", "azul", "gris" };
		boolean encontrado = false;

		for (int i = 0; i < colores.length && !encontrado; i++) {

			if (colores[i].equals(color)) {
				encontrado = true;
			}
		}

		if (encontrado) {
			this.color = color;
		} else {
			this.color = COLOR;
		}

	}

// Se entrega directriz para validar si el valor de consumo está dentro de
// de ciertos rangos, o de lo contrario tomará el valor estático.

	private void comprobarConsumoEnergetico(char consumoEnergetico) {
		if (consumoEnergetico >= 65 && consumoEnergetico <= 70) {
			this.consumo = consumoEnergetico;
		} else {
			this.consumo = CONSUMO;
		}

	}

// Se genera el Getter para PrecioBase, color, consumo y peso

	public double getPrecioBase() {
		return precio;
	}

	public String getColor() {
		return color;
	}

	public char getConsumoEnergetico() {
		return consumo;
	}

	public double getPeso() {
		return peso;
	}

// Se entregan las directrices para que se pueda considerar un valor adicional del producto
// en función del tipo de consumo que tiene el electrodoméstico.

	public double precioFinal() {
		double valor = 0;
		switch (consumo) {
		case 'A':
			valor += 100;
			break;
		case 'B':
			valor += 80;
			break;
		case 'C':
			valor += 60;
			break;
		case 'D':
			valor += 50;
			break;
		case 'E':
			valor += 30;
			break;
		case 'F':
			valor += 10;
			break;
		}

// Se define la lógica para entregar un aumento de valor al producto
// dependiendo del peso que este tiene.

		if (peso >= 0 && peso < 19) {
			valor += 10;
		} else if (peso >= 20 && peso < 49) {
			valor += 50;
		} else if (peso >= 50 && peso <= 79) {
			valor += 80;
		} else if (peso >= 80) {
			valor += 100;
		}

		return precio + valor;
	}

	public Electrodomestico() {
		this(PRECIOBASE, PESO, CONSUMO, COLOR);
	}

	public Electrodomestico(double precioBase, double peso) {
		this(precioBase, peso, CONSUMO, COLOR);
	}

	public Electrodomestico(double precioBase, double peso, char consumoEnergetico, String color) {
		this.precio = precioBase;
		this.peso = peso;
		comprobarConsumoEnergetico(consumoEnergetico);
		comprobarColor(color);
	}

}
```

```
// Se crea una clase hija como extensión de la clase padre "Electrodomésticos"

package modulo1.prueba2;

public class Lavadora extends Electrodomestico{

// Se declara la variable estática para dar un valor por default

    private final static int CARGA_DEF=5;

// Se declara la variable que puede aumentar el valor del producto, en función de su clasificación
    
    private  int carga;

    
    public int getCarga() {
        return carga;
    }
  
    public double precioFinal(){

// Se define la condición para aumentar el valor del producto, en función de su carga
    	
        double valor=super.precioFinal();
  
        if (carga>30){
            valor+=50;
        }
  
        return valor;
    }
    
    public Lavadora(){
        this(PRECIOBASE, PESO, CONSUMO, COLOR, CARGA_DEF);
    }

    public Lavadora(double precioBase, double peso){
        this(precioBase, peso, CONSUMO, COLOR, CARGA_DEF);
    }
  
    public Lavadora(double precioBase, double peso, char consumoEnergetico, String color, int carga){
        super(precioBase,peso, consumoEnergetico,color);
        this.carga=carga;
    }
}
```

```
// Se crea una clase hija como extensión de la clase padre "Electrodomésticos"

package modulo1.prueba2;

public class Television extends Electrodomestico{

// Se declara la variable estática para dar un valor por default

    private final static int RESOLUCION_DEF=20;

// Se declaran las variables que puede aumentar el valor del producto, en función de sus condiciones

    private int resolucion;
    
    private boolean sintonizadorTDT;

    public double precioFinal(){

        double valor=super.precioFinal();

// se definen las condiciones que pueden incrementar el valor del producto

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
```

```
// Se declara la clase general que va a ser la ejecutora

package modulo1.prueba2;

public class Main {

	public static void main(String[] args) {

// Se define el arreglo para poder almacenar los datos que se van a ingresar dentro del programa

		Electrodomestico Productos[] = new Electrodomestico[10];

// Se le dan valores iniciales a cada una de las posiciones del arreglo

		Productos[0] = new Electrodomestico(120, 53, 'C', "verde");
		Productos[1] = new Lavadora(400, 51, 'A', "negro", 31);
		Productos[2] = new Television(600, 65, 'F', "blanco", 100, true);
		Productos[3] = new Electrodomestico(200, 90, 'D', "azul");
		Productos[4] = new Electrodomestico(300, 130, 'E', "azul");
		Productos[5] = new Electrodomestico(300, 72, 'F', "blanco");
		Productos[6] = new Lavadora(300, 29, 'E', "gris", 20);
		Productos[7] = new Television(400, 46, 'B', "rojo", 55, true);
		Productos[8] = new Television(400, 99, 'D', "rojo", 30, false);
		Productos[9] = new Lavadora(600, 12, 'C', "negro", 55);

// Se crean las variables que contabilizarán subtotales y total de sumatorios de valores por grupo de producto

		int Prod = 0;
		int NoLavNoTel = 0;
		int Televisores = 0;
		int Lavadoras = 0;

// Se define la lógica para adicionar cada producto dentro del grupo que le corresponde, según la definición anterior.

		for (int i = 0; i < Productos.length; i++) {

			if (Productos[i] instanceof Electrodomestico) {
				Prod += Productos[i].precioFinal();
			}
			if (Productos[i] instanceof Lavadora) {
				Lavadoras += Productos[i].precioFinal();
			}
			if (Productos[i] instanceof Television) {
				Televisores += Productos[i].precioFinal();
			}
		}

// Se calcula un subtotal a partir de los valores anteriores

		NoLavNoTel = Prod - Televisores - Lavadoras;

// Se imprimen los resultados en pantalla, para visualizar las sumatorias solicitadas de valores

		System.out.println("El valor de los productos que no son ni Lavadoras ni Televisones es de:   " + NoLavNoTel + " €");
		System.out.println("El valor total de las lavadoras es de:                                    " + Lavadoras + " €");
		System.out.println("El valor total de las televisiones es de:                                 " + Televisores + " €");
		System.out.println("                                                                         --------");
		System.out.println("El valor total de todos los electrodomesticos es de:                      " + Prod + " €");
	}
}
```

