import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class MainWindow extends JPanel{
	 private static final String CARD_JBUTTON =  "Card JButton";
	private boolean space,key1;
	private final Color skyColor = Color.CYAN;
	private Image background;
	private Image clouds;
	
	
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
	   g.drawString("Press the button to begin the game. Once you press the spacebar, the bird will move downwards.", 100,300);
	   g.drawString("To make the bird go up, keep hitting the spacebar.", 275, 325);
	   g.drawString("Once the bird is through all the pipes, it will move on to the next level.",190,350); 
	   
	   
	   g.drawImage(clouds, 140, 25, 120, 90, this);
	   g.drawImage(clouds, 480, 25, 120, 90, this);
	   g.drawImage(clouds, 250, 150, 120, 90, this);
	   g.drawImage(clouds, 500, 200, 120, 90, this);
	   g.drawImage(clouds, 50, 180, 120, 90, this);
	   g.drawImage(clouds, 700, 150, 120, 90, this);
	   g.drawImage(clouds, 800, 50, 120, 90, this);
		


	}
	public static void showButton()
	{
		final JPanel contentPane = new JPanel();
		contentPane.setLayout(new CardLayout(20, 20));
////	    Window1 win1 = new Window1();
////        contentPane.add(win1, CARD_JBUTTON);
//		JFrame frame = new JFrame("Card Layout Test");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLocationRelativeTo(null);

		// This JPanel is the base for CardLayout for other JPanels.
	
		JPanel buttonPanel = new JPanel(); 
		final JButton startButton = new JButton("START");
		startButton.setBounds(50,150,100,30);
		startButton.setBackground(Color.BLACK);
		startButton.setForeground(Color.WHITE);
		buttonPanel.add(startButton);

		startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
				cardLayout.previous(contentPane);
			}
		});
	}



	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_1) {
			key1 = true;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			space = true;
		} 
	}
	
	 public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		  key1 = false;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		  	space = false;
		}
	 }
	  public void run()
	  {
		  showButton();
	  }
	public static void main(String[] args)
	{
	//	 showButton();
	  JFrame MainWindow = new JFrame("MainWindow");
	  MainWindow.setSize(1000,700);
	  MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  Container c = MainWindow.getContentPane();
	  c.add(new MainWindow());
	  
	  MainWindow.setVisible(true);
	  MainWindow.setResizable(false);
   }
}