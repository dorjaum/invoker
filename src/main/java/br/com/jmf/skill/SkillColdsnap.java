package br.com.jmf.skill;

public class SkillColdsnap extends SkillPane{

	private static final String IMG_COLDSNAP = "/img/coldsnap.png";
	
	public SkillColdsnap() {
		super(IMG_COLDSNAP);
		this.setCooldown(20);
	}

}
