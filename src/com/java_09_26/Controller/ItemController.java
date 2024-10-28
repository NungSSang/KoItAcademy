package com.java_09_26.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.jave_09_26.dto.EnemyDto;
import com.jave_09_26.dto.ItemDto;
import com.jave_09_26.service.ItemService;

public class ItemController {
	ItemService itemService;
	EnemyDto enemyDto;
	ItemDto itemDto;
	Scanner sc = new Scanner(System.in);
	public void dropItems() {
		if (enemyDto.geteName().equals("마법사")) {
			System.out.println(itemService.getHeroDropItemBox().get(0));
			itemService.getHeroDropItemBox().add(itemService.getDropItem()[0]);
		} else if (enemyDto.geteName().equals("전사")) {
			System.out.println(itemService.getHeroDropItemBox().get(1));
			itemService.getHeroDropItemBox().add(itemService.getDropItem()[1]);
		} else if (enemyDto.geteName().equals("엔트")) {
			System.out.println(itemService.getHeroDropItemBox().get(2));
			itemService.getHeroDropItemBox().add(itemService.getDropItem()[2]);
		} else if (enemyDto.geteName().equals("괴물")) {
			System.out.println(itemService.getHeroDropItemBox().get(3));
			itemService.getHeroDropItemBox().add(itemService.getDropItem()[3]);
		} else if (enemyDto.geteName().equals("용")) {
			System.out.println(itemService.getHeroDropItemBox().get(4));
			itemService.getHeroDropItemBox().add(itemService.getDropItem()[4]);
		} else {
			System.out.println("드롭된 아이템이 없습니다.");
		}
	}

	public void showItem() {
		System.out.printf("마법사의 로브 %d개 \n", Collections.frequency(itemService.getHeroDropItemBox(), "마법사의 로브"));
		System.out.printf("전사의 몽둥이 %d개 \n", Collections.frequency(itemService.getHeroDropItemBox(), "전사의 몽둥이"));
		System.out.printf("괴물의 이빨 %d개 \n", Collections.frequency(itemService.getHeroDropItemBox(), "괴물의 이빨"));
		System.out.printf("엔트의 사과 %d개 \n", Collections.frequency(itemService.getHeroDropItemBox(), "엔트의 사과"));
		System.out.printf("용의 심장 %d개 \n", Collections.frequency(itemService.getHeroDropItemBox(), "용의 심장"));
	}

	public void makeItem(int i) {
		if (i == 0) {
			if (Collections.frequency(itemService.getHeroDropItemBox(), "마법사의 로브") == 0
					|| Collections.frequency(itemService.getHeroDropItemBox(), "엔트의 사과") == 0) {
				System.out.println("재료 아이템이 부족합니다.");
			} else {
				removeSpecificOccurrences(itemService.getHeroDropItemBox(), "마법사의 로브", 1);
				removeSpecificOccurrences(itemService.getHeroDropItemBox(), "엔트의 사과", 1);
				System.out.println(itemService.getMakeItem()[0]);
				System.out.printf("마법사의 황금사과 아이템을 성공적으로 제작하였습니다.\n마법사의 로브를 1개 잃었습니다.\n엔트의 사과를 1개 잃었습니다.\n");
				itemService.getHeromountableItem().add(itemService.getMakeItem()[0]);
			}
		} else if (i == 1) {
			if (Collections.frequency(itemService.getHeroDropItemBox(), "전사의 몽둥이") == 0
					|| Collections.frequency(itemService.getHeroDropItemBox(), "괴물의 이빨") < 2) {
				System.out.println("재료 아이템이 부족합니다.");
			} else {
				removeSpecificOccurrences(itemService.getHeroDropItemBox(), "전사의 몽둥이", 1);
				removeSpecificOccurrences(itemService.getHeroDropItemBox(), "괴물의 이빨", 2);
				System.out.println(itemService.getMakeItem()[1]);
				System.out.printf("이빨장식 몽둥이 아이템을 성공적으로 제작하였습니다.\n전사의 몽둥이를 1개 잃었습니다.\n괴물의 이빨을 2개 잃었습니다.\n");
				itemService.getHeromountableItem().add(itemService.getMakeItem()[1]);
			}
		} else if (i == 2) {
			if (Collections.frequency(itemService.getHeroDropItemBox(), "전사의 몽둥이") == 0
					|| Collections.frequency(itemService.getHeroDropItemBox(), "용의 심장") == 0) {
				System.out.println("재료 아이템이 부족합니다.");
			} else {
				removeSpecificOccurrences(itemService.getHeroDropItemBox(), "전사의 몽둥이", 1);
				removeSpecificOccurrences(itemService.getHeroDropItemBox(), "용의 심장", 1);
				System.out.println(itemService.getMakeItem()[1]);
				System.out.printf("드래곤 소드 아이템을 성공적으로 제작하였습니다.\n전사의 몽둥이를 1개 잃었습니다.\n용의 심장을 1개 잃었습니다.\n");
				itemService.getHeromountableItem().add(itemService.getMakeItem()[2]);
			}
		}
		itemDto.setItemMake(false);
	}

