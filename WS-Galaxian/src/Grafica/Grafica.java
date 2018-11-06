package Grafica;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Juego.*;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;

public class Grafica{
	private static JLabel lblPuntaje;
	private static JLabel lblVidaJugador;
	private static Juego juego;
	private static JFrame ventana;
	private static JPanel panelJuego;
	private static JPanel panelEstado;
	private static ThreadJugador threadJugador;
	private static ThreadNivel threadNivel;
	private static JLabel[] vidas;
	static int vidasJugador;
	private static Grafica grafico;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana = new JFrame();
					ventana.setBackground(Color.BLACK);
					ventana.getContentPane().setLayout(new FlowLayout());
					ventana.setTitle("Space Adventure");
					ImageIcon iconoVentana = new ImageIcon(this.getClass().getResource("/img/naveN.png"));
					ventana.setIconImage(iconoVentana.getImage());
					ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					JPanel panel = new JPanel();
					panel.setPreferredSize(new Dimension(800, 600));
					panel.setLayout(null);
					panel.setBackground(Color.BLACK);
					JLabel texto=new JLabel();
					texto.setBounds(150,40,520,520);
					Icon imagen=new ImageIcon(this.getClass().getResource("/img/videogame.png"));
				    texto.setIcon(imagen);
					panel.add (texto);
		
					panel.addMouseListener(new MouseListener(){
					      public void mouseClicked(MouseEvent me) {
					    	  ventana.remove(panel);
				            	grafico= new Grafica();
					        }
					        public void mousePressed(MouseEvent me) {}
					        public void mouseReleased(MouseEvent me) {}
					        public void mouseEntered(MouseEvent me) {}
					        public void mouseExited(MouseEvent me) {}
					      });
				
					ventana.getContentPane().add(panel);
					ventana.setBounds(0,0,800,660);
					
					JMenuBar menuBar = new JMenuBar();
					ventana.setJMenuBar(menuBar);
					
					JButton btnNewButton = new JButton("Reiniciar");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println("accion REINICIAR");
							ventana.dispose();
							main(new String[0]);
						}
					});
					menuBar.add(btnNewButton);
					
					JButton btnNewButton_1 = new JButton("Salir");
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println("accion SALIR");
							ventana.dispose();
						}
					});
					menuBar.add(btnNewButton_1);
					ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public  Grafica() {
		lblPuntaje = new JLabel();
		lblVidaJugador=new JLabel();
		panelJuego = new JPanel();
		vidasJugador=3;
		vidas=new JLabel[4];
		Icon vida = new ImageIcon(this.getClass().getResource("/img/heart.png"));
		int x=15;
		for(int i=0; i<vidas.length;i++) {
			vidas[i]=new JLabel();
			vidas[i].setIcon(vida);
			vidas[i].setBounds(x,0,120,70);
			x=x+30;
		}
		for(int i=0;i<3;i++)
			panelJuego.add(vidas[i]);
		
		juego = new Juego(this);
		panelJuego.setPreferredSize(new Dimension(800, 600));
		panelJuego.setLayout(null);
		panelJuego.setBackground(Color.BLACK);
		panelEstado = new JPanel();
		panelEstado.setPreferredSize(new Dimension(800, 600));
		panelEstado.setLayout(null);
		
		ventana.getContentPane().add(panelJuego);
		
        lblPuntaje.setText("0");
        lblPuntaje.setBounds(700,0,200,60);
        lblPuntaje.setFont(new java.awt.Font("Cooper Black", 0, 36)); 
        lblPuntaje.setForeground(Color.PINK);
        panelJuego.add(lblPuntaje);
        panelJuego.add(lblVidaJugador);
		ventana.pack();
		ventana.setVisible(true);
		threadJugador = new ThreadJugador(juego.getJugador());
	    threadNivel = new ThreadNivel(juego);
	    juego.iniciarNivel(threadNivel);
	    threadNivel.start();
		threadJugador.start();
	}

	public void actualizarGraficamente() {
		panelJuego.repaint();
	}

	public void eliminarGraficamente(JLabel l) {
		panelJuego.remove(l);
	}

	public void agregarGraficamente(JLabel l) {
		panelJuego.add(l);
	}

	public void cambiarPuntaje() {
		lblPuntaje.setText(juego.getJugador().getPuntaje() + "");
	}

	public Juego getJuego() {
		return juego;
	}
	
	public void gameOver() {
		JPanel contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(800, 600));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		JLabel texto=new JLabel();
		texto.setBounds(140,30,520,520);
		Icon imagen=new ImageIcon(this.getClass().getResource("/img/game-over.png"));
	    texto.setIcon(imagen);
		contentPane.add (texto);
		ventana.remove(panelJuego);
		ventana.getContentPane().add(contentPane);
		ventana.pack();
		ventana.repaint();

	}

	public void gameWin() {
		JPanel contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(800, 600));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		JLabel texto=new JLabel();
		texto.setBounds(150,20,520,520);
		Icon imagen=new ImageIcon(this.getClass().getResource("/img/win (1).png"));
	    texto.setIcon(imagen);
		contentPane.add (texto);
		ventana.remove(panelJuego);
		ventana.getContentPane().add(contentPane);
		ventana.pack();
		ventana.repaint();

		
	}
	
	public void pasoNivel(String s) {
		JPanel contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(800, 600));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		JLabel texto=new JLabel();
		texto.setBounds(138,35,520,520);
		Icon imagen=new ImageIcon(this.getClass().getResource("/img/rocket (1).png"));
	    texto.setIcon(imagen);
		contentPane.add (texto);
		ventana.remove(panelJuego);
		ventana.getContentPane().add(contentPane);
		ventana.pack();
		ventana.repaint();
		try {
			ThreadNivel.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ventana.remove(contentPane);
		contentPane.setVisible(false);
		ventana.getContentPane().add( panelJuego );
		ventana.pack();
		ventana.repaint();
	}
	
	public void addVida() {
		int cantVidas=juego.getJugador().getVidas();
		int numero=cantVidas-2;
		juego.insertarVida(vidas[numero]);
	}
	
	public void cambiarVida(int v) {
		juego.eliminarVida(vidas[v]);
	}
}
