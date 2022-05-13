package pingpong;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bats extends Rectangle{
	
	int id;
	int Yspeed;
	int speed = 25;
	
   public  bats(int x, int y, int bat_width,int bat_height,int id) {
	   super(x,y,bat_width,bat_height);
	   this.id = id;
		
	}
   
   public void keypressed(KeyEvent e) {
	   switch(id) {
	   
	   case 1:
		   if(e.getKeyChar() == 'w') {
			   setYdirection(-speed);
			   move();
		   }
		   if(e.getKeyCode() == KeyEvent.VK_S) {
			   setYdirection(speed);
			   move();
		   }
		   break;
	   case 2:
		   if(e.getKeyCode() == KeyEvent.VK_UP) {
			   setYdirection(-speed);
			   move();
		   }
		   if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			   setYdirection(speed);
			   move();
		   }
		   break;
	   }
   }
   
   public void keyreleased(KeyEvent e) {
   switch(id) {
	   
	   case 1:
		   if(e.getKeyCode() == KeyEvent.VK_W) {
			   setYdirection(0);
			   move();
		   }
		   if(e.getKeyCode() == KeyEvent.VK_S) {
			   setYdirection(0);
			   move();
		   }
		   break;
	   case 2:
		   if(e.getKeyCode() == KeyEvent.VK_UP) {
			   setYdirection(0);
			   move();
		   }
		   if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			   setYdirection(0);
			   move();
		   }
		   break;
	   }
   }
   
   public void setYdirection(int ydirection) {
	   Yspeed = ydirection;
   }
   
   public void draw(Graphics g) {
	   if(id ==1 ) {
		   g.setColor(Color.BLUE);
	   }else {
		   g.setColor(Color.RED);
	   }
	   g.fillRect(x, y, width, height);
   }
   
    public void  move() {
 	   y = y+ Yspeed;
    } 
   
   

}
