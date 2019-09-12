
public class Cliente extends Thread{

	private int numMensajes;
	private Buffer buffer;
	
	public Cliente(int n, Buffer buff) {
		this.buffer=buff;
		this.numMensajes=n;
	}
	
	public void hacerConsultas() {
		for(int i=1;i<=numMensajes;i++) {
			Mensaje mensaje=new Mensaje();
			buffer.almacenar(mensaje);
		}
		buffer.RestarCliente();
	}
	
	public void run() {
		hacerConsultas();
	}
	
}
