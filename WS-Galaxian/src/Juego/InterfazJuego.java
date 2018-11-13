package Juego;

import Logica.*;
import Nivel.Nivel;

public interface InterfazJuego {
	public Jugador getJugador();
	public Nivel getNivel();
	public Grafica getGrafica();
}
