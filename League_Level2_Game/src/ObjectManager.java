import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Knife k;
	ArrayList<Orange> oranges = new ArrayList<Orange>();
	Random random = new Random();


	ObjectManager(Knife knife){
		k = knife;
	}
	
	void addOrange(){
		oranges.add(new Orange(random.nextInt(FruitNinja.WIDTH),0,50,50));
	
	}
	
	void update() {
		for(int i = 0; i < oranges.size(); i++){
			Orange orange = oranges.get(i);
			orange.update();
			if(orange.y >= FruitNinja.HEIGHT) {
				orange.isActive = false;
			}
		}
		purgeObjects();

	}
	
	
	void draw(Graphics g){
		k.draw(g);
		
		for(int i = 0; i < oranges.size(); i++){
			Orange orange = oranges.get(i);
			orange.draw(g);

		}	
	}
	
	void purgeObjects() {
		for(int i = 0; i < oranges.size(); i++){
			Orange orange = oranges.get(i);
			if(orange.isActive == false) {
				oranges.remove(i);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addOrange();
		
	}

}
