package br.com.jmf.skill;

public class SkillMeteor extends SkillPane{

	private static final String IMG_METEOR = "/img/meteor.png";
	
	public SkillMeteor() {
		super(IMG_METEOR);
		this.setCooldown(55);
	}

}
