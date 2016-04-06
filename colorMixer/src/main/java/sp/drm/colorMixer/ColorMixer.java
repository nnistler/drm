package sp.drm.colorMixer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.Color;
import sp.drm.ServicesIF.ColorIF;

@SuppressWarnings("serial")
public class ColorMixer extends JPanel implements ColorIF
{
	private JFrame frame = null;
	private Color rgbaVal;
	public ColorMixer() 
	{
		
		super();
		rgbaVal = new Color(0,0,0);

		setBackground(rgbaVal);
	}
	
	public Color getColor(){
		return this.rgbaVal;
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
	}

	public void mix(ColorIF c1, ColorIF c2) {
		int r = (c1.getColor().getRed() + c2.getColor().getRed()) / 2;
		int g = (c1.getColor().getGreen() + c2.getColor().getGreen()) / 2;
		int b = (c1.getColor().getBlue() + c2.getColor().getBlue()) / 2;
		rgbaVal = new Color(r,g,b);
		setBackground(rgbaVal);
	}
	
	public void draw()
	{
		frame = new JFrame();
		ColorMixer window = new ColorMixer();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(window);
		frame.setSize(1280,720);
		frame.setVisible(true);
	}

	public void close()
	{
		if(frame != null)
		{
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
	}
}
