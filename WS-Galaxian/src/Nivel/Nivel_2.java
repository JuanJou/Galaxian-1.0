package Nivel;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;

import Enemigo.Enemigo;
import Enemigo.PrototipoEnemigo;
import Grafica.*;
import Juego.Juego;
import Juego.ThreadNivel;
import Obstaculo.*;
import Premio.Premio;

public class Nivel_2 extends Nivel {
	
	public Nivel_2(Juego j) {
		super(j);
		FONDO = new ImageIcon(this.getClass().getResource("/img/Fondo1.png"));
		FILAS = 3;
	}

	public void iniciarNivel(Grafica g,ThreadNivel t) {
		g.pasoNivel("Nivel 2");
		threadNivel=t;
		generarEnemigos();
		generarObstaculos();
	}

	
	public Nivel nivelSiguiente() {
		return new Nivel_3(juego);
	}

	public void generarEnemigos() {
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
				enemigosGenerados.add(nuevoEnemigo);
				posicionHorizontal += DIST_HORIZONTAL;
			}
			posicionVertical += DIST_VERTICAL;
		}
		generarPremios(enemigosGenerados);
	}

	protected void generarPremios(LinkedList<PrototipoEnemigo> enemigosGenerados) {
		Random rnd =new Random();
		Enemigo e = enemigosGenerados.get(rnd.nextInt(enemigosGenerados.size()));
        Premio miPremio = prototiposPremios.get(rnd.nextInt(prototiposPremios.size()));
        e.asignarPremio(miPremio);
        e = enemigosGenerados.get(rnd.nextInt(enemigosGenerados.size()));
        miPremio = prototiposPremios.get(rnd.nextInt(prototiposPremios.size()));
        e.asignarPremio(miPremio);
	}

	public void generarObstaculos() {
		Obstaculo o = new Destruible(new Point(300, 300));
		juego.insertarEnLista(o);
	}


	
}
