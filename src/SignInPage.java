import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class SignInPage extends JFrame {
	private JLabel backgroundImage, usernameText, passwordText;
	private ImageIcon background;
	private JButton signInButton, previousPageButton;
	private JTextField usernameTextField, passwordTextField;
	private UIManager uiManager;
	private Color customBlue;
	private SignInEventHandler handler;
	private CurrentUser currentUser;
	
	public SignInPage() {
		Container container = getContentPane();
		
		container.setLayout(null);
		
		// Creating an event handler for this page
		handler = new SignInEventHandler();
		
		// Creating a custom blue color
		customBlue = new Color(0, 168, 225);
		
		// Preventing buttons from changing color when clicked
		uiManager = new UIManager();
		uiManager.put("Button.select", customBlue);
		
		// Creating the background image
		background = new ImageIcon("img\\HomepageBackground.jpg");
		backgroundImage = new JLabel("",background,JLabel.CENTER);
		backgroundImage.setBounds(0,0,1920,1080);
		
	    // Creating the text fields
		usernameTextField = new JTextField();
		usernameTextField.setBounds(785,300,350,35);
		usernameTextField.setForeground(Color.BLACK);
		usernameTextField.setBackground(Color.WHITE);
		usernameTextField.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		usernameTextField.setBorder(null);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(785,400,350,35);
		passwordTextField.setForeground(Color.BLACK);
		passwordTextField.setBackground(Color.WHITE);
		passwordTextField.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		passwordTextField.setBorder(null);
		
		// Creating the necessary texts
		usernameText = new JLabel("Username");
		usernameText.setBounds(785,155,200,250);
		usernameText.setForeground(Color.WHITE);
		usernameText.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		
		passwordText = new JLabel("Password");
		passwordText.setBounds(785,255,200,250);
		passwordText.setForeground(Color.WHITE);
		passwordText.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		
		// Creating the sign in button
		signInButton = new JButton("Sign In");
		signInButton.setBounds(785,550,350,70);
		signInButton.setForeground(Color.WHITE);
		signInButton.setBackground(customBlue);
		signInButton.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		signInButton.setBorder(null);
		signInButton.setFocusPainted(false);
		
		// Creating the button to return to the previous page
		previousPageButton = new JButton("Back");
		previousPageButton.setBounds(785,650,350,70);
		previousPageButton.setForeground(Color.WHITE);
		previousPageButton.setBackground(customBlue);
		previousPageButton.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		previousPageButton.setBorder(null);
		previousPageButton.setFocusPainted(false);
							
		// Adding components to the container
		
		container.add(signInButton);
		container.add(usernameTextField);
		container.add(passwordTextField);
		container.add(usernameText);
		container.add(passwordText);
		container.add(previousPageButton);
		container.add(backgroundImage);
		
		
		// Register components to the listener
		signInButton.addActionListener(handler);
		previousPageButton.addActionListener(handler);
	}
	
	// Named inner class	
	public class SignInEventHandler implements ActionListener {

		 private String username;
		 private String userPassword;
		 private boolean logInControl = false;

		 public void actionPerformed(ActionEvent event) {

			if (event.getSource() == signInButton) {
				
				try {
					username = usernameTextField.getText();
					userPassword = passwordTextField.getText();
					
					File database = new File("database.txt");
					Scanner scanner = new Scanner(database);
					
					while (scanner.hasNextLine()) {
						if (scanner.nextLine().equals(username) && scanner.nextLine().equals(userPassword)) {
							logInControl = true;
							currentUser = new CurrentUser(username, userPassword, scanner.nextLine());
							JOptionPane.showMessageDialog(null, "Welcome");
							
							setVisible(false);
							
							MoviesPage moviesPage = new MoviesPage(currentUser);
							moviesPage.setTitle("Movies Page");
							moviesPage.setSize(1920,1080);
							moviesPage.setVisible(true);
							moviesPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							break;
						}
					}
					
					if(!logInControl) {
						JOptionPane.showMessageDialog(null, "Wrong username or password");
					}
					
				}
				
				catch(FileNotFoundException fileNotFound) {
					JOptionPane.showMessageDialog(null, "Couldn't reach the database.");
				}
				
				catch(Exception genericException) {
					JOptionPane.showMessageDialog(null, "Unidentified error occured.");
				}
			}
			
			else if (event.getSource() == previousPageButton) {
				setVisible(false);
			}
		}
	}
}
