package Premio;

import java.awt.Point;
import javax.swing.ImageIcon;
import Juego.*;

public class Vida extends PrototipoPremio {

	public Vida(Point pos) {
		super(pos);
		setGraficos();
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/heart.png"));
	}

	public void meActivo(InterfazJuego juego) {
		Jugador jugador = juego.getJugador();
		jugador.restablecerPorcentajeVida();
		jugador.agregarVida();
		if(jugador.getVidas()<6)
			jugador.getJuego().getGrafica().addVida();
		
	}
	
	public PrototipoPremio clone() {
		Vida clon = new Vida(new Point(this.pos.x, this.pos.y));
		return clon;
	}

}
