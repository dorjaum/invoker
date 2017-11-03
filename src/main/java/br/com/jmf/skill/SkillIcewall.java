package br.com.jmf.skill;

public class SkillIcewall extends SkillPane{

	private static final String IMG_ICEWALL = "/img/icewall.png";
	
	public SkillIcewall() {
		super(IMG_ICEWALL);
		this.setCooldown(25);
	}

}
