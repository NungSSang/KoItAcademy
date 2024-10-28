package com.jave_09_26.dto;

import java.util.Random;

public class EnemyDto {
	private String eName;
	private int eHealth;
	private int eAttackPower;
	private int eBerrior; // 방어력(스테이지마다 증가할것)
	private int eBerriorInt; // 방어상수 ( 캐릭터 초기 설정 변하지 않음)
	private int dmg;
	Random random = new Random();
	public int randomInt;

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public int geteHealth() {
		return eHealth;
	}

	public void seteHealth(int eHealth) {
		this.eHealth = eHealth;
	}

	public int geteAttackPower() {
		return eAttackPower;
	}

	public void seteAttackPower(int eAttackPower) {
		this.eAttackPower = eAttackPower;
	}

	public int geteBerrior() {
		return eBerrior;
	}

	public void seteBerrior(int eBerrior) {
		this.eBerrior = eBerrior;
	}

	public int geteBerriorInt() {
		return eBerriorInt;
	}

	public void seteBerriorInt(int eBerriorInt) {
		this.eBerriorInt = eBerriorInt;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

}
