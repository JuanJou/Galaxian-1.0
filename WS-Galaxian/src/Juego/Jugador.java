package Juego;

import java.awt.Point;
import Colisionador.*;

import javax.swing.ImageIcon;
import Colisionador.Colisionador;
import Disparo.*;

public class Jugador extends Entidad {
	private int cantVidas;
	private Juego juego;
	private FabricaDisparos fabricaDisparo;
	private int cantDisparoSuper;

	public static final int DERECHA = 1, IZQUIERDA = -1, STOPDER = 2, STOPIZQ = -2;

	public Jugador(Point pos, Juego juego) {
		super(pos);
		setGraficos();
		this.juego = juego;
		colisionador = new ColisionadorJugador(juego);
		fabricaDisparo = new FabricaSimple(juego);
		cantVidas = 3;
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/naveN.png"));
		this.libreriaImagenes[1] = new ImageIcon(this.getClass().getResource("/img/naveNE.png"));
	}

	public void setFabrica(FabricaDisparos fabrica) {
		fabricaDisparo = fabrica;
	}

	public void restarPorcentajeVida(int fuerzaImpacto) {
		if (!estaAniquilado()) {
			if (porcentajeVida - fuerzaImpacto <= 0)
				morir();
			else
				porcentajeVida = porcentajeVida - fuerzaImpacto;
		}
	}

	public void restablecerPorcentajeVida() {
		porcentajeVida = 100;
	}

	public int getVidas() {
		return cantVidas;
	}

	public void agregarVida() {
		cantVidas = cantVidas + 1;
	}

	public void disparar() {
		if (cantDisparoSuper > 0)
			fabricaDisparo.crearDisparo(getPos().x, getPos().y - 20);
		else
			fabricaDisparo.crearDisparo(getPos().x, getPos().y - 20);
	}

	public void sumarPuntaje(int sum) {
		puntaje = puntaje + sum;
	}

	public void aniquilado() {
		juego.gameOver();
	}

	// pierde una vida
	protected void morir() {
		if (cantVidas > 1) {
			porcentajeVida = 100;
			if (cantVidas > 4) {
				juego.getGrafica().cambiarVida(3);
				cantVidas = 3;
			} else {
				juego.getGrafica().cambiarVida(cantVidas - 1);
				cantVidas = cantVidas - 1;
			}

		} else
			aniquilado();
	}

	public void meAtacan(Colisionador c) {
		c.atacarJugador(this);
	}

	public void mover(int d) {
		int velocidad = 10;

		switch (d) {
		case DERECHA:
			if (getPos().x < 720) {
				getPos().setLocation(getPos().x + velocidad, getPos().y);
				getGrafico().setBounds(getPos().x, getPos().y, ANCHO_SPRITE, ALTO_SPRITE);
			}
			break;
		case IZQUIERDA:
			if (getPos().x > 0) {
				setPos(getPos().x - velocidad, getPos().y);
				getGrafico().setBounds(getPos().x, getPos().y, ANCHO_SPRITE, ALTO_SPRITE);
			}
			break;
		}

		getGrafico().repaint();
	}

	public void actualizar() {
	}

	public void pausar() {
	}

	public void reanudar() {
	}

	public Juego getJuego() {
		return juego;
	}

	public void ponerEscudo() {
		cambiarGrafico(1);
		colisionador = new ColisionadorEscudo(juego);
	}

	public void sacarEscudo() {
		cambiarGrafico(0);
		colisionador = new ColisionadorJugador(juego);
	}
}
