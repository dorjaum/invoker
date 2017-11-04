package br.com.jmf.eventreader;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

import br.com.jmf.SkillCountController;

public class MouseReader implements NativeMouseListener {

	private static final SkillCountController INSTANCE = SkillCountController.getInstance();
	
	public void nativeMouseClicked(NativeMouseEvent e) {
		System.out.println("Mouse Clicked: " + e.getClickCount());
		INSTANCE.onMouseClicked(e.getButton());
	}

	public void nativeMousePressed(NativeMouseEvent e) {
		System.out.println("Mouse Pressed: " + e.getButton());
	}

	public void nativeMouseReleased(NativeMouseEvent e) {
		System.out.println("Mouse Released: " + e.getButton());
	}

	public void nativeMouseMoved(NativeMouseEvent e) {
		System.out.println("Mouse Moved: " + e.getX() + ", " + e.getY());
	}

	public void nativeMouseDragged(NativeMouseEvent e) {
		System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
	}
	
	public SkillCountController getSkillCountPane() {
		return INSTANCE;
	}
	
}
