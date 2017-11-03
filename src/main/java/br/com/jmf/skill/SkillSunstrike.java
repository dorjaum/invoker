package br.com.jmf.skill;

public class SkillSunstrike extends SkillPane{

	private static final String IMG_SUNSTRIKE = "/img/sunstrike.png";
	
	public SkillSunstrike() {
		super(IMG_SUNSTRIKE);
		this.setCooldown(25);
	}

}
