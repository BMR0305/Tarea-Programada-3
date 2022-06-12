package org.BreakOut;
import javafx.scene.media.*;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.io.IOException;


public class Breakout extends JFrame {

	public Breakout() {
		initUI();
	}

	public void initUI() {

		add(new Board());
		setTitle("Breakout");                                                                                                                                                                                                                             //***


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		pack();
	}

	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(() -> {
			var game = new Breakout();
			game.setVisible(true);

		});
	}

}
