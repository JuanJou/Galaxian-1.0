package Nivel;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Enemigo.Enemigo;
import Enemigo.PrototipoEnemigo;
import Logica.*;
import Juego.Juego;
import Obstaculo.*;
import Premio.Premio;

public class Nivel_4 extends Nivel {
	
	public Nivel_4(Juego j) {
		super(j);
		FILAS = 4;
		Icon i= new ImageIcon(this.getClass().getResource("/img/nivel4.png"));
		FONDO = new JLabel();
		FONDO.setIcon(i);
		FONDO.setBounds(160,100,512,512);
	}

	public void iniciarNivel(Grafica g,ThreadNivel t) {
		g.pasoNivel("4");
		threadNivel=t;
		generarEnemigos();
		generarObstaculos();
	}

	
	public Nivel nivelSiguiente() {
		return new Nivel_5(juego);
	}

	protected void generarEnemigos() {
		PrototipoEnemigo nuevoEnemigo,prot;
		Random rnd;
		LinkedList<PrototipoEnemigo> enemigosGenerados =new LinkedList<PrototipoEnemigo>();
		int posicionVertical = 0;
		int posicionHorizontal = 60;
		for (int i = 0; i < FILAS; ++i) {
			posicionHorizontal = 60;
			for (int j = 0; j < ENEMIGOSXFILA; j++) {
				rnd = new Random();
				prot = prototiposEnemigos.get(rnd.nextInt(prototiposEnemigos.size()));
				nuevoEnemigo = prot.clone();
				nuevoEnemigo.setPos(posicionHorizontal, posicionVertical);
				juego.insertarEnLista(nuevoEnemigo);
				juego.sumarEnemigo();
				enemigosGenerados.add(nuevoEnemigo);
				posicionHorizontal += DIST_HORIZONTAL;
			}
			posicionVertical += DIST_VERTICAL;
		}
		generarPremios(enemigosGenerados);
	}

	private void generarPremios(LinkedList<PrototipoEnemigo> enemigosGenerados) {
		Random rnd =new Random();
		Enemigo e = enemigosGenerados.get(rnd.nextInt(enemigosGenerados.size()));
        Premio miPremio = prototiposPremios.get(rnd.nextInt(prototiposPremios.size()));
        e.asignarPremio(miPremio);
        e = enemigosGenerados.get(rnd.nextInt(enemigosGenerados.size()));
        miPremio = prototiposPremios.get(rnd.nextInt(prototiposPremios.size()));
        e.asignarPremio(miPremio);
	}

	protected void generarObstaculos() {
		Obstaculo o = new Destruible(new Point(700, 100));
		juego.insertarEnLista(o);
		o = new Barricada(new Point(0, 400));
		juego.insertarEnLista(o);
	}


	
}
