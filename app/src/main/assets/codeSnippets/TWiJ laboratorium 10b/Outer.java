import java.awt.event.*;
public class Outer implements ActionListener {
	MainClass obj;
	Outer(MainClass obj) {
		this.obj = obj;
	}
	public void actionPerformed(ActionEvent e) {
		obj.tf.setText("Java");
	}
}