	public void equipInven() { // 장착할 수 있는 아이템이 있는지 체크하고 장비를 장착하는 메서드
		if (itemService.getHeromountableItem().size() == 0) {
			System.out.println("장착할 수 있는 아이템이 없습니다.");
		} else {
			System.out.println("나의 아이템 " + itemService.getHeromountableItem());
			System.out.printf("장착할 아이템의 이름을 입력 해 주세요: ");
			String cmd = sc.nextLine();
			if (cmd.equals("마법사의 황금사과")) {
				for (int i = 0; i < itemService.getHeromountableItem().size(); i++) {
					if (itemService.getHeromountableItem().get(i) == "마법사의 황금사과") {
						itemService.getHeromountableItem().remove(i);
						System.out.println("마법사의 황금사과 아이템을 장착했습니다.");
						itemService.getHeroequippedItem().add("마법사의 황금사과");
					} else {
						System.out.println("아이템을 가지고 있지 않습니다.");
					}
				}
			} else if (cmd.equals("이빨장식 몽둥이")) {
				for (int i = 0; i < itemService.getHeromountableItem().size(); i++) {
					if (itemService.getHeromountableItem().get(i) == "이빨장식 몽둥이") {
						itemService.getHeromountableItem().remove(i);
						System.out.println("이빨장식 몽둥이 아이템을 장착했습니다.");
						itemService.getHeroequippedItem().add("이빨장식 몽둥이");
					} else {
						System.out.println("아이템을 가지고 있지 않습니다.");
					}
				}
			} else if (cmd.equals("드래곤 소드")) {
				for (int i = 0; i < itemService.getHeromountableItem().size(); i++) {
					if (itemService.getHeromountableItem().get(i) == "드래곤 소드") {
						itemService.getHeromountableItem().remove(i);
						System.out.println("드래곤 소드 아이템을 장착했습니다.");
						itemService.getHeroequippedItem().add("드래곤 소드");
					} else {
						System.out.println("아이템을 가지고 있지 않습니다.");
					}
				}
			}
		}
		itemDto.setItemEquip(false);
	}

	private void removeSpecificOccurrences(ArrayList<String> dropItemBox, String itemName, int count) {
		int removedCount = 0;
		// ArrayList를 반복하면서 요소 제거
		for (int i = 0; i < itemService.getHeroDropItemBox().size(); i++) {
			if (itemService.getHeroDropItemBox().get(i).equals(itemName)) {
				itemService.getHeroDropItemBox().remove(i);
				removedCount++;
				i--; // remove 후 인덱스 조정
				if (removedCount == count) {
					break; // 지정된 개수만큼 제거하면 중단
				}
			}
		}
	}

	public void itemController2() {
		System.out.printf(
				"cmd : 명령어 확인\nback: 게임으로 돌아가기\n재료아이템 목록: 재료 아이템 목록\n장비아이템 목록: 장착 가능한 아이템 목록\n장착아이템 목록: 장착한 아이템 목록\n아이템 장착:아이템 장착\n아이템 제작: 아이템 제작\n");
		while (true) {

			String cmd = sc.nextLine();
			if (cmd.equals("back")) {
				break;
			} else if (cmd.equals("cmd")) {
				System.out.printf(
						"cmd : 명령어 확인\nback: 게임으로 돌아가기\n재료아이템 목록: 재료 아이템 목록\n장비아이템 목록: 장착 가능한 아이템 목록\n장착아이템 목록: 장착한 아이템 목록\n아이템 장착:아이템 장착\n아이템 제작: 아이템 제작\n");
			} else if (cmd.equals("")) {
				System.out.println("명령어를 입력 해 주세요.");
			}
			if (cmd.equals("재료아이템 목록")) {
				showItem();
				continue;
			} else if (cmd.equals("장비아이템 목록")) {
				if (itemService.getHeromountableItem().size() == 0) {
					System.out.println("장비아이템이 없습니다.");
				} else {
					System.out.println(itemService.getHeromountableItem());
				}

			} else if (cmd.equals("장착아이템 목록")) {
				if (itemService.getHeroequippedItem().size() == 0) {
					System.out.println("장착한 아이템이 없습니다.");
				} else {
					System.out.println(itemService.getHeroequippedItem());
				}
			}

			if (cmd.equals("레시피")) {
				System.out.print("아이템을 제작할 수 있습니다.\n마법사의 로브 1개 , 엔트의 사과 1개를 사용해서 마법사의 황금사과를 만들 수 있습니다.\n");
				System.out.println("전사의 몽둥이 1개 , 괴물의 이빨 2개를 사용해서 이빨장식 몽둥이를 만들 수 있습니다.");
				System.out.println("전사의 몽둥이 1개 , 용의 이빨을 사용해서 드래곤 소드를 만들 수 있습니다.");
				System.out.println("만들고 싶은 아이템의 이름을 입력 해 주세요.");
				continue;
			}
			if (cmd.equals("아이템 제작")) {
				System.out.printf("마법사의 황금사과\n이빨장식 몽둥이\n드래곤 소드\n");
				System.out.printf("제작할 아이템의 이름을 입력해 주세요: ");
				itemDto.setItemMake(true);
			}
			if (cmd.equals("마법사의 황금사과") && !itemDto.getItemEquip() && itemDto.getItemMake()) {
				makeItem(0);
			} else if (cmd.equals("이빨장식 몽둥이") && !itemDto.getItemEquip() && itemDto.getItemMake()) {
				makeItem(1);
			} else if (cmd.equals("드래곤 소드") && !itemDto.getItemEquip() && itemDto.getItemMake()) {
				makeItem(2);
			}

			if (cmd.equals("아이템 장착")) {
				itemDto.setItemEquip(true);
				if (itemDto.getItemEquip()) {
					equipInven();
				}
				continue;
			}

		}
	}
}
