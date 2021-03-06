/**
 * @(#)Bishop.java
 *
 *
 * @author Justin Dennis
 * @version 1.00 2016/5/24
 */

import java.awt.Point;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Bishop extends Piece{
	
	Point[] moveLocations;
	boolean[] valid;

    public Bishop(Point location, Color t, BufferedImage texture) {
    	super(location, "Bishop", t, texture);
    	valid = new boolean[4];
    	moveLocations = new Point[4];
    	valid[0] = true;
    	valid[1] = true;
    	valid[2] = true;
    	valid[3] = true;
    	moveLocations[0] = new Point(1,-1);
    	moveLocations[1] = new Point(1,1);
    	moveLocations[2] = new Point(-1,-1);
    	moveLocations[3] = new Point(-1,1);
    }
    
    public void selectMoveLocations(Board b){
    	valid[0] = true;
    	valid[1] = true;
    	valid[2] = true;
    	valid[3] = true;
    	for(int i = 1; i < b.getSize(); i++){
    		for(int j = 0; j < moveLocations.length; j++){
    			Point spot = new Point(location.x + (moveLocations[j].x * i), location.y + (moveLocations[j].y * i));
    			if(spot.x < b.getSize() && spot.x >= 0 && spot.y < b.getSize() && spot.y >= 0){
    				if(b.getPosition(spot).getPiece() != null && b.getPosition(spot).getPiece().getTeam() == team){
    					valid[j] = false;
    				}
    				if(valid[j]){
	    				b.getPosition(spot).select();
	    			}
	    			if(b.getPosition(spot).getPiece() != null){
	    				valid[j] = false;
	    			}
    			}
    		}
    	}
    }
    
    public void selectAttackLocations(Board b){
    	
    }
    
    public void deselectMoveLocations(Board b){
    	valid[0] = true;
    	valid[1] = true;
    	valid[2] = true;
    	valid[3] = true;
    	for(int i = 1; i < b.getSize(); i++){
    		for(int j = 0; j < moveLocations.length; j++){
    			Point spot = new Point(location.x + (moveLocations[j].x * i), location.y + (moveLocations[j].y * i));
    			if(spot.x < b.getSize() && spot.x >= 0 && spot.y < b.getSize() && spot.y >= 0){
    				if(b.getPosition(spot).getPiece() != null && b.getPosition(spot).getPiece().getTeam() == team){
    					valid[j] = false;
    				}
    				if(valid[j]){
	    				b.getPosition(spot).deselect();
	    			}
	    			if(b.getPosition(spot).getPiece() != null){
	    				valid[j] = false;
	    			}
    			}
    		}
    	}
    }
    
    public void deselectAttackLocations(Board b){
    	
    }
    
    public Point[] getMoveLocations(){
    	return moveLocations;
    }
    
    public Point[] getAttackLocations(){
    	return moveLocations;
    }
}