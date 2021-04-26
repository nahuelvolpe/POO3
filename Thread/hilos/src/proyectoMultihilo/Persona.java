package proyectoMultihilo;

public class Persona extends Thread{
	
	private String nombre;
	private long tiempo;
	
	public Persona(String nom, long time) {
		this.nombre=nom;
		this.tiempo=time;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getTiempo() {
		return tiempo;
	}

	public void setTiempo(long tiempo) {
		this.tiempo = tiempo;
	}

	public void run() {
		try {
		Thread.sleep(this.getTiempo());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Soy "+ this.getNombre());
		
	}
	
}
