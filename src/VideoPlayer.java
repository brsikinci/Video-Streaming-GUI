import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VideoPlayer extends JFrame {
	private JLabel backgroundImage;
	private JButton button480p, button720p, button1080p, button2160p, previousPageButton, playButton;
	private ImageIcon background;
	private UIManager uiManager;
	private Color customBlue;
	private VideoPlayerEventHandler handler = new VideoPlayerEventHandler();
	private CurrentUser currentUser;
	private String movieName;
	private boolean qualitySelected = false;
	private int quality;

	public VideoPlayer(CurrentUser currentUser, String movieName) {
		Container container = getContentPane();
		container.setLayout(null);
		
		this.currentUser = currentUser;
		this.movieName = movieName;
		
		// Creating a custom blue color
		customBlue = new Color(0, 168, 225);
		
		// Preventing buttons from changing color when clicked
		uiManager = new UIManager();
		uiManager.put("Button.select", customBlue);
		
		// Creating the background image
		background = new ImageIcon("img\\HomepageBackground.jpg");
		backgroundImage = new JLabel("",background,JLabel.CENTER);
		backgroundImage.setBounds(0,0,1920,1080);
		
		// Creating the button to return to the previous page
		previousPageButton = new JButton("Back");
		previousPageButton.setBounds(785,750,350,70);
		previousPageButton.setForeground(Color.WHITE);
		previousPageButton.setBackground(customBlue);
		previousPageButton.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		previousPageButton.setBorder(null);
		previousPageButton.setFocusPainted(false);
		
		// Creating the play button
		playButton = new JButton("Play");
		playButton.setBounds(785,550,350,70);
		playButton.setForeground(Color.WHITE);
		playButton.setBackground(customBlue);
		playButton.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		playButton.setBorder(null);
		playButton.setFocusPainted(false);
				
		// Creating video quality buttons
		button480p = new JButton("480p");
		button480p.setBounds(245,650,350,70);
		button480p.setForeground(Color.WHITE);
		button480p.setBackground(customBlue);
		button480p.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		button480p.setBorder(null);
		button480p.setFocusPainted(false);
		
		button720p = new JButton("720p");
		button720p.setBounds(605,650,350,70);
		button720p.setForeground(Color.WHITE);
		button720p.setBackground(customBlue);
		button720p.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		button720p.setBorder(null);
		button720p.setFocusPainted(false);
		
		button1080p = new JButton("1080p");
		button1080p.setBounds(965,650,350,70);
		button1080p.setForeground(Color.WHITE);
		button1080p.setBackground(customBlue);
		button1080p.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		button1080p.setBorder(null);
		button1080p.setFocusPainted(false);
		
		button2160p = new JButton("2160p");
		button2160p.setBounds(1325,650,350,70);
		button2160p.setForeground(Color.WHITE);
		button2160p.setBackground(customBlue);
		button2160p.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		button2160p.setBorder(null);
		button2160p.setFocusPainted(false);
		
		container.add(button480p);
		container.add(button720p);
		container.add(button1080p);
		container.add(button2160p);
		container.add(previousPageButton);
		container.add(playButton);
		container.add(backgroundImage);
		
		button480p.addActionListener(handler);
		button720p.addActionListener(handler);
		button1080p.addActionListener(handler);
		button2160p.addActionListener(handler);
		previousPageButton.addActionListener(handler);
		playButton.addActionListener(handler);
		
	}
	public class VideoPlayerEventHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == button480p) {
				JOptionPane.showMessageDialog(null, "480p is the selected quality.");
				qualitySelected = true;
				quality = 480;
			}
			
			else if (event.getSource() == button720p) {
				if(currentUser.getSubscriptionLevel().equals("Free")) {
					JOptionPane.showMessageDialog(null, "Your subscription doesn't cover this quality. Select a lower quality.");
				}
				else {
					JOptionPane.showMessageDialog(null, "720p is the selected quality.");
					qualitySelected = true;
					quality = 720;
				}
			}
			
			else if(event.getSource() == button1080p) {
					
				if(currentUser.getSubscriptionLevel().equals("Free") || currentUser.getSubscriptionLevel().equals("Silver")) {
					JOptionPane.showMessageDialog(null, "Your subscription doesn't cover this quality. Select a lower quality.");
				}
				else {
					JOptionPane.showMessageDialog(null, "1080p is the selected quality.");
					qualitySelected = true;
					quality = 1080;
				}
			}
			
			else if (event.getSource() == button2160p) {
				
				if (currentUser.getSubscriptionLevel().equals("Free") || currentUser.getSubscriptionLevel().equals("Silver") || currentUser.getSubscriptionLevel().equals("Gold")) {
					JOptionPane.showMessageDialog(null, "Your subscription doesn't cover this quality. Select a lower quality.");
				}
				else {
					JOptionPane.showMessageDialog(null, "2160p is the selected quality.");
					qualitySelected = true;
					quality = 2160;
				}
			}
			
			else if (event.getSource() == playButton) {
				if (!qualitySelected) {
					JOptionPane.showMessageDialog(null, "Please select a quality first.");
				}
				else {
					JOptionPane.showMessageDialog(null, movieName + "\n" + quality + "p\n" + "Enjoy your movie!");
				}
			}
			
			else if (event.getSource() == previousPageButton) {
				setVisible(false);
			}
		}
	}
}