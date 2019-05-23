import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

//import practice.FlappyBird;


public class FlappyBird2 extends JPanel implements KeyListener
{
	public static final int DRAWING_WIDTH = 1000;
	public static final int DRAWING_HEIGHT = 700;
	private Bird bird;
	private TopPipe topPipe1;
	private TopPipe topPipe2;
	private TopPipe topPipe3;
	private TopPipe topPipe4;
	
	private BottomPipe bottomPipe1;
	private BottomPipe bottomPipe2;
	private BottomPipe bottomPipe3;
	private BottomPipe bottomPipe4;

	private boolean spaceKeyPressed;

	public FlappyBird2 () {
		super();
		bird = new Bird(100,100);
		topPipe1 = new TopPipe(250,0,70,290);
		bottomPipe1 = new BottomPipe(250, 460, 70, 260);

		//second set of columns
		topPipe2 = new TopPipe(470, 0, 70, 340);
		bottomPipe2 = new BottomPipe(470, 490, 70, 210);

		//third set of columns
		topPipe3 = new TopPipe(700, 0, 70, 200);
		bottomPipe3 = new BottomPipe(700, 350, 70, 500);

		//fourth set of columns
		topPipe4 = new TopPipe(930, 0, 70, 380);
		bottomPipe4 = new BottomPipe(930, 530, 70, 170);
		
		
//		pipe = new PipesObject();
		setBackground(Color.WHITE);
	}
	
	public boolean collided(Bird bird) {
		// TODO Auto-generated method stub
		boolean touchedPipe = false;
		
		int birdX = bird.getX();
		int birdY = bird.getY();
		System.out.println("Bird Coordinates: " + birdX + " , " + birdY);
		int topPipe1X = topPipe1.getX();
		int topPipe1Y = topPipe1.getY();
		System.out.println("Pipe 1 Coordinates: " + topPipe1X + " , " + topPipe1Y);
//		if (bird.isPointInImage(topPipe1X, topPipe1Y))
//		{
//			touchedPipe = true;
//		}
		
		if (topPipe1.isPointInImage(birdY, birdX ))
		{
			touchedPipe = true;
		}
		if (topPipe2.isPointInImage(birdX, birdY))
		{
			touchedPipe = true;
		}
		if (topPipe3.isPointInImage(birdX, birdY))
		{
			touchedPipe = true;
		}
		
		return touchedPipe;
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
		topPipe1.draw(g,this);
		topPipe2.draw(g,this);
		topPipe3.draw(g,this);
		topPipe4.draw(g,this);
		
		bottomPipe1.draw(g,this);
		bottomPipe2.draw(g,this);
		bottomPipe3.draw(g,this);
		bottomPipe4.draw(g,this);
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

			 if (spaceKeyPressed) {
				//System.out.println(spaceKeyPressed+ "jump");
				bird.jump();
				if (collided(bird)) {
					bird.stop();
				}
			} 
			else 
			{
				//System.out.println(spaceKeyPressed+ "fall");
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

	



	public void checkBird() {
		int x = bird.getX() + bird.getWidth()/2;
		int y = bird.getY() + bird.getHeight()/2;
		if (x < 0 || x >= DRAWING_WIDTH || y > 0 || y > DRAWING_HEIGHT)

		bird.stop();
	}


	public static void main(String[] args)
	{
		JFrame w = new JFrame("Flappy Bird");
		w.setBounds(100, 100, 1000, 700);   
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlappyBird2 panel = new FlappyBird2();
		w.addKeyListener(panel);
		w.add(panel);
		w.setResizable(false);
		w.setVisible(true);

		panel.run();
	}
}