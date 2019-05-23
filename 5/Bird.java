
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Bird extends MovingImage {

	private double velX, velY;

	public Bird(int x, int y)
	{
		super("bird.png",x,y,40,50);

		
	}



	public void fall()
	{

		{
			velX = 5;
			velY = 10;
			System.out.println("birdfall");
			moveByAmount((int)velX,(int)velY);
		}
	}

	public void jump()
	{

		{
			velX = 5;
			velY= -20;
			System.out.println("birdjump");
			moveByAmount((int)velX,(int)velY);
	
		}
	}



		public void stop()
		{
			
				velX = 0;
				velY=  0;
				moveByAmount((int)velX,(int)velY);
				System.out.println("stop");
				
			
		}


//		public boolean intersects(PipesObject pipe) {
//			// TODO Auto-generated method stub
//			return false;
//		}






}
