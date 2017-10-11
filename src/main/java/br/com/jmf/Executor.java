package br.com.jmf;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class Executor {

	public static void main(String[] args) {
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			//e.printStackTrace();
		}
		
		GlobalScreen.addNativeKeyListener(new KeyboardReader());
	}
}
