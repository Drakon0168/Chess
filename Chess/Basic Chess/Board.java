/**
 * @(#)Board.java
 *
 *
 * @author JustinDennis
 * @version 1.00 2016/5/4
 */
import java.util.ArrayList;
import java.awt.Point;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Board {
	
	Square[][] positions;
	BufferedImage[] images;
	int size;
	ArrayList<Piece> pieces;

    public Board(int s, BufferedImage[] i) {
    	size = s;
    	positions = new Square[size][size];
    	images = i;
    	setBoard();
    }
    
    public Square[][] getBoard(){
    	return positions;
    }
    
    public void setBoard(){
    	pieces = new ArrayList<Piece>();
    	int index = 0;
    	for(int i = 0; i < positions.length; i++){
    		for(int j = 0; j < positions[0].length; j++){
    			positions[i][j] = new Square(null);
    			if(i == 0){
    				if(j == (size / 2)){
    					pieces.add(new King(new Point(j,i), Color.WHITE, images[0]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == size - 1){
    					pieces.add(new Rook(new Point(j,i), Color.WHITE, images[4]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == 0){
    					pieces.add(new Rook(new Point(j,i), Color.WHITE, images[4]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == size - 2){
    					pieces.add(new Knight(new Point(j,i), Color.WHITE, images[3]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == 1){
    					pieces.add(new Knight(new Point(j,i), Color.WHITE, images[3]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == size - 3){
    					pieces.add(new Bishop(new Point(j,i), Color.WHITE, images[5]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == 2){
    					pieces.add(new Bishop(new Point(j,i), Color.WHITE, images[5]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == size - 4){
    					pieces.add(new Queen(new Point(j,i), Color.WHITE, images[1]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == 3){
    					pieces.add(new Queen(new Point(j,i), Color.WHITE, images[1]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    			}
    			
    			if(i == 1){
    				pieces.add(new Pawn(new Point(j,i), Color.WHITE, images, 1));
    				positions[i][j].setPiece(pieces.get(index));
    				index++;
    			}
    			
    			if(i == positions.length - 1){
    				if(j == (size / 2)){
    					pieces.add(new King(new Point(j,i), Color.BLACK, images[0]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == size - 1){
    					pieces.add(new Rook(new Point(j,i), Color.BLACK, images[4]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == 0){
    					pieces.add(new Rook(new Point(j,i), Color.BLACK, images[4]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == size - 2){
    					pieces.add(new Knight(new Point(j,i), Color.BLACK, images[3]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == 1){
    					pieces.add(new Knight(new Point(j,i), Color.BLACK, images[3]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == size - 3){
    					pieces.add(new Bishop(new Point(j,i), Color.BLACK, images[5]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == 2){
    					pieces.add(new Bishop(new Point(j,i), Color.BLACK, images[5]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == size - 4){
    					pieces.add(new Queen(new Point(j,i), Color.BLACK, images[1]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    				if(j == 3){
    					pieces.add(new Queen(new Point(j,i), Color.BLACK, images[1]));
    					positions[i][j].setPiece(pieces.get(index));
    					index++;
    				}
    			}
    			
    			if(i == positions.length - 2){
    				pieces.add(new Pawn(new Point(j,i), Color.BLACK, images, -1));
    				positions[i][j].setPiece(pieces.get(index));
    				index++;
    			}
    		}
    	}
    }
    
    public void deselectAll(){
    	for(int i = 0; i < size; i++){
    		for(int j = 0; j < size; j++){
    			positions[i][j].deselect();
    		}
    	}
    }
    
    public Square getPosition(int x, int y){
    	return positions[x][y];
    }
    
    public Square getPosition(Point p){
    	if(p.x < size && p.y < size && p.x >= 0 && p.y >= 0){
    		return positions[p.y][p.x];
    	}
    	System.out.println("Out of bounds : (" + p.x + ", " + p.y + ")");
    	return null;
    }
    
    public int getSize(){
    	return size;
    }
    
    public String toString(){
    	String s = "";
    	for(int i = 0; i < positions.length; i++){
    		for(int j = 0; j < positions[0].length; j++){
    			if(positions[i][j].hasPiece()){
    				s += positions[i][j].toString().substring(0,4);
    			}
    			else{
    				s += "    ";
    			}
    			if(j < positions[0].length - 1){
    				s += "|";
    			}
    		}
    		s += "\n";
    		for(int j  = 0; j < positions[0].length; j++){
    			s += "----";
    			if(j < positions[0].length - 1){
    				s += "-";
    			}
    		}
    		s += "\n";
    	}
    	
    	return s;
    }
}