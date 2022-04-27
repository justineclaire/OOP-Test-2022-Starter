package ie.tudublin;

import processing.data.TableRow;

public class Nematode extends NematodeVisualiser {

    public String name;
    public Integer length;
    public Boolean limbs;
    public String gender;
    public Boolean eyes;

    public Nematode(TableRow n) 
    {
       this (
            n.getString("name"),
            n.getInt("length"),
            n.getInt("limbs") == 1,
            n.getString("gender"),
            n.getInt("eyes") == 1
       );
         
    }
 
    @Override
    public String toString() {
        String limb;
        String eye;

        if(gender.equals(str('m')) == true)
		{
			gender = "male";
		}
		else if(gender.equals(str('f')) == true)
		{
			gender = "female";
		}
		else if(gender.equals(str('h')) == true)
		{
			gender = "hermaphrodite";
		}
        else
        {
            gender = "not gendered";
        }

        if(limbs)
        {
            limb = "do";
        }
        else
        {
            limb = "do not";
        }

        if(eyes)
        {
            eye = "do";
        }
        else
        {
            eye = "do not";
        }

            return name+", " + length + " circle(s) long, is " + gender + ", "+eye+" have eyes and "+limb+" have limbs\n";
    }
        
    

    public Nematode(String name, Integer length, Boolean limbs, String gender, Boolean eyes)
    {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }
    
}
