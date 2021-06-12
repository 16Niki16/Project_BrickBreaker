package project2risrok;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
	int map[][];
	private int brickWidth;
	private int brickHeight;

	public int getBrickWidth(){return brickWidth;}
	public int getBrickHeight(){return brickHeight;}

	public MapGenerator(int row, int col) {
		map = new int[row][col];
			for(int j = 0; j<map.length;j++) {
				map[0][j] = 1;
		}
		brickWidth = 540/col;
		brickHeight = 150/row;
	}
	public void draw(Graphics2D g) {
			for(int j = 0; j<map.length;j++) {
				if(map[0][j] > 0) {
					g.setColor(Color.red);		
					g.fillRect(j * brickWidth + 80, j*brickHeight + 50, brickWidth, brickHeight);
					g.drawRect(j * brickWidth + 80, j*brickHeight + 50, brickWidth, brickHeight);
			}
		}
	}
	public void setBrickValue(int value, int row, int col) {
		map[row][col] = value;		
		}
	}

