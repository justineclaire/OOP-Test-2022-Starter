package ie.tudublin;
import processing.data.TableRow;

public class Nematode extends NematodeVisualiser {

    public String name;
    public Integer length;
    public Integer limbs;
    public String gender;
    public Integer eyes;

    public Nematode(TableRow n) 
    {
       this (
            n.getString("name"),
            n.getInt("length"),
            n.getInt("limbs"),
            n.getString("gender"),
            n.getInt("eyes")
       );
         
    }
 
    @Override
    public String toString() {
        return "Nematode []";
    }  

    public Nematode(String name, Integer length, Integer limbs, String gender, Integer eyes)
    {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }
    
}
