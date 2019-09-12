
public class Servidor extends Thread {
	
	private Buffer buffer;
	
	public Servidor(Buffer buff){
		buffer=buff;
	}
	
	public void responderConsulta() {
		Mensaje mensajeActual;
		mensajeActual=buffer.retirar();
		if(mensajeActual!=null) {
			synchronized(mensajeActual){
				mensajeActual.setConsulta(mensajeActual.getConsulta()+1);
				mensajeActual.notify();
			}
		}
		else {
			yield();
		}
	}
	
	public void run() {
		while(buffer.getClientes()!=0) {
			responderConsulta();
		}
	}
}
