import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;


public class FlappyBird extends JPanel implements KeyListener
{
	public static final int DRAWING_WIDTH = 1000;
	public static final int DRAWING_HEIGHT = 700;
	private Bird bird;
	private Pipes pipes;
//	private PipesObject pipe;


	private boolean spaceKeyPressed;

	public FlappyBird () {
		super();
		bird = new Bird(100,100);
		pipes = new Pipes();
		
//		pipe = new PipesObject();
		setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;

		Graphics2D g2 = (Graphics2D)g;

		g2.scale(ratioX,ratioY);

		bird.draw(g,this);
		pipes.draw(g);
	}


	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			bird.jump();
			spaceKeyPressed = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if  (e.getKeyCode() == KeyEvent.VK_SPACE) {
			spaceKeyPressed = false;
		}
	}

	public void keyTyped(KeyEvent e) {

	}


	public void run() {
		while(true) {
			// MAKE A CHANGE
			System.out.println(spaceKeyPressed);
//			if(bird.stop())
//			{
//				bird.stop();
//			
//			}	
//				
			 if (spaceKeyPressed) {
				System.out.println(spaceKeyPressed+ "jump");
				bird.jump();
			} 
			else 
			{
				System.out.println(spaceKeyPressed+ "fall");
				bird.fall();
			}
		
			checkBird();

			//show the change
			repaint();


			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	

//	public void intersects(Rectangle r)
//	{
//		boolean intersects = false;
//
//		if (bird.intersects(pipe))
//		{
//			intersects = true;
//			bird.stop();
//		}
//
//	}

	public void checkBird() {
		int x = bird.getX() + bird.getWidth()/2;
		int y = bird.getY() + bird.getHeight()/2;
		if (x < 0 || x > DRAWING_WIDTH || y > 0 || y > DRAWING_HEIGHT)
			//
			//	bird = new Bird(380,0);
			if (pipes.collided(bird))
			{
				bird.stop();
			}
		bird.stop();
	}


	public static void main(String[] args)
	{
		JFrame w = new JFrame("Flappy Bird");
		w.setBounds(100, 100, 1000, 700);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlappyBird panel = new FlappyBird();
		w.addKeyListener(panel);
		w.add(panel);
		w.setResizable(false);
		w.setVisible(true);

		panel.run();
	}
}
