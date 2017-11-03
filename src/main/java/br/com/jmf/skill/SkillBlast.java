package br.com.jmf.skill;

public class SkillBlast extends SkillPane{

	private static final String IMG_BLAST = "/img/blast.png";
	
	public SkillBlast() {
		super(IMG_BLAST);
		this.setCooldown(40);
	}

}
