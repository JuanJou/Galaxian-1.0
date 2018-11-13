package Colisionador;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Juego.*;
import Obstaculo.*;
import Premio.Premio;
import Logica.*;

public class ColisionadorJugador extends Colisionador {

	public ColisionadorJugador() {
		fuerzaImpacto = 10;
		
	}

	public void atacarJugador(Jugador j) {
	}

	public void atacarEnemigo(Enemigo e) {
		e.setPorcentajeVida(e.getPorcentajeVida() - fuerzaImpacto);
		Sound.CRASH.play();
	}

	public void atacarDisparo(Disparo d) {
		Sound.CRASH.play();
	}

	public void atacarPremio(Premio p) {
		p.meActivo();
		p.setPorcentajeVida(0);
		Sound.PO.play();
	}

	public void atacarObstaculo(Destruible d) {
	}
	
	public void atacarObstaculo(Barricada b) {
	};
}
