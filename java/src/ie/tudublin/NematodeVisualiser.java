package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	
	Integer counter = 0;
	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
			counter--;
			if(counter < 0)
			{
				counter = nems.size()-1;
			}
			
		}	
		if (keyCode == RIGHT)
		{
			counter++;
			if(counter == nems.size())
			{
				counter = 0;
			}
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();	
		loadNematodes();			
	}
	
	ArrayList<Nematode> nems = new ArrayList<>();
	public void loadNematodes()
	{
		
		Table nematodes = loadTable("nematodes.csv", "header");
		for(TableRow n:nematodes.rows())
		{
			Nematode nemat = new Nematode(n);
			nems.add(nemat);
		}
	}


	public void draw()
	{	
		
		background(0);
		//initialising colours and which nematode to draw
		translate(width/2, height/2);
		float col = map(counter, 0, nems.size(), 0, 255);
		fill(col, 255, 255);
		stroke(col, 255, 255);
		Nematode nem = nems.get(counter);

		//names
		textSize(30);
		//text(nem.name, 0, -200);

		//arrows
		strokeWeight(10);
		line(-350, 0, -250, 0);
		line(-350, 0, -300, 20);
		line(-350, 0, -300, -20);

		line(350, 0, 250, 0);
		line(350, 0, 300, 20);
		line(350, 0, 300, -20);

		int circSize = 50;

		int ellipsex = 0;
		int ellipsey = -50;
		textAlign(CENTER);
		text(nem.name, ellipsex, ellipsey - 100);
		for(int i = 0; i < nem.length; i++)
		{
			
			strokeWeight(4);
			noFill();
			ellipse(ellipsex, ellipsey, circSize, circSize);

			if(nem.limbs == true)
			{
				line(ellipsex-circSize, ellipsey, ellipsex - circSize/2, ellipsey);
				line(ellipsex+circSize, ellipsey, ellipsex + circSize/2, ellipsey);
			}

			ellipsey += 50;
		}

		
	}
}
