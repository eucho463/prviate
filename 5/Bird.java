
import java.awt.Rectangle;
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
	
	public boolean intersects(Pipes pipes) {
		int x = this.getX()+this.getWidth()/2;
		int y = this.getY()+this.getHeight()/2;
		
		for (Rectangle rect: pipes.getPipes())
		{
			if((x> rect.x && x< rect.x +rect.width) &&
			   (y> rect.y && y< rect.y +rect.height))	{
				return true;
			
			}
		}
		return false;
	}

		public void stop()
		{
			{
				velX = 0;
				velY=  0;
				moveByAmount((int)velX,(int)velY);
			}
		}

}