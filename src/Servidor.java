
public class Servidor extends Thread {
	
	public Servidor(){}
	
	public void responderConsulta(Buffer buffer) {
		Mensaje mensajeActual;
		mensajeActual=buffer.retirar();
		synchronized(mensajeActual){
			mensajeActual.setConsulta(mensajeActual.getConsulta()+1);
			mensajeActual.notify();
		}
	}
}
