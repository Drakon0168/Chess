/**
 * @(#)Pawn.java
 *
 *
 * @author Justin Dennis
 * @version 1.00 2016/5/6
 */
 
import java.awt.Point;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Pawn extends Piece{

	Point[] moveLocations;
	Point[] attackLocations;
	int direction;
	BufferedImage[] textures;

    public Pawn(Point loc, Color t, BufferedImage[] Textures, int d) {
    	super(loc, "Pawn", t, Textures[2]);
    	direction = d;
    	textures = Textures;
    	moveLocations = new Point[2];
    	attackLocations = new Point[2];
    	moveLocations[0] = new Point(0, direction);
    	moveLocations[1] = new Point(0, 2 * direction);
    	attackLocations[0] = new Point(1, direction);
    	attackLocations[1] = new Point(-1, direction);
    }
    
    public void switchDirection(){
    	direction *= -1;
    	moveLocations[0] = new Point(0, direction);
    	attackLocations[0] = new Point(1, direction);
    	attackLocations[1] = new Point(-1, direction);
    }
    
    public void selectMoveLocations(Board b){
    	boolean valid = true;
    	for(Point p : moveLocations){
    		if(location.x + p.x >= 0 && location.x + p.x < b.getSize() && location.y + p.y >= 0 && location.y + p.y < b.getSize()){
    			if(b.getPosition(location.y + p.y, location.x + p.x).getPiece() == null && valid){
    				b.getPosition(location.y + p.y, location.x + p.x).select();
    			}
    			else{
    				valid = false;
    			}
    		}
    	}
    }
    
    public void pastFirstTurn(){
    	moveLocations = new Point[1];
    	moveLocations[0] = new Point(0, direction);
    }
    
    public void selectAttackLocations(Board b){
    	for(Point p : attackLocations){
    		if(location.x + p.x >= 0 && location.x + p.x < b.getSize() && location.y + p.y >= 0 && location.y + p.y < b.getSize()){
    			if(b.getPosition(location.y + p.y, location.x + p.x).getPiece() != null && b.getPosition(location.y + p.y, location.x + p.x).getPiece().getTeam() != team){
    				b.getPosition(location.y + p.y, location.x + p.x).select();
    			}
    		}
    	}
    }
    
    public void deselectMoveLocations(Board b){
    	for(Point p : moveLocations){
    		if(location.x + p.x >= 0 && location.x + p.x < b.getSize() && location.y + p.y >= 0 && location.y + p.y < b.getSize()){
    			if(b.getPosition(location.y + p.y, location.x + p.x).getPiece() == null){
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
    
    public boolean canAttack(Board b){
    	for(Point p : attackLocations){
    		if(location.x + p.x >= 0 && location.x + p.x < b.getSize() && location.y + p.y >= 0 && location.y + p.y < b.getSize()){
    			if(b.getPosition(location.y + p.y, location.x + p.x).getPiece() != null && b.getPosition(location.y + p.y, location.x + p.x).getPiece().getTeam() != team){
    				return true;
    				
    			}
    		}
    	}
    	return false;
    }
    
    public void transform(int i, Board b){
    	Piece newPiece = new Queen(location, team, textures[1]);;
    	switch(i){
    		case 0:
    			newPiece = new Rook(location, team, textures[4]);
    			break;
    		case 1:
    			newPiece = new Bishop(location, team, textures[5]);
    			break;
    		case 2:
    			newPiece = new Knight(location, team, textures[3]);
    			break;
    		case 3:
    			newPiece = new Queen(location, team, textures[1]);
    			break;
    	}
    	b.getPosition(location).setPiece(newPiece);
    }
    
    public Point[] getMoveLocations(){
    	return moveLocations;
    }
    
    public Point[] getAttackLocations(){
    	return attackLocations;
    }
}