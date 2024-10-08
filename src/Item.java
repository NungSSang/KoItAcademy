import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Item {
	private int hpPlus = 50;
	private int attackPlus = 20;
	private int berrior = 20;
	Character hero;
	Enemy enemy;
	int[] items = { hpPlus, attackPlus, berrior };
	String[] dropItem = { "마법사의 로브", "전사의 몽둥이", "엔트의 사과", "괴물의 이빨", "용의 심장" };
	ArrayList<String> items2;
	Maps maps = new Maps();
	Scanner sc = new Scanner(System.in);

	public Item() {
		this.items2 = new ArrayList<>(Arrays.asList("hpPlus", "attackPlus", "berrior", "Exp Up"));
	}

	public int getHpPlus() {
		return hpPlus;
	}

	public int getAttackPlus() {
		return attackPlus;
	}

	public int getBerrior() {
		return berrior;
	}

	public void dropItems(Character hero, Enemy enemy) {
		if (enemy.geteName().equals("마법사")) {
			System.out.println(dropItem[0]);
			hero.dropItemBox.add(dropItem[0]);
		} else if (enemy.geteName().equals("전사")) {
			System.out.println(dropItem[1]);
			hero.dropItemBox.add(dropItem[1]);
		} else if (enemy.geteName().equals("엔트")) {
			System.out.println(dropItem[2]);
			hero.dropItemBox.add(dropItem[2]);
		} else if (enemy.geteName().equals("괴물")) {
			System.out.println(dropItem[3]);
			hero.dropItemBox.add(dropItem[3]);
		} else if (enemy.geteName().equals("용")) {
			System.out.println(dropItem[4]);
			hero.dropItemBox.add(dropItem[4]);
		} else {
			System.out.println("드롭된 아이템이 없습니다.");
		}
	}
}
