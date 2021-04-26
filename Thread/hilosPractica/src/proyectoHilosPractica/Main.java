package proyectoHilosPractica;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		long t1 = System.currentTimeMillis();
		
		
		for(int i=0; i<500; i++) {
			Vector v1 = new Vector(2000, i);
			v1.procesar();
		}
		
		long t2 = System.currentTimeMillis();
		long tiempo = t2-t1;
		System.out.println(tiempo);
	}
		/*long tm1 = System.currentTimeMillis();
		
		Thread t1[] = new Thread[500];
		
		for(int i=0; i<500; i++) {
			t1[i] = new Thread(new VectorConcurrente(2000,i));
			t1[i].start();
		}
		for(int i=0; i<500; i++) {
			t1[i].join();
		}
		
		long tm2 = System.currentTimeMillis();
		long tiempo = tm2-tm1;
		System.out.println(tiempo);
	}*/

}
