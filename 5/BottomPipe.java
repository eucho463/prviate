import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BottomPipe extends MovingImage {
	
	private double velX, velY;
	private boolean touchBird;
	private Bird bird;

	public BottomPipe(int x, int y, int width, int height)
	{
		super("pipeDown.png",x,y,width,height);
		velX = 0;
		velY = 0;	
		touchBird = false;
	}

//	public void paintComponent(Graphics g)
//	{
//		super.paintComponent(g);
//
//		g.setColor(Color.GREEN); // color of the sun 
//
//		//first set of columns (top and bottom)
//		g.fillRect(250, 0, 70, 290);
//		g.fillRect(250, 460, 70, 240);
//
//		//second set of columns
//		g.fillRect(470, 0, 70, 340);
//		g.fillRect(470, 490, 70, 190);
//
//		//third set of columns
//		g.fillRect(700, 0, 70, 200);
//		g.fillRect(700, 350, 70, 500);
//
//		//fourth set of columns
//		g.fillRect(930, 0, 70, 380);
//		g.fillRect(930, 530, 70, 150);
//
//
//
//	}

/*	
	public void draw(Graphics g)
	{
		//TopPipe pipe1 = new TopPipe(250,0,70,290);
		
		
		g.setColor(Color.GREEN); // color of the sun 
		//first set of columns (top and bottom)
		g.fillRect(250, 0, 70, 290);
		g.fillRect(250, 460, 70, 240);
		//second set of columns
		g.fillRect(470, 0, 70, 340);
		g.fillRect(470, 520, 70, 190);
		//third set of columns
		g.fillRect(700, 0, 70, 200);
		g.fillRect(700, 350, 70, 500);
		//fourth set of columns
		g.fillRect(930, 0, 70, 380);
		g.fillRect(930, 550, 70, 150);
	}
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
	public boolean collided(Bird bird) {
		// TODO Auto-generated method stub
		
		bird.getX();
		bird.getY();
	
		return false;
	}*/

//
//
}