package org.BreakOut;


import javafx.scene.media.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.Object;
import java.util.Arrays;


public class Board extends JPanel {

    private Timer timer;
    private java.lang.String message = "Game Over";
    private ArrayList<Ball> listOfBalls = new ArrayList<Ball>();
    private Paddle paddle;
    private Brick[] bricks;
    private java.lang.Boolean notfinished = true;
    private java.lang.Boolean inGame = false;
    private java.lang.Integer lifes = 3;
    private java.lang.Integer score = 0;
    private java.lang.Double level = 1.0;
    private java.lang.Boolean player = false;


    public Board(java.lang.String board) {
        initBoard(board);
    }

    private void initBoard(java.lang.String board) {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        listOfBalls = new ArrayList<Ball>();
        setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
        gameInit(board);
    }

    private void gameInit(java.lang.String board) {

        bricks = new Brick[Commons.N_OF_BRICKS];
        java.lang.Double velocity = level/2+0.5;
        listOfBalls.add(new Ball(velocity));
        paddle = new Paddle("N");

        java.lang.Integer k = 0;

        java.lang.String [] listOfBricks = board.split("%", 49);


        for (java.lang.Integer i = 0; i < 8; i++) {

            for (java.lang.Integer j = 0; j < 6; j++) {
                java.lang.Integer index = 6*i+j;
                java.lang.String specsString = listOfBricks[index];
                java.lang.String [] listOfSpecs = specsString.split("-", 3);
                java.lang.Integer power = Integer.parseInt(listOfSpecs[0]);
                java.lang.Integer points =  Integer.parseInt(listOfSpecs[1]);
                System.out.println(power);
                System.out.println(points);
                bricks[k] = new Brick(j * 40 + 30, i * 10 + 50, power, points);
                k++;
            }
        }

        timer = new Timer(Commons.PERIOD, new GameCycle());
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        var g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        if (inGame) {
            if (notfinished) {
                drawObjects(g2d);
            } else {
                gameFinished(g2d);
            }
        }
        else{
            startingScreen(g2d);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics2D g2d) {
        if (player){
            drawPlayer(g2d);
        }
        else{
            drawSpectator(g2d);
        }

    }

    private void gameFinished(Graphics2D g2d) {

        var font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.WHITE);
        g2d.setFont(font);
        g2d.drawString(message,
                (Commons.WIDTH - fontMetrics.stringWidth(message)) / 2,
                Commons.WIDTH / 2);
        g2d.drawString("Final score: "+score.toString(),
                80, 200);
    }

