import java.util.ArrayList;

public class Buffer {
	
	private int capacidad;
	private int clientes;
	private ArrayList<Mensaje> mensajesEnCola;
	
	public Buffer(int n, int c) {
		this.capacidad=n;
		this.clientes=c;
		mensajesEnCola=new ArrayList<Mensaje>();
	}

	public void almacenar(Mensaje mensaje) {
		synchronized(this){
			while(mensajesEnCola.size()==capacidad) {
				try {
					wait();
				} catch (InterruptedException e) {}
			}
			mensajesEnCola.add(mensaje);
		}
		
		synchronized(mensaje) {
			try {
				mensaje.wait();
			} 
			catch (InterruptedException e) {}
		}
	}
	
	public Mensaje retirar() {
		synchronized(this) {
			while(mensajesEnCola.size()==0) {
				Thread.yield();
			}
		}
		
		Mensaje m;
		synchronized(this) {
			m=mensajesEnCola.remove(0);
		}
		return m;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public void setCapacidad(int c) {
		capacidad=c;
	}
	
	public ArrayList<Mensaje> getMensajes(){
		return mensajesEnCola;
	}
	
	public void setMensajes(ArrayList<Mensaje> mensajes){
		mensajesEnCola=mensajes;
	}

	public synchronized void RestarCliente() {
		clientes--;		
	}

}
