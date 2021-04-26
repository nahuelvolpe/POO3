package proyectJuego;

public class Jugador implements Runnable {

	public Pantalla pantalla;
	public int tipo;
	public String jugador;

	public Jugador(Pantalla display, int tipo, String jugador) {
		this.pantalla = display;
		this.tipo = tipo;
		this.jugador=jugador;
	}


	public Pantalla getPantalla() {
		return pantalla;
	}


	public void setPantalla(Pantalla pantalla) {
		this.pantalla = pantalla;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	
	public String getJugador() {
		return jugador;
	}
	
	public void setJugador(String jugador) {
		this.jugador = jugador;
	}


	@Override
	public void run() {

			if(this.getTipo()==1) {

				try{
					pantalla.sumar(this.getJugador(), this.getTipo());
				}catch(InterruptedException e) {
					e.printStackTrace();
				}

			}else if(this.getTipo()==0){

				try{
					pantalla.restar(this.getJugador(), this.getTipo());
				}catch(InterruptedException e) {
					e.printStackTrace();
				}	
			}else {
				System.out.println("Error");
			}
		}


}
