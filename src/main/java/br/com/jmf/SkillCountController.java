package br.com.jmf;

import static br.com.jmf.enums.KeyType.*;

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

import org.jcp.xml.dsig.internal.dom.ApacheNodeSetData;
import org.jnativehook.keyboard.NativeKeyEvent;

import br.com.jmf.enums.KeyType;
import br.com.jmf.enums.SkillType;

public class SkillCountController {

	private static final String IMG_COLDSNAP = "/img/coldsnap.png";
	private static final String IMG_ALACRITY = "/img/alacrity.png";
	private static final String IMG_BLAST = "/img/blast.png";
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
	private KeyType[] sequence = new KeyType[3];
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

			
        });
    }

    private void addKeyToSequence(KeyType key) {
    	sequence[2] = sequence[1];
    	sequence[1] = sequence[0];
    	sequence[0] = key;
    }
    
    private void summonSkillR() {
    	if(isInvalidSequence()) {
    		return;
    	}
    	
    	SkillType skill = SkillType.getSkill(sequence);
    	SkillPane selectedSkill = getSkillPane(skill);
    	
    	dAndF[1] = dAndF[0];
    	dAndF[0] = selectedSkill;
    	System.out.println(skill.name());
    }
    
    private SkillPane getSkillPane(SkillType skill) {
		switch(skill) {
		case ALACRITY:
			return getAlacrity();
			
		case BLAST:
			return getBlast();
			
		case COLDSNAP:
			return getColdsnap();
			
		case EMP:
			return getEmp();
			
		case FORGESPIRIT:
			return getForgespirit();
			
		case GHOSTWALK:
			return getGhostwalk();
			
		case ICEWALL:
			return getIcewall();
			
		case METEOR:
			return getMeteor();
			
		case SUNSTRIKE:
			return getSunstrike();
			
		case TORNADO:
			return getTornado();
		}
		
		return null;
	}

	private void castSkill(SkillPane skill) {
    	if(skill == null) {
    		return;
    	}
    	
    	if(skill.isOnCooldown()) {
    		return;
    	}
    	
    	skill.putInCooldown();
    }
    
    private boolean isInvalidSequence() {
    	for (KeyType keyType : sequence) {
    		if(keyType == null) return true;
		}
    	
    	return false;
    }
    
	public void onKeyPressed(String keyPressed) {
		switch(KeyType.value(keyPressed)) {
		case KEY_Q :
			System.out.println("PRESSIONOU Q");
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
			castSkill(dAndF[0]);
			break;
		case KEY_F :
			System.out.println("PRESSIONOU F");
			castSkill(dAndF[1]);
			break;
		}
		
	}
	
	private void createSkills(JFrame frame) {
		initiateSkills();
        addSkillsToFrame(frame);
	}

	private void addSkillsToFrame(JFrame frame) {
		frame.add(getAlacrity());
        frame.add(getBlast());	
        frame.add(getColdsnap());
        frame.add(getEmp());
        frame.add(getForgespirit());
        frame.add(getGhostwalk());
        frame.add(getIcewall());
        frame.add(getMeteor());
        frame.add(getSunstrike());
        frame.add(getTornado());
	}

	private void initiateSkills() {
		setupAlacrity();
		setupBlast();
		setupColdsnap();
		
        setEmp(new SkillPane("/img/emp.png"));
        setForgespirit(new SkillPane("/img/forgespirit.png"));
        setGhostwalk(new SkillPane("/img/ghostwalk.png"));
        setIcewall(new SkillPane("/img/icewall.png"));
        setMeteor(new SkillPane("/img/meteor.png"));
        setSunstrike(new SkillPane("/img/sunstrike.png"));
        setTornado(new SkillPane("/img/tornado.png"));
	}

	private void setupAlacrity() {
		setAlacrity(new SkillPane(IMG_ALACRITY));
		getAlacrity().setCooldown(15);
		getAlacrity().setOctarine(false);
//		getAlacrity().putInCooldown();
	}
	private void setupBlast() {
		setBlast(new SkillPane(IMG_BLAST));
		getBlast().setCooldown(40);
		getBlast().setOctarine(false);
//		getBlast().putInCooldown();
	}
	private void setupColdsnap() {
		setColdsnap(new SkillPane(IMG_COLDSNAP));
		getColdsnap().setCooldown(20);
		getColdsnap().setOctarine(false);
//		getColdsnap().putInCooldown();
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
