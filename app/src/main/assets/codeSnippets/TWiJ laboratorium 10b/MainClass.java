import java.awt.event.*;
import javax.swing.*;
public class MainClass extends JFrame{
	JTextField tf;
	MainClass(){
		tf=new JTextField();
		tf.setBounds(60,50,150,30);
		JButton b=new JButton("Click me");
		b.setBounds(60,100,150,30);
		Outer o=new Outer(this);
		b.addActionListener(o);
		add(b);
		add(tf);
		setSize(300,300);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String args[]){
		new MainClass();
	}
}