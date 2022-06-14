package org.BreakOut;
import javax.swing.JFrame;
import java.awt.EventQueue;


/**
 * Clase Breakout
 */
public class Breakout extends JFrame {
	/**
	 * Constructor de la clase Breakout
	 */
	public Breakout() {
		initUI();
	}

	/**
	 * Inicializador de la interfaz de usuario
	 */
	public void initUI() {

		add(new Board());
		setTitle("Breakout");                                                                                                                                                                                                                             //***
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		pack();
	}

	/**
	 * Funcion main
	 * @param args argumentos del main
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(() -> {
			var game = new Breakout();
			game.setVisible(true);

		});
	}

}
