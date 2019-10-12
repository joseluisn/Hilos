package Hilos;

/**
 *
 * @author Jose Luis Novoa
 */
public class Main extends Thread{
	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("Jose Luis", new int[] { 1, 1, 1, 1, 2 });
		Cliente cliente2 = new Cliente("Ana Maria", new int[] { 1, 3, 5, 1, 1 });
		long initialTime = System.currentTimeMillis();
		long finalTime = System.currentTimeMillis();
		Cajero cajera1 = new Cajero("Cajera",cliente1,initialTime);
		
		cajera1.procesarCompra(cliente1, initialTime);
		cajera1.procesarCompra(cliente2, initialTime);
		
		finalTime = (System.currentTimeMillis() - initialTime);
		System.out.println("El tiempo de procesar las dos compras es de " + finalTime / 1000 + " segundos");
		
	}
}