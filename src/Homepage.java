import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// TODO Look at other font types

public class Homepage extends JFrame {
	private JLabel backgroundImage, slogan, textBetweenButtons;
	private ImageIcon background;
	private JButton signInButton, joinButton;
	private UIManager uiManager;
	private Color customBlue;
	
	public Homepage() {
		Container container = getContentPane();
		
		container.setLayout(null);
		
		// Creating a custom blue color
		customBlue = new Color(0, 168, 225);
		
		// Preventing buttons from changing color when clicked
		uiManager = new UIManager();
		uiManager.put("Button.select", customBlue);
		
		// Creating the background image
		background = new ImageIcon("img\\HomepageBackground.jpg");
		backgroundImage = new JLabel("",background,JLabel.CENTER);
		backgroundImage.setBounds(0,0,1920,1080);
		
		// Creating the site's slogan
		slogan = new JLabel("<html>Join Watch Online to watch popular movies and TV shows, including award-winning titles.</html>");
		slogan.setBounds(60,300,1200,250);
		slogan.setForeground(Color.WHITE);
		slogan.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		
		// Creating the subscribe button
		signInButton = new JButton("Already a member? Sign in");
		signInButton.setBounds(300,550,350,100);
		signInButton.setForeground(Color.WHITE);
		signInButton.setBackground(customBlue);
		signInButton.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		signInButton.setBorder(null);
		signInButton.setFocusPainted(false);
		
		// Creating the text between the buttons
		textBetweenButtons = new JLabel("Or");
		textBetweenButtons.setBounds(450,580,200,250);
		textBetweenButtons.setForeground(Color.WHITE);
		textBetweenButtons.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		
		// Creating the free account button
		joinButton = new JButton("Join us!");
		joinButton.setBounds(300,770,350,100);
		joinButton.setForeground(Color.WHITE);
		joinButton.setBackground(customBlue);
		joinButton.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		joinButton.setBorder(null);
		joinButton.setFocusPainted(false);
		
		// Adding components to the container
		container.add(signInButton);
		container.add(joinButton);
		container.add(textBetweenButtons);
		container.add(slogan);
		container.add(backgroundImage);
		
		// Register components to the listener
		signInButton.addActionListener(new ActionListener() { // Anonymous class for event handling
			public void actionPerformed(ActionEvent event) {  
					SignInPage signInPage = new SignInPage();
					
					signInPage.setTitle("Sign In Page");
					signInPage.setSize(1920, 1080);
					signInPage.setVisible(true);
					signInPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
		}); 
		
		joinButton.addActionListener(new ActionListener() { // Anonymous class for event handling
			public void actionPerformed(ActionEvent event) {
					JoinUsPage joinUsPage = new JoinUsPage();
					
					joinUsPage.setTitle("Join Us Page");
					joinUsPage.setSize(1920, 1080);
					joinUsPage.setVisible(true);
					joinUsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
		});
		
	}
}
