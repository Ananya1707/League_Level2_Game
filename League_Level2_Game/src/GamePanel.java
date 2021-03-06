import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseMotionListener, MouseListener {
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
	public static BufferedImage image2;
	public static boolean needImage2 = true;
	public static boolean gotImage2 = false;
	public static BufferedImage image3;
	public static boolean needImage3 = true;
	public static boolean gotImage3 = false;
	public static BufferedImage image4;
	public static boolean needImage4 = true;
	public static boolean gotImage4 = false;
	Knife k = new Knife(0,0,100,100);
	ObjectManager m = new ObjectManager(k);
	static Timer orangeSpawn;
	static Timer watermelonSpawn;
	static Timer bananaSpawn;
	static Timer bombSpawn;



	
	GamePanel(){
		titleFont = new Font("Arial", Font.PLAIN, 48);
		instructionsFont  = new Font("Arial", Font.PLAIN, 25);
		
	    frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	    
	    if (needImage) {
	        loadImage ("background.png");
	    }
	    
	    if (needImage2) {
	        loadImage2 ("FNxoutline.png");
	    }
	    
	    if (needImage3) {
	        loadImage3 ("FNxoutline.png");
	    }
	    
	    if (needImage4) {
	        loadImage4 ("FNxoutline.png");
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
		m.updateBomb();
		
		System.out.println(m.strike);
		
		if(m.strike == 1) {
			needImage2 = true;
			gotImage2 = false;
			needImage3 = true;
			gotImage3 = false;
			needImage4 = true;
			gotImage4 = false;
			
			if (needImage2) {
		        loadImage2 ("FNx.png");
		    }
		}
		
		if(m.strike == 2) {
			if (needImage3) {
		        loadImage3 ("FNx.png");
		    }
		}
		
		if(m.strike == 3) {
			if (needImage4) {
		        loadImage4 ("FNx.png");
		        k.isActive = false;
		    }
		}

		
		if(!k.isActive) {
			orangeSpawn.stop();
			watermelonSpawn.stop();
			bananaSpawn.stop();
			bombSpawn.stop();

		}
		
		if(k.isActive == false) {
			currentState = END;
			
		}

		
	}
	
	void updateEndState()  {
		
	}
	
	void drawMenuState(Graphics g) { 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, FruitNinja.WIDTH, FruitNinja.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Fruit Ninja", 290, 170);
		g.setFont(instructionsFont);
		g.drawString("Press ENTER to start", 280, 270);
		g.drawString("Press Space for instructions", 250, 350);
		
	}
	
	void drawGameState(Graphics g) { 
		if (gotImage) {
			g.drawImage(image, 0, 0, FruitNinja.WIDTH, FruitNinja.HEIGHT, null);
			g.drawImage(image2, 750, 15, 35, 35, null);
			g.drawImage(image3, 705, 15, 35, 35, null);
			g.drawImage(image4, 665, 15, 35, 35, null);

			g.setFont(instructionsFont);
			g.setColor(Color.BLACK);
			g.drawString("SCORE: " + m.score , 20, 30);
			
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, FruitNinja.WIDTH, FruitNinja.HEIGHT);
		}
		m.drawOrange(g);
		m.drawWatermelon(g);
		m.drawBanana(g);
		m.drawBomb(g);

		
	}
	
	void drawEndState(Graphics g)  {
		g.setColor(Color.RED);
		g.fillRect(0, 0, FruitNinja.WIDTH, FruitNinja.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("You Lost :(", 290, 170);
		g.setFont(instructionsFont);
		g.setColor(Color.BLACK);
		g.drawString("SCORE: " + m.score , 350, 300);
		
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
					bombSpawn.stop();

				}
		    
		    else {
		        currentState++;
				startGame();

		    }
		}  
		
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
		    JOptionPane.showMessageDialog(null, "Click on the fruits and not the bomb \n Missing a fruit is one strike and clicking a bomb is also on strike \n Once you get 3 strikes the game ends you score is displayed");
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
	
	void loadImage2(String imageFile) {
	    if (needImage2) {
	        try {
	            image2 = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage2 = true;
	        } catch (Exception e) {
	            
	        }
	        needImage2 = false;
	    }
	}
	
	void loadImage3(String imageFile) {
	    if (needImage3) {
	        try {
	            image3 = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage3 = true;
	        } catch (Exception e) {
	            
	        }
	        needImage3 = false;
	    }
	}
	
	void loadImage4(String imageFile) {
	    if (needImage4) {
	        try {
	            image4 = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage4 = true;
	        } catch (Exception e) {
	            
	        }
	        needImage4 = false;
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
		k.update();
		
	}
	
	void startGame() {
		orangeSpawn = new Timer(2000 , m);
	    orangeSpawn.start();
	    
	    watermelonSpawn = new Timer(7000 , m);
	    watermelonSpawn.start();
	    
	    bananaSpawn = new Timer(4000 , m);
	    bananaSpawn.start();
	    
	    bombSpawn = new Timer(4000 , m);
	    bombSpawn.start();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		m.checkCollision();

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
