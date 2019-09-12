import java.util.ArrayList;

public class Main {
	
	private static Buffer buffer;
	private static ArrayList<Cliente> clientes;
	private static ArrayList<Servidor> servidores;
	
	public static void main(String[] args) {
		int numClientes=8;
		int numMensajes=2;
		int numServidores=4;
		int capacidadBuffer=10;
		buffer=new Buffer(capacidadBuffer, numClientes);
		clientes=new ArrayList<Cliente>();
		servidores=new ArrayList<Servidor>();
		for(int i=0;i<numClientes;i++) {
			clientes.add(new Cliente(numMensajes,buffer));
		}
		for(int i=0;i<numServidores;i++) {
			servidores.add(new Servidor(buffer));
		}
		for(int j=0;j<clientes.size();j++) {
			clientes.get(j).start();
		}
		for(int j=0;j<servidores.size();j++) {
			servidores.get(j).start();
		}
		System.out.println("terminado exitosamente");
	}
}
