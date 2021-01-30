import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
public class JToolBarDemo extends JFrame {
	public JToolBarDemo() {
		JToolBar toolbar = new JToolBar();
		toolbar.setRollover(true);
		JButton button = new JButton("File");
		toolbar.add(button);
		toolbar.addSeparator();
		toolbar.add(new JButton("Edit"));
		toolbar.addSeparator();
		toolbar.add(new JComboBox(new String[]{"Item 1", "Item 2", "Item 3"}));
		toolbar.addSeparator();
		add(toolbar, BorderLayout.NORTH);
		JTextArea textArea = new JTextArea("Text Area");
		JScrollPane mypane = new JScrollPane(textArea);
		add(mypane, BorderLayout.CENTER);
		setSize(450, 250);
		setVisible(true);
	}
	public static void main(String[] args) {
		JToolBarDemo jToolBarDemo = new JToolBarDemo();
	}
}