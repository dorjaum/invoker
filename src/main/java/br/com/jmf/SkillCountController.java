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

import br.com.jmf.enums.SkillType;

public class SkillCountController {

	private static final String KEY_Q = "Q";
	private static final String KEY_W = "W";
	private static final String KEY_E = "E";
	private static final String KEY_R = "R";
	private static final String KEY_D = "D";
	private static final String KEY_F = "F";

	private SkillPane alacrity;
	private SkillPane blast;
	private SkillPane coldsnap;
	private SkillPane emp;
	private SkillPane forgespirit;
	private SkillPane ghostwalk;
	private SkillPane icewall;
	private SkillPane meteor;
	private SkillPane sunstrike;
	private SkillPane tornado;
	private String[] sequence = new String[3];
	private SkillPane[] dAndF = new SkillPane[2];
	
    public SkillCountController() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Invoker Skills");
                //frame.setUndecorated(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                createSkills(frame);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setAlwaysOnTop(true);
                frame.setLocation(0, 0);
                frame.setVisible(true);
            }

			
        });
    }

    private void addKeyToSequence(String key) {
    	sequence[2] = sequence[1];
    	sequence[1] = sequence[0];
    	sequence[0] = key;
    }
    
    private void summonSkillR() {
    	if(isInvalidSequence()) {
    		return;
    	}
    	
    	SkillType skill = SkillType.getSkill(sequence);
    	System.out.println(skill.name());
    	
    }
    
    private void castSkillD() {
    	
    }
    
    private void castSkillF() {
    	
    }
    
    private boolean isInvalidSequence() {
    	for (String string : sequence) {
    		if(string == null || string == "") return true;
		}
    	
    	return false;
    }
    
	public void onKeyPressed(String keyPressed) {
		switch(keyPressed) {
		case KEY_Q :
			System.out.println("PRESSIONOU Q");
			getAlacrity().resetCooldown();
			addKeyToSequence(KEY_Q);
			break;
		case KEY_W :
			System.out.println("PRESSIONOU W");
			addKeyToSequence(KEY_W);
			break;
		case KEY_E :
			System.out.println("PRESSIONOU E");
			addKeyToSequence(KEY_E);
			break;
		case KEY_R :
			System.out.println("PRESSIONOU R");
			summonSkillR();
			break;
		case KEY_D :
			System.out.println("PRESSIONOU D");
			castSkillD();
			break;
		case KEY_F :
			System.out.println("PRESSIONOU F");
			castSkillF();
			break;
			default:
		}
		
	}
	
	private void createSkills(JFrame frame) {
		initiateSkills();
        addSkillsToFrame(frame);
	}

	private void addSkillsToFrame(JFrame frame) {
		frame.add(getAlacrity());
//        frame.add(getBlast());	
//        frame.add(getColdsnap());
//        frame.add(getEmp());
//        frame.add(getForgespirit());
//        frame.add(getGhostwalk());
//        frame.add(getIcewall());
//        frame.add(getMeteor());
//        frame.add(getSunstrike());
//        frame.add(getTornado());
	}

	private void initiateSkills() {
		setupAlacrity();
//		setBlast(new SkillPane("/img/blast.png"));
//		setColdsnap(new SkillPane("/img/coldsnap.png"));
//        setEmp(new SkillPane("/img/emp.png"));
//        setForgespirit(new SkillPane("/img/forgespirit.png"));
//        setGhostwalk(new SkillPane("/img/ghostwalk.png"));
//        setIcewall(new SkillPane("/img/icewall.png"));
//        setMeteor(new SkillPane("/img/meteor.png"));
//        setSunstrike(new SkillPane("/img/sunstrike.png"));
//        setTornado(new SkillPane("/img/tornado.png"));
	}

	private void setupAlacrity() {
		setAlacrity(new SkillPane("/img/alacrity.png"));
		getAlacrity().setCooldown(15);
		getAlacrity().setOctarine(false);
		getAlacrity().resetCooldown();
	}

	public SkillPane getAlacrity() {
		return alacrity;
	}

	public void setAlacrity(SkillPane alacrity) {
		this.alacrity = alacrity;
	}

	public SkillPane getBlast() {
		return blast;
	}

	public void setBlast(SkillPane blast) {
		this.blast = blast;
	}

	public SkillPane getColdsnap() {
		return coldsnap;
	}

	public void setColdsnap(SkillPane coldsnap) {
		this.coldsnap = coldsnap;
	}

	public SkillPane getEmp() {
		return emp;
	}

	public void setEmp(SkillPane emp) {
		this.emp = emp;
	}

	public SkillPane getForgespirit() {
		return forgespirit;
	}

	public void setForgespirit(SkillPane forgespirit) {
		this.forgespirit = forgespirit;
	}

	public SkillPane getGhostwalk() {
		return ghostwalk;
	}

	public void setGhostwalk(SkillPane ghostwalk) {
		this.ghostwalk = ghostwalk;
	}

	public SkillPane getIcewall() {
		return icewall;
	}

	public void setIcewall(SkillPane icewall) {
		this.icewall = icewall;
	}

	public SkillPane getMeteor() {
		return meteor;
	}

	public void setMeteor(SkillPane meteor) {
		this.meteor = meteor;
	}

	public SkillPane getSunstrike() {
		return sunstrike;
	}

	public void setSunstrike(SkillPane sunstrike) {
		this.sunstrike = sunstrike;
	}

	public SkillPane getTornado() {
		return tornado;
	}

	public void setTornado(SkillPane tornado) {
		this.tornado = tornado;
	}
}
