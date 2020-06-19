package modulo1.prueba2;

public class Main {

	public static void main(String[] args) {

		Electrodomestico Productos[] = new Electrodomestico[10];

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

		int Prod = 0;
		int NoLavNoTel = 0;
		int Televisores = 0;
		int Lavadoras = 0;

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

		NoLavNoTel = Prod - Televisores - Lavadoras;

		System.out.println("El valor de los productos que no son ni Lavadoras ni Televisones es de:   " + NoLavNoTel + " €");
		System.out.println("El valor total de las lavadoras es de:                                    " + Lavadoras + " €");
		System.out.println("El valor total de las televisiones es de:                                 " + Televisores + " €");
		System.out.println("                                                                         --------");
		System.out.println("El valor total de todos los electrodomesticos es de:                      " + Prod + " €");
	}
}
