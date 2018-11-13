package Obstaculo;


import Colisionador.*;
import Comportamiento.ObstaculoMolesto;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Barricada extends Obstaculo {

	public Barricada(Point pos) {
		super(pos);
		setGraficos();
		colisionador = new ColisionadorNeutro();
		comportamiento = new ObstaculoMolesto(this);
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/obstaculo2.png"));
		this.libreriaImagenes[1] = new ImageIcon(this.getClass().getResource("/img/Explosion.png"));
	}

	public void meAtacan(Colisionador c) {
		c.atacarObstaculo(this);
	}
	
	public void ponerEscudo() {
	}
	
	public void sacarEscudo() {
	}
}
