package br.com.jmf.enums;

public enum KeyType {
	KEY_Q("Q"),
	KEY_W("W"),
	KEY_E("E"),
	KEY_R("R"),
	KEY_D("D"),
	KEY_F("F"),
	KEY_DEFAULT("DEFAULT");
	
	private String key;
	
	KeyType(String key){
		this.key = key;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public static KeyType value(String str) {
		KeyType[] values = values();
		for (KeyType keyType : values) {
			if(keyType.getKey().equals(str))
				return keyType;
		}
		
		return KEY_DEFAULT;
	}
}
