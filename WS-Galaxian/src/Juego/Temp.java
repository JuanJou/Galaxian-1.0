package Juego;

import Nivel.Nivel;

public class Temp extends Thread {
	private Nivel nivel;
	private int tiempo;
	private volatile boolean execute = true;

	public Temp(Nivel n) {
		nivel = n;
		tiempo = 500;
		nivel.pausarEntidades();
	}

	public void run() {
		while (execute) {
			try {
				Thread.sleep(100);
				tiempo -= 10;
				if (tiempo <= 0) {
					execute = false;
					nivel.reanudarEntidades();
				}
			} catch (InterruptedException e) {
			}
		}
	}

}
