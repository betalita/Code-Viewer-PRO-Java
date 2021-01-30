package pl.edu.prz.jprokop;
import java.awt.*;
public class SwingProgram extends JFrame {
	public SwingConstructor() {
		super("SwingProgram");
		String input = JOptionPane.showInputDialog("Please enter your name");
		String name = "Hello " + input + " ! ";
		JLabel label = new JLabel(name, JLabel.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 50));
		label.setBackground(Color.yellow);
		label.setForeground(Color.blue);
		label.setOpaque(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(label);
		setSize(600,400);
		//setVisible(true);
	}
	public static void main(String[] args) {
		new SwingProgram();
	}
}