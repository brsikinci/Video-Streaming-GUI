import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DatabaseLogger {
	
	private String username;
	private String userPassword;
	
	DatabaseLogger(JTextField usernameTextField, JTextField passwordTextField, String subscriptionLevel)
	{
		if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("")) {
			 JOptionPane.showMessageDialog(null, "Please enter your username and password");
		}
		else {
			try {
				FileWriter fileWriter = new FileWriter("database.txt", true);
				
				username = usernameTextField.getText();
				userPassword = passwordTextField.getText();
				
				fileWriter.write(username);
				fileWriter.write("\n");
				fileWriter.write(userPassword);
				fileWriter.write("\n");
				fileWriter.write(subscriptionLevel);
				fileWriter.write("\n");
				fileWriter.close();   
			}
			catch(IOException ioException) {
				JOptionPane.showMessageDialog(null, "Couldn't write your account information to the database. Account creation failed.");
			}
			catch(Exception genericException) {
				JOptionPane.showMessageDialog(null, "Unidentified error occured.");
			}
		}
	}
}