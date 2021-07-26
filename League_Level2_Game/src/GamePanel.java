import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseMotionListener {
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
	Font instructionsFont;
	Timer frameDraw;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;		
	Knife k = new Knife(0,0,100,100);
	ObjectManager m = new ObjectManager(k);
	Timer orangeSpawn;
	Timer watermelonSpawn;
	Timer bananaSpawn;


	
	GamePanel(){
		titleFont = new Font("Arial", Font.PLAIN, 48);
		instructionsFont  = new Font("Arial", Font.PLAIN, 25);
		
	    frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	    
	    if (needImage) {
	        loadImage ("background.png");
	    }
	   
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
		m.updateOrange();
		m.updateWatermelon();
		m.updateBanana();

		
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
		if (gotImage) {
			g.drawImage(image, 0, 0, FruitNinja.WIDTH, FruitNinja.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, FruitNinja.WIDTH, FruitNinja.HEIGHT);
		}
		m.drawOrange(g);
		m.drawWatermelon(g);
		m.drawBanana(g);


		
	}
	
	void drawEndState(Graphics g)  {
		g.setColor(Color.RED);
		g.fillRect(0, 0, FruitNinja.WIDTH, FruitNinja.HEIGHT);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		
		System.out.println("action");
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    }
		        
		    else if(currentState == GAME) {
					currentState++;
					orangeSpawn.stop();
					watermelonSpawn.stop();
					bananaSpawn.stop();
				}
		    
		    else {
		        currentState++;
				startGame();

		    }
		}  
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		}
		
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		}
		
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		}
		
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		k.x = e.getX() - 50;
		k.y = e.getY() - 70;
		
	}
	
	void startGame() {
		orangeSpawn = new Timer(1000 , m);
	    orangeSpawn.start();
	    
	    watermelonSpawn = new Timer(1000 , m);
	    watermelonSpawn.start();
	    
	    bananaSpawn = new Timer(1000 , m);
	    bananaSpawn.start();
	}

}
