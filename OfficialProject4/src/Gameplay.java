import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	//Easy,Medium,Hard,Mad\
			private String currMode = "Medium";
			private boolean play = false;
			private int score = 0;
			private int totalBricks = 21;
			private Timer timer;
			private int delay = 8;
			private int playerX = 310;
			private int ballposX = (int)(Math.random()*500)+100;
			private int ballposY = 450;
			private double ballXdir = -1;
			private double ballYdir = -2;
			private double speedset = 0;
			private double sliderXdir;
			private double sliderXdirside;
			private double sliderSpeedset;
			private double sliderSpeed;

			
			
			
			
			private MapGenerator map;
			
			public Gameplay() {
				map = new MapGenerator(3, 7);
				addKeyListener(this);
				setFocusable(true);
				setFocusTraversalKeysEnabled(false);
				timer = new Timer(delay, this);
				timer.start();
			}
			
			public void paint(Graphics obj) {
			
				obj.setColor(Color.black);
				obj.fillRect(1, 1, 692, 592);
				
			//	map.draw((Graphics2D) obj);
				
				obj.setColor(Color.cyan);
				obj.fillRect(0, 0, 3, 592);
				obj.fillRect(0, 0, 692, 3);
				obj.fillRect(685, 0, 3, 592);
				
				obj.setColor(Color.white);
				obj.setFont(new Font("serif", Font.BOLD, 25));
				obj.drawString("" +score, 590, 30);
	
				obj.setColor(Color.magenta);
				obj.fillRect(playerX, 550, 100, 8);
				
		
				obj.setColor(Color.cyan);
				obj.fillOval(ballposX, ballposY, 20, 20);
				
	
				if(totalBricks <= 0) {
					play = false;
					ballXdir = 0;
					ballYdir = 0;
					obj.setColor(Color.RED);
					obj.setFont(new Font("serif", Font.BOLD, 30));
					obj.drawString("You Won:  ", 190, 300);
					
					obj.setFont(new Font("serif", Font.BOLD, 20));
					obj.drawString("Press Enter to Restart ", 230, 350);
				}
				
	
				if(ballposY > 570) {
					play = false;
					ballXdir = 0;
					ballYdir = 0;
					obj.setColor(Color.RED);
					obj.setFont(new Font("serif", Font.BOLD, 30));
					obj.drawString("Game Over, Scores: ", 190, 300);
					
					obj.setFont(new Font("serif", Font.BOLD, 20));
					obj.drawString("Press Enter to Restart ", 230, 350);
				} 
				
				obj.dispose();
			}
			
		@Override
		public void actionPerformed(ActionEvent e) {
			timer.start();
			switch(currMode){
				case "Easy":
					sliderXdir =1;
					sliderXdirside =1.5;
					sliderSpeed =1;
					sliderSpeedset=7;
					break;
				case "Medium":
					sliderXdir =1.5;
					sliderXdirside =2;
					sliderSpeed =2;
					sliderSpeedset=4;
					break;
				case "Hard":
					sliderXdir =1.5;
					sliderXdirside =3;
					sliderSpeed =3;
					sliderSpeedset=1;
					break;
				case "Mad":
					sliderXdir =1;
					sliderXdirside =2;
					sliderSpeed =20;
					sliderSpeedset=(int)(Math.random()*5)+1;
					break;
			}
			

			if(play) {
				if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100,8))) {
				
					if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX+40, 550, 20,8))){
						if(ballXdir>0){
							ballXdir=sliderXdir;
						}else{
							ballXdir=-sliderXdir;
						}
				
					}else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 39,8))) {
						ballXdir=-sliderXdirside;
			
					}else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX+61, 550, 40,8))){
						ballXdir=sliderXdirside;
					}
				
					speedset++;
					if(speedset%sliderSpeedset==0){
						if(ballYdir>0)
						ballYdir+=sliderSpeed;
						else
						ballYdir-=sliderSpeed;
					}
					ballYdir = -ballYdir;

				}
				
				 A: for(int i = 0; i<map.map.length; i++) {
					for(int j=0; j<map.map[0].length; j++) {
						if(map.map[i][j] > 0) {
							int brickX = j*map.getBrickWidth() + 80;
							int brickY = i * map.getBrickHeight() + 50;
							int brickWidth = map.getBrickHeight();
							int brickHeight = map.getBrickWidth();
				
							Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
							Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
							Rectangle brickRect = rect;
							
					
							if(ballRect.intersects(brickRect)) {
								map.setBrickValue(0, i, j);
								totalBricks--;
								score += 5;
							
								if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
									ballXdir = -ballXdir;
								}else {
									ballYdir = -ballYdir;

								}
							}
						
						}
					}
				}
				
		
				ballposX += ballXdir;
				ballposY += ballYdir;
			
				if(ballposX < 0) {
					ballXdir = -ballXdir;		
				}
				if(ballposY < 0) {
					ballYdir = -ballYdir;		
				}
				if(ballposX > 670) {
					ballXdir = -ballXdir;		
				}
			}
			
			repaint();
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
	
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if(playerX >= 600) {
					playerX = 600;
				}else {
					moveRight(); 
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				if(playerX < 10) {
					playerX = 4;
				}else {
					moveLeft(); 
				}
			}	
			
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(!play) {
					play = true; 
					ballposX = (int)(Math.random()*500)+100;
					ballposY = 450;
					ballXdir = -1;
					ballYdir = -2;
					playerX = 310;
					score = 0;
					totalBricks = 21;
					speedset=0;
					map = new MapGenerator(3, 7);
					
					repaint();
				}
			}
		}
	
		public void moveRight() {
			play = true;
			playerX+=20;
		}
		public void moveLeft() {
			play = true;
			playerX-=20;
		}
	}

