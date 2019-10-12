package Hilos;

/**
 *
 * @author Jose Luis Novoa
 */
public class Cajero {
	private Cliente cliente;
	private long initialTime;
	private String nombre;

	public Cajero() {
		
	}
	public Cajero(String nombre, Cliente cliente,long initialTime) {
		this.nombre = nombre;
		this.initialTime=initialTime;
		this.cliente=cliente;
	}


	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public long getInitialTime() {
		return initialTime;
	}
	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void procesarCompra(Cliente cliente, long timeStamp){
		System.out.println("La " + this.nombre + " empieza a registrar los productos de " + cliente.getNombre());
		for (int i = 0; i < cliente.getCompra().length; i++) {
			esperar(cliente.getCompra()[i]);
		}
		System.out.println("La " + this.nombre + " termino de procesar la compra de " + cliente.getNombre()
				+ " en un tiempo de : " + (System.currentTimeMillis() - initialTime) / 1000 + " seg");

	}

	private void esperar(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}