package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.ObserverNotifier;

// MVC structure taken from https://www.newthinktank.com/2013/02/mvc-java-tutorial/
public class PolygonWindow extends JFrame {

	private JTextField numberOfDrawings = new JTextField(10);
	private JTextField numberOfPainters = new JTextField(10);
	private JButton drawButton = new JButton("start!!!");
	private static volatile PolygonWindow instance; 
	
	public static PolygonWindow getInstance() {
		PolygonWindow result = instance;
		if(result == null) {
			synchronized(PolygonWindow.class) {
				result = instance;
				if(result == null) {
					instance = result = new PolygonWindow();
				}
			}
		}
		return result; 
	}
	private PolygonWindow() {
		setTitle("Polygon Drawer");
		setSize(1400, 1050);
		setLocation(400, 0);
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
		setLayout(new GridLayout(2,1));
		mainPanel.add(numberOfDrawings);
		mainPanel.add(numberOfPainters);
		mainPanel.add(drawButton);
		this.add(mainPanel);
		mainPanel.setPreferredSize(new Dimension(100, 50));
		this.add(ShapesPanel.getInstance());
		ShapesPanel.getInstance().revalidate();
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
