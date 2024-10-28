package com.jave_09_26.dto;

public class CharacterDto {
	
	private String pName;
	private int pHealth;
	private int pAttackPower;
	private int pBerrior; // 방어력(스테이지마다 증가할것)
	private int pBerriorInt; // 방어상수 ( 캐릭터 초기 설정 변하지 않음)
	private int pDmg;
	private Boolean berrior = false;
	private Boolean isRun = false;

	public CharacterDto() {
		this.pHealth = 100;
		this.pAttackPower = 40;
		this.pBerrior = 100;
		this.pBerriorInt = 100;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpHealth() {
		return pHealth;
	}

	public void setpHealth(int pHealth) {
		this.pHealth = pHealth;
	}

	public int getpAttackPower() {
		return pAttackPower;
	}

	public void setpAttackPower(int pAttackPower) {
		this.pAttackPower = pAttackPower;
	}

	public int getpBerrior() {
		return pBerrior;
	}

	public void setpBerrior(int pBerrior) {
		this.pBerrior = pBerrior;
	}

	public int getpBerriorInt() {
		return pBerriorInt;
	}

	public void setpBerriorInt(int pBerriorInt) {
		this.pBerriorInt = pBerriorInt;
	}

	public int getDmg() {
		return pDmg;
	}

	public void setDmg(int dmg) {
		this.pDmg = dmg;
	}

	public Boolean getIsRun() {
		return isRun;
	}

	public void setIsRun(Boolean isRun) {
		this.isRun = isRun;
	}

	public Boolean getberrior() {
		return berrior;
	}

	public void setberrior(Boolean berrior) {
		this.berrior = berrior;
	}
}
