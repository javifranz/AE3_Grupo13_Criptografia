package aplicacion;

import java.io.Serializable;

public class Mensaje implements Serializable {
	
	
	
	private static final long serialVersionUID = 3526483192707204517L;
	public String frase;

	public Mensaje(String frase) {
		super();
		this.frase = frase;
	}
	
	
	

	public String getFrase() {
		return frase;
	}




	public void setFrase(String frase) {
		this.frase = frase;
	}




	@Override
	public String toString() {
		return "Mensaje [frase=" + frase + "]";
	}
	

}
