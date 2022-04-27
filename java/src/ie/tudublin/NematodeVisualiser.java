package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	
	Integer counter = 0;
	Integer colr = counter;
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
		//load nematodes into list
		loadNematodes();			
	}
	
	//list to store nematodes
	ArrayList<Nematode> nems = new ArrayList<>();
	public void loadNematodes()
	{
		
		Table nematodes = loadTable("nematodes.csv", "header");
		for(TableRow n:nematodes.rows())
		{
			Nematode nemat = new Nematode(n);
			nems.add(nemat);
		}

		System.out.println(nems);
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

		//variables for nematodes
		int circSize = 50;
		int ellipsex = 0;
		int ellipsey = -60;
		
		//drawing name
		textAlign(CENTER);
		text(nem.name, ellipsex, ellipsey - 100);

		//drawing nematodes
		strokeWeight(4);

		//pushmatrix to translate() and be able to draw eyes on correct circle
		pushMatrix();
		translate(ellipsex, ellipsey);
		if(nem.eyes == true)
		{
			//radius
			float r = circSize/2;

			//right eye
			float x = r * cos(-45);
			float y = r * sin(-45);

			float x2 = circSize * cos(-45);
			float y2 = circSize * sin(-45);
			line(x, y, x2, y2);

			noFill();
			ellipse(x2+5, y2-5, 10, 10);

			//left eye
			float x3 = r * cos(-90);
			float y3 = r * sin(-90);

			float x4 = circSize * cos(-90);
			float y4 = circSize * sin(-90);
			line(x3, y3, x4, y4);

			ellipse(x4-5, y4-5, 10, 10);
		}
		popMatrix();

		//for loop to draw correct number of circles for the nematodes
		for(int i = 0; i < nem.length; i++)
		{
			
			noFill();
			ellipse(ellipsex, ellipsey, circSize, circSize);

			//draw limbs
			if(nem.limbs == true)
			{
				line(ellipsex-circSize, ellipsey, ellipsex - circSize/2, ellipsey);
				line(ellipsex+circSize, ellipsey, ellipsex + circSize/2, ellipsey);
			}//end if

			//draw next circle under current
			ellipsey += 50;
		}//end for

		//bottom of nematode
		int bottom = ellipsey - circSize/2;

		//draw the genders
		if(nem.gender.equals("male") == true)
		{
			line(ellipsex, bottom, ellipsex, bottom+30);
			ellipse(ellipsex, bottom+35, 10, 10);
		}
		else if(nem.gender.equals("female") == true)
		{
			ellipse(ellipsex, ellipsey-50, circSize/2, circSize/2);
		}
		else if(nem.gender.equals("hermaphrodite") == true)
		{
			ellipse(ellipsex, ellipsey-50, circSize/2, circSize/2);

			line(ellipsex, bottom, ellipsex, bottom+30);
			ellipse(ellipsex, bottom+35, 10, 10);
		}//end genders 

	
	}//end draw
}
