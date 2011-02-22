import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Finder{
	public static void main(String[]ar){
		new Finder();
	}
	
	JFrame locatorMap = new JFrame("Locator");
	JFrame displayMap = new JFrame("Display");
	Locator locator = new Locator();
	Displayer displayer = new Displayer();
	
	public Finder(){
		displayMap.setLayout(new GridLayout(1,1,0,0));
		displayMap.getContentPane().add(displayer);
		displayMap.setSize(410, 440);
		displayMap.setLocation(500,0);
		displayMap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayMap.setVisible(true);
		
		locatorMap.setLayout(new GridLayout(1,1,0,0));
		locatorMap.getContentPane().add(locator);
		locatorMap.setSize(410, 440);
		locatorMap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		locatorMap.setVisible(true);
	}
	
	public class Locator extends JPanel{
		int mouseX = 100, mouseY = 100, WIDTH = 48, HEIGHT = 48;
		PersonFinder person = new PersonFinder();
		
		public Locator(){
			addMouseListener(person);
		}
		
		public void paintComponent(Graphics g){
			g.clearRect(0,0,440,440);
			
			for(int i = 50 ; i < 400 ; i += 50)
				g.drawLine(i,0,i,400);
			for(int i = 50 ; i < 400 ; i += 50)
				g.drawLine(0,i,400,i);
			
			g.fillOval(mouseX - WIDTH/2, mouseY - HEIGHT/2, WIDTH, HEIGHT);
		}
		
		public class PersonFinder extends MouseAdapter{
			
			public void mouseMoved(MouseEvent e){
				mouseX = e.getX();
				mouseY = e.getY();
				
				locator.repaint();
				displayer.repaint();
			}

		}
		
	}
	
	public class Displayer extends JPanel{
		
		public void paintComponent(Graphics g){
			
		}
		
	}
}