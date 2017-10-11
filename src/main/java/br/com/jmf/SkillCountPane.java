package br.com.jmf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.NumberFormat;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jnativehook.keyboard.NativeKeyEvent;

public class SkillCountPane {

	private static final String KEY_Q = "Q";
	private static final String KEY_W = "W";
	private static final String KEY_E = "E";
	private static final String KEY_R = "R";
	private static final String KEY_D = "D";
	private static final String KEY_F = "F";

    public SkillCountPane() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Invoker Skills");
                frame.setUndecorated(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                createSkills(frame);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setAlwaysOnTop(true);
                frame.setLocation(0, 0);
                frame.setVisible(true);
            }

			private void createSkills(JFrame frame) {
				frame.add(new SkillPane("/img/alacrity.png"));
                frame.add(new SkillPane("/img/blast.png"));
                frame.add(new SkillPane("/img/coldsnap.png"));
                frame.add(new SkillPane("/img/emp.png"));
                frame.add(new SkillPane("/img/forgespirit.png"));
                frame.add(new SkillPane("/img/ghostwalk.png"));
                frame.add(new SkillPane("/img/icewall.png"));
                frame.add(new SkillPane("/img/meteor.png"));
                frame.add(new SkillPane("/img/sunstrike.png"));
                frame.add(new SkillPane("/img/tornado.png"));
			}
        });
    }

	public void onKeyPressed(String keyPressed) {
		switch(keyPressed) {
		case KEY_Q :
			System.out.println("PRESSIONOU Q");
			break;
		case KEY_W :
			System.out.println("PRESSIONOU W");
			break;
		case KEY_E :
			System.out.println("PRESSIONOU E");
			break;
		case KEY_R :
			System.out.println("PRESSIONOU R");
			break;
		case KEY_D :
			System.out.println("PRESSIONOU D");
			break;
		case KEY_F :
			System.out.println("PRESSIONOU F");
			break;
			default:
		}
		
	}
}
