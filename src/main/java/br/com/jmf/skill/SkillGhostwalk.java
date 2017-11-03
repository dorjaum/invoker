package br.com.jmf.skill;

public class SkillGhostwalk extends SkillPane{

	private static final String IMG_GHOSTWALK = "/img/ghostwalk.png";
	
	public SkillGhostwalk() {
		super(IMG_GHOSTWALK);
		this.setCooldown(45);
	}

}
