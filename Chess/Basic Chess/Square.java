/**
 * @(#)Square.java
 *
 *
 * @author Justin Dennis
 * @version 1.00 2016/5/6
 */


public class Square {
	
	private Piece piece;
	private boolean isSelected;

    public Square(Piece p) {
    	piece = p;
    	isSelected = false;
    }
    
    public boolean hasPiece(){
    	if(piece != null){
    		return true;
    	}
    	
    	return false;
    }
    
    public void select(){
    	isSelected = true;
    }
    
    public void deselect(){
    	isSelected = false;
    }
    
    public boolean getSelected(){
    	return isSelected;
    }
    
    public Piece getPiece(){
    	return piece;
    }
    
    public void setPiece(Piece p){
    	piece = p;
    }
    
    public String toString(){
    	if(piece == null){
    		return "null";
    	}
    	return piece.toString();
    }
    
}