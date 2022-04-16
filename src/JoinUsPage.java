import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JoinUsPage extends JFrame {
	private JLabel backgroundImage, usernameText, passwordText;
	private ImageIcon background;
	private JButton previousPageButton, silverButton, goldButton, platinumButton, freeButton;
	private JTextField usernameTextField, passwordTextField;
	private UIManager uiManager;
	private Color customBlue;
	private JoinUsEventHandler handler;
	
	public JoinUsPage() {
		Container container = getContentPane();
		
		container.setLayout(null);
		
		// Creating an event handler for this page
		handler = new JoinUsEventHandler();
		
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
		usernameText = new JLabel("Email");
		usernameText.setBounds(785,155,200,250);
		usernameText.setForeground(Color.WHITE);
		usernameText.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		
		passwordText = new JLabel("Password");
		passwordText.setBounds(785,255,200,250);
		passwordText.setForeground(Color.WHITE);
		passwordText.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		
		// Creating the button to return to the previous page
		previousPageButton = new JButton("Back");
		previousPageButton.setBounds(785,650,350,70);
		previousPageButton.setForeground(Color.WHITE);
		previousPageButton.setBackground(customBlue);
		previousPageButton.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		previousPageButton.setBorder(null);
		previousPageButton.setFocusPainted(false);
		
		// Creating free account button
		freeButton = new JButton("Free Account (30 Days)");
		freeButton.setBounds(245,550,350,70);
		freeButton.setForeground(Color.WHITE);
		freeButton.setBackground(customBlue);
		freeButton.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		freeButton.setBorder(null);
		freeButton.setFocusPainted(false);
		
		// Creating silver subscription button
		silverButton = new JButton("Silver");
		silverButton.setBounds(605,550,350,70);
		silverButton.setForeground(Color.WHITE);
		silverButton.setBackground(customBlue);
		silverButton.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		silverButton.setBorder(null);
		silverButton.setFocusPainted(false);
		
		// Creating gold subscription button
		goldButton = new JButton("Gold");
		goldButton.setBounds(965,550,350,70);
		goldButton.setForeground(Color.WHITE);
		goldButton.setBackground(customBlue);
		goldButton.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		goldButton.setBorder(null);
		goldButton.setFocusPainted(false);
		
		// Creating platinum subscription button
		platinumButton = new JButton("Platinum");
		platinumButton.setBounds(1325,550,350,70);
		platinumButton.setForeground(Color.WHITE);
		platinumButton.setBackground(customBlue);
		platinumButton.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		platinumButton.setBorder(null);
		platinumButton.setFocusPainted(false);
		
		// Adding components to the container
		
		container.add(usernameTextField);
		container.add(passwordTextField);
		container.add(usernameText);
		container.add(passwordText);
		container.add(previousPageButton);
		container.add(freeButton);
		container.add(silverButton);
		container.add(goldButton);
		container.add(platinumButton);
		container.add(backgroundImage);
		
		// Register components to the listener
	
		previousPageButton.addActionListener(handler);
		freeButton.addActionListener(handler);
		silverButton.addActionListener(handler);
		goldButton.addActionListener(handler);
		platinumButton.addActionListener(handler);
	}
	
	// Named inner class
	public class JoinUsEventHandler implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			 if (event.getSource() == freeButton) {
				 DatabaseLogger databaseLogger = new DatabaseLogger(usernameTextField, passwordTextField, "Free");
				 JOptionPane.showMessageDialog(null, "Your free account has been successfully created. You can go back to the sign in page.");
			 }
			 else if (event.getSource() == silverButton) {
				 DatabaseLogger databaseLogger = new DatabaseLogger(usernameTextField, passwordTextField, "Silver");
				 JOptionPane.showMessageDialog(null, "Your silver account has been successfully created. You can go back to the sign in page.");
			 }
			 else if (event.getSource() == goldButton) {
				 DatabaseLogger databaseLogger = new DatabaseLogger(usernameTextField, passwordTextField, "Gold");
				 JOptionPane.showMessageDialog(null, "Your gold account has been successfully created. You can go back to the sign in page.");
			 }
			 else if (event.getSource() == platinumButton) {
				 DatabaseLogger databaseLogger = new DatabaseLogger(usernameTextField, passwordTextField, "Platinum");
				 JOptionPane.showMessageDialog(null, "Your platinum account has been successfully created. You can go back to the sign in page.");
			 }
			 else if (event.getSource() == previousPageButton) {
				 setVisible(false);
			 }
		}
	}
}


