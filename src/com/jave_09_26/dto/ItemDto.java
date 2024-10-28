package com.jave_09_26.dto;

import java.util.Scanner;

public class ItemDto {
	
	private int hpPlus = 50;
	private int attackPlus = 20;
	private int berrior = 20;
	Boolean itemEquip = false;
	Boolean itemMake = false;
//	private int gold;
//	private int expUp;
//	Scanner sc = new Scanner(System.in);

	
	
	public int getHpPlus() {
		return hpPlus;
	}
	public void setHpPlus(int hpPlus) {
		this.hpPlus = hpPlus;
	}
	public int getAttackPlus() {
		return attackPlus;
	}
	public void setAttackPlus(int attackPlus) {
		this.attackPlus = attackPlus;
	}
	public int getBerrior() {
		return berrior;
	}
	public void setBerrior(int berrior) {
		this.berrior = berrior;
	}

	public Boolean getItemEquip() {
		return itemEquip;
	}
	public void setItemEquip(Boolean itemEquip) {
		this.itemEquip = itemEquip;
	}
	public Boolean getItemMake() {
		return itemMake;
	}
	public void setItemMake(Boolean itemMake) {
		this.itemMake = itemMake;
	}

	
	
	
}
