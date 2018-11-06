package Juego;

import Colisionador.*;
import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;
import Comportamiento.*;

public abstract class Entidad{
	protected final int ANCHO_SPRITE = 80;
	protected final int ALTO_SPRITE = 80;
	protected JLabel sprite;
	protected Icon libreriaImagenes[];
	protected int porcentajeVida;
	protected int puntaje;
	protected Point pos;
	protected Comportamiento comportamiento;
	protected Colisionador colisionador;
	protected boolean estaAniquilado;
	protected InterfazJuego juego;
	
	protected Entidad(Point pos) {
		this.pos = pos;
		libreriaImagenes = new Icon[2];
		porcentajeVida = 100;
		puntaje = 0;
		setGraficos();
	}

	public Point getPos() {
		return pos;
	}

	public boolean estaAniquilado(){
		return estaAniquilado;
	}

	public void setPos(int x, int y) {
		pos.setLocation(x, y);
		getGrafico().setBounds(x,y,ANCHO_SPRITE, ALTO_SPRITE);
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int nuevoPuntaje) {
		puntaje = nuevoPuntaje;
	}
	
	public JLabel getGrafico() {
		if (sprite == null) {
			sprite = new JLabel(libreriaImagenes[0]);
			sprite.setBounds(this.pos.x, this.pos.y, ANCHO_SPRITE, ALTO_SPRITE);
		}
		return sprite;
	}

	protected abstract void setGraficos();

	public void cambiarGrafico(int dir) {
		if (this.sprite != null) {
			this.sprite.setIcon(this.libreriaImagenes[dir]);
			this.sprite.setBounds(this.pos.x, this.pos.y, ANCHO_SPRITE, ALTO_SPRITE);
		}
	}

	public void setComportamiento(Comportamiento c) {
		comportamiento = c;
	}

	public void setPorcentajeVida(int v) {
		porcentajeVida = v;
	}

	public int getPorcentajeVida() {
		return porcentajeVida;
	}

	public abstract void aniquilado();

	public abstract void actualizar();

	public abstract void meAtacan(Colisionador c);

	public void atacar(Entidad e) {
		e.meAtacan(colisionador);
	}

	public void moverme() {
		comportamiento.activar();
	}
	
	public abstract void pausar();

	public abstract void reanudar();
	
	public abstract void ponerEscudo();
	
	public abstract void sacarEscudo();
	
}
