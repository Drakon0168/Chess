/**
 * @(#)MouseInput.java
 *
 *
 * @author Justin Dennis
 * @version 1.00 2016/6/3
 */

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Point;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class MouseInput implements MouseListener, MouseMotionListener{

	private Point p, selected;
	private Board board;
	private JFrame frame;
	private boolean locked;
	private Color turn;
	private ImageIcon icon;

    public MouseInput(Board b, JFrame f, BufferedImage i) {
    	turn = Color.WHITE;
    	p = new Point(0,0);
    	icon = new ImageIcon(i);
    	selected = null;
    	board = b;
    	frame = f;
    	locked = false;
    }
    
    public void transformPawn(Pawn p){
    	String[] options = new String[4];
    	options[0] = "Rook";
    	options[1] = "Bishop";
    	options[2] = "Knight";
    	options[3] = "Queen";
    	int i = JOptionPane.showOptionDialog(frame, "Select A Piece", "Pawn Transformation", JOptionPane.DEFAULT_OPTION, 1, icon, options, options[3]);
    	p.transform(i, board);
    }
    
    public void mouseClicked(MouseEvent e){
    	p = new Point((e.getPoint().x - 9) / 70, (e.getPoint().y - 32) / 70);
    	if(!locked){
    		if(board.getPosition(p).getPiece() != null){
    			if(board.getPosition(p).getPiece().getTeam() == turn){
    				if(!(board.getPosition(p).getPiece() instanceof Pawn)){
	    				board.getPosition(p).getPiece().selectMoveLocations(board);
		    		}
		    		else{
		    			Pawn pawn = (Pawn)board.getPosition(p).getPiece();
		    			if(pawn.canAttack(board)){
		    				pawn.selectAttackLocations(board);
		    			}
		    			pawn.selectMoveLocations(board);
		    		}
		    		locked = true;
		    		selected = p;
		    		frame.repaint();
    			}
	    	}
    	}
    	else{
    		if(board.getPosition(p).getSelected()){
    			if(board.getPosition(p).getPiece() instanceof King){
    				board.setBoard();
    				turn = Color.WHITE;
    			}
    			else{
    				board.getPosition(selected).getPiece().deselectMoveLocations(board);
	    			board.getPosition(selected).getPiece().deselectAttackLocations(board);
	    			
	    			if(board.getPosition(selected).getPiece() instanceof Pawn){
	    				board.getPosition(p).setPiece(board.getPosition(selected).getPiece());
			    		Pawn pawn = (Pawn)board.getPosition(p).getPiece();
			    		pawn.pastFirstTurn();
	    				pawn.setLocation(p);
	    				board.getPosition(selected).setPiece(null);
	    				if(pawn.getLocation().y == 0 || pawn.getLocation().y == board.getSize() - 1){
	    					transformPawn(pawn);
	    				}
			    	}
			    	else{
			    		board.getPosition(p).setPiece(board.getPosition(selected).getPiece());
		    			board.getPosition(p).getPiece().setLocation(p);
		    			board.getPosition(selected).setPiece(null);
			    	}
	    			if(turn == Color.WHITE){
		    			turn = Color.BLACK;
		    		}
		    		else{
		    			turn = Color.WHITE;
		    		}
		    		System.out.println(board);
    			}
    		}
    		else{
    			board.getPosition(selected).getPiece().deselectMoveLocations(board);
    			board.getPosition(selected).getPiece().deselectAttackLocations(board);
    		}
    		locked = false;
    		selected = null;
    		frame.repaint();
    	}
    }
    
    public void mouseEntered(MouseEvent e){
    }
    
    public void mouseExited(MouseEvent e){
    }
    
    public void mousePressed(MouseEvent e){
    }
    
    public void mouseReleased(MouseEvent e){
    }
    
    public void mouseMoved(MouseEvent e){
    	if(!locked){
    		Point newPoint = new Point((e.getPoint().x - 9) / 70, (e.getPoint().y - 32) / 70);
    		if(newPoint.x != p.x || newPoint.y != p.y){
	    		if(board.getPosition(p).getPiece() != null){
	    			if(board.getPosition(p).getPiece().getTeam() == turn){
		    			board.getPosition(p).getPiece().deselectMoveLocations(board);
		    			board.getPosition(p).getPiece().deselectAttackLocations(board);
		    			frame.repaint();
	    			}
	    		}
	    		p = new Point(newPoint.x, newPoint.y);
	    		if(board.getPosition(p).getPiece() != null){
	    			if(board.getPosition(p).getPiece().getTeam() == turn){
		    			if(!(board.getPosition(p).getPiece() instanceof Pawn)){
		    				board.getPosition(p).getPiece().selectMoveLocations(board);
			    		}
			    		else{
			    			Pawn pawn = (Pawn)board.getPosition(p).getPiece();
			    			if(pawn.canAttack(board)){
			    				pawn.selectAttackLocations(board);
			    			}
			    			pawn.selectMoveLocations(board);
			    		}
		    			frame.repaint();
	    			}
	    		}
	    	}
    	}
    }
    
    public void mouseDragged(MouseEvent e){
    }
}