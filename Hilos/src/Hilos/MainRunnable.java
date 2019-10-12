package Hilos;

/**
 * 
 * @author Jose Luis Novoa
 */
public class MainRunnable implements Runnable {

	private Cliente cliente;
	private Cajero cajera;
	private long initialTime;

	public MainRunnable(Cliente cliente, Cajero cajera, long initialTime) {
		this.cajera = cajera;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("Ana Maria", new int[] { 1, 1, 1, 1, 2 });
		Cliente cliente2 = new Cliente("Jose Luis", new int[] { 1, 3, 5, 1, 1 });
		// Ingresamos el tiempo inicial para que las cajeras procesen las compras de los
		// clientes
		long initialTime = System.currentTimeMillis();
		Cajero cajera1 = new Cajero("Cajera 1", cliente1, initialTime);
		Cajero cajera2 = new Cajero("Cajera 2", cliente2, initialTime);

		Runnable proceso1 = new MainRunnable(cliente1, cajera1, initialTime);
		Runnable proceso2 = new MainRunnable(cliente2, cajera2, initialTime);
		new Thread(proceso1).start();
		new Thread(proceso2).start();
	}

	@Override
	public void run() {
		cajera.procesarCompra(this.cliente, this.initialTime);
	}
}
