import java.util.Random;
import java.util.ArrayList;

public class Enemy {
	private String eName;
	private int eHealth;
	private double eAttackPower;
	private int eBerrior; // 방어력(스테이지마다 증가할것)
	private int eBerriorInt; // 방어상수 ( 캐릭터 초기 설정 변하지 않음)
	private double dmg;
	Random random = new Random();
	public int randomInt;
	Character hero;
	Item item;
	Maps maps = new Maps();
	String[] enem = { "마법사", "전사", "괴물", "엔트", "용" };
	int[] ehealth = { 100, 110, 120, 110, 150 };
	int[] eattackPower = { 10, 10, 10, 20, 30 };
	private ArrayList<String> attackPatterns;
	public Enemy(String eName , Character hero) {
		this.eBerrior = 10;
		this.eBerriorInt = 0;
		this.attackPatterns = new ArrayList<>();
		setAttackPatterns(eName);
		this.hero = hero;
	}

	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}

	public int geteHealth() {
		return eHealth;
	}

	public void seteHealth(int eHealth) {
		this.eHealth = eHealth;
	}

	public double geteAttackPower() {
		return eAttackPower;
	}

	public void seteAttackPower(double eAttackPower) {
		this.eAttackPower = eAttackPower;
	}

	public int geteBerrior() {
		return eBerrior;
	}

	public void seteBerrior(int eBerrior) {
		this.eBerrior = eBerrior;
	}

	public int geteBerriorInt() {
		return eBerriorInt;
	}

	public void seteBerriorInt(int eBerriorInt) {
		this.eBerriorInt = eBerriorInt;
	}

	public double getDmg() {
		return dmg;
	}

	public void setDmg(double dmg) {
		this.dmg = dmg;
	}

	// 적 생성
	public void makeEnemy() {
		randomInt = random.nextInt(enem.length-1);
		if (SceneManager.stageNum % 5 == 0) {
			this.eName = enem[4];
			this.eHealth = ehealth[4];
			this.eAttackPower = eattackPower[4];
		} else {
			this.eName = enem[randomInt];
			this.eHealth = ehealth[randomInt];
			this.eAttackPower = eattackPower[randomInt];
			if (SceneManager.stageNum % 5 == 0) {
				eHealth = eHealth + (SceneManager.stageNum * 10);
			}
		}
	}

	// 적 공격
	public void attack(Character hero) {
		System.out.println("적 공격");
		if (hero.getBerrior(hero)) {
			System.out.println(eName + "의 공격을 방어했습니다.");
			hero.setBerrior(false);
			System.out.println("기본공격 = attack , 스킬 = skill 을 입력하여 공격할 수 있습니다.");
		} else if (!hero.getBerrior(hero) && eHealth >= 0) {
			System.out.println(eName + "이(가) " + eAttackPower + "의 데미지를 줍니다.");
			hero.takeDamage(this);
		} else if (eHealth <= 0) {
			System.out.println("대상이 없습니다.");
		}
	}

	// 적 패턴
	public void setAttackPatterns(String eName) {
		System.out.println("패턴설정");
		switch (eName) {
		case "마법사":
			attackPatterns.add("Fireball");
			attackPatterns.add("Lightning Bolt");
			attackPatterns.add("Magic Shield");
			break;
		case "전사":
			attackPatterns.add("Sword Slash");
			attackPatterns.add("Shield Block");
			attackPatterns.add("Berserk");
			break;
		case "괴물":
			attackPatterns.add("Claw Swipe");
			attackPatterns.add("Roar");
			attackPatterns.add("Tail Whip");
			break;
		case "엔트":
			attackPatterns.add("Root Entangle");
			attackPatterns.add("Branch Smash");
			attackPatterns.add("Healing Sap");
			break;
		case "용":
			attackPatterns.add("Dragon Bress");
			attackPatterns.add("Tail Whip");
			attackPatterns.add("Wing Attack");
			break;
		default:
			attackPatterns.add("Basic Attack");
			break;
		}
	}

	// 적 공격 랜덤으로 하는거
	public void enemyRandomAttack(Character hero) {
		System.out.println("랜덤어택");
		if (hero.getBerrior(hero)) {
			System.out.println(eName + "의 공격을 방어했습니다.");
			hero.setBerrior(false);
			System.out.println("기본공격 = attack , 스킬 = skill 을 입력하여 공격할 수 있습니다.");
		} else {
			int randomPattern = random.nextInt(attackPatterns.size());
			setAttackPatterns(eName);
			System.out.println(eName + "이(가) " + attackPatterns.get(randomPattern) + " 공격을 사용합니다.");
			hero.takeDamage(this);
		}
	}

	// 캐릭터 정보 출력 메소드
	public void printStatus() {
		System.out.printf("적군이 나타났습니다. 이름 %s 체력 %d 공격력 %f \n", eName, eHealth, eAttackPower);
		System.out.println("기본공격 = attack , 스킬 = skill 을 입력하여 공격할 수 있습니다.");
	}

	// 적군의 체력 감소 메소드 (피해를 받았을 때)
	public void takeDamage(Character hero) {
		System.out.println("적 데미지 입는");
		dmg = hero.getpAttackPower() / ((eBerrior + eBerriorInt) / eBerrior);
		eHealth -= dmg;
		if (eHealth <= 0 && !hero.getIsRun()) {
			enemyDie();
		} else if (hero.getIsRun()) {
			if (eName == "용") {
			} else {
				System.out.println("성공적으로 도망쳤습니다!");
				System.out.println("Next를 입력해 진행해주세요.");
			}
//			hero.setIsRun(false);
		} else if (eHealth >= 0 && hero.getpHealth() >= 0) {
			System.out.println(eName + "이(가) " + dmg + "의 피해를 입었습니다." + eHealth + " 의 체력이 남았습니다.");
			System.out.println(eName + "이(가) 공격할 차례 입니다.");
			System.out.println("Enter를 눌러 다음");
		}
	}

	// 적 사망
	public void enemyDie() {
		 if (hero != null) { 
	            System.out.println(eName + "의 체력이 0이 되었습니다. 적군을 쓰러트렸습니다.");
	            System.out.println("next를 입력하여 로비로");
	        } else {
	            System.out.println("Hero 객체가 없습니다.");
	        }
	}



}
