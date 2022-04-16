import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoviesPage extends JFrame {
	
	private JLabel darkKnight, cuckooNest, requiem, backgroundImage;
	private ImageIcon background;
	private JButton darkKnightButton, cuckooNestButton, requiemButton, previousPageButton;
	private MoviesPageEventHandler handler;
	private Color customBlue;
	private UIManager uiManager;
	private CurrentUser currentUser;
		
	public MoviesPage(CurrentUser currentUser)
	{
		Container container = getContentPane();
		
		container.setLayout(null);
		
		// Storing the currently signed in user.
		this.currentUser = currentUser;
		
		// Creating an event handler for this page
		handler = new MoviesPageEventHandler();
		
		// Creating a custom blue color
		customBlue = new Color(0, 168, 225);
		
		// Preventing buttons from changing color when clicked
		uiManager = new UIManager();
		uiManager.put("Button.select", customBlue);
		
		// Creating a custom blue color
		customBlue = new Color(0, 168, 225);
		
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
		
		// Creating the label and button for the movie "The Dark Knight"
		darkKnight = new JLabel("The Dark Knight");
		darkKnightButton = new JButton("Watch The Dark Knight");
		darkKnightButton.setBounds(425,650,350,70);
		darkKnightButton.setForeground(Color.WHITE);
		darkKnightButton.setBackground(customBlue);
		darkKnightButton.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		darkKnightButton.setBorder(null);
		darkKnightButton.setFocusPainted(false);
		
		// Creating the label and button for the movie "One Flew Over the Cuckoo's Nest"
		cuckooNest = new JLabel("One Flew Over the Cuckoo's Nest");
		cuckooNestButton = new JButton("Watch One Flew Over the Cuckoo's Nest");
		cuckooNestButton.setBounds(785,650,350,70);
		cuckooNestButton.setForeground(Color.WHITE);
		cuckooNestButton.setBackground(customBlue);
		cuckooNestButton.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
		cuckooNestButton.setBorder(null);
		cuckooNestButton.setFocusPainted(false);
		
		// Creating the label and button for the movie "Requiem for a Dream"
		requiem = new JLabel("Requiem for a Dream");
		requiemButton = new JButton("Watch Requiem for a Dream");
		requiemButton.setBounds(1145,650,350,70);
		requiemButton.setForeground(Color.WHITE);
		requiemButton.setBackground(customBlue);
		requiemButton.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		requiemButton.setBorder(null);
		requiemButton.setFocusPainted(false);
		
		container.add(darkKnight);
		container.add(darkKnightButton);
		container.add(cuckooNest);
		container.add(cuckooNestButton);
		container.add(requiem);
		container.add(requiemButton);
		container.add(previousPageButton);
		container.add(backgroundImage);
		
		darkKnightButton.addActionListener(handler);
		cuckooNestButton.addActionListener(handler);
		requiemButton.addActionListener(handler);
		previousPageButton.addActionListener(handler);
	}
	
	public class MoviesPageEventHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == darkKnightButton) {
				VideoPlayer videoPlayer = new VideoPlayer(currentUser, "The Dark Knight");
				videoPlayer.setTitle("The Dark Knight");
				videoPlayer.setSize(1920,1080);
				videoPlayer.setVisible(true);
			}
			else if(event.getSource() == cuckooNestButton) {
				VideoPlayer videoPlayer = new VideoPlayer(currentUser, "One Flew Over the Cuckoo's Nest");
				videoPlayer.setTitle("One Flew Over the Cuckoo's Nest");
				videoPlayer.setSize(1920,1080);
				videoPlayer.setVisible(true);
			}
			else if(event.getSource() == requiemButton) {
				VideoPlayer videoPlayer = new VideoPlayer(currentUser, "Requiem for a Dream");
				videoPlayer.setTitle("Requiem for a Dream");
				videoPlayer.setSize(1920,1080);
				videoPlayer.setVisible(true);
			}
			else if(event.getSource() == previousPageButton) {
				setVisible(false);
			}
		}
	}
}