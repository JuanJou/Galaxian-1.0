package Obstaculo;

import java.awt.Point;
import Colisionador.*;
import Comportamiento.*;
import Juego.*;

public abstract class Obstaculo extends Entidad {

	public Obstaculo(Point pos) {
		super(pos);
		comportamiento = new MovimientoObstaculo(this);
	}

	public void aniquilado(){
		estaAniquilado = true;
	}

	public void actualizar(){
		if(porcentajeVida>0)
			moverme();
		else
			aniquilado();
	}
	

	public void pausar() {

	}

	public void reanudar() {

	}
	
	public void ponerEscudo() {
	}
	
	public void sacarEscudo() {
	}
	
	public abstract void meAtacan(Colisionador c) ;
	
}
