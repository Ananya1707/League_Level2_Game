import javax.swing.JFrame;

public class FruitNinja {
	JFrame frame;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 550;
	GamePanel panel;

	public static void main(String[] args) {
		FruitNinja game  = new FruitNinja();
		game.setup();
		
	}
	
	FruitNinja(){
		frame = new JFrame();
		panel = new GamePanel();

		
	}
	
	void setup(){
		frame.add(panel);
		frame.setSize(WIDTH,HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		frame.addMouseMotionListener(panel);
		frame.addMouseListener(panel);

	}

}
