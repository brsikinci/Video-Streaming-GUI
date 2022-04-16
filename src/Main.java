import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Homepage homepage = new Homepage();
		
		homepage.setTitle("Homepage");
		homepage.setSize(1920, 1080);
		homepage.setVisible(true);
		homepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}