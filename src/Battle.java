import java.util.Scanner;

public class Battle {
	Character hero;
	Enemy enemy;
	Main main;
	Scanner sc = new Scanner(System.in);

	public Battle(Character hero, Enemy enemy) {
		this.hero = hero;
	}

	public void playerAttack(Enemy enemy) {
		hero.attack();
		enemy.takeDamage(hero);
	}

	public void playerSkillAttack(Enemy enemy) {
		System.out.println("스킬공격");
		hero.skillAttack(enemy);
	}

	public void enemyAttack(Enemy enemy) {
		enemy.enemyRandomAttack(hero);
	}
}
