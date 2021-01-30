import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseEventDemo extends JFrame {
	public MouseEventDemo() {
		setSize(300, 300);
		setTitle("MouseEventDemo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JTextArea textArea = new JTextArea();
		textArea.setText("Kliknij w obszar okna aplikacji");
		textArea.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {
				if ((e.getModifiers() & InputEvent.BUTTON1_MASK) ==
						InputEvent.BUTTON1_MASK) {
					textArea.setText("Naciśnięty lewy przycisk w pozycji " +
							e.getX() + ", " + e.getY());
				} else {
					textArea.setText("Naciśnięty prawy przycisk w pozycji " +
							e.getX() + ", " + e.getY());
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				textArea.setText("Puściłeś przycisk myszy");
			}
			@Override
			public void mouseCliked(MouseEvent e) {
				textArea.setText("Kliknąłeś w pozycji " + e.getX() + ", " +
						e.getY());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textArea.setText("Kursor poza obszarem aplikacji");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				textArea.setText("Kursor w obszarze aplikacji");
			}
		});
		add(textArea, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		new MouseEventDemo().setVisible(true);
	}
}