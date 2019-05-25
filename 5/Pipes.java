
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Pipes extends JPanel {
	private ArrayList<Rectangle> pipelist;
	public Pipes()
	{
		//first set of columns (top and bottom)
		
		pipelist = new ArrayList<Rectangle>();
				pipelist.add( new Rectangle(250, 0, 70, 290));
				pipelist.add( new Rectangle(250, 490, 70, 240));

				//second set of columns
				pipelist.add( new Rectangle(470, 0, 70, 340));
				pipelist.add( new Rectangle(470, 520, 70, 190));

				//third set of columns
				pipelist.add( new Rectangle(700, 0, 70, 200));
				pipelist.add( new Rectangle(700, 350, 70, 500));

				//fourth set of columns
				pipelist.add( new Rectangle(930, 0, 70, 380));
				pipelist.add( new Rectangle(930, 550, 70, 150));

		//repaint();
	}

	public ArrayList<Rectangle> getPipes()
	{
		return pipelist;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setColor(Color.GREEN); 

	for(Rectangle rect : pipelist)
	{
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}


	}

	public void draw(Graphics g)
	{
		g.setColor(Color.GREEN);  
		for(Rectangle rect : pipelist)
		{
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}

	}

	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}


}