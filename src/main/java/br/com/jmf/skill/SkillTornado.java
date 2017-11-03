package br.com.jmf.skill;

public class SkillTornado extends SkillPane{

	private static final String IMG_TORNADO = "/img/tornado.png";
	
	public SkillTornado() {
		super(IMG_TORNADO);
		this.setCooldown(30);
	}

}
