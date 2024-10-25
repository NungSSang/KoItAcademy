import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Item {
	private int hpPlus = 50;
	private int attackPlus = 20;
	private int berrior = 20;
	private int gold;
	Random random = new Random();
//	private int expUp;
	Enemy enemy;

	int[] items = { hpPlus, attackPlus, berrior };
	String[] dropItem = { "마법사의 로브", "전사의 몽둥이", "엔트의 사과", "괴물의 이빨", "용의 심장" };
	String[] makeItem = { "마법사의 황금사과", "이빨장식 몽둥이", "드래곤 소드" };
	ArrayList<String> items2;
	Maps maps = new Maps();
	Scanner sc = new Scanner(System.in);
	Boolean itemEquip = false;
	Boolean itemMake = false;

	public Item() {
		this.items2 = new ArrayList<>(Arrays.asList("hpPlus", "attackPlus", "berrior"));
	}

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

	public int getGold() {
		gold = (int) (Math.random() * 201) + 50;
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
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

	public void showItem(Character hero) {
		System.out.printf("마법사의 로브 %d개 \n", Collections.frequency(hero.dropItemBox, "마법사의 로브"));
		System.out.printf("전사의 몽둥이 %d개 \n", Collections.frequency(hero.dropItemBox, "전사의 몽둥이"));
		System.out.printf("괴물의 이빨 %d개 \n", Collections.frequency(hero.dropItemBox, "괴물의 이빨"));
		System.out.printf("엔트의 사과 %d개 \n", Collections.frequency(hero.dropItemBox, "엔트의 사과"));
		System.out.printf("용의 심장 %d개 \n", Collections.frequency(hero.dropItemBox, "용의 심장"));
	}

	public void makeItem(Character hero, int i) {
		if (i == 0) {
			if (Collections.frequency(hero.dropItemBox, "마법사의 로브") == 0
					|| Collections.frequency(hero.dropItemBox, "엔트의 사과") == 0) {
				System.out.println("재료 아이템이 부족합니다.");
			} else {
				removeSpecificOccurrences(hero.dropItemBox, "마법사의 로브", 1, hero);
				removeSpecificOccurrences(hero.dropItemBox, "엔트의 사과", 1, hero);
				System.out.println(makeItem[0]);
				System.out.printf("마법사의 황금사과 아이템을 성공적으로 제작하였습니다.\n마법사의 로브를 1개 잃었습니다.\n엔트의 사과를 1개 잃었습니다.\n");
				hero.mountableItem.add(makeItem[0]);
			}
		} else if (i == 1) {
			if (Collections.frequency(hero.dropItemBox, "전사의 몽둥이") == 0
					|| Collections.frequency(hero.dropItemBox, "괴물의 이빨") < 2) {
				System.out.println("재료 아이템이 부족합니다.");
			} else {
				removeSpecificOccurrences(hero.dropItemBox, "전사의 몽둥이", 1, hero);
				removeSpecificOccurrences(hero.dropItemBox, "괴물의 이빨", 2, hero);
				System.out.println(makeItem[1]);
				System.out.printf("이빨장식 몽둥이 아이템을 성공적으로 제작하였습니다.\n전사의 몽둥이를 1개 잃었습니다.\n괴물의 이빨을 2개 잃었습니다.\n");
				hero.mountableItem.add(makeItem[1]);
			}
		} else if (i == 2) {
			if (Collections.frequency(hero.dropItemBox, "전사의 몽둥이") == 0
					|| Collections.frequency(hero.dropItemBox, "용의 심장") == 0) {
				System.out.println("재료 아이템이 부족합니다.");
			} else {
				removeSpecificOccurrences(hero.dropItemBox, "전사의 몽둥이", 1, hero);
				removeSpecificOccurrences(hero.dropItemBox, "용의 심장", 1, hero);
				System.out.println(makeItem[1]);
				System.out.printf("드래곤 소드 아이템을 성공적으로 제작하였습니다.\n전사의 몽둥이를 1개 잃었습니다.\n용의 심장을 1개 잃었습니다.\n");
				hero.mountableItem.add(makeItem[2]);
			}
		}
		itemMake = false;
	}

	public void equipInven(Character hero) { // 장착할 수 있는 아이템이 있는지 체크하고 장비를 장착하는 메서드
		if (hero.mountableItem.size() == 0) {
			System.out.println("장착할 수 있는 아이템이 없습니다.");
		} else {
			System.out.println("나의 아이템 " + hero.mountableItem);
			System.out.printf("장착할 아이템의 이름을 입력 해 주세요: ");
			String cmd = sc.nextLine();
			if (cmd.equals("마법사의 황금사과")) {
				for (int i = 0; i < hero.mountableItem.size(); i++) {
					if (hero.mountableItem.get(i) == "마법사의 황금사과") {
						hero.mountableItem.remove(i);
						System.out.println("마법사의 황금사과 아이템을 장착했습니다.");
						hero.equippedItem.add("마법사의 황금사과");
					} else {
						System.out.println("아이템을 가지고 있지 않습니다.");
					}
				}
			} else if (cmd.equals("이빨장식 몽둥이")) {
				for (int i = 0; i < hero.mountableItem.size(); i++) {
					if (hero.mountableItem.get(i) == "이빨장식 몽둥이") {
						hero.mountableItem.remove(i);
						System.out.println("이빨장식 몽둥이 아이템을 장착했습니다.");
						hero.equippedItem.add("이빨장식 몽둥이");
					} else {
						System.out.println("아이템을 가지고 있지 않습니다.");
					}
				}
			} else if (cmd.equals("드래곤 소드")) {
				for (int i = 0; i < hero.mountableItem.size(); i++) {
					if (hero.mountableItem.get(i) == "드래곤 소드") {
						hero.mountableItem.remove(i);
						System.out.println("드래곤 소드 아이템을 장착했습니다.");
						hero.equippedItem.add("드래곤 소드");
					} else {
						System.out.println("아이템을 가지고 있지 않습니다.");
					}
				}
			}
		}
		itemEquip = false;
	}

	private void removeSpecificOccurrences(ArrayList<String> dropItemBox, String itemName, int count, Character hero) {
		int removedCount = 0;
		// ArrayList를 반복하면서 요소 제거
		for (int i = 0; i < hero.dropItemBox.size(); i++) {
			if (hero.dropItemBox.get(i).equals(itemName)) {
				hero.dropItemBox.remove(i);
				removedCount++;
				i--; // remove 후 인덱스 조정
				if (removedCount == count) {
					break; // 지정된 개수만큼 제거하면 중단
				}
			}
		}
	}

	public void itemController(Character hero) {
		System.out.printf(
				"cmd : 명령어 확인\nback: 게임으로 돌아가기\n재료아이템 목록: 재료 아이템 목록\n장비아이템 목록: 장착 가능한 아이템 목록\n장착아이템 목록: 장착한 아이템 목록\n아이템 장착:아이템 장착\n아이템 제작: 아이템 제작\n");
//		while (true) {
//
//			String cmd = sc.nextLine();
//			if (cmd.equals("back")) {
//				break;
//			} else if (cmd.equals("cmd")) {
//				System.out.printf(
//						"cmd : 명령어 확인\nback: 게임으로 돌아가기\n재료아이템 목록: 재료 아이템 목록\n장비아이템 목록: 장착 가능한 아이템 목록\n장착아이템 목록: 장착한 아이템 목록\n아이템 장착:아이템 장착\n아이템 제작: 아이템 제작\n");
//			} else if (cmd.equals("")) {
//				System.out.println("명령어를 입력 해 주세요.");
//			}
//			if (cmd.equals("재료아이템 목록")) {
//				showItem(hero);
//				continue;
//			} else if (cmd.equals("장비아이템 목록")) {
//				if (hero.mountableItem.size() == 0) {
//					System.out.println("장비아이템이 없습니다.");
//				} else {
//					System.out.println(hero.mountableItem);
//				}
//
//			} else if (cmd.equals("장착아이템 목록")) {
//				if (hero.equippedItem.size() == 0) {
//					System.out.println("장착한 아이템이 없습니다.");
//				} else {
//					System.out.println(hero.equippedItem);
//				}
//			}
//
//			if (cmd.equals("레시피")) {
//				System.out.print("아이템을 제작할 수 있습니다.\n마법사의 로브 1개 , 엔트의 사과 1개를 사용해서 마법사의 황금사과를 만들 수 있습니다.\n");
//				System.out.println("전사의 몽둥이 1개 , 괴물의 이빨 2개를 사용해서 이빨장식 몽둥이를 만들 수 있습니다.");
//				System.out.println("전사의 몽둥이 1개 , 용의 이빨을 사용해서 드래곤 소드를 만들 수 있습니다.");
//				System.out.println("만들고 싶은 아이템의 이름을 입력 해 주세요.");
//				continue;
//			}
//			if (cmd.equals("아이템 제작")) {
//				System.out.printf("마법사의 황금사과\n이빨장식 몽둥이\n드래곤 소드\n");
//				System.out.printf("제작할 아이템의 이름을 입력해 주세요: ");
//				itemMake = true;
//			}
//			if (cmd.equals("마법사의 황금사과") && !itemEquip && itemMake) {
//				makeItem(hero, 0);
//			} else if (cmd.equals("이빨장식 몽둥이") && !itemEquip && itemMake) {
//				makeItem(hero, 1);
//			} else if (cmd.equals("드래곤 소드") && !itemEquip && itemMake) {
//				makeItem(hero, 2);
//			}
//
//			if (cmd.equals("아이템 장착")) {
//				itemEquip = true;
//				if (itemEquip) {
//					equipInven(hero);
//				}
//				continue;
//			}
//
//		}

	}

}