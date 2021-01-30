import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame {
	JButton blogin = new JButton("Login");
	JPanel panel = new JPanel(new GridLayout(2, 2));
	JLabel user = new JLabel("User");
	JTextField txuser = new JTextField(10);
	JLabel password = new JLabel("Password");
	JPasswordField pass = new JPasswordField(10);
	Login() {
		super("Autentification");
		this.setSize(300, 150);
		panel.add(user);
		panel.add(txuser);
		panel.add(password);
		panel.add(pass);
		add(panel, BorderLayout.CENTER);
		add(blogin, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		actionLogin();
	}
	public void actionLogin() {
		blogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String puname = txuser.getText();
				String ppaswd = pass.getText();
				if (puname.equals("admin") && ppaswd.equals("admin")) {
					NewWindow regFace = new NewWindow();
					regFace.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Wrong Password / Username");
					txuser.setText("");
					pass.setText("");
					txuser.requestFocus();
				}
			}
		});
	}
	public static void main(String[] args) {
		Login login = new Login();
	}
}
class NewWindow extends JFrame {
	public static void main(String[] args) {
		NewWindow newWindow = new NewWindow();
	}
	NewWindow() {
		super("Welcome");
		setSize(300, 200);
		setLocation(500, 280);
		JPanel panel = new JPanel();
		JLabel welcome = new JLabel("Welcome to a New Frame");
		panel.add(welcome);
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}