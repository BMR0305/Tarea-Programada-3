package org.BreakOut;

import javax.swing.ImageIcon;
import java.lang.Object;

/**
 * Clase Ball implementa herencia
 */
public class Ball extends Sprite {
    /**
     * xdir: direccion de la bola en el eje x
     * ydir: direccion de la bola en el eje y
     * velocity: velocidad de la bola
     */
    private java.lang.Double xdir;
    private java.lang.Double ydir;
    private java.lang.Double velocity;


    /**
     * Constructor de la clase Ball
     * @param velocity velocidad base de la bola
     */
    public Ball(java.lang.Double velocity) {

        initBall(velocity);
    }

    /**
     * Incializador de las instancias de Ball
     * @param velocity velocidad base de la bola
     */
    void initBall(java.lang.Double velocity) {
        
        xdir = 1*velocity;
        ydir = -1*velocity;
        this.velocity = velocity;
        loadImage();
        getImageDimensions();
        resetState();
    }

    /**
     * Funcion que carga la imagen dada una direccion y la asigna al atributo image
     */
    private void loadImage() {

        var ii = new ImageIcon("src/resources/ball.png");
        image = ii.getImage();
    }

    /**
     * Funcion que mueve la bola en la pantalla dependiendo de la direccion, la posicion y la velocidad
     */
    void move() {

        x += xdir.intValue();
        y += ydir.intValue();

        if (x <= 0) {

            setXDir(1*velocity);
        }

        if (x >= Commons.WIDTH - imageWidth) {

            setXDir(-1*velocity);
        }

        if (y <= 0) {

            setYDir(1*velocity);
        }
    }

    /**
     * Funcion que posiciona la bola a su posicion inicial cambiando el valor de sus coordenadas
     */
    void resetState() {

        x = Commons.INIT_BALL_X;
        y = Commons.INIT_BALL_Y;
    }

    /**
     * Funcion que asigna la direccion de la bola en el eje x
     * @param x direccion que se desea asignar
     */
    void setXDir(java.lang.Double x) {

        xdir = x;
    }

    /**
     * Funcion que asigna la direccion de la bola en el eje y
     * @param y direccion que se desea asignar
     */
    void setYDir(java.lang.Double y) {

        ydir = y;
    }

    /**
     * Funcion que retorna la direccion en el eje y
     * @return ydir
     */
    java.lang.Double getYDir() {

        return ydir;
    }
    /**
     * Funcion que asigna la velocidad de la bola
     * @param velocity velocidad que se desea asignar
     */
    void setVelocity(java.lang.Double velocity) {

        this.velocity = velocity;
    }

    /**
     * Funcion que retorna la velocidad de la bola
     * @return velocity
     */
    java.lang.Double getVelocity() {
        return velocity;
    }
}
