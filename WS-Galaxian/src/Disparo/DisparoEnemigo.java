package Disparo;

import java.awt.Point;
import javax.swing.ImageIcon;
import Colisionador.Colisionador;
import Colisionador.ColisionadorDisparoEnemigo;
import Colisionador.ColisionadorNeutro;
import Comportamiento.DisparaAbajo;

public final class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(Point pos, int fuerzaImpacto) {
		super(pos, fuerzaImpacto);
		this.colisionador = new ColisionadorDisparoEnemigo(this);
		comportamiento=new DisparaAbajo(this);
	}

	public void actualizar() {
		if (porcentajeVida > 0) 
			moverme();
		else
			aniquilado();
		super.actualizar();
	}

	public void meAtacan(Colisionador c) {
		c.atacarDisparo(this);
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/disparoEN.png"));
		this.libreriaImagenes[1] = new ImageIcon(this.getClass().getResource("/img/Explosion.png"));
	}

	public void aniquilado() {
		estaAniquilado = true;
	}
	
	public void ponerEscudo() {
		colisionador=new ColisionadorNeutro();
	}
	
	public void sacarEscudo() {
		colisionador=new ColisionadorDisparoEnemigo(this);
	}
	

}
