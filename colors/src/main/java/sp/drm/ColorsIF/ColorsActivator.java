package sp.drm.ColorsIF;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import sp.drm.ColorsImpl.Blue;
import sp.drm.ColorsImpl.ColorMixer;
import sp.drm.ColorsImpl.Green;
import sp.drm.ColorsImpl.Red;
import sp.drm.ColorsImpl.Yellow;

public class ColorsActivator implements BundleActivator {

    public static BundleContext bundleContext = null;
    private ColorMixer mixer;
    private JFrame jf = new JFrame("Select Color");
    private JRadioButton purple = new JRadioButton("Purple");
    private JRadioButton green = new JRadioButton("Yellow");
    private JRadioButton yellow = new JRadioButton("Orange");
    private JButton submit = new JButton("Submit");
    private JTextField answer = new JTextField(10);

    public void start(BundleContext bContext) throws Exception {
	ColorsActivator.bundleContext = bContext;
	log("started");

	bContext.registerService(ColorsIF.class.getName(), new Blue(), bProp());
	bContext.registerService(ColorsIF.class.getName(), new Red(), rProp());
	bContext.registerService(ColorsIF.class.getName(), new Yellow(), yProp());
	bContext.registerService(ColorsIF.class.getName(), new Green(), gProp());
	bContext.registerService(ColorMixer.class.getName(), new ColorMixer(), null);

	mixer = getMixer();
	getInput();
    }

    public void stop(BundleContext bContext) throws Exception {
	log("stopped");
	mixer = null;
	ColorsActivator.bundleContext = null;

    }

    private void getInput() {
	jf.setLayout(new GridLayout(6, 1));

	ButtonGroup group = new ButtonGroup();
	group.add(purple);
	group.add(green);

	jf.add(new Label("Select a color:"));
	jf.add(purple);
	jf.add(green);
	jf.add(yellow);
	jf.add(answer);
	jf.add(submit);

	jf.setLocationRelativeTo(null);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setLocation(200, 200);
	jf.setSize(200, 200);
	jf.setVisible(true);

	ActionListener preferenceListener = new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JRadioButton) {
		    JRadioButton radioButton = (JRadioButton) e.getSource();
		    if (radioButton.isSelected()) {
			answer.setText(radioButton.getText());
		    }
		}
	    }
	};

	ActionListener submitListener = new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (answer.getText().equals("Purple")) {
		    log("purple selected");
		    try {
			ServiceReference[] pref1 = getServiceReferences("(color=B)");
			ColorsIF pService1 = getService(pref1);
			ServiceReference[] pref2 = getServiceReferences("(color=R)");
			ColorsIF pService2 = getService(pref2);
			mixer.mix(pService1, pService2);
			mixer.draw();
			// drawDemo(pService1, pService2);
		    } catch (InvalidSyntaxException e1) {
			e1.printStackTrace();
		    } // catch (InterruptedException e1) {
		      // e1.printStackTrace();
		      // }
		} else if (answer.getText().equals("Yellow")) {
		    log("green selected");
		    try {
			ServiceReference[] yref1 = getServiceReferences("(color=G)");
			ColorsIF yService1 = getService(yref1);
			ServiceReference[] yref2 = getServiceReferences("(color=R)");
			ColorsIF yService2 = getService(yref2);
			mixer.mix(yService1, yService2);
			mixer.draw();
			// drawDemo(gService1, gService2);
		    } catch (InvalidSyntaxException e1) {
			e1.printStackTrace();
		    } // catch (InterruptedException e1) {
		      // e1.printStackTrace();
		      // }
		} else if (answer.getText().equals("Orange")) {
		    log("orange selected");
		    try {
			ServiceReference[] oref1 = getServiceReferences("(color=R)");
			ColorsIF oService1 = getService(oref1);
			ServiceReference[] oref2 = getServiceReferences("(color=Y)");
			ColorsIF oService2 = getService(oref2);
			mixer.mix(oService1, oService2);
			mixer.draw();
			// drawDemo(oService1, oService2);
		    } catch (InvalidSyntaxException e1) {
			e1.printStackTrace();
		    } // catch (InterruptedException e1) {
		      // e1.printStackTrace();
		      // }
		}
		jf.setVisible(false);
	    }
	};

	purple.addActionListener(preferenceListener);
	green.addActionListener(preferenceListener);
	yellow.addActionListener(preferenceListener);
	submit.addActionListener(submitListener);

    }

    private ServiceReference[] getServiceReferences(String filter) throws InvalidSyntaxException {
	return bundleContext.getServiceReferences(ColorsIF.class.getName(), filter);
    }

    private ColorsIF getService(ServiceReference[] refs) {
	for (ServiceReference cif : refs) {
	    return (ColorsIF) bundleContext.getService(cif);
	}
	return null;
    }

    private ColorMixer getMixer() throws InvalidSyntaxException {
	ServiceReference mixerRef = bundleContext.getServiceReference(ColorMixer.class.getName());
	return (ColorMixer) bundleContext.getService(mixerRef);
    }

    private void drawDemo(ColorsIF s1, ColorsIF s2) throws InterruptedException {
	s1.draw();
	Thread.sleep(2000);
	s2.draw();
	Thread.sleep(2000);
	mixer.draw();
	Thread.sleep(3000);
	mixer.close();
	Thread.sleep(2000);
	s2.close();
	Thread.sleep(2000);
	s1.close();
    }

    private void log(String message) {
	System.out.println("colorMixer: " + message + ".");
    }

    private Hashtable<String, String> bProp() {
	Hashtable<String, String> bProp = new Hashtable<String, String>();
	bProp.put("color", "B");
	return bProp;
    }

    private Hashtable<String, String> rProp() {
	Hashtable<String, String> rProp = new Hashtable<String, String>();
	rProp.put("color", "R");
	return rProp;
    }

    private Hashtable<String, String> yProp() {
	Hashtable<String, String> yProp = new Hashtable<String, String>();
	yProp.put("color", "Y");
	return yProp;
    }

    private Hashtable<String, String> gProp() {
	Hashtable<String, String> yProp = new Hashtable<String, String>();
	yProp.put("color", "G");
	return yProp;
    }
}
