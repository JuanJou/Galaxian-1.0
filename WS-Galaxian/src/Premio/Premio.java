package Premio;

import java.awt.Point;

import Colisionador.Colisionador;
import Colisionador.ColisionadorNeutro;
import Comportamiento.*;
import Juego.*;

public abstract class Premio extends Entidad {

	public Premio(Point pos) {
		super(pos);
		comportamiento = new MovimientoPremio(this);
		colisionador = new ColisionadorNeutro();
	}

	public void meAtacan(Colisionador c) {
		c.atacarPremio(this);
	}
	
	public void aniquilado(){
		estaAniquilado=true;
	}

	public void actualizar(){
		if(porcentajeVida>0)
			moverme();
		else
			aniquilado();
	}
	
	public abstract void meActivo(InterfazJuego j);
	
	public void pausar() {
	}

	public void reanudar() {
	}
	
	public void ponerEscudo() {
	}
	
	public void sacarEscudo() {
	}
	
}
