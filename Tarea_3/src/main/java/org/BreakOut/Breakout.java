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
		add(new Board("6-80%1-80%6-80%5-80%3-80%2-80%5-70%0-70%5-70%6-70%0-70%5-70%6-60%6-60%0-60%1-60%6-60%0-60%4-50%4-50%2-50%2-50%3-50%6-50%5-40%6-40%5-40%5-40%6-40%1-40%1-30%5-30%1-30%2-30%0-30%4-30%5-20%0-20%4-20%3-20%3-20%4-20%4-10%2-10%5-10%2-10%2-10%4-10%ajugbuhsabgjhdsabu*´{ñ}%%%"));
		setTitle("Breakout");                                                                                                                                                                                                                             //***
		try{
			client.main("esto es una prueba");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
