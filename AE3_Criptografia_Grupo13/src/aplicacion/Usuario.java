package aplicacion;

public class Usuario {

	public String nombre;
	public String passHash;
	
	
	public Usuario(String nombre, String passHash) {
		super();
		this.nombre = nombre;
		this.passHash = passHash;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPassHash() {
		return passHash;
	}


	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}


	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", passHash=" + passHash + "]";
	}
	
	
	
	
	
	
}
