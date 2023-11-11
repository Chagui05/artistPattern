package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import logic.IDrawableStrat;

public class ShapesPanel extends JPanel {

    private List<IDrawableStrat> shapes = new ArrayList<>();
    private static volatile ShapesPanel instance; 

    private ShapesPanel() {
        setPreferredSize(new Dimension(600, 700));
        setMinimumSize(new Dimension(1, 1));

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
//    	System.out.println("paintComponentaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        super.paintComponent(g);
        for (IDrawableStrat shape : shapes) {
        	shape.paintComp(g);
        }
    }

    public void addComponent(IDrawableStrat shape) {
        shapes.add(shape);
//        System.out.println("addedd"+shapes.size());
        this.repaint();
    }

	public List<IDrawableStrat> getShapes() {
		return shapes;
	}


}
