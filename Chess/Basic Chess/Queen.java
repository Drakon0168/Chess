/**
 * @(#)Queen.java
 *
 *
 * @author Justin Dennis
 * @version 1.00 2016/6/3
 */

import java.awt.Point;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Queen extends Piece{

	Point[] moveLocations;
	boolean[] valid;

    public Queen(Point location, Color t, BufferedImage texture) {
    	super(location, "Queen", t, texture);
    	moveLocations = new Point[8];
    	moveLocations[0] = new Point(1,0);
    	moveLocations[1] = new Point(-1,0);
    	moveLocations[2] = new Point(0,1);
    	moveLocations[3] = new Point(0,-1);
    	moveLocations[4] = new Point(1,-1);
    	moveLocations[5] = new Point(1,1);
    	moveLocations[6] = new Point(-1,-1);
    	moveLocations[7] = new Point(-1,1);
    	valid = new boolean[8];
    	valid[0] = true;
    	valid[1] = true;
    	valid[2] = true;
    	valid[3] = true;
    	valid[4] = true;
    	valid[5] = true;
    	valid[6] = true;
    	valid[7] = true;
    }
    
    public void selectMoveLocations(Board b){
    	valid[0] = true;
    	valid[1] = true;
    	valid[2] = true;
    	valid[3] = true;
    	valid[4] = true;
    	valid[5] = true;
    	valid[6] = true;
    	valid[7] = true;
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
    	valid[4] = true;
    	valid[5] = true;
    	valid[6] = true;
    	valid[7] = true;
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