package org.BreakOut;

import java.awt.Image;
import java.awt.Rectangle;
import java.lang.Object;

/**
 * Clase padre de los objetos que se colocarán en ventana
 */
public class Sprite {

	/**
	 * x: posicion en el eje x
	 * y: posicion en el eje y
	 * imageWidth: ancho de la imagen en la ventana
	 * imageHeight: largo de la imagen en la ventana
	 * image: imagen que se carga en la ventana
	 */
	java.lang.Integer x;
	java.lang.Integer y;
	java.lang.Integer imageWidth;
	java.lang.Integer imageHeight;
	Image image;

	/**
	 * Resetea la posicion en x del objeto
	 * @param x nueva posicion en el eje x
	 */
	protected void setX(java.lang.Integer x) {
		this.x = x;
	}

	/**
	 * Solicita el valor de la posicion en el eje x
	 * @return posicion en x del objeto
	 */
	java.lang.Integer getX() {
		return x;
	}

	/**
	 * Resetea la posicion en y del objeto
	 * @param y nueva posicion en el eje x
	 */
	protected void setY(java.lang.Integer y) {
		this.y = y;
	}

	/**
	 * Solicita el valor de la posicion en el eje y
	 * @return posicion en y del objeto
	 */
	java.lang.Integer getY() {
		return y;
	}

	/**
	 * Solicita el valor del ancho del objeto en ventana
	 * @return ancho del objeto
	 */
	java.lang.Integer getImageWidth() {
		return imageWidth;
	}

	/**
	 * Solicita el valor del largo del objeto en ventana
	 * @return largo del objeto
	 */
	java.lang.Integer getImageHeight() {
		return imageHeight;
	}

	/**
	 * Solicita la imagen a cargar en ventana
	 * @return imagen del objeto
	 */
	Image getImage() {
		return image;
	}

	/**
	 * Solicita el rectangulo generado por el objeto en ventana
	 * @return rectangulo de las dimensiones del objeto
	 */
	Rectangle getRect() {
		return new Rectangle(x,y,image.getWidth(null), image.getHeight(null));
	}

	/**
	 * Resetea las dimensiones del objeto con las dimensiones de la imagen que se
	 * colocará en ventana
	 */
	void getImageDimensions() {
		imageWidth = image.getWidth(null);
		imageHeight = image.getHeight(null);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
