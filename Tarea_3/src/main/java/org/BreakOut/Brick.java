package org.BreakOut;

import javax.swing.ImageIcon;
import java.io.*;
import java.lang.Object;
import java.util.Scanner;

public class Brick extends Sprite {

    private java.lang.Boolean destroyed;
    private java.lang.Integer power;
    private java.lang.Integer points;

    public Brick(java.lang.Integer x, java.lang.Integer y,java.lang.Integer power, java.lang.Integer points) {
        initBrick(x, y, power, points);
    }
    
    private void initBrick(java.lang.Integer x, java.lang.Integer y, java.lang.Integer power, java.lang.Integer points) {
        
        this.x = x;
        this.y = y;
        
        destroyed = false;
        this.power = power;
        this.points = points;

        loadImage(power, points);
        getImageDimensions();
    }
    
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

    java.lang.Boolean isDestroyed() {
        return destroyed;
    }

    void setDestroyed(java.lang.Boolean val) {
        
        destroyed = val;
    }

    java.lang.Integer getPower(){
        return this.power;
    }

    java.lang.Integer getPoints(){
        return this.points;
    }


}
