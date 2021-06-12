package project2risrok;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

	private int alien = 7;
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private int map1[];
	private Timer timer, bullet, mapT, alien1;
	private int delay = 17;
	private int alienX;
	private int brickWidth1 = 50;
	private int brickHeight1 = 20;
	private int playerX = 310;
	private int bulletX = 310;
	private int playerY = 550;
	private int bulletY = 550;
	private int alienY = 20;
	private boolean play = false;
	private boolean shot = false;
	private Graphics graph;
	private MapGenerator_official map;

	public Gameplay() {
		 map = new MapGenerator_official(3,4);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}

	private void drawShot(Graphics obj) {
		obj.setColor(Color.green);
		if (!shot) {
			obj.fillRect(playerX + 20, bulletY - 20, 10, 25);
			bulletX = playerX + 20;
		} else {
			obj.fillRect(bulletX, bulletY - 20, 10, 25);
		}
	}

	/*private void draw(Graphics g) {
		Random rand = new Random();
		int r = 7;
		map1 = new int[r];
		for (int i = 0; i < map1.length; i++) {
			int n = rand.nextInt(2) + 1;
			// System.out.println(n);
			map1[i] = n;
		}
		for (int i = 0; i < map1.length; i++) {
			if (map1[i] > 1) {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int p = rand.nextInt(500) + 10;
			///	System.out.println(p);
				g.setColor(Color.red);
				alienX = i * p + 50;
				list.add(alienX);
				if (alienY < 550) {
					for (int j = 0; j < 7; j++) {
						g.fillRect(list.get(j), alienY, brickWidth1, brickHeight1);
						g.drawRect(list.get(j), alienY, brickWidth1, brickHeight1);
					}
				}
			}
		}
	}
*/
	public void paint(Graphics obj) {

		obj.setColor(Color.black);
		obj.fillRect(1, 1, 692, 592);

		obj.setColor(Color.magenta);
		obj.fillRect(playerX, playerY, 50, 25);

		drawShot(obj);
		map.draw((Graphics2D) obj);
		//draw(obj);
		Toolkit.getDefaultToolkit().sync();
		obj.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if (bulletY <= -25) {
			bulletX = playerX + 20;
			bulletY = 550;
			shot = false;
			bullet.stop();
		}
		/*if (alienY > 550) {
			alienY = 20;
			list = new LinkedList<Integer>();
			alien1.stop();
			repaint();
		} else {
			AlienMove();
		}
*/
		repaint();
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {

		int x = bulletX;
		int y = bulletY;

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (bulletY == 0) {
				bulletY = 550;
			} else {
				if (!shot) {
					moveAbove();
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (playerX >= 600) {
				playerX = 600;
			} else {
				moveRight();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (playerX < 10) {
				playerX = 4;
			} else {
				moveLeft();
			}
		}
	}

	public void moveRight() {
		play = true;
		playerX += 20;
	}

	public void moveLeft() {
		play = true;
		playerX -= 20;
	}

	public void moveAbove() {
		play = true;
		shot = true;
		bullet = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bulletY -= 20;
			}
		});
		bullet.start();
	}

	public void AlienMove() {
		if (play = true) {
			alien1 = new Timer(500, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					alienY += 1;
					System.out.println(alienY);
				}
			});
			alien1.start();
		}
	}
}