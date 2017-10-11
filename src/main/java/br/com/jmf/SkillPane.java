package br.com.jmf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.NumberFormat;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SkillPane extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4428499083094536647L;
    private BufferedImage potion;
    private BufferedImage chargeBar;
    private String image;
	private long cooldown;
	private long cooldownProgress;
	private boolean octarine;
    
    public SkillPane(String image) {
    	this.setImage(image);
        try {
            potion = ImageIO.read(getClass().getResource(image));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        setOpaque(false);

        setForeground(Color.BLUE);
        setBackground(Color.GRAY);

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setCooldownProgress(getCooldownProgress() + 1);
                if (getCooldownProgress() > getCooldown()) {
                    ((Timer) e.getSource()).stop();
                }
                repaint();
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }

    @Override
    public void invalidate() {
        super.invalidate();
        chargeBar = null;
    }

    @Override
    public Dimension getPreferredSize() {
        FontMetrics fm = getFontMetrics(getFont());
        return new Dimension(60, Math.max(50, fm.getHeight() + 4));
    }

    protected void createChargeBar() {

        if (chargeBar == null) {
            if (getWidth() > 0 && getHeight() > 0) {
                FontMetrics fm = getFontMetrics(getFont());
                int height = Math.max(50, fm.getHeight() + 4);
                chargeBar = new BufferedImage(getWidth() - 4, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = chargeBar.createGraphics();
                int x = 0;
                int y = (height - potion.getHeight()) / 2;
                while (x < getWidth() - 4) {
                    g2d.drawImage(potion, x, y, this);
                    x += potion.getWidth();
                }
                g2d.dispose();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        createChargeBar();
        super.paintComponent(g);

        int width = getWidth() - 4;
        int height = getHeight() - 4;
        int x = 2;
        int y = 2;

        g.setColor(getBackground());
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);

        int progressWidth = (int) (width * getCooldownProgress());
        BufferedImage progressImage = chargeBar.getSubimage(0, 0, progressWidth, chargeBar.getHeight());
        g.drawImage(progressImage, x, y, this);

        FontMetrics fm = g.getFontMetrics();
        String value = NumberFormat.getPercentInstance().format(getCooldownProgress());
        x = x + ((width - fm.stringWidth(value)) / 2);
        y = y + ((height - fm.getHeight()) / 2);

        g.setColor(Color.WHITE);
        g.drawString(value, x, y + fm.getAscent());
    }

	public void setCooldown(long segundos) {
		this.cooldown = segundos;
	}
	
	public long getCooldown() {
		return this.cooldown;
	}
	
	public void setOctarine(boolean has) {
		this.octarine = has;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void resetCooldown() {
		setCooldownProgress(0);
	}

	public long getCooldownProgress() {
		return cooldownProgress;
	}

	public void setCooldownProgress(long cooldownProgress) {
		this.cooldownProgress = cooldownProgress;
	}
}
