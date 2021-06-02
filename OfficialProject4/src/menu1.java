import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;

public class menu1 extends JFrame {

	private int music = (int) (Math.random() * 4) + 1;
	private AudioInputStream audio = null;
	private Clip clip = null;
	private JPanel contentPane;
	private static JLabel backImg;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu1 frame = new menu1();
				    frame.setBounds(100,100,633, 439);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menu1() {
		System.out.println(music);
		try {
			switch (music) {
			case 1:
				audio = AudioSystem.getAudioInputStream(new File(
						"C:\\Users\\nikip\\eclipse-workspace\\New folder\\OfficialProject4\\src\\music2\\fcw1.wav")
								.getAbsoluteFile());
				break;
			case 2:
				audio = AudioSystem.getAudioInputStream(new File(
						"C:\\Users\\nikip\\eclipse-workspace\\New folder\\OfficialProject4\\src\\music2\\fkc1.wav")
								.getAbsoluteFile());
				break;
			case 3:
				audio = AudioSystem.getAudioInputStream(new File(
						"C:\\Users\\nikip\\eclipse-workspace\\New folder\\OfficialProject4\\src\\music2\\fmm1.wav")
								.getAbsoluteFile());
				break;
			case 4:
				audio = AudioSystem.getAudioInputStream(new File(
						"C:\\Users\\nikip\\eclipse-workspace\\New folder\\OfficialProject4\\src\\music2\\fos1.wav")
								.getAbsoluteFile());
				break;
			}

			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
			clip.loop(music);

		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Game Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(254, 47, 141, 49);
		lblNewLabel.setOpaque(false);
		final Random r = new Random();
		Timer t = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256), r.nextInt(256));
					lblNewLabel.setForeground(c);
				} catch (IllegalArgumentException e) {
					System.out.println("izvyn 255");
				}
			}
		});
		t.start();
		contentPane.add(lblNewLabel);

		JButton btnNivo1 = new JButton("Nivo 1");
		btnNivo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						Main.main(new String[] {});
					}
				}.start();
				dispose();
			}
		});
		btnNivo1.setBounds(241, 109, 165, 21);
		contentPane.add(btnNivo1);
		JButton Button = new JButton("Exit");
		Button.setBounds(241, 155, 165, 21);
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(Button);
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(234, 54, 185, 134);
		contentPane.add(panel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nikip\\Downloads\\12.jpg"));
		lblNewLabel_1.setBounds(0, 0, 617, 400);
		contentPane.add(lblNewLabel_1);

	}
}
