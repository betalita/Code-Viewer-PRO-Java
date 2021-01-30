import java.awt.*;
import javax.swing.*;
public class GridLayoutDemo extends JFrame {
	public GridLayoutDemo() {
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		setTitle("GridLayoutDemo");
		setLayout(new GridLayout(2, 3));
		setSize(600, 600);
		setVisible(true);
	}
	public static void main(String[] args) {
		GridLayoutDemo gridLayoutDemo = new GridLayoutDemo();
	}
}