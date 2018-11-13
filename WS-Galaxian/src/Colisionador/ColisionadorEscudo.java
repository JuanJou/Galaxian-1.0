package Colisionador;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Juego.Jugador;
import Obstaculo.*;
import Premio.Premio;

public class ColisionadorEscudo extends Colisionador {
	
	public ColisionadorEscudo() {
		fuerzaImpacto = 10;
	}

	public void atacarJugador(Jugador j) {
	}

	public void atacarEnemigo(Enemigo e) {
		e.tieneEscudo(fuerzaImpacto);
		
	}

	public void atacarDisparo(Disparo d) {
	}

	public void atacarPremio(Premio p) {
		p.meActivo();
		p.setPorcentajeVida(0);
	}
	

	public void atacarObstaculo(Destruible d) {}
	
	public void atacarObstaculo(Barricada b) {}
}
