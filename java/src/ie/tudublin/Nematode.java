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

            return name+": is "+length+" circles long, and is of gender "+gender;
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
