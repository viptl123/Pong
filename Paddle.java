import java.awt.*;
import java.awt.geom.Rectangle2D;



public class Paddle extends Rectangle{

		private static final long serialVersionUID = 1L;
		private int w;
		private int h;
		private int posX;
		private int posY;
	
	
	public Paddle(int positionX, int positionY) {
		super(positionX, positionY, 10, 60);
		w = 10;
		h = 60;
		posX = positionX;
		posY = positionY;
		
	}
	
	public void drawPaddle(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		Rectangle2D.Double rect = new Rectangle2D.Double(posX, posY, w, h);
		g2d.fill(rect);
	}
	public int getXPos() {
		return posX;
	}
	
	public int getYPos() {
		return posY;
	}
	
	public void changeYPosition(int positionY) {
		posY += positionY;
		super.setLocation(posX, posY);
	}
	public void returnUser() {
		posX = 900;
		posY = 250;
		super.setLocation(posX, posY);
	}
	public void returnComputer() {
		posX = 100;
		posY = 250;
		super.setLocation(posX, posY);
		
	}
	
	
}
