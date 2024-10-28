package com.java_09_26.Controller;

import java.util.Scanner;

import com.jave_09_26.dto.CharacterDto;
import com.jave_09_26.dto.EnemyDto;
import com.jave_09_26.dto.ItemDto;
public class CharacterController {
	private CharacterDto heroDto;
	private EnemyDto enemyDto;
	private EnemyController enemy;
	private ItemDto item;
	Scanner sc = new Scanner(System.in);
	
	
	public void printStatus() {
		System.out.printf("이름 %s 체력 %d 공격력 %f 방어력 %d \n", heroDto.getpName(), heroDto.getpHealth(),heroDto.getpAttackPower(),heroDto.getpBerrior());
	}

	// 캐릭터가 공격하는 메소드
	public void attack() {
		if (heroDto.getpHealth() >= 0) {
			System.out.println(heroDto.getpName() + "이(가) " + heroDto.getpAttackPower() + "의 공격력력으로 공격합니다.");
		}
	}

	// 스킬 공격
	public void skillAttack() {
		System.out.println("강공 = 1 , Hp회복 = 2 , 도망치기 = 3 , 방어 = 4");
		String skill = sc.next();
		if (!skill.equals("1") && !skill.equals("2") && !skill.equals("3") && !skill.equals("4")) {
			skillAttack();
		} else if (skill.equals("1")) {
			heroDto.setpAttackPower(heroDto.getpAttackPower()+20); // 스킬 데미지는 공격력 + 20으로 설정되어있음 바꿔야함
			System.out.println(heroDto.getpName() + "(이)가 강한 공격을 합니다.");
			enemy.takeDamage();
			heroDto.setpAttackPower(heroDto.getpAttackPower()-20);// 스킬 데미지는 공격력 + 20으로 설정되어있는거 다시 원복
		} else if (skill.equals("2")) {
			heroDto.setpHealth(heroDto.getpHealth()+20);
			System.out.println("캐릭터의 HP가 20만큼 회복되었습니다.");
		} else if (skill.equals("3")) {
			if (enemyDto.geteName() == "용") {
				System.out.println("보스 스테이지에선 도망칠 수 없습니다.");
				skillAttack();
			} else {
				enemyDto.seteHealth(0); // 적의 체력을 0으로 설정
				System.out.println("도망을 쳤습니다.");
				heroDto.setIsRun(true);
				enemy.takeDamage();
			}
		} else if (skill.equals("4")) {
			heroDto.setberrior(true);
		}
	}

	// 체력 감소 메소드 (피해를 받았을 때)
	public void takeDamage() {
		heroDto.setDmg(enemyDto.geteAttackPower() / ((heroDto.getpBerrior() + heroDto.getpBerriorInt()) / heroDto.getpBerrior()));
		heroDto.setpHealth(heroDto.getpHealth()-heroDto.getDmg());
		if (heroDto.getpHealth() <= 0) {
			System.out.println("캐릭터의 Hp가 0이되어 게임을 종료합니다.");
		} else if (heroDto.getpHealth() >= 0 && enemyDto.geteHealth() >= 0) {
			System.out.println(heroDto.getpName() + "이(가) " + enemyDto.geteAttackPower() + "의 피해를 입었습니다." + heroDto.getpHealth() + " 의 체력이 남았습니다.");
			System.out.println("내가 공격할 차례 입니다.");
			System.out.println("기본공격 = attack , 스킬 = skill 을 입력하여 공격할 수 있습니다.");
		}
	}

	// 아이템 선택
	public void useItem() {
		if (heroDto.getIsRun()) {
			System.out.println("도망쳤기 때문에 아이템을 획득할 수 없습니다.");
			heroDto.setIsRun(false);
		} else {
//			System.out.println(items.items2);
			System.out.println("HP = 1 , attack = 2 , berrior = 3");
			System.out.println("다음 스테이지로 넘어가기 전 아이템을 선택 해 주세요.");
//			String item = sc.next();
			if (!item.equals("1") && !item.equals("2") && !item.equals("3")) {
				useItem();
			} else if (item.equals("1")) {
				heroDto.setpHealth(heroDto.getpHealth() + item.getHpPlus()); 
				System.out.println(heroDto.getpName() + "의 체력이" + item.getHpPlus() + "만큼 증가하였습니다.");
//				itemBox.add(item.getHpPlus());
			} else if (item.equals("2")) {
				heroDto.setpAttackPower(heroDto.getpAttackPower() + item.getAttackPlus());
				System.out.println(heroDto.getpName() + "의 공격력이" + item.getAttackPlus() + "만큼 증가하였습니다.");
//				itemBox.add(items.getHpPlus());

			} else if (item.equals("3")) {
				heroDto.setpBerrior(heroDto.getpBerrior() + item.getBerrior());
				System.out.println(heroDto.getpName() + "의 방어력이" + item.getBerrior() + "만큼 증가하였습니다.");
//				itemBox.add(items.getHpPlus());
			}
		}
	}

	public void addChar(String heroName) {
		heroDto.setpName(heroName);
	}
}
