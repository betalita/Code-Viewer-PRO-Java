import java.awt.*;
import javax.swing.*;
public class FlowLayoutDemo extends JFrame {
	public FlowLayoutDemo() {
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
		setTitle("FlowLayoutDemo");
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		FlowLayoutDemo flowLayoutDemo = new FlowLayoutDemo();
	}
}