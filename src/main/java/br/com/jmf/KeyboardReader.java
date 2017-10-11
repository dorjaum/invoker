package br.com.jmf;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyboardReader implements NativeKeyListener {

	private SkillCountPane skillCountPane = new SkillCountPane();
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent key) {
		getSkillCountPane().onKeyPressed(NativeKeyEvent.getKeyText(key.getKeyCode()));
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		System.out.println("typed > " + NativeKeyEvent.getKeyText(arg0.getKeyCode()));
		
	}

	public SkillCountPane getSkillCountPane() {
		return skillCountPane;
	}

}
