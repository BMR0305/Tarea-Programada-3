package org.BreakOut;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import java.lang.Object;

public class Paddle extends Sprite {
	
	private java.lang.Integer dx = 0;
	private java.lang.String size = "";
	
	public Paddle(java.lang.String size_) {
		initPaddle(size_);
	}
	
	private void initPaddle(java.lang.String size_) {
		this.size = size_;
		loadImage();
		getImageDimensions();
		resetState();
		
	}
	private void reloadPaddle(){
		loadImage();
		getImageDimensions();
	}
	
	private void loadImage() {
		var ii = new ImageIcon("src/resources/paddle/paddle_"+size+".png");
		image = ii.getImage();
		
	}
	
	void move() {
		x += dx;
		
		if (x <= 0) {
			x = 0;
			
		}
		
	if (x >= Commons.WIDTH - imageWidth) {
		x = Commons.WIDTH - imageWidth;
	}
	}
	
	void keyPressed(KeyEvent e) {
		java.lang.Integer key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			
			dx = -2;
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			
			dx = 2;
		}
		
		
	}
	
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


	void keyReleased(KeyEvent e) {
		java.lang.Integer key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			
			dx = 0;
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			
			dx = 0;
		}
		
	
		
	}
	
	
	private void resetState() {
		x = Commons.INIT_PADDLE_X;
		y = Commons.INIT_PADDLE_Y;
	}

	public java.lang.String getSize(){
		return size;
	}

}
