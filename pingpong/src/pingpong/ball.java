package pingpong;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ball extends Rectangle {
	
	Random random;
	int Xspeed;
	int Yspeed;
	int speedfactor = 3; 
	
	   public ball(int x, int y,int width ,int height) {
		   super(x, y,width,height);
		   random  = new Random();
		   int randomXdirection = random.nextInt(2);
		   if(randomXdirection == 0) {
			   randomXdirection--;
			   setXdirection(randomXdirection * speedfactor);
		   }
		   int randomYdirection = random.nextInt(2);
		   if(randomYdirection == 0) {
			   randomYdirection--;
			   setYdirection(randomYdirection * speedfactor);
		   }
	   }
	   
	   public void setXdirection(int randomXDirection) {
		   Xspeed = randomXDirection;
	   }
	   
	   public void setYdirection(int randomYDirection) {
		   Yspeed = randomYDirection;
	   }
	   
	   public void draw(Graphics g) {
		  g.setColor(Color.white);
		  g.fillOval(x, y, height, width);
	   }
	   
	    public void  move() {
	 	  x += Xspeed;
	 	  y += Yspeed;
	    } 

}
