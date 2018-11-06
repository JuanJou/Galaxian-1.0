package Colisionador;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Juego.Jugador;
import Obstaculo.*;
import Premio.Premio;

public class ColisionadorMolestiaJugador extends Colisionador {

	public void atacarJugador(Jugador j) {
	}

	public void atacarEnemigo(Enemigo e) {
	}

	public void atacarDisparo(Disparo d) {
		d.aniquilado();
	}

	public void atacarPremio(Premio p) {
	}

	public void atacarObstaculo(Destruible d) {

	}
	
	public void atacarObstaculo(Barricada b) {};

}
