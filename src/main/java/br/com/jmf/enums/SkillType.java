package br.com.jmf.enums;

import static br.com.jmf.enums.KeyType.*;

import java.util.ArrayList;
import java.util.List;

public enum SkillType {

	ALACRITY("ALACRITY", new KeyType[] {KEY_W, KEY_W, KEY_E}),
	BLAST("BLAST", new KeyType[] {KEY_Q, KEY_W, KEY_E}),
	COLDSNAP("COLDSNAP", new KeyType[] {KEY_Q, KEY_Q,KEY_Q}),
	EMP("EMP", new KeyType[] {KEY_W, KEY_W,KEY_W}),
	FORGESPIRIT("FORGESPIRIT", new KeyType[] {KEY_E, KEY_E,KEY_Q}),
	GHOSTWALK("GHOSTWALK", new KeyType[] {KEY_Q, KEY_Q,KEY_W}),
	ICEWALL("ICEWALL", new KeyType[] {KEY_Q, KEY_Q,KEY_E}),
	METEOR("METEOR", new KeyType[] {KEY_E, KEY_E,KEY_W}),
	SUNSTRIKE("SUNSTRIKE", new KeyType[] {KEY_E, KEY_E,KEY_E}),
	TORNADO("TORNADO", new KeyType[] {KEY_W, KEY_W,KEY_Q}),
	DEFAULT("DEFAULT", new KeyType[] {KEY_DEFAULT});
	
	private String name;
	private ArrayList<KeyType> keySequenceL = new ArrayList<KeyType>();
	
	SkillType(String name, KeyType... keySequence){
		this.name = name;
		
		for (KeyType keyType : keySequence) {
			keySequenceL.add(keyType);
		}
	}
	
	public static SkillType getSkill(KeyType[] keySequence) {
		if(isWhatSkill(keySequence, ALACRITY)) {
			return ALACRITY;
		}
		if(isWhatSkill(keySequence, BLAST)) {
			return BLAST;
		}
		if(isWhatSkill(keySequence, COLDSNAP)) {
			return COLDSNAP;
		}
		if(isWhatSkill(keySequence, EMP)) {
			return EMP;
		}
		if(isWhatSkill(keySequence, FORGESPIRIT)) {
			return FORGESPIRIT;
		}
		if(isWhatSkill(keySequence, GHOSTWALK)) {
			return GHOSTWALK;
		}
		if(isWhatSkill(keySequence, ICEWALL)) {
			return ICEWALL;
		}
		if(isWhatSkill(keySequence, METEOR)) {
			return METEOR;
		}
		if(isWhatSkill(keySequence, SUNSTRIKE)) {
			return SUNSTRIKE;
		}
		if(isWhatSkill(keySequence, TORNADO)) {
			return TORNADO;
		}
		
		return DEFAULT;
	}

	private static boolean isWhatSkill(KeyType[] keyInserted, SkillType skillType) {
		ArrayList<KeyType> cloneList = (ArrayList<KeyType>) skillType.keySequenceL.clone();
		
		for (KeyType key : keyInserted) {
			int posicao = 0;
			for (KeyType keyType : cloneList) {
				if(key.equals(keyType)) {
					cloneList.remove(posicao);
					break;
				}else {
					posicao++;
				}
			}
		}
		
		return cloneList.isEmpty();
	}
	
}
