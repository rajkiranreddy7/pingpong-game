package pingpong;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class framesetup extends JFrame{
	
	panel Panel;
	
	public  framesetup() {
		Panel = new panel();
		this.add(Panel);
		this.setTitle("pong game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // if u click X button it will close
		this.pack(); // 
		this.setVisible(true);
		this.setLocationRelativeTo(null); // to appear in the middle of the screen
	}

}
