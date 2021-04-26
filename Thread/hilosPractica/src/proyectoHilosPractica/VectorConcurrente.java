package proyectoHilosPractica;

import java.util.ArrayList;
import java.util.Collections;

public class VectorConcurrente implements Runnable{
	private int tamaño;
	private long tiempo;
	private int id;
	ArrayList<Integer> vector; 
	
	public VectorConcurrente(int tam, int id) {
		this.tamaño=tam;
		this.vector = new ArrayList<Integer>();
		this.id = id;
	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	public long getTiempo() {
		return tiempo;
	}

	public void setTiempo(long tiempo) {
		this.tiempo = tiempo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList<Integer> getVector() {
		return vector;
	}

	public void setVector(ArrayList<Integer> vector) {
		this.vector = vector;
	}

	public void run() {
		for(int i=0; i<this.getTamaño(); i++) {
			vector.add((int) Math.ceil(Math.random() * 500));
		}
		
		Collections.sort(vector);
		
	}

}
