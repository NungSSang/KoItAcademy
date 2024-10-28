package com.jave_09_26.util;
import java.util.Scanner;

import com.java_09_26.Controller.CharacterController;
import com.java_09_26.Controller.EnemyController;
import com.java_09_26.Controller.ItemController;
import com.java_09_26.Controller.MapController;
import com.jave_09_26.dto.CharacterDto;
import com.jave_09_26.dto.EnemyDto;

public class App {
	CharacterController hero;
	CharacterDto heroDto = new CharacterDto();
	EnemyController enemy;
	EnemyDto enemyDto;
	ItemController item;	
	MapController map;
	Battle battle;
	public void run() {
		Scanner sc = new Scanner(System.in);
		
		CharacterController charCon = new CharacterController();
		
		System.out.print("캐릭터명은 공백이 불가능 합니다 \n캐릭터의 이름을 입력 해 주세요: ");
		String heroName = sc.next();
		
		charCon.addChar(heroName);
		
		
		System.out.println("캐릭터가 생성되었습니다.");
		hero.printStatus();
		Boolean isBattle = false;
		Boolean isAttack = false;
		Boolean isBattleStarted = false;

		while (true) {
			String cmd = sc.nextLine();
			if (!isBattle && cmd.equals("")) {
				System.out.println("명령어를 입력해 주세요");
				System.out.println(
						"exit: 게임 종료 / next: 게임 진행 / showme: 캐릭터 정보 / attack: 공격 / 엔터누름 : 전투 진행 / item : 아이템 관리");
				continue;
			} else if (cmd.equals("cmd")) {
				System.out.println(
						"cmd: 명령어 확인 / exit: 게임 종료 / next: 게임 진행 / showme: 캐릭터 정보 / attack: 공격 / 엔터누름 : 전투 진행 / item : 아이템 관리 ");
				continue;
			}
			if (cmd.equals("exit")) {
				System.out.println("게임을 종료합니다.");
				break;
			} else if (heroDto.getpHealth() <= 0) {
				System.out.println("게임을 종료합니다.");
				break;
			} else if (cmd.equals("back")) {
				continue;
			} else if (cmd.equals("showme") && isAttack) { // 아군 캐릭터 프로필
				isAttack = false;
				hero.printStatus();
			}
			if (cmd.equals("item")) {
				item.itemController2();

			}
			if (cmd.equals("next") && !isBattle) { // 게임 진행
				isBattle = true;
				isAttack = false;
				hero.useItem();
				System.out.println("battle을 입력하여 전투 진입");
				continue;
			} else if (!isBattleStarted && (cmd.equals("attack") || cmd.equals("skill"))) {
				System.out.println("전투를 시작하지 않았습니다. 전투를 시작합니다.");
				map.playeGame();
				enemy.makeEnemy();
				enemy.printStatus();
				isBattleStarted = true; // 전투 시작 플래그 설정
				continue;
			} else if (isBattle && cmd.equals("battle") && !isBattleStarted) { // 전투 시작
				map.playeGame();
				enemy.makeEnemy();
				enemy.printStatus();
				isBattleStarted = true; // 전투가 시작되었음을 표시
				continue;
			}
			// 기본 공격
			if (isBattle && enemyDto.geteHealth() >= 0 && cmd.equals("attack") && isBattleStarted && !isAttack) {
				isAttack = true;
				battle.playerAttack(); // 기본 공격
				if (enemyDto.geteHealth() <= 0) {
					item.dropItems();
					isAttack = true;
					isBattle = false;
					isBattleStarted = false; // 전투 종료 후 전투 시작 상태 초기화
					continue;
				} // 스킬 공격
			} else if (isBattle && enemyDto.geteHealth() >= 0 && cmd.equals("skill") && isBattleStarted && !isAttack) {
				isAttack = true;
				battle.playerSkillAttack(); // 스킬 공격
				if (enemyDto.geteHealth() <= 0) {
					if (!heroDto.getIsRun()) {
						item.dropItems();
					}
					isAttack = true;
					isBattle = false;
					isBattleStarted = false; // 전투 종료 후 전투 시작 상태 초기화
					continue;
				}
			} else if (isBattle && cmd.equals("") && isAttack) { // 적군 턴
				battle.enemyAttack();
				isAttack = false;
			} else if (isBattle && enemyDto.geteHealth() <= 0 && (cmd.equals("attack") || cmd.equals(""))) {
				isAttack = false;
				System.out.println("의미없는 클릭");
				continue;
			}

		}
	}
}

