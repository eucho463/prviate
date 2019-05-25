

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class MainWindow extends JPanel implements KeyListener{


	private final Color skyColor = Color.CYAN;
	private Image background;
	private Image clouds;

	public static JFrame mainWindow;
	private boolean spaceKeyPressed = false;

	public MainWindow() 
	{
		super();

		setBackground(skyColor);

		background = (new ImageIcon("Background.png")).getImage();
		clouds = (new ImageIcon("Clouds.png")).getImage();

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.drawImage(background, 0, 0, 1000, 700, this);

		Font myfont = new Font("Monospaced",Font.BOLD, 50);
		g.setFont(myfont);
		g.setColor(Color.CYAN);
		g.drawString("FLAPPY BIRD", 300, 150);

		Font myfont1 = new Font("Serif", Font.BOLD,20);
		g.setFont(myfont1);
		g.setColor(Color.CYAN);
		g.drawString("Press the spacebar to begin the game. Once you press the spacebar, the bird will move downwards.", 100,300);
		g.drawString("To make the bird go up, keep hitting the spacebar.", 275, 325);
		g.drawString("Once the bird is through a certain number of pipes, it will move on to the next level.",150,350); 


		g.drawImage(clouds, 140, 25, 120, 90, this);
		g.drawImage(clouds, 480, 25, 120, 90, this);
		g.drawImage(clouds, 250, 150, 120, 90, this);
		g.drawImage(clouds, 500, 200, 120, 90, this);
		g.drawImage(clouds, 50, 180, 120, 90, this);
		g.drawImage(clouds, 700, 150, 120, 90, this);
		g.drawImage(clouds, 800, 50, 120, 90, this);

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) 
			spaceKeyPressed = true;

	}

	public void keyReleased(KeyEvent e) {

	}

	public void run() {
		while(true) {


			if (spaceKeyPressed) {
				FlappyBird birdMain = new FlappyBird();
				birdMain.flappyBirdMain();
				mainWindow.dispatchEvent( new WindowEvent(mainWindow, WindowEvent.WINDOW_CLOSING));

			}
			repaint();	
		}
	}

	public static void main(String[] args)
	{
		mainWindow = new JFrame("MainWindow");
		mainWindow.setSize(1000,700);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = mainWindow.getContentPane();
		c.add(new MainWindow());
		mainWindow.setVisible(true);


		MainWindow panel = new MainWindow();

		mainWindow.addKeyListener(panel);
		mainWindow.add(panel);
		panel.run();
	}


	public void keyTyped(KeyEvent e) {


	}

}
