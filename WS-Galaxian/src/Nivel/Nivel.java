package Nivel;

import java.awt.Point;
import java.util.LinkedList;
import javax.swing.JLabel;

import Disparo.FabricaDisparoEnemigo;
import Premio.*;
import Enemigo.*;
import Juego.Entidad;
import Juego.Juego;
import Logica.*;



public abstract class Nivel implements InterfazNivel {
	//ATRIBUTOS DEL JUEGO
	protected static final int ALTURA_JUEGO = 800;
	protected static final int ANCHURA_JUEGO = 600;
	protected static final int ENEMIGOSXFILA = 6;
	protected static final int DIST_HORIZONTAL = 120;
	protected static final int DIST_VERTICAL = 64;
	protected int FILAS;
	protected JLabel FONDO;
	protected LinkedList<PrototipoEnemigo> prototiposEnemigos;
	protected LinkedList<PrototipoPremio> prototiposPremios;
	protected ThreadNivel threadNivel;
	protected Juego juego;
	

	public Nivel(Juego juego){
		this.juego = juego;
		prototiposEnemigos = new LinkedList<PrototipoEnemigo>();
		prototiposPremios= new LinkedList<PrototipoPremio>();
		generarPrototiposEnemigos();
		generarPrototiposPremios();
	
	}
	
	

	public abstract void iniciarNivel(Grafica g,ThreadNivel t);
	
	public abstract Nivel nivelSiguiente();
	
	public JLabel getFondo() {
		return FONDO;
	}
	


	protected void generarPrototiposEnemigos() {
		Point inicial = new Point(0, 0);
		PrototipoEnemigo bomba = new Bomba(inicial, new FabricaDisparoEnemigo(juego),juego);
		prototiposEnemigos.add(bomba);
		PrototipoEnemigo perdedor = new Perdedor(inicial, new FabricaDisparoEnemigo(juego), juego);
		prototiposEnemigos.add(perdedor);
		PrototipoEnemigo debil = new Debil(inicial, new FabricaDisparoEnemigo(juego), juego);
		prototiposEnemigos.add(debil);
		PrototipoEnemigo distraido = new Distraido(inicial, new FabricaDisparoEnemigo(juego), juego);
		prototiposEnemigos.add(distraido);
		PrototipoEnemigo kamikaze = new Kamikaze(inicial, new FabricaDisparoEnemigo(juego), juego);
		prototiposEnemigos.add(kamikaze);
	}
	
	protected void generarPrototiposPremios(){
        Point inicial = new Point(0, 0);
        PrototipoPremio detenerTiempo = new DetenerTiempo(inicial,juego);
        prototiposPremios.add(detenerTiempo);
        PrototipoPremio vida = new Vida(inicial,juego);
        prototiposPremios.add(vida);
        PrototipoPremio superDisparo = new SuperDisparo(inicial,juego);
        prototiposPremios.add(superDisparo); 
        PrototipoPremio escudo=new Escudo(inicial,juego);
        prototiposPremios.add(escudo);
        PrototipoPremio mejora=new MejoraArmaDoble(inicial,juego);
        prototiposPremios.add(mejora);
        mejora=new MejoraArmaTriple(inicial,juego);
        prototiposPremios.add(mejora);
        
        
    }

	
	protected abstract void generarEnemigos();

	protected abstract void generarObstaculos();
	
	public void agregarEntidadEnLista(Entidad e) {
		juego.insertarEnLista(e);
	}
	
	public ThreadNivel getThread() {
		return threadNivel;
	}
	
	public boolean haySiguiente() {
		return nivelSiguiente()!=null;
	}
	
	public void pausarEntidades() {
		juego.pausarEntidades();
	}
	
	public void reanudarEntidades() {
		juego.reanudarEntidades();
	}
	
	public void ponerEscudo() {
		juego.ponerEscudo();
	}
	
	public void sacarEscudo() {
		juego.sacarEscudo();
	}
	
	public void restarEnemigo() {
		juego.restarEnemigo();
	}
}
