import java.awt.*;

import java.awt.geom.*;

public class Ball extends Ellipse2D.Double{

	// position of ball on canvas
	private int posX;
	private int posY;
	// how big ball is 
	private int radius;
	// how fast ball moves 
	private int speedX;
	private int speedY;
	private static final long serialVersionUID = 1L;
	
	public Ball() {
		
		super(508, 265, 15, 15);
		posX = 508 ;
		posY = 265;
		radius = 15;
		speedX = 7;
		speedY =0;
		
		
	}
	
	public void drawBall(Graphics g)  {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
		
		Ellipse2D.Double ball = new Ellipse2D.Double(posX,posY,radius,radius);		
		g2d.fill(ball);
		
	}
	
	public void changeBallXPosition(int x) {
		posX += x;
		super.setFrame(posX, posY, radius, radius);
	}
	public void changeBallYPosition(int y) {
		posY += y;
		
		super.setFrame(posX, posY, radius, radius);
	}
	public int getXPos() {
		return posX;
	}
	public int getYPos() {
		return posY;
	}
	
	
	public void returnToCenter() {
		posX =508;
		posY = 265;
		super.setFrame(posX, posY, radius, radius);
		speedX =7;
		speedY =0;
	}
	public int getXSpeed(){
		return speedX;
	}
	public void changeXSpeed(int newSpeed) {
		speedX = newSpeed;
	}
	public boolean collidesWith(Shape other) {
	    return this.getBounds2D().intersects(other.getBounds2D());
	}
	public int getYSpeed() {
		return speedY;
	}
	public void changeYSpeed(int newSpeed) {
		speedY = newSpeed;
	}
	
	
	
}