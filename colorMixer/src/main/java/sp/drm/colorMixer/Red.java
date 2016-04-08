package sp.drm.colorMixer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.Color;
import sp.drm.ServicesIF.ColorIF;

@SuppressWarnings("serial")
public class Red extends JPanel implements ColorIF
{
	private JFrame frame = null;
	private Color rgbaVal;
	public Red() 
	{
		
		super();
		rgbaVal = new Color(255,0,0);
		frame = new JFrame();

		this.setBackground(rgbaVal);
	}
	
	public Color getColor(){
		return this.rgbaVal;
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
	}

	public void draw()
	{
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(this);
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
