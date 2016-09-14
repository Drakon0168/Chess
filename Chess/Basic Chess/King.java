/**
 * @(#)King.java
 *
 *
 * @author Justin Dennis
 * @version 1.00 2016/5/6
 */
import java.awt.Point;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class King extends Piece{

	Point[] moveLocations;
	Point[] attackLocations;

    public King(Point loc, Color t, BufferedImage texture) {
    	super(loc, "King", t, texture);
    	moveLocations = new Point[8];
    	attackLocations = new Point[8];
    	int index = 0;
    	for(int x = -1; x <= 1; x++){
    		for(int y = -1; y <= 1; y++){
    			if(x != 0 || y != 0){
	    			moveLocations[index] = new Point(x,y);
	    			attackLocations[index] = new Point(x,y);
	    			index++;
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