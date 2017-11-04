package br.com.jmf.type;

public enum MouseType {

	LEFT_BUTTON(1),
	RIGHT_BUTTON(2);

	private int button;
	
	MouseType(int button){
		this.button = button;
	}
	
}
