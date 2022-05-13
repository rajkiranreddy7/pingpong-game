package pingpong;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class score_calculate extends Rectangle{
	
	static int WIDTH ;  // final makes you run faster
	static int HEIGHT ;
	static int player1=0;
	static int player2=0;
	
	   public  score_calculate(int WIDTH, int HEIGHT) {
		   score_calculate.WIDTH = WIDTH;
		   score_calculate.HEIGHT = HEIGHT; 
		}
       public void draw(Graphics g) {
		   g.setColor(Color.white);
		   g.setFont(new Font("Consolas" , Font.PLAIN ,60));
		   g.drawLine(WIDTH/2,0, WIDTH/2,HEIGHT);
		   
		   g.drawString(String.valueOf(player1), (WIDTH/2) - 60 , 50);
		   g.drawString(String.valueOf(player2), (WIDTH/2) + 30 , 50);
	   }
}
