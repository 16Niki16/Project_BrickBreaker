import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class menu2 extends JFrame {

	private  AudioInputStream  audio =  null;
	private Clip clip = null;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu2 frame = new menu2();
					frame.setResizable(false);
				    frame.setBounds(100,100,326, 301);
				    frame.setVisible(true);
				   
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 */
	public menu2() throws LineUnavailableException, IOException {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 301);
	
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lblmusic = new JLabel("music");
		Lblmusic.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Lblmusic.setBounds(103, 11, 82, 29);
		contentPane.add(Lblmusic);
		Lblmusic.setOpaque(false);
	        final Random r=new Random();
	        Timer t=new Timer(500,new ActionListener(){
	            public void actionPerformed(ActionEvent ae)
	            {
	            	  try {
	                Color c=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256));
	                Lblmusic.setForeground(c);
	                }catch(IllegalArgumentException e) {
	                	System.out.println("izvyn 255");
	                }
	            }
	        });
	        t.start();
		contentPane.add(Lblmusic);

		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					audio = AudioSystem.getAudioInputStream(new File("C:\\Users\\Niki.DESKTOP-GET8UK9\\Desktop\\eclipseProjects\\OfficialProject4\\src\\music2\\fcw1.wav").getAbsoluteFile());
					clip = AudioSystem.getClip();
			        clip.open(audio);
			        clip.start();
			        clip.loop(Clip.LOOP_CONTINUOUSLY);
			        
				} catch (UnsupportedAudioFileException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnNewButton.setBounds(1, 51, 169, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					audio = AudioSystem.getAudioInputStream(new File("C:\\Users\\Niki.DESKTOP-GET8UK9\\Desktop\\eclipseProjects\\OfficialProject4\\src\\music2\\fkc1.wav").getAbsoluteFile());
					clip = AudioSystem.getClip();
			        clip.open(audio);
			        clip.start();
			        clip.loop(Clip.LOOP_CONTINUOUSLY);
				} catch (UnsupportedAudioFileException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnNewButton_1.setBounds(141, 85, 169, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					audio = AudioSystem.getAudioInputStream(new File("C:\\Users\\Niki.DESKTOP-GET8UK9\\Desktop\\eclipseProjects\\OfficialProject4\\src\\music2\\fmm1.wav").getAbsoluteFile());
					clip = AudioSystem.getClip();
			        clip.open(audio);
			        clip.start();
			        clip.loop(Clip.LOOP_CONTINUOUSLY);
				} catch (UnsupportedAudioFileException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnNewButton_2.setBounds(1, 144, 169, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					audio = AudioSystem.getAudioInputStream(new File("C:\\Users\\Niki.DESKTOP-GET8UK9\\Desktop\\eclipseProjects\\OfficialProject4\\src\\music2\\fos1.wav").getAbsoluteFile());
					clip = AudioSystem.getClip();
			        clip.open(audio);
			        clip.start();
			        clip.loop(Clip.LOOP_CONTINUOUSLY);
				} catch (UnsupportedAudioFileException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnNewButton_3.setBounds(141, 191, 169, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Niki.DESKTOP-GET8UK9\\Desktop\\eclipseProjects\\OfficialProject4\\src\\c8194adbcaaab3c57d80361cbdfff215.gif"));
		lblNewLabel.setBounds(0, 0, 310, 268);
		contentPane.add(lblNewLabel);
		
	}
}
