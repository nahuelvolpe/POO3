package proyectMonitor;

public class Hilo implements Runnable{
	
	public Monitor control;
	public int estado;
	public long time;
	
	public Hilo(Monitor control, int estado, long time) {
		this.control=control;
		this.estado=estado;
		this.time=time;
	}

	
	public Monitor getControl() {
		return control;
	}



	public void setControl(Monitor control) {
		this.control = control;
	}



	public int getEstado() {
		return estado;
	}



	public void setEstado(int estado) {
		this.estado = estado;
	}

	


	public long getTime() {
		return time;
	}


	public void setTime(long time) {
		this.time = time;
	}


	@Override
	public void run() {
		
		try {
			Thread.sleep(this.getTime());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		if(this.getEstado() == 1) {
			try {
				control.esperar();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}else if(this.getEstado() == 2) {
			control.notificartodos();
		}
		
	}

}