// 캐릭터 = 스테이지 종료시 선택 아이템 , 적 드랍 아이템 , 장착 가능한 아이템 , 장착된 아이템
// 캐릭터: 공격, 데미지 입음, 사망, 아이템 선택 , 정보출력 // itemBox{}, dropItemBox{},
// mountableItem{}, equippedItem{}
// 적 = attackPatterns{} , enem[] , ehealth[] , eattackPower[]
// 적: 적군 생성 ,적군 공격 패턴 , 패턴중 하나 가져와서 공격 ,적군 데미지 입음 , 사망 , 정보출력
// 아이템 items2 <- 스테이지 종료 아이템
// 아이템 = 적 처치시 아이템 드랍 , 보유 재료 아이템 , 장착할 수 있는 아이템 , 장착된 아이템 출력 , 아이템 제작 , 아이템 소모시
// 캐릭터가 보유중인 재료 아이템 제거 , 나머지 while 문
// 맵 = maps[]

// 명령어를 받는곳
// 명령어를 확인해서 처리를 하는곳
// 처리 하는곳에서 데이터에 접근해야 한다면 데이터를 처리할 수 있는 곳으로 넘겨주는 곳
// 데이터를 처리하는곳
// 데이터
// 가져오거나 저장한 데이터를 넘겨주는 곳
// 넘겨받은 데이터를 처리한 곳으로 넘겨주는 곳
// 데이터를 처리한곳에서 사용
// 명령어를 받는곳


//System.out.printf(
//"cmd : 명령어 확인\nback: 게임으로 돌아가기\n재료아이템 목록: 재료 아이템 목록\n장비아이템 목록: 장착 가능한 아이템 목록\n장착아이템 목록: 장착한 아이템 목록\n아이템 장착:아이템 장착\n아이템 제작: 아이템 제작\n");
//while(true){
//String cmdItem = sc.nextLine();
//if (cmdItem.equals("back")) {
//break;
//} else if (cmdItem.equals("cmd")) {
//System.out.printf(
//	"cmd : 명령어 확인\nback: 게임으로 돌아가기\n재료아이템 목록: 재료 아이템 목록\n장비아이템 목록: 장착 가능한 아이템 목록\n장착아이템 목록: 장착한 아이템 목록\n아이템 장착:아이템 장착\n아이템 제작: 아이템 제작\n");
//} else if (cmdItem.equals("")) {
//System.out.println("명령어를 입력 해 주세요.");
//}
//if (cmdItem.equals("재료아이템 목록")) {
//item.showItem();
//continue;
//} else if (cmdItem.equals("장비아이템 목록")) {
//if (.mountableItem.size() == 0) {
//System.out.println("장비아이템이 없습니다.");
//} else {
//System.out.println(hero.mountableItem);
//}
//
//} else if (cmdItem.equals("장착아이템 목록")) {
//if (hero.equippedItem.size() == 0) {
//System.out.println("장착한 아이템이 없습니다.");
//} else {
//System.out.println(hero.equippedItem);
//}
//}
//
//if (cmdItem.equals("레시피")) {
//System.out.print("아이템을 제작할 수 있습니다.\n마법사의 로브 1개 , 엔트의 사과 1개를 사용해서 마법사의 황금사과를 만들 수 있습니다.\n");
//System.out.println("전사의 몽둥이 1개 , 괴물의 이빨 2개를 사용해서 이빨장식 몽둥이를 만들 수 있습니다.");
//System.out.println("전사의 몽둥이 1개 , 용의 이빨을 사용해서 드래곤 소드를 만들 수 있습니다.");
//System.out.println("만들고 싶은 아이템의 이름을 입력 해 주세요.");
//continue;
//}
//if (cmdItem.equals("아이템 제작")) {
//System.out.printf("마법사의 황금사과\n이빨장식 몽둥이\n드래곤 소드\n");
//System.out.printf("제작할 아이템의 이름을 입력해 주세요: ");
//item.itemMake = true;
//}
//if (cmdItem.equals("마법사의 황금사과") && !item.itemEquip && item.itemMake) {
//item.makeItem(hero, 0);
//} else if (cmdItem.equals("이빨장식 몽둥이") && !item.itemEquip && item.itemMake) {
//item.makeItem(hero, 1);
//} else if (cmdItem.equals("드래곤 소드") && !item.itemEquip && item.itemMake) {
//item.makeItem(hero, 2);
//}
//
//if (cmdItem.equals("아이템 장착")) {
//item.itemEquip = true;
//if (item.itemEquip) {
//item.equipInven(hero);
//}
//continue;
//}
//
//}