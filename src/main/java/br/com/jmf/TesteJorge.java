package br.com.jmf;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class TesteJorge extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Dimension dimension = new Dimension(800, 110);
	private static final Dimension dimension_icon = new Dimension(80, 100);
	private JProgressBar progressBar;
	
	private static final String PREFIX_PATH ="src/main/resources/img/";
	
	
	public TesteJorge() {
		
	}
	
	public TesteJorge(String nome) {
		super(nome);
	}
	
	public void run() {
    	JPanel jPanel = new JPanel();
    	jPanel.setSize(this.getSize());
    	jPanel.setBackground(Color.CYAN);
    	
    	addIconsToJPanel(jPanel);
    	progressBar = new JProgressBar(0, 25);
    	progressBar.setValue(0);
    	progressBar.setStringPainted(true);
    	
    	jPanel.add(progressBar);
    	
    	this.getContentPane().add(jPanel);
    	this.setAlwaysOnTop( true );
//    	this.setUndecorated(true);
    	this.setLocation(0, 0);
    	
    	
    	for (int i = 0; i < 25; i++) {
    		try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		progressBar.setValue(i);
		}
	}

	private void addIconsToJPanel(JPanel jPanel) {
		JLabel labelEmp = createIconLabel("emp.png");
    	jPanel.add(labelEmp);
    	
    	JLabel labelTornado = createIconLabel("tornado.png");
    	jPanel.add(labelTornado);
    	
    	JLabel labelGhostWalk = createIconLabel("ghostwalk.png");
    	jPanel.add(labelGhostWalk );
    	
    	JLabel labelColdSnap = createIconLabel("coldsnap.png");
    	jPanel.add(labelColdSnap );
    	
    	JLabel alacrity = createIconLabel("alacrity.png");
    	jPanel.add(alacrity );
    	
    	JLabel blast = createIconLabel("blast.png");
    	jPanel.add(blast );
    	
    	JLabel icewall = createIconLabel("icewall.png");
    	jPanel.add(icewall );
    	
    	JLabel labelMeteor = createIconLabel("meteor.png");
    	jPanel.add(labelMeteor);
    	
    	JLabel forgespirit = createIconLabel("forgespirit.png");
    	jPanel.add(forgespirit );
    	
    	JLabel sunstrike = createIconLabel("sunstrike.png");
    	jPanel.add(sunstrike );
	}

	private JLabel createIconLabel(String iconName) {
		ImageIcon emp = new ImageIcon(PREFIX_PATH + iconName);
    	JLabel label = new JLabel();
    	label.setSize(dimension_icon);
    	label.setIcon(emp);
		return label;
	}
    public static void main(String[] args) {
    	TesteJorge testeJorge = new TesteJorge("Invoker Skills By Mestre dos Mangos!!!");
		testeJorge.setSize(dimension);
    	testeJorge.setVisible(true);
    	testeJorge.run();
    }
    
//    public void anotherTest() {
//        JFrame frame = new JFrame("Invoker!!");
//
//        // Set's the window to be "always on top"
//        frame.setAlwaysOnTop( true );
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationByPlatform( true );
//        
////        frame.setFocusableWindowState(false);
////        frame.setUndecorated(true);
//        
//        frame.setSize(800,600);
//        //frame.add( new JLabel("  Isn't this annoying?") );
////        ImageIcon emp = new ImageIcon("emp.png");
////           JLabel empLabel = new JLabel(emp);
////        frame.add(empLabel, BorderLayout.CENTER);
//        
//        frame.pack();
//        frame.setVisible( true );
////        TimeFrame timeFrame = new TimeFrame();
//    }
 
}
