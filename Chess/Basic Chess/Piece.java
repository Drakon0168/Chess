/**
 * @(#)Piece.java
 *
 *
 * @author Justin Dennis
 * @version 1.00 2016/5/4
 */
 
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Piece {
	
	protected Point location;
	protected String name;
	protected BufferedImage texture, tint;
	protected Color team, shade;
	
    public Piece(Point loc, String n, Color t, BufferedImage i) {
    	name = n;
    	location = loc;
    	team = t;
    	if(t == Color.WHITE){
    		shade =	new Color(t.getRed(), t.getGreen(), t.getBlue(), 175);
    	}
    	else{
    		shade = new Color(t.getRed(), t.getGreen(), t.getBlue(), 200);
    	}
    	texture = i;
    	tint = new BufferedImage(i.getColorModel(), i.copyData(null), i.isAlphaPremultiplied(), null);
    	for(int y = 0; y < tint.getHeight(); y++){
    		for(int x = 0; x < tint.getWidth(); x++){
    			if(new Color(tint.getRGB(x,y), true).getAlpha() != 0){
    				tint.setRGB(x,y,shade.getRGB());
    			}
    		}
    	}
    }
    
    public abstract void selectAttackLocations(Board b);
    	
    public abstract void selectMoveLocations(Board b);
    
    public abstract void deselectAttackLocations(Board b);
    	
    public abstract void deselectMoveLocations(Board b);
    
    public Color getTeam(){
    	return team;
    }
    
    public void draw(Graphics g, int size, int squares, int x, int y){
    	g.drawImage(texture, x * (size/squares), y * (size/squares), (size/squares), (size/squares), null);
    	g.drawImage(tint, x * (size/squares), y * (size/squares), (size/squares), (size/squares), null);
    }
    
    public Point getLocation(){
    	return location;
    }
    
    public void setLocation(Point loc){
    	location = loc;
    }
    
    public abstract Point[] getMoveLocations();
   
    public abstract Point[] getAttackLocations();
    
    public BufferedImage getImage(){
    	return texture;
    }
    
    public void setImage(BufferedImage t){
    	texture = t;
    }
    
    public String toString(){
    	return name;
    }
}