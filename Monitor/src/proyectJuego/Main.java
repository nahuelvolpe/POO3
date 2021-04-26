package proyectJuego;

public class Main {

	public static void main(String[] args) {
		
		Pantalla p1 = new Pantalla();

		Thread t1 = new Thread(new Jugador(p1,0,"Nahuel"));
		Thread t2 = new Thread(new Jugador(p1,1, "Daniel"));
		Thread t3 = new Thread(new Jugador(p1,1, "Jorgito"));
		Thread t4 = new Thread(new Jugador(p1,1, "Matias"));
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
