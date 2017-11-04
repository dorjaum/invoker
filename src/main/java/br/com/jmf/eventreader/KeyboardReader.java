package br.com.jmf.eventreader;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import br.com.jmf.SkillCountController;

public class KeyboardReader implements NativeKeyListener {

	private static final SkillCountController INSTANCE = SkillCountController.getInstance();

	@Override
	public void nativeKeyPressed(NativeKeyEvent key) {
		getSkillCountPane().onKeyPressed(NativeKeyEvent.getKeyText(key.getKeyCode()));
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		System.out.println(NativeKeyEvent.getKeyText(arg0.getKeyCode()));
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		System.out.println(NativeKeyEvent.getKeyText(arg0.getKeyCode()));
	}

	public SkillCountController getSkillCountPane() {
		return INSTANCE;
	}

}
