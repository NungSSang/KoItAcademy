import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Item {

	private int hpPlus = 50;
	private int attackPlus = 20;
	private int berrior = 20;
	Character hero;
	Enemy enemy;
	int[] items = { hpPlus, attackPlus, berrior };
	String[] dropItem = { "마법사의 로브", "전사의 몽둥이", "엔트의 사과", "괴물의 이빨", "용의 심장" };
	String[] makeItem = { "마법사의 황금사과", "이빨장식 몽둥이", "드래곤 소드" };
	ArrayList<String> items2;
	Maps maps = new Maps();
	Scanner sc = new Scanner(System.in);
	Boolean itemEquip = false;

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

	public void makeItems(Character hero) {

	}

	public void itemController(Character hero) {
		System.out.printf("cmd : 명령어 확인\nback: 돌아가기\n재료아이템: 재료 아이템 목록\n장비아이템: 장착 가능한 아이템 목록\n장착아이템: 장착한 아이템 목록\n아이템장착: 장비아이템 장착\nmake: 아이템 제작\n");
		while (true) {
			String cmd = sc.nextLine();
			if (cmd.equals("back")) {
				break;
			}else if(cmd.equals("cmd")) {
				System.out.printf("cmd : 명령어 확인\nback: 돌아가기\n재료아이템: 재료 아이템 목록\n장비아이템: 장착 가능한 아이템 목록\n장착아이템: 장착한 아이템 목록\n아이템장착: 장비아이템 장착\nmake: 아이템 제작\n");
			}
			if (cmd.equals("재료아이템")) {
				int a = Collections.frequency(hero.dropItemBox, "마법사의 로브");
				int b = Collections.frequency(hero.dropItemBox, "전사의 몽둥이");
				int c = Collections.frequency(hero.dropItemBox, "괴물의 이빨");
				int d = Collections.frequency(hero.dropItemBox, "엔트의 사과");
				int f = Collections.frequency(hero.dropItemBox, "용의 심장");
				System.out.printf("마법사의 로브 %d개 \n", a);
				System.out.printf("전사의 몽둥이 %d개 \n", b);
				System.out.printf("괴물의 이빨 %d개 \n", c);
				System.out.printf("엔트의 사과 %d개 \n", d);
				System.out.printf("용의 심장 %d개 \n", f);
				continue;
			}else if(cmd.equals("장비아이템 목록")) {
				System.out.println(hero.mountableItem);
			}
			
			if (cmd.equals("make")) {
				System.out.print("아이템을 제작할 수 있습니다.\n마법사의 로브 1개 , 엔트의 사과 1개를 사용해서 마법사의 황금사과를 만들 수 있습니다.\n");
				System.out.println("전사의 몽둥이 1개 , 괴물의 이빨 2개를 사용해서 이빨장식 몽둥이를 만들 수 있습니다.");
				System.out.println("전사의 몽둥이 1개 , 용의 이빨을 사용해서 드래곤 소드를 만들 수 있습니다.");
				System.out.println("만들고 싶은 아이템의 이름을 입력 해 주세요.");
				continue;
			}
			if (cmd.equals("마법사의 황금사과") && !itemEquip) {
				removeSpecificOccurrences(hero.dropItemBox, "마법사의 로브", 1, hero);
				removeSpecificOccurrences(hero.dropItemBox, "엔트의 사과", 1, hero);
				System.out.println(makeItem[0]);
				System.out.printf("마법사의 황금사과 아이템을 성공적으로 제작하였습니다.\n마법사의 로브를 1개 잃었습니다.\n엔트의 사과를 1개 잃었습니다.\n");
				hero.mountableItem.add(makeItem[0]);
				continue;
			} else if (cmd.equals("이빨장식 몽둥이") && !itemEquip) {
				removeSpecificOccurrences(hero.dropItemBox, "전사의 몽둥이", 1, hero);
				removeSpecificOccurrences(hero.dropItemBox, "괴물의 이빨", 2, hero);
				System.out.println(makeItem[1]);
				System.out.printf("이빨장식 몽둥이 아이템을 성공적으로 제작하였습니다.\n전사의 몽둥이를 1개 잃었습니다.\n괴물의 이빨을 2개 잃었습니다.\n");
				hero.mountableItem.add(makeItem[1]);
				continue;
			} else if (cmd.equals("드래곤 소드") && !itemEquip) {
				removeSpecificOccurrences(hero.dropItemBox, "전사의 몽둥이", 1, hero);
				removeSpecificOccurrences(hero.dropItemBox, "용의 심장", 1, hero);
				System.out.println(makeItem[1]);
				System.out.printf("드래곤 소드 아이템을 성공적으로 제작하였습니다.\n전사의 몽둥이를 1개 잃었습니다.\n용의 심장을 1개 잃었습니다.\n");
				hero.mountableItem.add(makeItem[2]);
				continue;
			}
			if(cmd.equals("아이템장착")) {
				itemEquip = true;
				if(itemEquip) {
					equipInven(hero);
				}
				continue;
			}
			
		}

	}
	
	private void equipInven(Character hero) { // 장착할 수 있는 아이템이 있는지 체크하고 장비를 장착하는 메서드
		itemEquip = false;
		String cmd = sc.nextLine();
		System.out.println("장착할 아이템의 이름을 입력 해 주세요.");
		System.out.println("나의 아이템 " + hero.mountableItem);
		if(cmd.equals("마법사의 황금사과")) {
			for ( int i = 0; i < hero.mountableItem.size(); i++) {
				if(hero.mountableItem.get(i) == "마법사의 황금사과") {
					hero.mountableItem.remove(i);
					System.out.println("마법사의 황금사과 아이템을 장착했습니다.");
					hero.equippedItem.add("마법사의 황금사과");
				}
			}
		}else if(cmd.equals("이빨장식 몽둥이")) {
			for ( int i = 0; i < hero.mountableItem.size(); i++) {
				if(hero.mountableItem.get(i) == "이빨장식 몽둥이") {
					hero.mountableItem.remove(i);
					System.out.println("이빨장식 몽둥이 아이템을 장착했습니다.");
					hero.equippedItem.add("이빨장식 몽둥이");
				}
			}
		}else if(cmd.equals("드래곤 소드")) {
			for ( int i = 0; i < hero.mountableItem.size(); i++) {
				if(hero.mountableItem.get(i) == "드래곤 소드") {
					hero.mountableItem.remove(i);
					System.out.println("드래곤 소드 아이템을 장착했습니다.");
					hero.equippedItem.add("드래곤 소드");
				}
			}
		}else {
			System.out.println("아이템을 가지고 있지 않습니다.");
		}
	}
	
	private void removeSpecificOccurrences(ArrayList<String> dropItemBox, String element, int count, Character hero) {
		int removedCount = 0;
		// ArrayList를 반복하면서 요소 제거
		for (int i = 0; i < hero.dropItemBox.size(); i++) {
			if (hero.dropItemBox.get(i).equals(element)) {
				hero.dropItemBox.remove(i);
				removedCount++;
				i--; // remove 후 인덱스 조정
				if (removedCount == count) {
					break; // 지정된 개수만큼 제거하면 중단
				}
			}
		}
	}
}
