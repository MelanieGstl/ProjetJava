package element;

import java.awt.Point;

public class Monstre extends Mobile{
	
	private Point position;
	private Hero hero;

	public Monstre (Point position, Hero hero) {
		this.position = position;
		this.hero = hero;
	}

	/*private void saveLastPosition() {
		if ((this.lastPosition.getX() != this.getPosition().getX()) || (this.lastPosition.getY() != this.getPosition().getY())) {
			this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
		}
	}*/

	@Override
	public void moveUp() {
		
		super.moveUp();
	}

	@Override
	public void moveLeft() {
		super.moveLeft();
	}

	@Override
	public void moveDown() {
		super.moveDown();
	}

	@Override
	public void moveRight() {
		super.moveRight();
	}

	/*public void moveBack() {
		this.setX(this.lastPosition.x);
		this.setY(this.lastPosition.y);
	}*/
	
	public void move(){
		if(this.hero.getX() < this.position.x){
			super.moveLeft();
		}else if(this.hero.getX() > this.position.x){
			super.moveRight();
		}else if(this.hero.getY() < this.position.y){
			super.moveUp();
		}else if(this.hero.getY() > this.position.y){
			super.moveDown();
		}else if (this.hero.getPosition() == this.position){
			
		}
	}


}

