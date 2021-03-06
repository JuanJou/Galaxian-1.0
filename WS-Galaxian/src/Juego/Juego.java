package Juego;

import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JLabel;

import Grafica.*;
import Nivel.*;

public class Juego implements InterfazJuego {
	private Nivel nivel;
	private Jugador jugador;
	private Grafica grafica;
	private LinkedList<Entidad> aInsertar;
	private LinkedList<Entidad> aRecorrer;
	private LinkedList<Entidad> aEliminar;
	private LinkedList<JLabel> vidaAinsertar;
	private LinkedList<JLabel> vidaAeliminar;
	
	public Juego(Grafica g) {
		crearJugador();
		grafica = g;
		nivel = new Nivel_1(this);
		aInsertar = new LinkedList<Entidad>();
		aRecorrer = new LinkedList<Entidad>();
		aEliminar = new LinkedList<Entidad>();
		vidaAinsertar=new LinkedList<JLabel>();
		vidaAeliminar=new LinkedList<JLabel>();
	}
	public void iniciarNivel( ThreadNivel t) {
		nivel.iniciarNivel(grafica, t);
	}

	public void crearJugador() {
		jugador = new Jugador(new Point(800 / 2, 600 - 80), this);
	}

	public Jugador getJugador() {
		return jugador;
	}

	public Grafica getGrafica() {
		return grafica;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public int getPuntaje() {
		return jugador.getPuntaje();
	}
	
	public int getVidas() {
		return jugador.getVidas();
	}

	public void gameWin() {
		grafica.gameWin();
	}

	public void gameOver() {
		nivel.getThread().detenerThread();
		grafica.gameOver();
	}
	
	public void pausarEntidades() {
		for(Entidad e: aRecorrer) {
			e.pausar();
		}
	}
	
	
	public void reanudarEntidades() {
		for(Entidad e: aRecorrer) {
			e.reanudar();
		}
	}
	
	public void ponerEscudo() {
		for(Entidad e:aRecorrer) {
			e.ponerEscudo();
		}
	}
	
	public void sacarEscudo() {
		for(Entidad e:aRecorrer) {
			e.sacarEscudo();
		}
	}
	
	
	public void actualizar() {
		for (Entidad e : aRecorrer) {
			e.actualizar();
			if (e.estaAniquilado()) {
				aEliminar.add(e);
				grafica.getJuego().getJugador().sumarPuntaje(e.getPuntaje());
				grafica.cambiarPuntaje();
			}
		}
		grafica.actualizarGraficamente();
	}

	public void insertarEnLista(Entidad e) {
		aInsertar.add(e);
	}

	/**
	 * Inserta logica y graficamente la entidad
	 */
	public void insertarARecorrer() {
		for (Entidad e: aInsertar) {
			if (e != null) {
				grafica.agregarGraficamente(e.getGrafico());
				aRecorrer.add(e);
			}
		}
		for(JLabel l: vidaAinsertar)
			grafica.agregarGraficamente(l);
			
		aInsertar.clear();
		vidaAinsertar.clear();
	}
	
	public void insertarVida(JLabel l) {
		vidaAinsertar.add(l);
	}
	
	public void eliminarVida(JLabel l) {
		vidaAeliminar.add(l);
	}


	public void removerEliminados() {
		for (Entidad entidadRemovida: aEliminar) {
			if(entidadRemovida != null) {
				grafica.eliminarGraficamente(entidadRemovida.getGrafico());
				aRecorrer.remove(entidadRemovida);
			}
		}
		for(JLabel l: vidaAeliminar)
			grafica.eliminarGraficamente(l);
		aEliminar.clear();
		vidaAeliminar.clear();
	}

	public void controlarColisiones() {
		for (Entidad entidad1 : aRecorrer)
			for (Entidad entidad2 : aRecorrer) {
				if (entidad1 != entidad2) {
					if (hayColision(entidad1, entidad2) || hayColision(entidad2, entidad1))
						entidad1.atacar(entidad2);
				}
			}
	}

	public boolean hayColision(Entidad a, Entidad b) {
		boolean retorno;
		if ((Math.abs(a.getPos().x - b.getPos().x) < 40) && (Math.abs(a.getPos().y - b.getPos().y) < 40))
			retorno = true;
		else
			retorno = false;
		return retorno;
	}

	public void controlarNivel(ThreadNivel threadNivel) {
		if (aRecorrer.size() == 1) {
			if(nivel.haySiguiente()==true) {
				jugador.cambiarGrafico(0);
				nivel=nivel.nivelSiguiente();
				nivel.iniciarNivel(grafica,threadNivel);
			}
			else {
				threadNivel.detenerThread();
				grafica.gameWin();}
		}
	}

	
}
