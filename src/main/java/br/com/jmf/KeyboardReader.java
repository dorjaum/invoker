package br.com.jmf;

import java.util.Scanner;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyboardReader implements NativeKeyListener {

	public static void main(String[] args) {
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			//e.printStackTrace();
		}
		
		GlobalScreen.addNativeKeyListener(new KeyboardReader());
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent key) {
		System.out.println("Pressed > " + NativeKeyEvent.getKeyText(key.getKeyCode()));
		
		
		if("Q" == NativeKeyEvent.getKeyText(key.getKeyCode())){
			System.out.println("QUAS");
		}
		if("W" == NativeKeyEvent.getKeyText(key.getKeyCode())){
			System.out.println("WEX");
		}
		if("E" == NativeKeyEvent.getKeyText(key.getKeyCode())){
			System.out.println("EXORT");
		}
		if("R" == NativeKeyEvent.getKeyText(key.getKeyCode())){
			System.out.println("CAST");
		}		
		if("D" == NativeKeyEvent.getKeyText(key.getKeyCode())){
			System.out.println("USE D");
		}	
		if("F" == NativeKeyEvent.getKeyText(key.getKeyCode())){
			System.out.println("USE F");
		}		
		
		
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		System.out.println("typed > " + NativeKeyEvent.getKeyText(arg0.getKeyCode()));
		// TODO Auto-generated method stub
		
	}
}
