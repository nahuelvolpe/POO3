package proyectoMultihilo;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
	
	Persona p1 = new Persona("Daniel",0); 
	Persona p2 = new Persona("Nahuel",0); 
	Persona p3 = new Persona("Rocio",0); 
	Persona p4 = new Persona("Matias",0); 

	p1.start();
	p2.start();
	p3.start();
	p4.start();
	p1.join();
	p2.join();
	p3.join();
	p4.join();
	
	System.out.println("Proceso");
	
	}
	
}
