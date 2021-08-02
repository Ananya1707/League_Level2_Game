import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Knife k;
	ArrayList<Orange> oranges = new ArrayList<Orange>();
	ArrayList<Watermelon> watermelons = new ArrayList<Watermelon>();
	ArrayList<Banana> bananas = new ArrayList<Banana>();


	Random random = new Random();
	Random randomW = new Random();
	Random randomB = new Random();



	ObjectManager(Knife knife){
		k = knife;
	}
	
	void addOrange(){
		oranges.add(new Orange(random.nextInt(FruitNinja.WIDTH),0,40,40));
	
	}
	
	void updateOrange() {
		for(int i = 0; i < oranges.size(); i++){
			Orange orange = oranges.get(i);
			//orange.y += 1; 
			orange.update();
			if(orange.y >= FruitNinja.HEIGHT) {
				orange.isActive = false;
			}
		}
		purgeOrangeObjects();

	}
	
	
	void drawOrange(Graphics g){
		k.draw(g);
		
		for(int i = 0; i < oranges.size(); i++){
			Orange orange = oranges.get(i);
			orange.draw(g);

		}	
	}
	
	void purgeOrangeObjects() {
		for(int i = 0; i < oranges.size(); i++){
			Orange orange = oranges.get(i);
			if(orange.isActive == false) {
				oranges.remove(i);
			}
		}
	}
	
	void addWatermelon(){
		watermelons.add(new Watermelon(randomW.nextInt(FruitNinja.WIDTH),0,80,80));
	
	}
	
	void updateWatermelon() {
		for(int i = 0; i < watermelons.size(); i++){
			Watermelon watermelon = watermelons.get(i);
			//orange.y += 1; 
			watermelon.update();
			if(watermelon.y >= FruitNinja.HEIGHT) {
				watermelon.isActive = false;
			}
		}
		purgeWatermelonObjects();

	}
	
	
	void drawWatermelon(Graphics g){
		k.draw(g);
		
		for(int i = 0; i < watermelons.size(); i++){
			Watermelon watermelon = watermelons.get(i);
			watermelon.draw(g);

		}	
	}
	
	void purgeWatermelonObjects() {
		for(int i = 0; i < watermelons.size(); i++){
			Watermelon watermelon = watermelons.get(i);
			if(watermelon.isActive == false) {
				watermelons.remove(i);
			}
		}
	}
	
	void addBanana(){
		bananas.add(new Banana(randomB.nextInt(FruitNinja.WIDTH),0,60,60));
	
	}
	
	void updateBanana() {
		for(int i = 0; i < bananas.size(); i++){
			Banana banana = bananas.get(i);
			//orange.y += 1; 
			banana.update();
			if(banana.y >= FruitNinja.HEIGHT) {
				banana.isActive = false;
			}
		}
		purgeBananaObjects();

	}
	
	
	void drawBanana(Graphics g){
		k.draw(g);
		
		for(int i = 0; i < bananas.size(); i++){
			Banana banana = bananas.get(i);
			banana.draw(g);

		}	
	}
	
	void purgeBananaObjects() {
		for(int i = 0; i < bananas.size(); i++){
			Banana banana = bananas.get(i);
			if(banana.isActive == false) {
				bananas.remove(i);
			}
		}
	}
	
	void checkCollision() {
		for(int i = 0; i < oranges.size(); i++){
			Orange orange = oranges.get(i);
			if(k.collisionBox.intersects(orange.collisionBox)){
				orange.isActive = false;
					
			}
			
		}
		
		for(int i = 0; i < watermelons.size(); i++){
			Watermelon watermelon = watermelons.get(i);
			if(k.collisionBox.intersects(watermelon.collisionBox)){
				watermelon.isActive = false;
					
			}
			
		}
		
		for(int i = 0; i < bananas.size(); i++){
			Banana banana = bananas.get(i);
			if(k.collisionBox.intersects(banana.collisionBox)){
				banana.isActive = false;
					
			}
			
		}
			
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == GamePanel.orangeSpawn) {
			addOrange();
		
		}
		
		if(e.getSource() == GamePanel.watermelonSpawn) {
			addWatermelon();
		
		}
		if(e.getSource() == GamePanel.bananaSpawn) {
			addBanana();
		
		}
	}

}