    private void startingScreen(Graphics2D g2d) {

        var font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.WHITE);
        g2d.setFont(font);
        g2d.drawString("Press P to be a player",
                (Commons.WIDTH - fontMetrics.stringWidth("Press P to be a player")) / 2,
                Commons.WIDTH / 2);
        g2d.drawString("Press S to be a spectator",
                20, 200);
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (inGame && player){
                paddle.keyPressed(e);
            }
            else{
                java.lang.Integer key = e.getKeyCode();
                if (key == KeyEvent.VK_S) {
                    inGame = true;
                }
                else if (key == KeyEvent.VK_P){
                    player=true;
                    inGame = true;
                }

            }
        }
    }

    private class GameCycle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            doGameCycle();
        }
    }

    private void doGameCycle() {
        if (player){
            if(inGame){
                for (Ball ball : listOfBalls) {
                    ball.move();
                }
                paddle.move();
                checkCollision();

            }
        }
        repaint();
    }

    private void stopGame() {

        notfinished = false;
        timer.stop();
    }

    private void checkCollision() {
        for (java.lang.Integer  i = 0; i < listOfBalls.size(); i++){
            Ball ball = listOfBalls.get(i);
            if (ball.getRect().getMaxY() > Commons.BOTTOM_EDGE) {
                if (lifes == 0){
                    stopGame();
                }
                else{
                    if (listOfBalls.size()-1 == 0){
                        ball.initBall(level/2+0.5);
                        lifes = lifes-1;
                    }
                    else{
                        listOfBalls.remove(ball);
                    }
                }
            }
        }

        for (java.lang.Integer i = 0, j = 0; i < Commons.N_OF_BRICKS; i++) {

            if (bricks[i].isDestroyed()) {

                j++;
            }

            if (j == Commons.N_OF_BRICKS) {
                level+=1;

                initBoard("6-80%1-80%6-80%5-80%3-80%2-80%5-70%0-70%5-70%6-70%0-70%5-70%6-60%6-60%0-60%1-60%6-60%0-60%4-50%4-50%2-50%2-50%3-50%6-50%5-40%6-40%5-40%5-40%6-40%1-40%1-30%5-30%1-30%2-30%0-30%4-30%5-20%0-20%4-20%3-20%3-20%4-20%4-10%2-10%5-10%2-10%2-10%4-10%ajugbuhsabgjhdsabu*´{ñ}%%%");
            }
        }
        for (Ball ball : listOfBalls) {
            if ((ball.getRect()).intersects(paddle.getRect())) {

                Integer paddleLPos = (int) paddle.getRect().getMinX();
                Integer ballLPos = (int) ball.getRect().getMinX();

                Integer first = paddleLPos + 8;
                Integer second = paddleLPos + 16;
                Integer third = paddleLPos + 24;
                Integer fourth = paddleLPos + 32;

                if (ballLPos < first) {

                    ball.setXDir(-1 * ball.getVelocity());
                    ball.setYDir(-1 * ball.getVelocity());
                }

                if (ballLPos >= first && ballLPos < second) {

                    ball.setXDir(-1 * ball.getVelocity());
                    ball.setYDir(-1 * ball.getVelocity() * ball.getYDir());
                }

                if (ballLPos >= second && ballLPos < third) {

                    ball.setXDir(0.0);
                    ball.setYDir(-1 * ball.getVelocity());
                }

                if (ballLPos >= third && ballLPos < fourth) {

                    ball.setXDir(1 * ball.getVelocity());
                    ball.setYDir(-1 * ball.getVelocity() * ball.getYDir());
                }

                if (ballLPos > fourth) {

                    ball.setXDir(1 * ball.getVelocity());
                    ball.setYDir(-1 * ball.getVelocity());
                }
            }
        }

        for (java.lang.Integer i = 0; i < Commons.N_OF_BRICKS; i++) {
            for (java.lang.Integer j = 0; j < listOfBalls.size(); j++){
                Ball ball = listOfBalls.get(j);
                if ((ball.getRect()).intersects(bricks[i].getRect())) {

                    java.lang.Integer ballLeft = (int) ball.getRect().getMinX();
                    java.lang.Integer ballHeight = (int) ball.getRect().getHeight();
                    java.lang.Integer ballWidth = (int) ball.getRect().getWidth();
                    java.lang.Integer ballTop = (int) ball.getRect().getMinY();

                    var pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                    var pointLeft = new Point(ballLeft - 1, ballTop);
                    var pointTop = new Point(ballLeft, ballTop - 1);
                    var pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

                    if (!bricks[i].isDestroyed()) {

                        if (bricks[i].getRect().contains(pointRight)) {

                            ball.setXDir(-1*ball.getVelocity());
                        } else if (bricks[i].getRect().contains(pointLeft)) {

                            ball.setXDir(1*ball.getVelocity());
                        }

                        if (bricks[i].getRect().contains(pointTop)) {

                            ball.setYDir(1*ball.getVelocity());
                        } else if (bricks[i].getRect().contains(pointBottom)) {

                            ball.setYDir(-1*ball.getVelocity());
                        }
                        java.lang.Integer power = bricks[i].getPower();
                        if(power == 1){
                            lifes = lifes + 1;
                        }
                        else if(power == 2){
                            listOfBalls.add(new Ball(level/2+0.5));
                        }
                        else if(power == 3){
                            paddle.changeSize(1);
                        }
                        else if(power == 4){
                            paddle.changeSize(-1);
                        }
                        else if(power == 5){
                            ball.setVelocity(ball.getVelocity()+0.5);
                        }
                        else if(power == 6){
                            if (ball.getVelocity()-1==0){
                                ball.setVelocity(1.0);
                            }
                            else{
                                ball.setVelocity(ball.getVelocity()-0.5);
                            }
                        }
                        score += bricks[i].getPoints();
                        bricks[i].setDestroyed(true);
                    }
                }
            }
        }
    }
    private void drawPlayer(Graphics2D g2d) {
        java.lang.String gameInfo = "";
        for (Ball ball : listOfBalls) {
            g2d.drawImage(ball.getImage(), ball.getX(), ball.getY(),
                    ball.getImageWidth(), ball.getImageHeight(), this);
            gameInfo = gameInfo + ball.getX().toString()+"&"+ball.getY().toString()+"#";

        }

        g2d.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
                paddle.getImageWidth(), paddle.getImageHeight(), this);
        gameInfo= gameInfo + "%"+paddle.getX().toString()+"&"+paddle.getY().toString()+"&"+paddle.getSize()+"%";
        for (java.lang.Integer  i = 0; i < Commons.N_OF_BRICKS; i++) {
            if (!bricks[i].isDestroyed()) {
                g2d.drawImage(bricks[i].getImage(), bricks[i].getX(),
                        bricks[i].getY(), bricks[i].getImageWidth(),
                        bricks[i].getImageHeight(), this);
                gameInfo =gameInfo + bricks[i].getX().toString()+"&"+bricks[i].getY().toString()+"&"+bricks[i].getPower().toString()+"&"+bricks[i].getPoints().toString()+"#";
            }
        }
        var font = new Font("Verdana", Font.BOLD, 12);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.WHITE);
        g2d.setFont(font);
        g2d.drawString("Lifes: " + lifes.toString(),240, 20);
        g2d.drawString("Score: " + score.toString(),10, 20);
        java.lang.Integer level_ = level.intValue();
        g2d.drawString("Level: " + level_.toString(),125, 20);
        gameInfo = gameInfo + "%"+lifes.toString()+"&"+score.toString()+"&"+level_.toString()+"%";

        /*java.lang.String [] gameInfoArray = gameInfo.split("%");
        java.lang.String balls_ = gameInfoArray[0];
        java.lang.String paddle_ = gameInfoArray[1];
        java.lang.String bricks_ = gameInfoArray[2];
        java.lang.String misc_ = gameInfoArray[3];
        java.lang.String [] ballsInfo =  balls_.split("#");
        for(java.lang.String ballInfo : ballsInfo){
            java.lang.String [] ballCoords =  ballInfo.split("&");
            System.out.println("Ball X: " +ballCoords[0]);
            System.out.println("Ball Y: " +ballCoords[1]);
        }
        System.out.println("Paddle: " + paddle_);
        java.lang.String [] bricksInfo =  bricks_.split("#");
        for(java.lang.String brickInfo : bricksInfo){
            java.lang.String [] brickCoords =  brickInfo.split("&");
            System.out.println("Brick X: " +brickCoords[0]);
            System.out.println("Brick Y: " +brickCoords[1]);
        }
        System.out.println("Etc: " + gameInfoArray[3]);*/
    }
    private void drawSpectator(Graphics2D g2d) {
        java.lang.String gameInfo = "";
        java.lang.String [] gameInfoArray = gameInfo.split("%");
        java.lang.String balls_ = gameInfoArray[0];
        java.lang.String paddle_ = gameInfoArray[1];
        java.lang.String bricks_ = gameInfoArray[2];
        java.lang.String misc_ = gameInfoArray[3];

        java.lang.String [] ballsInfo =  balls_.split("#");
        for(java.lang.String ballInfo : ballsInfo){
            java.lang.String [] ballCoords =  ballInfo.split("&");
            System.out.println("Ball X: " +ballCoords[0]);
            System.out.println("Ball Y: " +ballCoords[1]);
            Ball ball_ = new Ball(0.0);
            g2d.drawImage(ball_.getImage(),Integer.valueOf(ballCoords[0]), Integer.valueOf(ballCoords[1]),
                    ball_.getImageWidth(), ball_.getImageHeight(), this);
        }
        java.lang.String [] paddleCoords =  paddle_.split("&");
        Paddle paddleE = new Paddle(paddleCoords[2]);
        g2d.drawImage(paddleE.getImage(), Integer.valueOf(paddleCoords[0]), Integer.valueOf(paddleCoords[1]),
                paddle.getImageWidth(), paddle.getImageHeight(), this);

        java.lang.String [] bricksInfo =  bricks_.split("#");
        for(java.lang.String brickInfo : bricksInfo){
            java.lang.String [] brickCoords =  brickInfo.split("&");
            System.out.println("Brick X: " +brickCoords[0]);
            System.out.println("Brick Y: " +brickCoords[1]);
            Brick brick_ = new Brick(Integer.valueOf(brickCoords[0]),Integer.valueOf(brickCoords[1]),Integer.valueOf(brickCoords[2]),Integer.valueOf(brickCoords[3]));
            g2d.drawImage(brick_.getImage(), brick_.getX(),
                    brick_.getY(), brick_.getImageWidth(),
                    brick_.getImageHeight(), this);
        }
        var font = new Font("Verdana", Font.BOLD, 12);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.WHITE);
        g2d.setFont(font);

        java.lang.String [] misc_Info =  misc_.split("&");
        g2d.drawString("Lifes: " + misc_Info[0],240, 20);
        g2d.drawString("Score: " + misc_Info[1],10, 20);
        g2d.drawString("Level: " + misc_Info[2],125, 20);
    }

}

