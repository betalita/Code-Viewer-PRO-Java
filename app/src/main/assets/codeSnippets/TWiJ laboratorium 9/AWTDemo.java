import java.awt.event.*;
public class AWTDemo extends Frame {
	public AWTDemo(){
		super("AWT Demo");
		prepareGUI();
	}
	public static void main(String[] args){
		AWTDemo awtDemo = new AWTDemo();
		awtDemo.setVisible(true);
	}
	private void prepareGUI(){
		setSize(800,800);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});
	}
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		Font font = new Font("Serif", Font.BOLD, 54);
		g.setFont(font);
		g.drawString("AWT Demo", 50, 150);
		g.setColor(Color.BLUE);
		g.drawRect(100,200,150,150);
		g.setColor(Color.GREEN);
		g.fillRect(100,200,400,400);

	}
}