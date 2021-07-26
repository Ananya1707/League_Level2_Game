import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Banana  extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	Banana(int x, int y, int width, int height) {
		super(x, 550, width, height,7);
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("banana.png");
		}
	}
	
	void update() {
		y -= speed;
        super.update();

		
	}
	
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.YELLOW);
			g.fillRect(x, y, width, height);
		}

		
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
	
	

}
