package pingpong;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class panel extends JPanel implements Runnable{
	
	static final int WIDTH = 1000;  // final makes you run faster
	static final int HEIGHT = (int) (WIDTH *0.5);
	static final Dimension SCREEN_SIZE = new Dimension(WIDTH,HEIGHT);
	static final int diameter = 30;
	static final int BAT_WIDTH = 20;
	static final int BAT_HEIGHT = 100;
	Thread gamethread;
	Image image;
	Graphics graphics;
	Random random;
	bats bat1;
	bats bat2;
	ball Ball;
	score_calculate score;
	
	
   public  panel() {
		newbat();
		newball();
		score =  new score_calculate(WIDTH, HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		gamethread = new Thread(this);
		gamethread.start();
	}
   
   public void newball() {
	   random = new Random();
	   Ball = new ball((WIDTH/2)-(diameter/2) ,random.nextInt(HEIGHT-diameter) ,diameter,diameter);
   }
   
   public void newbat() {
 	   bat1 = new bats(0,(HEIGHT/2) - (BAT_HEIGHT/2), BAT_WIDTH,BAT_HEIGHT,1);
 	   bat2 = new bats(WIDTH - BAT_WIDTH,(HEIGHT/2) - (BAT_HEIGHT/2), BAT_WIDTH,BAT_HEIGHT,2);
   }
  
   public void paint(Graphics g) {
	   image = createImage(getWidth() , getHeight());
	   graphics = image.getGraphics();
	   draw(graphics);
	   g.drawImage(image,0,0,this);   
  }
  
   public void draw(Graphics g) {   
	   bat1.draw(g);
	   bat2.draw(g);
	   Ball.draw(g);
	   score.draw(g);
  }
  
   public void  move() {
	   Ball.move();
	   //bat1.move();;
   }
  
   public void checkcollision() {
	   
	   // stops bats at edges
	   
	   if(bat1.y <= 0) {
		   bat1.y =0;
	   }
	   if(bat1.y >= (HEIGHT-BAT_HEIGHT)) {
		   bat1.y = HEIGHT -BAT_HEIGHT;
	   }
	   
	   if(bat2.y <= 0) {
		   bat2.y =0;
	   }
	   if(bat2.y >= (HEIGHT -BAT_HEIGHT)) {
		   bat2.y = HEIGHT -BAT_HEIGHT;
	   }
	   
	   if(Ball.intersects(bat1)) {
		   Ball.Xspeed = Math.abs(Ball.Xspeed);
		   Ball.Xspeed+= 0.5;
		  /* if(Ball.Yspeed >=0) {
			   Ball.Yspeed++;
		   }else {
			   Ball.Yspeed--;
		   }*/
		   Ball.setXdirection(Ball.Xspeed);
		   Ball.setYdirection(Ball.Yspeed);   
	   }
      if(Ball.intersects(bat2)) {
    	  Ball.Xspeed = Math.abs(Ball.Xspeed);
		  Ball.Xspeed+=0.5;
		  /* if(Ball.Yspeed >=0) {
			   Ball.Yspeed++;
		   }else {
			   Ball.Yspeed--;
		   }*/
		   Ball.setXdirection(-Ball.Xspeed);
		   Ball.setYdirection(Ball.Yspeed);   
		   
	   }
	   
	   if(Ball.y<=0) {
		   Ball.setYdirection(-Ball.Yspeed);
	   }
	   if(Ball.y> HEIGHT - diameter) {
		   Ball.setYdirection(-Ball.Yspeed);
	   }
	   
	   if(Ball.x<= 0) {
		   score.player2++;
		   System.out.println("player 2 score is: " + score.player2);
		   newball();
		   newbat();
		   
	   }
	   if(Ball.x >= WIDTH - diameter) {
		   score.player1++;
		   System.out.println("player 1 score is: " + score.player1);
		   newball();
		   newbat();   
	   }
	   
   }
   
   public void run() {
	   // gameloop
	   
	   long lasttime = System.nanoTime();
	   double amountofticks = 60.0;
	   double ns = 1000000000 / amountofticks;
	   double delta = 0;
	   
	   while(true) {
		   long now = System.nanoTime();
		   delta += (now - lasttime) /ns;
		   lasttime = now;
		   
		   if(delta>=1) {
			   
			   move();
			   checkcollision();
			   repaint();
			   delta--;
			   //System.out.println("test");
		   }
	   }
   }
   
   public class AL extends KeyAdapter{
	   
	   public void keyPressed(KeyEvent e) {
		   bat1.keypressed(e);
		   bat2.keypressed(e);
	   }
	   
       public void keyReleased(KeyEvent e) {
		   bat1.keyreleased(e);
		   bat2.keyreleased(e);
	   }
   }

}
