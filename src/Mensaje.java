
public class Mensaje {

	private int consulta;
	
	public Mensaje() {
		this.consulta=(int)(Math.random()*1000);
	}
	
	public int getConsulta() {
		return consulta;
	}
	
	public int setConsulta(int n) {
		consulta=n;
		return consulta;
	}
	
}
