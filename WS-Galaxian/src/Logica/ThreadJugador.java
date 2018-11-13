package Logica;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import Juego.Jugador;

public class ThreadJugador extends Thread {

	private int movimiento; // FLAG del movimiento
	private int tiempoPausa;
	private boolean ejecutar;
	private Jugador jugador;

	public ThreadJugador(Jugador j) {
		this.tiempoPausa = 20;
		this.jugador = j;
		ejecutar = true;
		movimiento = Jugador.STOPDER;
		setListener();
	}
	
	

	public void run() {
		while (ejecutar) {
			jugador.mover(movimiento);
			try {
				Thread.sleep(tiempoPausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void pausar() {
		ejecutar = false;
	}

	public void reiniciar() {
		ejecutar = true;
	}

	private class PlayerMovementAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		private int d;

		public PlayerMovementAction(int d) {
			this.d = d;
		}
		public void actionPerformed(ActionEvent e) {
			if (!(movimiento == Jugador.DERECHA && d == Jugador.STOPIZQ)
					&& !(movimiento == Jugador.IZQUIERDA && d == Jugador.STOPDER)) {
				movimiento = d;
			}
			if(jugador.pasoNivel()==true)
				jugador.pase(false);
	
			
		}
	}

	private class DisparoActionApretar extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
					jugador.estoyDisparando(true);
				
		
			}
		}

	
	
	private class DisparoActionSoltar extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
			jugador.estoyDisparando(false);
			
		}


	}
	


	public void setListener() {
		InputMap inputMap = jugador.getGrafico().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = jugador.getGrafico().getActionMap();

		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "mover derecha");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "mover parar derecha"); // soltó la tecla der
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "mover izquierda");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "mover parar izquierda"); // soltó la tecla izq
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "disparo");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "disparoapretar");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "disparosoltar");
		
		actionMap.put("mover derecha", new PlayerMovementAction(Jugador.DERECHA));
		actionMap.put("mover parar derecha", new PlayerMovementAction(Jugador.STOPDER));
		actionMap.put("mover parar izquierda", new PlayerMovementAction(Jugador.STOPIZQ));
		actionMap.put("mover izquierda", new PlayerMovementAction(Jugador.IZQUIERDA));
		actionMap.put("disparoapretar", new DisparoActionApretar());
		actionMap.put("disparosoltar", new DisparoActionSoltar());
	}
	
}
