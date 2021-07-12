import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameObject implements MouseListener {
	 int x;
	 int y;
	 int width;
	 int height;
	 int speed = 0;
	 boolean isActive = true;
	 
	 GameObject(int x, int y, int width, int height){
		 this.x = x;
		 this.y = y;
		 this.width = width;
		 this.height = height;
		 
	 }
	 
	 void update() {
		 
	 }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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