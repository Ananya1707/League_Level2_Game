import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
	Font instructionsFont;
	
	GamePanel(){
		titleFont = new Font("Arial", Font.PLAIN, 48);
		instructionsFont  = new Font("Arial", Font.PLAIN, 25);
	}

	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}
		else if(currentState == GAME){
		    drawGameState(g);
		}
		else if(currentState == END){
		    drawEndState(g);
		}


	}
	
	void updateMenuState() {  
		 
	 }
	
	void updateGameState() {
		
	}
	
	void updateEndState()  {
		
	}
	
	void drawMenuState(Graphics g) { 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, FruitNinja.WIDTH, FruitNinja.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 170, 100);
		g.setFont(instructionsFont);
		g.drawString("Press ENTER to start", 280, 270);
		g.drawString("Press Space for instructions", 250, 350);
		
	}
	
	void drawGameState(Graphics g) { 
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, FruitNinja.WIDTH, FruitNinja.HEIGHT);
		
	}
	
	void drawEndState(Graphics g)  {
		g.setColor(Color.RED);
		g.fillRect(0, 0, FruitNinja.WIDTH, FruitNinja.HEIGHT);
		
	}

}
