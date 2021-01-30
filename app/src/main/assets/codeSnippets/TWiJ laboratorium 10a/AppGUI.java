import java.awt.*;
import javax.swing.*;
public class AppGUI extends JFrame {
	public AppGUI(){
		setTitle("AppGUI");
		JPanel p1 = new JPanel();
		p1.setBackground(Color.RED);
		JTextField display = new JTextField("0.0");
		JButton b1 = new JButton("Button 1");
		JButton b2 = new JButton("Button 2");
		JButton b3 = new JButton("Button 3");
		JButton b4 = new JButton("Button 4");
		p1.add(display);
		p1.add(b1); p1.add(b2);
		p1.add(b3); add(b4);
		add(p1);
	}
	public static void main(String[] args){
		AppGUI frame = new AppGUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);
		frame.setVisible(true);
	}
}