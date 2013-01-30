package fr.creeparena.util;

public class Coordonnee<Double> {
    private int x;
    private int y;
    
    public Coordonnee(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
    
    public int getX() { 
        return this.x; 
    } 
  
    public int getY() { 
        return this.y; 
    }
    
    public String toString() {
        return "x = " + x + "\ny = " + y + "\n";
    }
    
    
}
