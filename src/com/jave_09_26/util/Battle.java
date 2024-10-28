package com.jave_09_26.util;
import com.java_09_26.Controller.*;
public class Battle {
	CharacterController hero;
	EnemyController enemy;

	public void playerAttack() {
		hero.attack();
		enemy.takeDamage();
	}

	public void playerSkillAttack() {
		System.out.println("스킬공격");
		hero.skillAttack();
	}

	public void enemyAttack() {
		enemy.enemyRandomAttack();
	}
}
