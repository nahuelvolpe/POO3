package proyectJuego;

public class Pantalla {

	public int puntaje = 0;
	
	public Pantalla() {}
		
	
	
	
	public int getPuntaje() {
		return puntaje;
	}




	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}




	public synchronized void sumar(String jugador, int tipo) throws InterruptedException {
		
		while(puntaje>0) {
			this.wait();
		}
		puntaje++;
		notifyAll();
		System.out.println("Soy el jugador: "+jugador +", tipo =  " + tipo+" y el puntaje es = "+puntaje);
		
	}
	
	public synchronized void restar(String jugador, int tipo) throws InterruptedException {
		
		while(puntaje<=0) {
			this.wait();
		}
		puntaje--;
		notifyAll();
		System.out.println("Soy el jugador: "+jugador +", tipo =  " + tipo+" y el puntaje es = "+puntaje);
	}

}
