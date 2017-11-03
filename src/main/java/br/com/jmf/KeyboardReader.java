package br.com.jmf;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyboardReader implements NativeKeyListener {

	private SkillCountController skillCountPane = new SkillCountController();
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent key) {
		getSkillCountPane().onKeyPressed(NativeKeyEvent.getKeyText(key.getKeyCode()));
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {

	}

	public SkillCountController getSkillCountPane() {
		return skillCountPane;
	}

}
