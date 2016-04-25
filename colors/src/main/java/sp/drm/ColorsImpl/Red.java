package sp.drm.ColorsImpl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sp.drm.ColorsIF.ColorsIF;

@SuppressWarnings("serial")
public class Red extends JPanel implements ColorsIF {
    private JFrame frame = null;
    private Color rgbaVal;

    public Red() {

	super();
	rgbaVal = new Color(255, 0, 0);
	frame = new JFrame();

	this.setBackground(rgbaVal);
    }

    public Color getColor() {
	return this.rgbaVal;
    }

    public void paintComponent(Graphics graphics) {
	super.paintComponent(graphics);
    }

    public void draw() {
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.add(this);
	frame.setTitle("Red");
	frame.setSize(960, 540);
	frame.setVisible(true);
    }

    public void close() {
	if (frame != null) {
	    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
    }
}
