package org.BreakOut;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

/**
 * Clase Paddle implementa herencia
 */
public class Paddle extends Sprite {
	/**
	 * dx: direccion a la que se mueve la raqueta
	 * size: letra que representa el tamaño de la raqueta
	 */
	private java.lang.Integer dx = 0;
	private java.lang.String size = "";

	/**
	 * Constructor de la clase Paddle
	 * @param size_ tamaño inicial de la paleta
	 */
	public Paddle(java.lang.String size_) {
		initPaddle(size_);
	}

	/**
	 * Incializador de la clase Paddle
	 * @param size_ tamaño inicial de la paleta
	 */
	private void initPaddle(java.lang.String size_) {
		this.size = size_;
		loadImage();
		getImageDimensions();
		resetState();
		
	}

	/**
	 * Funcion para recargar y mostrar la nueva imagen de la Paleta cuando esta crece o decrece en tamaño
	 */
	private void reloadPaddle(){
		loadImage();
		getImageDimensions();
	}

	/**
	 *  Funcion que carga la imagen de la raqueta y la almacena en el atributo image
	 */
	private void loadImage() {
		var ii = new ImageIcon("src/resources/paddle/paddle_"+size+".png");
		image = ii.getImage();
		
	}
	/**
	 * Funcion que mueve la raqueta en la pantalla dependiendo de la direccion y la posicion
	 */
	void move() {
		x += dx;
		
		if (x <= 0) {
			x = 0;
			
		}
		
	if (x >= Commons.WIDTH - imageWidth) {
		x = Commons.WIDTH - imageWidth;
	}
	}

	/**
	 * Funcion que detecta el evento de presionar en el teclado, y actua acorde a este evento
	 * @param e evento en el teclado
	 */
	void keyPressed(KeyEvent e) {
		java.lang.Integer key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			
			dx = -2;
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			
			dx = 2;
		}
		
		
	}

	/**
	 * Funcion para cambiar el tamaño de la raqueta dependiendo del tamaño actual
	 * @param change tamaño al que se desea cambiar
	 */
	void changeSize(java.lang.Integer change){
		if (change == 1 && size == "N"){
			size = "L";
			reloadPaddle();
		}
		else if (change == 1 && size == "S"){
			size = "N";
			reloadPaddle();
		}
		else if (change == -1 && size == "N"){
			size = "S";
			reloadPaddle();
		}
		else if (change == -1 && size == "L"){
			size = "N";
			reloadPaddle();
		}
	}

	/**
	 * Funcion que detecta el evento de soltar en el teclado, y actua acorde a este evento
	 * @param e evento en el teclado
	 */
	void keyReleased(KeyEvent e) {
		java.lang.Integer key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			
			dx = 0;
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			
			dx = 0;
		}
		
	
		
	}

	/**
	 * Funcion que posiciona la raqueta a su posicion inicial cambiando el valor de sus coordenadas
	 */
	private void resetState() {
		x = Commons.INIT_PADDLE_X;
		y = Commons.INIT_PADDLE_Y;
	}

	/**
	 * Funcion que retorna el tamaño de la raqueta
	 * @return size
	 */
	public java.lang.String getSize(){
		return size;
	}

}
