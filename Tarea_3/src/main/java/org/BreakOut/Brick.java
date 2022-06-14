package org.BreakOut;

import javax.swing.ImageIcon;

/**
 * Clase Brick implementa herencia
 */
public class Brick extends Sprite {
    /**
     * destroyed: variable booleana que indica si el ladrillo esta destruido o no
     * power: dependiendo del valor numerico de esta variable es el poder que se le asigna al ladrillo
     * points: dpenediendo del valor numerico de esta variable es la cantidad de puntos a otorgar al destruir el ladrillo
     */
    private java.lang.Boolean destroyed;
    private java.lang.Integer power;
    private java.lang.Integer points;

    /**
     * Constructor de la clase Brick
     * @param x posicion en x del ladrillo
     * @param y posicion en y del ladrillo
     * @param power poder almacenado por el ladrillo
     * @param points puntos a otorgar por el ladrillo
     */
    public Brick(java.lang.Integer x, java.lang.Integer y,java.lang.Integer power, java.lang.Integer points) {
        initBrick(x, y, power, points);
    }
    /**
     * Incicializador de la clase Brick
     * @param x posicion en x del ladrillo
     * @param y posicion en y del ladrillo
     * @param power poder almacenado por el ladrillo
     * @param points puntos a otorgar por el ladrillo
     */
    private void initBrick(java.lang.Integer x, java.lang.Integer y, java.lang.Integer power, java.lang.Integer points) {
        
        this.x = x;
        this.y = y;
        
        destroyed = false;
        this.power = power;
        this.points = points;

        loadImage(power, points);
        getImageDimensions();
    }

    /**
     * Funcion que carga la imagen del ladrillo y la almacena en el atributo image, esta imagen depende del poder
     * y los puntos (color)
     * @param power poder asignado al ladrillo
     * @param points puntos asignados al ladrillo
     */
    private void loadImage(java.lang.Integer power, java.lang.Integer points) {
        java.lang.String color = "";
        if (points == 10 || points == 20){
            color = "v";
        }
        else if (points == 30 || points ==40){
            color = "a";
        }
        else if (points == 50 || points ==60){
            color = "n";
        }
        else{
            color = "r";
        }
        var ii = new ImageIcon("src/resources/"+color+"/brick_"+power.toString()+"_"+color+".png");
        image = ii.getImage();        
    }

    /**
     * Funcion que retorna el atributo destroyed
     * @return destroyed
     */
    java.lang.Boolean isDestroyed() {
        return destroyed;
    }
    /**
     * Funcion que asigna el valor de destroyed
     * @param val nuevo valor de destroyed
     */
    void setDestroyed(java.lang.Boolean val) {
        
        destroyed = val;
    }

    /**
     * Funcion que retorna el poder
     * @return power
     */
    java.lang.Integer getPower(){
        return this.power;
    }
    /**
     * Funcion que retorna los puntos
     * @return points
     */
    java.lang.Integer getPoints(){
        return this.points;
    }


}
