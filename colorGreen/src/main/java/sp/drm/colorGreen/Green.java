package sp.drm.colorGreen;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.Color;
import sp.drm.ServicesIF.ColorIF;

@SuppressWarnings("serial")
public class Green extends JPanel implements ColorIF
{
	private JFrame frame = null;
	private Color rgbaVal;
	public Green() 
	{
		
		super();
		rgbaVal = new Color(0,255,0);

		setBackground(rgbaVal);
	}
	
	public Color getColor(){
		return this.rgbaVal;
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
	}

	public void draw()
	{
		frame = new JFrame();
		Green window = new Green();
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
