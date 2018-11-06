package Juego;

public class ThreadNivel extends Thread {
	private Juego juego;

	private volatile boolean ejecutar;

	public ThreadNivel(Juego j) {
		juego=j;
	}
	
	public void detenerThread() {
		ejecutar = false;
	}
	
	
	public void run() {
		long lastTime = System.nanoTime();
		double fps = 30.0; ////////////////// FPS
		double ns = 1000000000 / fps;
		double delta = 0;
		
		this.ejecutar = true;
	
		while (ejecutar) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				juego.insertarARecorrer();
				juego.controlarColisiones();
				juego.removerEliminados();
				juego.actualizar();
				//aca iba controlarColisiones
				//aca removerEliminados
				juego.controlarNivel(this);
				delta--;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}