package Disparo;

import java.awt.Point;
import javax.swing.ImageIcon;
import Colisionador.Colisionador;

public final class DisparoSuper extends DisparoJugador {

	public DisparoSuper(Point pos, int fuerzaImpacto) {
		super(pos, fuerzaImpacto);
	}

	public void actualizar() {
		if (porcentajeVida > 0) 
			moverme();
		else
			aniquilado();
		super.actualizar();
	}

	protected void setGraficos() {
		this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/disparoSuper.png"));
		this.libreriaImagenes[1] = new ImageIcon(this.getClass().getResource("/img/Explosion.png"));
	}

	public void meAtacan(Colisionador c) {
	}

	public void aniquilado() {
		estaAniquilado = true;
	}

	
}
