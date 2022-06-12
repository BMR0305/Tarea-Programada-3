package org.BreakOut;

import javax.swing.ImageIcon;
import java.lang.Object;

public class Ball extends Sprite {
    private java.lang.Double xdir;
    private java.lang.Double ydir;
    private java.lang.Double velocity;
    public Ball(java.lang.Double velocity) {

        initBall(velocity);
    }

    void initBall(java.lang.Double velocity) {
        
        xdir = 1*velocity;
        ydir = -1*velocity;
        this.velocity = velocity;
        loadImage();
        getImageDimensions();
        resetState();
    }

    private void loadImage() {

        var ii = new ImageIcon("src/resources/ball.png");
        image = ii.getImage();
    }

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

    void resetState() {

        x = Commons.INIT_BALL_X;
        y = Commons.INIT_BALL_Y;
    }

    void setXDir(java.lang.Double x) {

        xdir = x;
    }

    void setYDir(java.lang.Double y) {

        ydir = y;
    }

    java.lang.Double getYDir() {

        return ydir;
    }

    void setVelocity(java.lang.Double velocity) {

        this.velocity = velocity;
    }
    java.lang.Double getVelocity() {
        return velocity;
    }
}
