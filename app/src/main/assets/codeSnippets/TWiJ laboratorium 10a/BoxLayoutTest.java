import javax.swing.*;
import java.awt.*;
public class BoxLayoutTest extends JFrame {
	public BoxLayoutTest() {
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("Long-Named Button 2");
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton button3 = new JButton("Button 3");
		button3.setFont(new Font("Arial", Font.PLAIN, 20));
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		// X_AXIS, Y_AXIS, LINE_AXIS, PAGE_AXIS
		p.add(button1);
		p.add(button2);
		p.add(button3);
		getContentPane().add(p, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		BoxLayoutTest frame = new BoxLayoutTest();
		frame.setBounds(10, 10, 300, 200);
		frame.setTitle("BoxLayoutTest");
		frame.setVisible(true);
	}
}