
public class Cliente extends Thread{

	private int numMensajes;
	
	public Cliente(int n) {
		this.numMensajes=n;
	}
	
	public void hacerConsultas(Buffer buffer) {
		for(int i=1;i<=numMensajes;i++) {
			Mensaje mensaje=new Mensaje();
			buffer.almacenar(mensaje);
		}
		buffer.RestarCliente();
	}
	
}
