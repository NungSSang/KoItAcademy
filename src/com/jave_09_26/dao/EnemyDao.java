package com.jave_09_26.dao;

import java.util.ArrayList;

import com.java_09_26.container.Container;
public class EnemyDao {
	
	public ArrayList<String> getAttackPattern(){
		return Container.attackPatterns;
	}
	public String[] getEnem() {
		return Container.enem;
	}
	public int[] getEhealth() {
		return Container.ehealth;
	}
	public int[] getEattackPower() {
		return Container.eattackPower;
	}
	
}
