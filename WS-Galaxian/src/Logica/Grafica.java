package Logica;

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

public class Grafica {
	private static JLabel lblPuntaje;
	private static Juego juego;
	private static JFrame ventana;
	private static JPanel panelJuego;
	private static JPanel panelEstado;
	private static ThreadJugador threadJugador;
	private static ThreadNivel threadNivel;
	private static JLabel[] vidas;
	static int vidasJugador;
	static JLabel text;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana = new JFrame();
					ventana.setBackground(Color.BLACK);
					ventana.setLayout(new FlowLayout());
					ventana.setTitle(" Space Adventure");
					ImageIcon iconoVentana = new ImageIcon(this.getClass().getResource("/img/naveN.png"));
					ventana.setIconImage(iconoVentana.getImage());
					ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					JPanel panel = new JPanel();
					panel.setPreferredSize(new Dimension(800, 600));
					panel.setLayout(null);
					panel.setBackground(Color.BLACK);
					JLabel texto = new JLabel();
					texto.setBounds(150, 40, 520, 520);
					Icon imagen = new ImageIcon(this.getClass().getResource("/img/videogame.png"));
					texto.setIcon(imagen);
					panel.add(texto);
					Sound.PRI.play();
					panel.addMouseListener(new MouseListener() {
						public void mouseClicked(MouseEvent me) {
							Sound.BEGIN.play();
							ventana.remove(panel);
							new Grafica();
						}

						public void mousePressed(MouseEvent me) {
						}

						public void mouseReleased(MouseEvent me) {
						}

						public void mouseEntered(MouseEvent me) {
						}

						public void mouseExited(MouseEvent me) {
						}
					});

					ventana.add(panel);
					ventana.pack();
					ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public Grafica() {
		lblPuntaje = new JLabel();
		panelJuego = new JPanel();
		vidasJugador = 3;
		vidas = new JLabel[4];
		Icon vida = new ImageIcon(this.getClass().getResource("/img/heart.png"));
		int x = 15;
		for (int i = 0; i < vidas.length; i++) {
			vidas[i] = new JLabel();
			vidas[i].setIcon(vida);
			vidas[i].setBounds(x, 0, 120, 70);
			x = x + 30;
		}
		for (int i = 0; i < 3; i++)
			panelJuego.add(vidas[i]);

		juego = new Juego(this);
		panelJuego.setPreferredSize(new Dimension(800, 600));
		panelJuego.setLayout(null);
		panelJuego.setBackground(Color.BLACK);
		panelEstado = new JPanel();
		panelEstado.setPreferredSize(new Dimension(800, 600));
		panelEstado.setLayout(null);

		ventana.add(panelJuego);

		lblPuntaje.setText("0");
		lblPuntaje.setBounds(700, 0, 200, 60);
		lblPuntaje.setFont(new java.awt.Font("Cooper Black", 0, 36));
		lblPuntaje.setForeground(Color.PINK);
		panelJuego.add(lblPuntaje);
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

	public void agregarPanel(JLabel l) {
		panelJuego.add(l);
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
		JLabel texto = new JLabel();
		texto.setBounds(140, 30, 520, 520);
		Icon imagen = new ImageIcon(this.getClass().getResource("/img/game-over.png"));
		texto.setIcon(imagen);
		contentPane.add(texto);
		ventana.remove(panelJuego);
		Sound.OVER.play();
		ventana.add(contentPane);
		ventana.pack();
		ventana.repaint();
		contentPane.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent me) {

				Sound.PRI.play();
				JPanel contentPan = new JPanel();
				contentPan.setPreferredSize(new Dimension(800, 600));
				contentPan.setLayout(null);
				contentPan.setBackground(Color.BLACK);
				JLabel texto = new JLabel();
				texto.setBounds(140, 30, 520, 520);
				Icon imagen = new ImageIcon(this.getClass().getResource("/img/videogame.png"));
				texto.setIcon(imagen);
				contentPan.add(texto);
				ventana.remove(contentPane);
				ventana.add(contentPan);
				ventana.pack();
				ventana.repaint();
				contentPan.addMouseListener(new MouseListener() {
					public void mouseClicked(MouseEvent me) {
						Sound.BEGIN.play();
						ventana.remove(contentPan);
						new Grafica();
					}

					public void mousePressed(MouseEvent me) {
					}

					public void mouseReleased(MouseEvent me) {
					}

					public void mouseEntered(MouseEvent me) {
					}

					public void mouseExited(MouseEvent me) {
					}
				});
			}

			public void mousePressed(MouseEvent me) {
			}

			public void mouseReleased(MouseEvent me) {
			}

			public void mouseEntered(MouseEvent me) {
			}

			public void mouseExited(MouseEvent me) {
			}
		});

	}

	public void gameWin() {
		JPanel contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(800, 600));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		JLabel texto = new JLabel();
		texto.setBounds(150, 45, 520, 520);
		Icon imagen = new ImageIcon(this.getClass().getResource("/img/winn.png"));
		texto.setIcon(imagen);
		contentPane.add(texto);
		ventana.remove(panelJuego);
		Sound.WIN.play();
		ventana.add(contentPane);
		ventana.pack();
		ventana.repaint();
		contentPane.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent me) {

				Sound.PRI.play();
				JPanel contentPan = new JPanel();
				contentPan.setPreferredSize(new Dimension(800, 600));
				contentPan.setLayout(null);
				contentPan.setBackground(Color.BLACK);
				JLabel texto = new JLabel();
				texto.setBounds(140, 30, 520, 520);
				Icon imagen = new ImageIcon(this.getClass().getResource("/img/videogame.png"));
				texto.setIcon(imagen);
				contentPan.add(texto);
				ventana.remove(contentPane);
				ventana.add(contentPan);
				ventana.pack();
				ventana.repaint();
				contentPan.addMouseListener(new MouseListener() {
					public void mouseClicked(MouseEvent me) {
						Sound.BEGIN.play();
						ventana.remove(contentPan);
						new Grafica();
					}

					public void mousePressed(MouseEvent me) {
					}

					public void mouseReleased(MouseEvent me) {
					}

					public void mouseEntered(MouseEvent me) {
					}

					public void mouseExited(MouseEvent me) {
					}
				});
			}

			public void mousePressed(MouseEvent me) {
			}

			public void mouseReleased(MouseEvent me) {
			}

			public void mouseEntered(MouseEvent me) {
			}

			public void mouseExited(MouseEvent me) {
			}
		});

	}

	public void pasoNivel(String s) {
		JPanel contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(800, 600));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		JLabel img = new JLabel();
		JLabel texto = new JLabel();
		texto.setText(s);
		texto.setBounds(370, 300, 200, 100);
		texto.setFont(new java.awt.Font("Cooper Black", 0, 80));
		Color green = new Color(153, 255, 204);
		texto.setForeground(green);
		img.setBounds(138, 33, 520, 520);
		Icon imagen = new ImageIcon(this.getClass().getResource("/img/rocket (1).png"));
		img.setIcon(imagen);
		Sound.START.play();
		contentPane.add(texto);
		contentPane.add(img);

		ventana.remove(panelJuego);
		ventana.add(contentPane);
		ventana.pack();
		ventana.repaint();
		try {
			ThreadNivel.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ventana.remove(contentPane);
		contentPane.setVisible(false);
		ventana.add(panelJuego);
		ventana.pack();
		ventana.repaint();
	}

	public void addVida() {
		int cantVidas = juego.getJugador().getVidas();
		int numero = cantVidas - 2;
		juego.insertarVida(vidas[numero]);
	}

	public void cambiarVida(int v) {
		juego.eliminarVida(vidas[v]);
	}

}
