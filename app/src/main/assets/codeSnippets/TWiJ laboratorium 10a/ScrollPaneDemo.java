import javax.swing.*;
public class ScrollPaneDemo extends JFrame {
	public ScrollPaneDemo() {
		super("ScrollPane Demo");
		ImageIcon img = new ImageIcon("fig.jpg");
		JScrollPane jsp = new JScrollPane(new JLabel(img));
		add(jsp);
		setSize(640, 480);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ScrollPaneDemo();
	}
}