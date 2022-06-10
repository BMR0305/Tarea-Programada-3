package org.BreakOut;

import javax.swing.JFrame;
import java.awt.EventQueue;
import java.io.IOException;


public class Breakout extends JFrame {

	public Breakout() {
		initUI();
	}

	public void initUI() {

		try{
			client.main("esto es una prueba");

		} catch (IOException e) {
			e.printStackTrace();
		}


		add(new Board());
		setTitle("Breakout");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		pack();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			var game = new Breakout();
			game.setVisible(true);

		});
	}

}
