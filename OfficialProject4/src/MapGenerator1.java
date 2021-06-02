import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator1 {
	int map[];
	private int brickWidth;
	private int brickHeight;

	public int getBrickWidth(){return brickWidth;}
	public int getBrickHeight(){return brickHeight;}

	public MapGenerator1(int row) {
		map = new int[row];
		for(int i = 0; i<map.length; i++) {
				map[i] = 1;
			
		}
		brickWidth = 50;
		brickHeight = 25;
	}
	public void draw(Graphics2D obj) {
		for(int i = 0; i<map.length; i++) {
				if(map[i] > 0) {
					obj.setColor(Color.red);		
					obj.fillRect(i * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
					obj.setStroke(new BasicStroke(3));
					obj.setColor(Color.black);
					obj.drawRect(i * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
			}
		}

	}
	public void setBrickValue(int value, int i) {
		map[i] = value;		
	}
}
