import javax.swing.*;
public class ComboBoxExample extends JFrame {

	public ComboBoxExample(){

		String item[]={"Item 1","Item 2","Item 3","Item 4","Item 5"};
		JComboBox cb=new JComboBox(item);
		cb.setBounds(50, 50,90,20);
		add(cb);
		setLayout(null);
		setSize(400,500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ComboBoxExample();
	}
}