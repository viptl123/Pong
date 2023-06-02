import javax.swing.*;
import java.awt.*;


public class drawPong extends JComponent{

	
	// user paddle that moves
	private Paddle user;
	// computer to play against
	private Paddle computer;
	// ball that you play with
	private Ball ball;
	
	private boolean showDescription =true;
	
	private int playerScore;
	private int computerScore;
	private static final long serialVersionUID = 1L;
	
	public drawPong() {
		user = new Paddle(900, 250);
		computer = new Paddle(100,250);
		ball = new Ball();
		playerScore =0;
		computerScore =0;
	}
	
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
		
		
		user.drawPaddle(g);
		computer.drawPaddle(g);
		ball.drawBall(g);
		
		Integer playScore = playerScore;
		
		g2d.setFont(new Font(Font.MONOSPACED, Font.ROMAN_BASELINE, 35));
		
		g2d.drawString(playScore.toString(), 750, 100);
		Integer compScore = computerScore;
		g2d.drawString(compScore.toString(), 250, 100);
		
		g2d.setFont(new Font(Font.MONOSPACED, Font.ROMAN_BASELINE, 15));
		
		if (showDescription) {
			g2d.drawString("First to 5 points wins",420, 50);
			g2d.drawString("Use up and down arrows or w and s to move", 350, 75);
			g2d.drawString("Type x to quit at anytime", 405, 100);
		}
		
	}
	public void setYPosition(int positionY) {
		user.changeYPosition(positionY); 
	}
	
	public void changeBallPosition(int x, int y) {
		ball.changeBallXPosition(x);
		ball.changeBallYPosition(y);
		
	}
	
	
	
	public Ball getBall(){
		return this.ball;
	}
	public Paddle getUser() {
		return user;
	}
	public Paddle getComputer() {
		return computer;
	}
	public boolean collides(Ball one, Shape two) {
		return one.collidesWith(two);
	}
	
	public int calculateYChange(Paddle paddle){
		int ballPos = getBall().getYPos();
		int paddlePos = paddle.getYPos() +15;
		int num = (ballPos - paddlePos) /5;
		return num ;
	}
	public int getPlayerScore() {
		return playerScore;
	}
	public int getComputerScore() {
		return computerScore;
	}
	public void increasePlayerScore() {
		playerScore +=1;
	}
	public void increaseComputerScore() {
		computerScore +=1;
	}
	public void showDescriptionTrue() {
		showDescription = true;
	}
	public void showDescriptionFalse() {
		showDescription = false;
	}
	
	
	
	
	
	
}