package proyectMonitor;

public class Main {

	public static void main(String[] args) {
		
		Monitor miMonitor = new Monitor();
		
		Hilo h1 = new Hilo(miMonitor, 1, 2000);
		Hilo h2 = new Hilo(miMonitor, 1, 2000);
		Hilo h3 = new Hilo(miMonitor, 1, 3000);
		Hilo h4 = new Hilo(miMonitor, 2, 4000);
		Hilo h5 = new Hilo(miMonitor, 2, 1000);

		Thread t1 = new Thread(h1);
		Thread t2 = new Thread(h2);
		Thread t3 = new Thread(h3);
		Thread t4 = new Thread(h4);
		Thread t5 = new Thread(h5);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	
	}

}
