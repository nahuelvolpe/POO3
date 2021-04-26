package proyectMonitor;

public class Monitor {
	
	public Monitor() {}
	
	public synchronized void esperar() throws InterruptedException {
		System.out.println("Esperando");
		this.wait();
	}
	
	public synchronized void notificar() {
		System.out.println("Notificado");
		this.notify();
	}
	
	public synchronized void notificartodos() {
		System.out.println("Todos notificados");
		this.notifyAll();
	}
	

}
