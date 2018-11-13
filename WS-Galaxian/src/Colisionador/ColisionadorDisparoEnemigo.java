package Colisionador;

import Disparo.*;
import Enemigo.Enemigo;
import Juego.Jugador;
import Obstaculo.*;
import Premio.Premio;

public class ColisionadorDisparoEnemigo extends Colisionador {

	private DisparoEnemigo disparo;

	public ColisionadorDisparoEnemigo(DisparoEnemigo d) {
		fuerzaImpacto = d.getImpacto();
		disparo = d;
	}

	public void atacarJugador(Jugador j) {
		j.restarPorcentajeVida(fuerzaImpacto);
		disparo.cambiarGrafico(1);
		
		disparo.aniquilado();
	}

	public void atacarEnemigo(Enemigo e) {
	}

	public void atacarDisparo(Disparo d) {
	}

	public void atacarPremio(Premio p) {
	}
	
	public void atacarObstaculo(Destruible d) {
		d.setPorcentajeVida(d.getPorcentajeVida() - fuerzaImpacto);
		disparo.cambiarGrafico(1);
		
		disparo.aniquilado();
		
	}
	
	public void atacarObstaculo(Barricada b) {};

}
