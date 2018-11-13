package Grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.FocusManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class LogInWindow {
	private static Map<String,String> usuarios;
	private static JFrame logInFrame;
	private static JTextField usuario;
	private static JTextField contrasena;
	private static JButton iniciarSesion;
	private static JTextField userField;
	private static JPasswordField passwordField;
	
	public static void main(String[] args) {
				
		logInFrame=new JFrame("Iniciar sesion");
		logInFrame.setVisible(true);
		logInFrame.getContentPane().setLayout(null);
		logInFrame.setBounds(0, 0, 600, 400);
		logInFrame.getContentPane().setBounds(0,0,600,400);
		
		userField = new JTextField();
		userField.setBounds(97, 61, 236, 39);
		logInFrame.getContentPane().add(userField);
		userField.setColumns(10);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBounds(236, 158, 171, 41);
		logInFrame.getContentPane().add(btnIniciarSesion);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(26, 64, 71, 33);
		logInFrame.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(26, 114, 71, 33);
		logInFrame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(97, 111, 236, 36);
		logInFrame.getContentPane().add(passwordField);
		
		btnIniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String userName=userField.getText();
				String password=passwordField.getText();
				if (!(userName.equals("")) && !(password.equals(""))) {
					ingresarUsuario(userName,password);
					UsuarioActual.user=userName;
				}
			}

			private void ingresarUsuario(String userName, String password) {	
				FileReader fileReader=null;
				try {
					fileReader=new FileReader(new File("src/users"));
					BufferedReader bufferReader=new BufferedReader(fileReader);
					
					String userAndPassword=null;
					String userSaved=null;
					String passwordSaved=null;
					boolean ingreso=false;
					
					while((userAndPassword=bufferReader.readLine())!=null) {
						userSaved=userAndPassword.split(" ")[0];
						passwordSaved=userAndPassword.split(" ")[1];
						if (userSaved.equals(userName) && password.equals(passwordSaved)) {
							ingreso=true;
							FocusManager.getCurrentManager().getActiveWindow().dispose();
							Grafica.main(args);
							UsuarioActual.user=userSaved;
							break;
						}
					}
					if (!ingreso)
						JOptionPane.showMessageDialog(null,"Contrasenia o nombre de usuario incorrecto","Error",JOptionPane.ERROR_MESSAGE);
					
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					try {
						fileReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		});
		
			
	}

	public LogInWindow() {
	
	}
}
