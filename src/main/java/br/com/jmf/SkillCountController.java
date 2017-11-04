package br.com.jmf;

import static br.com.jmf.type.KeyType.KEY_E;
import static br.com.jmf.type.KeyType.KEY_Q;
import static br.com.jmf.type.KeyType.KEY_W;

import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.jmf.skill.SkillAlacrity;
import br.com.jmf.skill.SkillBlast;
import br.com.jmf.skill.SkillColdsnap;
import br.com.jmf.skill.SkillEmp;
import br.com.jmf.skill.SkillForgespirit;
import br.com.jmf.skill.SkillGhostwalk;
import br.com.jmf.skill.SkillIcewall;
import br.com.jmf.skill.SkillMeteor;
import br.com.jmf.skill.SkillPane;
import br.com.jmf.skill.SkillSunstrike;
import br.com.jmf.skill.SkillTornado;
import br.com.jmf.type.KeyType;
import br.com.jmf.type.SkillType;

public class SkillCountController {
	
	private static final String INVOKER_SKILLS = "Invoker Skills";
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
	private static SkillCountController instance;
	
	public static SkillCountController getInstance() {
		if(instance == null) {
			instance = new SkillCountController();
		}
		
		return instance;
	}
	
    private SkillCountController() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                } 

                JFrame frame = new JFrame(INVOKER_SKILLS);
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
			System.out.println("PRESSED Q");
			addKeyToSequence(KEY_Q);
			break;
			
		case KEY_W :
			System.out.println("PRESSED W");
			addKeyToSequence(KEY_W);
			break;
			
		case KEY_E :
			System.out.println("PRESSED E");
			addKeyToSequence(KEY_E);
			break;
			
		case KEY_R :
			System.out.println("PRESSED R");
			summonSkillR();
			break;
			
		case KEY_D :
			System.out.println("PRESSED D");
			castSkill(dAndF[0]);
			break;
			
		case KEY_F :
			System.out.println("PRESSED F");
			castSkill(dAndF[1]);
			break;
		}
		
	}

	public void onMouseClicked(int button) {
		
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
		setEmp(new SkillEmp());
		setAlacrity(new SkillAlacrity());
		setBlast(new SkillBlast());
		setColdsnap(new SkillColdsnap());
        setForgespirit(new SkillForgespirit());
        setGhostwalk(new SkillGhostwalk());
        setIcewall(new SkillIcewall());
        setMeteor(new SkillMeteor());
        setSunstrike(new SkillSunstrike());
        setTornado(new SkillTornado());
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
