package view;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

// MVC structure taken from https://www.newthinktank.com/2013/02/mvc-java-tutorial/
public class PolygonWindow extends JFrame {

	private JTextField numberOfDrawings = new JTextField(10);
	private JTextField numberOfPainters = new JTextField(10);
	private JButton drawButton = new JButton("start!!!");

	public PolygonWindow() {
		setTitle("Polygon Drawer");
		setSize(900, 800);
		setLocation(400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		JPanel mainPanel = new JPanel();

		this.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				numberOfDrawings.setText("Number of Drawings");
			}
		});

		this.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				numberOfPainters.setText("Number of Painters");
			}
		});

		mainPanel.add(numberOfDrawings);
		mainPanel.add(numberOfPainters);
		mainPanel.add(drawButton);
		this.add(mainPanel);
	}

	public int getPainters() {
		return Integer.parseInt(numberOfPainters.getText());
	}

	public int getDrawings() {
		return Integer.parseInt(numberOfDrawings.getText());
	}

	public void startDrawing(ActionListener listenForCalcButton) {
		drawButton.addActionListener(listenForCalcButton);
	}

}
