/**
 * @(#)Starter.java
 *
 *
 * @author Justin Dennis
 * @version 1.00 2016/5/4
 */
 
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.imageio.ImageIO;
 import java.io.File;
 import java.io.IOException;
 import java.awt.Dimension;
 import java.awt.Graphics;
 import java.awt.Color;
 import java.awt.image.BufferedImage;

public class Starter{
	
    public Starter() {
    }
    
    public static void main(String[] args) {
    	BufferedImage[] images = new BufferedImage[8];
    	try{
    		images[0] = ImageIO.read(new File(".\\Sprites\\King.png"));
    		images[1] = ImageIO.read(new File(".\\Sprites\\Queen.png"));
    		images[2] = ImageIO.read(new File(".\\Sprites\\Pawn.png"));
    		images[3] = ImageIO.read(new File(".\\Sprites\\Knight.png"));
    		images[4] = ImageIO.read(new File(".\\Sprites\\Rook.png"));
    		images[5] = ImageIO.read(new File(".\\Sprites\\Bishop.png"));
    		images[6] = ImageIO.read(new File(".\\Sprites\\Selected.png"));
    		images[7] = ImageIO.read(new File(".\\Sprites\\Shadow.png"));
    	}
    	catch(IOException e){
    	}
    	int size = 630;
    	int squares = 9;
    	Board board = new Board(squares, images);
    	
    	JFrame frame = new JFrame("Battle Chess");
    	frame.setResizable(false);
    	frame.setIconImage(images[0]);
    	frame.setDefaultCloseOperation(3);
    	frame.setVisible(true);
    	
    	JPanel canvas = new JPanel(){
    		public void paintComponent(Graphics g){
    			g.setColor(Color.white);
    			g.fillRect(0,0,size,size);
    			g.setColor(new Color(0.7f,0.7f,0.7f));
    			for(int i = 0; i < squares; i++){
    				for(int j = 0; j < squares; j++){
    					if(i % 2 == 0){
    						if(j % 2 != 0){
    							g.fillRect(i * (size/squares), j * (size/squares), (size/squares), (size/squares));
    						}
    					}
    					else{
    						if(j % 2 == 0){
    							g.fillRect(i * (size/squares), j * (size/squares), (size/squares), (size/squares));
    						}
    					}
    				}
    			}
    			
    			for(int i = 0; i < squares; i++){
    				for(int j = 0; j < squares; j++){
    					if(board.getPosition(i,j).getSelected()){
    						g.drawImage(images[6], j * (size/squares), i * (size/squares), (size/squares), (size/squares), null);
    					}
    					
    					if(board.getPosition(i,j).getPiece() != null){
    						board.getPosition(i,j).getPiece().draw(g, size, squares, j, i);
    						if(!(board.getPosition(i,j).getPiece() instanceof King)){
    							g.drawImage(images[7], j * (size/squares), i * (size/squares), (size/squares), (size/squares), null);
    						}
    					}
    				}
    			}
    		}
    	};
    	
    	frame.setPreferredSize(new Dimension(size + (int)((size/squares) * 0.25f), size + (int)((size/squares) * 0.55f)));
    	frame.add(canvas);
    	frame.pack();
    	
    	MouseInput input = new MouseInput(board, frame, images[2]);
    	frame.addMouseListener(input);
    	frame.addMouseMotionListener(input);
    	
        System.out.println(board);
    }
}
