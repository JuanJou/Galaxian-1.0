package Colisionador;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Juego.InterfazJuego;
import Juego.Jugador;
import Obstaculo.*;
import Premio.Premio;

public class ColisionadorEscudo extends Colisionador {
	
	private InterfazJuego juego;

	public ColisionadorEscudo(InterfazJuego juego) {
		fuerzaImpacto = 10;
		this.juego=juego;
	}

	public void atacarJugador(Jugador j) {
	}

	public void atacarEnemigo(Enemigo e) {
		e.tieneEscudo(fuerzaImpacto);
		if(!e.estaAniquilado())
			e.setPorcentajeVida(e.getPorcentajeVida() - fuerzaImpacto);
	}

	public void atacarDisparo(Disparo d) {
	}

	public void atacarPremio(Premio p) {
		p.meActivo(juego);
		p.setPorcentajeVida(0);
	}
	

	public void atacarObstaculo(Destruible d) {}
	
	public void atacarObstaculo(Barricada b) {}
}
