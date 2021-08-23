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
	ArrayList<Bomb> bombs = new ArrayList<Bomb>();


	Random random = new Random();
	Random randomW = new Random();
	Random randomB = new Random();
	Random randomBomb = new Random();
	
	int score = 0;
	int strike = 0;




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
			if(orange.y <= 0) {
				orange.isActive = false;
				strike += 1;
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
			watermelon.update();
			if(watermelon.y <= 0) {
				watermelon.isActive = false;
				strike += 1;
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
			if(banana.y <= 0) {
				banana.isActive = false;
				strike += 1;
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
				score = score + 7;
					
			}
			
		}
		
		for(int i = 0; i < watermelons.size(); i++){
			Watermelon watermelon = watermelons.get(i);
			if(k.collisionBox.intersects(watermelon.collisionBox)){
				watermelon.isActive = false;
				score = score + 3;
					
			}
			
		}
		
		for(int i = 0; i < bananas.size(); i++){
			Banana banana = bananas.get(i);
			if(k.collisionBox.intersects(banana.collisionBox)){
				banana.isActive = false;
				score = score + 5;
					
			}
			
		}
		
		for(int i = 0; i < bombs.size(); i++){
			Bomb bomb = bombs.get(i);
			if(k.collisionBox.intersects(bomb.collisionBox)){
				bomb.isActive = false;
				strike += 1;
					
			}
			
		}
			
	}
	
	void addBomb(){
		bombs.add(new Bomb(randomBomb.nextInt(FruitNinja.WIDTH),0,60,60));
	
	}
	
	void updateBomb() {
		for(int i = 0; i < bombs.size(); i++){
			Bomb bomb = bombs.get(i);
			//orange.y += 1; 
			bomb.update();
			if(bomb.y >= FruitNinja.HEIGHT) {
				bomb.isActive = false;
			}
		}
		purgeBombObjects();

	}
	
	
	void drawBomb(Graphics g){
		k.draw(g);
		
		for(int i = 0; i < bombs.size(); i++){
			Bomb bomb = bombs.get(i);
			bomb.draw(g);

		}	
	}
	
	void purgeBombObjects() {
		for(int i = 0; i < bombs.size(); i++){
			Bomb bomb = bombs.get(i);
			if(bomb.isActive == false) {
				bombs.remove(i);
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
		
		if(e.getSource() == GamePanel.bombSpawn) {
			addBomb();
		
		}
	}

}
