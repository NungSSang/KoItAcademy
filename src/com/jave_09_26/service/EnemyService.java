package com.jave_09_26.service;

import java.util.ArrayList;

import com.java_09_26.Controller.EnemyController;
import com.jave_09_26.dao.EnemyDao;

public class EnemyService {
	EnemyController enemyController;
	EnemyDao enemyDao;
	
	public ArrayList<String> getAttackPattern(){
		return enemyDao.getAttackPattern();
	}
	public String[] getEnem() {
		return enemyDao.getEnem();
	}
	public int[] getEhealth() {
		return enemyDao.getEhealth();
	}
	public int[] getEattackPower() {
		return enemyDao.getEattackPower();
	}
	
}
