package project2risrok;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.Timer;

public class MapGenerator_official {
	int map[][];
	int m = 0;
	private int brickWidth;
	private int brickHeight;
	private int alienX;

	public int getBrickWidth(){return brickWidth;}
	public int getBrickHeight(){return brickHeight;}
	public int getAlienX(){return alienX;}

	public MapGenerator_official(int row, int col) {
		map = new int[row][col];
		for(int i = 0; i<map.length; i++) {
			for(int j = 0; j<map[0].length;j++) {
				map[i][j] = 1;
			}
		}
		brickWidth = 50;
		brickHeight =  150/row;;
	}
	public void draw(Graphics2D g) {
		for(int i = 0; i<map.length; i++) {
			for(int j = 0; j<map[0].length;j++) {
				if(map[i][j] > 0) {
					g.setColor(Color.red);
				//	if(alienX <= 600) {
					alienX = brickWidth + m;
					m += 20;
					g.fillRect(alienX, brickHeight + 10, brickWidth, brickHeight);
					g.drawRect(alienX, brickHeight + 10, brickWidth, brickHeight);
					
				//	}
				}
			}
		}

	}
	public void setBrickValue(int value, int row, int col) {
		map[row][col] = value;		
	}

}
