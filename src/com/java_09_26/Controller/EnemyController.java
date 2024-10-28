package com.java_09_26.Controller;

import com.jave_09_26.dto.CharacterDto;
import com.jave_09_26.dto.EnemyDto;
import com.jave_09_26.dto.MapDto;
import com.jave_09_26.service.EnemyService;
import com.jave_09_26.util.Util;

public class EnemyController {
	EnemyDto enemyDto;
	CharacterDto heroDto;
	CharacterController hero;
	EnemyService enemyService;
	MapDto mapDto;
	
	
	public EnemyController(String eName, int eHealth , int eAttackPower) {
		
	}

	
	// 적 생성
	public void makeEnemy() {
		enemyDto.randomInt = Util.makeRandom(enemyService.getEnem().length-1);
		if (mapDto.getStageNum() % 5 == 0) {
			enemyDto.seteName(enemyService.getEnem()[0]); 
			enemyDto.seteHealth(enemyService.getEhealth()[0]);
			enemyDto.seteAttackPower(enemyService.getEattackPower()[0]);

		} else {
			enemyDto.seteName(enemyService.getEnem()[enemyDto.randomInt]);
			enemyDto.seteHealth(enemyService.getEhealth()[enemyDto.randomInt]);
			enemyDto.seteAttackPower(enemyService.getEattackPower()[enemyDto.randomInt]);
			if (mapDto.getStageNum() % 5 == 0) {
				enemyDto.seteHealth(enemyDto.geteHealth() + (mapDto.getStageNum() * 10));// = eHealth + (SceneManager.stageNum * 10);
			}
		}
	}

	// 적 공격
	public void attack() {
		if (heroDto.getberrior()) {
			System.out.println(enemyDto.geteName() + "의 공격을 방어했습니다.");
			heroDto.setberrior(false);
			System.out.println("기본공격 = attack , 스킬 = skill 을 입력하여 공격할 수 있습니다.");
		} else if (!heroDto.getberrior() && enemyDto.geteHealth() >= 0) {
			System.out.println(enemyDto.geteName() + "이(가) " + enemyDto.geteAttackPower() + "의 데미지를 줍니다.");
			hero.takeDamage();
		} else if (enemyDto.geteHealth() <= 0) {
			System.out.println("대상이 없습니다.");
		}
	}

	// 적 패턴
	public void setAttackPatterns(String eName) {
		switch (enemyDto.geteName()) {
		case "마법사":
			enemyService.getAttackPattern().add("Fireball");
			enemyService.getAttackPattern().add("Lightning Bolt");
			enemyService.getAttackPattern().add("Magic Shield");
			break;
		case "전사":
			enemyService.getAttackPattern().add("Sword Slash");
			enemyService.getAttackPattern().add("Shield Block");
			enemyService.getAttackPattern().add("Berserk");
			break;
		case "괴물":
			enemyService.getAttackPattern().add("Claw Swipe");
			enemyService.getAttackPattern().add("Roar");
			enemyService.getAttackPattern().add("Tail Whip");
			break;
		case "엔트":
			enemyService.getAttackPattern().add("Root Entangle");
			enemyService.getAttackPattern().add("Branch Smash");
			enemyService.getAttackPattern().add("Healing Sap");
			break;
		case "용":
			enemyService.getAttackPattern().add("Dragon Bress");
			enemyService.getAttackPattern().add("Tail Whip");
			enemyService.getAttackPattern().add("Wing Attack");
			break;
		default:
			enemyService.getAttackPattern().add("Basic Attack");
			break;
		}
	}

	// 적 공격 랜덤으로 하는거
	public void enemyRandomAttack() {
		if (heroDto.getberrior()) {
			System.out.println(enemyDto.geteName() + "의 공격을 방어했습니다.");
			heroDto.setberrior(false);
			System.out.println("기본공격 = attack , 스킬 = skill 을 입력하여 공격할 수 있습니다.");
		} else {
			int randomPattern = Util.makeRandom(enemyService.getAttackPattern().size());
			setAttackPatterns(enemyDto.geteName());
			System.out.println(enemyDto.geteName() + "이(가) " + enemyService.getAttackPattern().get(randomPattern) + " 공격을 사용합니다.");
			hero.takeDamage();
		}
	}

	// 캐릭터 정보 출력 메소드
	public void printStatus() {
		System.out.printf("적군이 나타났습니다. 이름 %s 체력 %d 공격력 %f \n", enemyDto.geteName(), enemyDto.geteHealth(),enemyDto.geteAttackPower());
		System.out.println("기본공격 = attack , 스킬 = skill 을 입력하여 공격할 수 있습니다.");
	}

	// 적군의 체력 감소 메소드 (피해를 받았을 때)
	public void takeDamage() {
		enemyDto.setDmg(  heroDto.getpAttackPower() / ((enemyDto.geteBerrior() + enemyDto.geteBerriorInt()) / enemyDto.geteBerrior()));
		enemyDto.seteHealth(enemyDto.geteHealth()-enemyDto.getDmg());
		if (enemyDto.geteHealth() <= 0 && !heroDto.getIsRun()) {
			enemyDie();
		} else if (heroDto.getIsRun()) {
			if (enemyDto.geteName() == "용") {
			} else {
				System.out.println("성공적으로 도망쳤습니다!");
				System.out.println("다음 전투: next / 아이템 보기: item");
				heroDto.setIsRun(true);
			}
		} else if (enemyDto.geteHealth() >= 0 && heroDto.getpHealth() >= 0) {
			System.out.println(enemyDto.geteName() + "이(가) " + enemyDto.getDmg() + "의 피해를 입었습니다." + enemyDto.geteHealth() + " 의 체력이 남았습니다.");
			System.out.println(enemyDto.geteName() + "이(가) 공격할 차례 입니다.");
			System.out.println("Enter를 눌러 다음");
		}
	}

	// 적 사망
	public void enemyDie() {
		if (hero != null) {
			System.out.println(enemyDto.geteHealth() + "의 체력이 0이 되었습니다. 적군을 쓰러트렸습니다.");
			System.out.println("next를 입력하여 로비로");
		} else {
			System.out.println("Hero 객체가 없습니다.");
		}
	}
}
