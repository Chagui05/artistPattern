package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import logic.IDrawableStrat;

public class ShapesPanel extends JPanel {

    private List<IDrawableStrat> shapes = new ArrayList<>();
    private static volatile ShapesPanel instance; 

    private ShapesPanel() {
        setPreferredSize(new Dimension(800, 700));

    }
    
    public static ShapesPanel getInstance() {
    	ShapesPanel result = instance;
		if(result == null) {
			synchronized(ShapesPanel.class) {
				result = instance;
				if(result == null) {
					instance = result = new ShapesPanel();
				}
			}
		}
		return result; 
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IDrawableStrat s : shapes) {
            s.draw(g);
        }
    }

    public void addComponent(IDrawableStrat shape) {
        shapes.add(shape);
        repaint();
    }


}
