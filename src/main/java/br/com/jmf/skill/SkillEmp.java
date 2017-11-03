package br.com.jmf.skill;

public class SkillEmp extends SkillPane{

	private static final String IMG_EMP = "/img/emp.png";
	
	public SkillEmp() {
		super(IMG_EMP);
		this.setCooldown(30);
	}

}
