package modulo1.prueba2;

public class Electrodomestico {

	public final static String COLOR = "blanco";
	public final static char CONSUMO = 'F';
	public final static double PRECIOBASE = 100;
	public final static double PESO = 5;

	protected double precio;
	protected String color;
	protected char consumo;
	protected double peso;

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

	private void comprobarConsumoEnergetico(char consumoEnergetico) {
		if (consumoEnergetico >= 65 && consumoEnergetico <= 70) {
			this.consumo = consumoEnergetico;
		} else {
			this.consumo = CONSUMO;
		}

	}

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