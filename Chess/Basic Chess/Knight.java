/**
 * @(#)Knight.java
 *
 *
 * @author Justin Dennis
 * @version 1.00 2016/5/23
 */

import java.awt.Point;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Knight extends Piece{

	Point[] moveLocations;
	Point[] attackLocations;

    public Knight(Point loc, Color t, BufferedImage texture) {
    	super(loc, "Knight", t, texture);
    	moveLocations = new Point[8];
    	attackLocations = new Point[8];
    	int index = 0;
    	for(int i = 0; i < 2; i++){
    		for(int x = -2; x <= 2; x += 4){
	    		for(int y = -1; y <= 1; y += 2){
	    			if(x != 0 || y != 0){
	    				if(x != y && x != -1 * y){
	    					if(i == 0){
	    						moveLocations[index] = new Point(x,y);
				    			attackLocations[index] = new Point(x,y);
				    			index++;
	    					}
	    					else{
	    						moveLocations[index] = new Point(y,x);
				    			attackLocations[index] = new Point(y,x);
				    			index++;
	    					}
	    				}
	    			}
	    		}
	    	}
    	}
    }
    
    public void selectMoveLocations(Board b){
    	for(Point p : moveLocations){
    		if(location.x + p.x >= 0 && location.x + p.x < b.getSize() && location.y + p.y >= 0 && location.y + p.y < b.getSize()){
    			if(b.getPosition(location.y + p.y, location.x + p.x).getPiece() == null || b.getPosition(location.y + p.y, location.x + p.x).getPiece().getTeam() != team){
    				b.getPosition(location.y + p.y, location.x + p.x).select();
    			}
    		}
    	}
    }
    
    public void selectAttackLocations(Board b){
    	for(Point p : attackLocations){
    		if(location.x + p.x >= 0 && location.x + p.x < b.getSize() && location.y + p.y >= 0 && location.y + p.y < b.getSize()){
    			if(b.getPosition(location.y + p.y, location.x + p.x).getPiece() == null || b.getPosition(location.y + p.y, location.x + p.x).getPiece().getTeam() != team){
    				b.getPosition(location.y + p.y, location.x + p.x).select();
    			}
    		}
    	}
    }
    
    public void deselectMoveLocations(Board b){
    	for(Point p : moveLocations){
    		if(location.x + p.x >= 0 && location.x + p.x < b.getSize() && location.y + p.y >= 0 && location.y + p.y < b.getSize()){
    			if(b.getPosition(location.y + p.y, location.x + p.x).getPiece() == null || b.getPosition(location.y + p.y, location.x + p.x).getPiece().getTeam() != team){
    				b.getPosition(location.y + p.y, location.x + p.x).deselect();
    			}
    		}
    	}
    }
    
    public void deselectAttackLocations(Board b){
    	for(Point p : attackLocations){
    		if(location.x + p.x >= 0 && location.x + p.x < b.getSize() && location.y + p.y >= 0 && location.y + p.y < b.getSize()){
    			if(b.getPosition(location.y + p.y, location.x + p.x).getPiece() == null || b.getPosition(location.y + p.y, location.x + p.x).getPiece().getTeam() != team){
    				b.getPosition(location.y + p.y, location.x + p.x).deselect();
    			}
    		}
    	}
    }
    
    public Point[] getMoveLocations(){
    	return moveLocations;
    }
    
    public Point[] getAttackLocations(){
    	return attackLocations;
    }
}