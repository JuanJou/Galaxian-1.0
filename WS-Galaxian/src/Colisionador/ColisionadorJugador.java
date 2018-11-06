package Colisionador;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Juego.*;
import Obstaculo.*;
import Premio.Premio;

public class ColisionadorJugador extends Colisionador {

	private InterfazJuego juego;

	public ColisionadorJugador(InterfazJuego juego) {
		fuerzaImpacto = 10;
		this.juego=juego;
	}

	public void atacarJugador(Jugador j) {
	}

	public void atacarEnemigo(Enemigo e) {
		e.setPorcentajeVida(e.getPorcentajeVida() - fuerzaImpacto);
	}

	public void atacarDisparo(Disparo d) {
	}

	public void atacarPremio(Premio p) {
		p.meActivo(juego);
		p.setPorcentajeVida(0);
	}

	public void atacarObstaculo(Destruible d) {
	}
	
	public void atacarObstaculo(Barricada b) {
	};
}
