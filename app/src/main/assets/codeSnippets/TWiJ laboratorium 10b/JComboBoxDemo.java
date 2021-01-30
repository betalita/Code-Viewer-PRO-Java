import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JComboBoxDemo extends JFrame {
	JComboBox combo;
	JLabel label;
	public JComboBoxDemo(String title) {
		super(title);
		String[] data = {"Blue", "Green", "Red", "White", "Yellow"};
		DefaultComboBoxModel comboModel = new DefaultComboBoxModel(data);
		combo = new JComboBox(comboModel);
		combo.setPreferredSize(new Dimension(150, 25));
		combo.addActionListener(new MyListener());
		JPanel p = new JPanel();
		p.add(combo);
		label = new JLabel("Choose item !", JLabel.CENTER);
		Container content = this.getContentPane();
		content.add(p, BorderLayout.PAGE_START);
		content.add(label, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		JComboBoxDemo test = new JComboBoxDemo("JComboBoxDemo");
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setBounds( 10, 10, 250, 200);
		test.setVisible(true);
	}
	class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox)e.getSource();
			String itemText = (String)cb.getSelectedItem();
			label.setText(itemText);
		}
	}
}