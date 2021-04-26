package proyectoHilosPractica;

import java.util.ArrayList;
import java.util.Collections;

public class VectorConcurrente implements Runnable{
	private int tama�o;
	private long tiempo;
	private int id;
	ArrayList<Integer> vector; 
	
	public VectorConcurrente(int tam, int id) {
		this.tama�o=tam;
		this.vector = new ArrayList<Integer>();
		this.id = id;
	}

	public int getTama�o() {
		return tama�o;
	}

	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
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
		for(int i=0; i<this.getTama�o(); i++) {
			vector.add((int) Math.ceil(Math.random() * 500));
		}
		
		Collections.sort(vector);
		
	}

}
