package sp.drm.ColorsImpl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sp.drm.ColorsIF.ColorsIF;

@SuppressWarnings("serial")
public class ColorMixer extends JPanel implements ColorsIF {
    private JFrame frame = null;
    private Color rgbaVal;

    public ColorMixer() {

	super();
	frame = new JFrame();
	rgbaVal = new Color(0, 0, 0);

	this.setBackground(rgbaVal);
    }

    public Color getColor() {
	return this.rgbaVal;
    }

    public void paintComponent(Graphics graphics) {
	super.paintComponent(graphics);
    }

    public void mix(ColorsIF c1, ColorsIF c2) {
	int r = (c1.getColor().getRed() + c2.getColor().getRed()) / 2;
	int g = (c1.getColor().getGreen() + c2.getColor().getGreen()) / 2;
	int b = (c1.getColor().getBlue() + c2.getColor().getBlue()) / 2;
	rgbaVal = new Color(r, g, b);
	this.setBackground(rgbaVal);
    }

    public void draw() {
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.add(this);
	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	frame.setVisible(true);
    }

    public void close() {
	if (frame != null) {
	    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
    }
}
