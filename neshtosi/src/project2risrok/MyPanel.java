package project2risrok;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;


public class MyPanel extends JPanel {

    private List<MyRectangle> lstShapes;
    private Timer populate;

    public MyPanel() {

        lstShapes = new ArrayList<MyRectangle>(25);

        populate = new Timer(40, (ActionListener) new ActionListener() {
            public void actionPerformed1(ActionEvent e) {

                int x = (int) (Math.random() * getWidth());
                int y = (int) (Math.random() * getHeight());
                int width = (int) (Math.random() * (getWidth() / 4));
                int height = (int) (Math.random() * (getHeight() / 4));

                if (x + width > getWidth()) {
                    x = getWidth() - width;
                }
                if (y + height > getHeight()) {
                    y = getHeight() - height;
                }

                Color color = new Color(
                        (int) (Math.random() * 255),
                        (int) (Math.random() * 255),
                        (int) (Math.random() * 255));

                lstShapes.add(new MyRectangle(x, y, width, height, color));
                repaint();
            }

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        populate.setInitialDelay(0);
        populate.setRepeats(true);
        populate.setCoalesce(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                populate.restart();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                populate.stop();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        for (MyRectangle rect : lstShapes) {
            rect.paint(g2d);
        }

        FontMetrics fm = g2d.getFontMetrics();
        String text = Integer.toString(lstShapes.size());

        g2d.setColor(getForeground());
        g2d.drawString(text, getWidth() - fm.stringWidth(text), getHeight() - fm.getHeight() + fm.getAscent());

    }

    public class MyRectangle extends Rectangle {

        private Color color;

        public MyRectangle(int x, int y, int width, int height, Color color) {
            super(x, y, width, height);
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public void paint(Graphics2D g2d) {

            g2d.setColor(getColor());
            g2d.fill(this);

        }
    }
}
