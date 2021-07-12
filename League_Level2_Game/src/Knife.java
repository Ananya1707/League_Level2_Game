import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Knife extends GameObject {

	Knife(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
	
	public void x() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
