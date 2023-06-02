import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




public class Driver extends JFrame {
	
	private static final long serialVersionUID = 1L;
	static drawPong canvas;
	static JFrame j;
	static boolean keepPlaying = true;
	public static final int changePaddleNumber = 14;

	
	public static void main(String[] args) {
	
		// create frame and set default settings
		j = new JFrame();
		j.setSize(1000,600);
		j.setTitle("Pong");
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.getContentPane().setBackground(Color.black);
		
		
		
		// set up basics of the game 
		canvas = new drawPong();
		// add key listener to play with keyboard
		
		
		
		

		
		// show game
		j.add(canvas);
		j.setVisible(true);
		
		// get Objects to be able to use and move them
		Ball ball = canvas.getBall();
		Paddle computer = canvas.getComputer();
		Paddle user = canvas.getUser();
		j.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_UP && user.getYPos() > 10|| keyCode ==87 && user.getYPos() > 10) {
					canvas.setYPosition(changePaddleNumber);
				}
				else if (keyCode == KeyEvent.VK_DOWN && user.getYPos() < 520|| keyCode == 83 && user.getYPos() < 520) {
					canvas.setYPosition(changePaddleNumber * -1);		
				}
				j.repaint();
			}
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_UP && user.getYPos() > 10|| keyCode == 87 && user.getYPos() > 10) {
					canvas.setYPosition(changePaddleNumber * -1);
				}
				else if (keyCode == KeyEvent.VK_DOWN && user.getYPos() < 510|| keyCode == 83 && user.getYPos() < 510) {
					canvas.setYPosition(changePaddleNumber);
				}
				else if (keyCode == 88) {
					keepPlaying = false;
				}
				j.repaint();
			}
			public void keyReleased(KeyEvent e) {
				
			}
		});
		
		try {
			Thread.sleep(2000);
		}catch (Exception e) {
			
		}
		// play the game code 
		while (canvas.getPlayerScore() < 5 && keepPlaying && canvas.getComputerScore() < 5) {
			canvas.showDescriptionFalse();
			canvas.changeBallPosition(ball.getXSpeed(),ball.getYSpeed());
			// only move computer paddle if ball going towards computer paddle 
			if(ball.getXSpeed() < 0) {
				// only move if significant distance between ball and paddle
				int deltaPosComp = ball.getYPos() - computer.getYPos();
				if (deltaPosComp > 10 || deltaPosComp < -10) {
					//change computer paddle position
					int changePaddleLocation =3;
					if (ball.getYPos() < computer.getYPos()) {
						changePaddleLocation *= -1;
					}
					computer.changeYPosition(changePaddleLocation);
			}
		}
			// if user paddle collides with ball
			if (canvas.collides(ball, user)) {
				ball.changeXSpeed(ball.getXSpeed() * -1);
				ball.changeYSpeed(canvas.calculateYChange(user));
			}
			// if computer paddle collides with ball
			else if (canvas.collides(ball,computer)) {
				ball.changeXSpeed(ball.getXSpeed() * -1);
				ball.changeYSpeed(canvas.calculateYChange(computer));
			}
			// if ball hits top or bottom of frame
			else if (ball.getYPos() < 0 || ball.getYPos() > 550) {
				ball.changeYSpeed(ball.getYSpeed() * -1);
			}
			// if ball goes past users side
			else if (ball.getXPos() > 1020) {
				canvas.increaseComputerScore();
				try {
					Thread.sleep(3000);
				}
				catch (Exception e) {
				}
				ball.returnToCenter();
				computer.returnComputer();
				user.returnUser();
				canvas.showDescriptionTrue();
				j.repaint();
				try {
					Thread.sleep(2000);
				}
				catch (Exception e) {
				}
			}
			// if ball goes past computer side
			else if (ball.getXPos() < -20) {
				canvas.increasePlayerScore();
				try {
					Thread.sleep(3000);
				}
				catch (Exception e) {	
				}
				// return everything to origin position
				ball.returnToCenter();
				computer.returnComputer();
				user.returnUser();
				canvas.showDescriptionTrue();
				j.repaint(); 
				try {
					Thread.sleep(2000);
				}
				catch (Exception e) {
				}
			}
			try {
				Thread.sleep(15);
			}catch (Exception e) {
				
			}
			j.repaint();
		}
	}
}
