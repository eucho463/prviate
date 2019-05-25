import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FlappyBird extends JPanel implements KeyListener
{
	public static final int DRAWING_WIDTH = 1000;
	public static final int DRAWING_HEIGHT = 700;
	private Bird bird;
	private Pipes pipes;
	private Pages page;
	private MovingImage win, lose;
	private boolean spaceKeyPressed;
	

	public FlappyBird () {
		super();
		bird = new Bird(100,100);
		pipes = new Pipes();

		lose = new MovingImage("deadBird.jpg", 100,100,900,600);
		win = new MovingImage("win.png", 100,100,900,600);
		page = Pages.GAME;

		setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); 

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;

		Graphics2D g2 = (Graphics2D)g;
		g2.scale(ratioX,ratioY);
		
		switch(page)
		{
		case LOSE:

			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			lose.draw(g, this);
			break;
		case WIN:

			win.draw(g, this);
			break;
			
		default:
			bird.draw(g,this);
			pipes.draw(g);
			break;
		}
	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
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
				System.out.println("the bird jumped " + spaceKeyPressed);
				bird.jump();
			} 
			else 
			{
				bird.fall();
			}


			repaint();
			checkBird();

			{
				if(page == Pages.WIN || page == Pages.LOSE)
					break;
			}

			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void checkBird() {
		int x = bird.getX() + bird.getWidth()/2;
		int y = bird.getY() + bird.getHeight()/2;
		if (x < 0 || y > DRAWING_HEIGHT || y < 0 || bird.intersects(pipes)) {

			bird.stop();
			page = Pages.LOSE;
		}

		else if (x>= DRAWING_WIDTH)
		{
			bird.stop();
			page = Pages.WIN;
		}
	}

	public void flappyBirdMain()
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
