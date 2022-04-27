package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
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
	}
	

	public void loadNematodes()
	{
		ArrayList<Nematode> nems = new ArrayList<>();

		Table nematodes = loadTable("nematodes.csv", "header");
		for(TableRow n:nematodes.rows())
		{
			Nematode nem = new Nematode(n);
			nems.add(nem);
		}
	}


	public void draw()
	{	
	}
}
