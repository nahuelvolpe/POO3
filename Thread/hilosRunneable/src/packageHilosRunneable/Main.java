package packageHilosRunneable;

public class Main {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Persona("Nahuel",0));
		Thread t2 = new Thread(new Persona("Daniel",0));
		Thread t3 = new Thread(new Persona("Rocio",0));
		Thread t4 = new Thread(new Persona("Gabiota",0));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
