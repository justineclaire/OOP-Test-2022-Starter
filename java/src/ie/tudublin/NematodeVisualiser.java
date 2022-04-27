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
		

		float col = map(counter, 0, nems.size(), 0, 255);
		fill(col, 255, 255);
		stroke(col, 255, 255);
		Nematode nem = nems.get(counter);
		textSize(30);
		text(nem.name, width/2, height/5);



	}
}
