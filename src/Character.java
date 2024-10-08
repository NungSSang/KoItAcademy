import java.util.ArrayList;
import java.util.Scanner;

public class Character {
	private String pName;
	private int pHealth;
	private double pAttackPower;
	private int pBerrior; // 방어력(스테이지마다 증가할것)
	private int pBerriorInt; // 방어상수 ( 캐릭터 초기 설정 변하지 않음)
	private double pDmg;
	private Boolean Berrior = false;
	private Boolean isRun = false;
	Enemy enemy;
	Maps maps;
	Item item;
	Scanner sc = new Scanner(System.in);

	ArrayList<Integer> itemBox = new ArrayList<>();
	ArrayList<String> dropItemBox = new ArrayList<>();

	// 생성자: 캐릭터가 생성될 때 기본 속성 설정
	public Character(String pName) {
		this.pName = pName;
		this.pHealth = 100;
		this.pAttackPower = 40;
		this.pBerrior = 100;
		this.pBerriorInt = 100;
		this.item = new Item();
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpHealth() {
		return pHealth;
	}

	public void setpHealth(int pHealth) {
		this.pHealth = pHealth;
	}

	public double getpAttackPower() {
		return pAttackPower;
	}

	public void setpAttackPower(double pAttackPower) {
		this.pAttackPower = pAttackPower;
	}

	public int getpBerrior() {
		return pBerrior;
	}

	public void setpBerrior(int pBerrior) {
		this.pBerrior = pBerrior;
	}

	public int getpBerriorInt() {
		return pBerriorInt;
	}

	public void setpBerriorInt(int pBerriorInt) {
		this.pBerriorInt = pBerriorInt;
	}

	public double getDmg() {
		return pDmg;
	}

	public void setDmg(double dmg) {
		this.pDmg = dmg;
	}

	public Boolean getIsRun() {
		return isRun;
	}

	public void setIsRun(Boolean isRun) {
		this.isRun = isRun;
	}

	public Boolean getBerrior(Character hero) {
		return Berrior;
	}

	public void setBerrior(Boolean berrior) {
		Berrior = berrior;
	}

	// 캐릭터 정보 출력 메소드
	public void printStatus() {
		System.out.printf("이름 %s 체력 %d 공격력 %f 방어력 %d \n", pName, pHealth, pAttackPower, pBerrior);
	}

	// 캐릭터가 공격하는 메소드
	public void attack() {
		if (pHealth >= 0) {
			System.out.println(pName + "이(가) " + pAttackPower + "의 공격력력으로 공격합니다.");
		}
	}

	// 스킬 공격
	public void skillAttack(Enemy enemy) {
		System.out.println("강공 = 1 , Hp회복 = 2 , 도망치기 = 3 , 방어 = 4");
		String skill = sc.next();
		if (!skill.equals("1") && !skill.equals("2") && !skill.equals("3") && !skill.equals("4")) {
			skillAttack(enemy);
		} else if (skill.equals("1")) {
			pAttackPower = pAttackPower + 20; // 스킬 데미지는 공격력 + 20으로 설정되어있음 바꿔야함
			System.out.println(pName + "(이)가 강한 공격을 합니다.");
			enemy.takeDamage(this);
			pAttackPower = pAttackPower - 20;// 스킬 데미지는 공격력 + 20으로 설정되어있는거 다시 원복
		} else if (skill.equals("2")) {
			pHealth += 20;
			System.out.println("캐릭터의 HP가 20만큼 회복되었습니다.");
		} else if (skill.equals("3")) {
			if (enemy.geteName() == "용") {
				System.out.println("보스 스테이지에선 도망칠 수 없습니다.");
				skillAttack(enemy);
			} else {
				enemy.seteHealth(0); // 적의 체력을 0으로 설정
				System.out.println("도망을 쳤습니다.");
				isRun = true;
				enemy.takeDamage(this);
			}
		} else if (skill.equals("4")) {
			Berrior = true;
		}
	}

	// 체력 감소 메소드 (피해를 받았을 때)
	public void takeDamage(Enemy enemy) {
		pDmg = enemy.geteAttackPower() / ((pBerrior + pBerriorInt) / pBerrior);
		pHealth -= pDmg;
		if (pHealth <= 0) {
			System.out.println("캐릭터의 Hp가 0이되어 게임을 종료합니다.");
		} else if (pHealth >= 0 && enemy.geteHealth() >= 0) {
			System.out.println(pName + "이(가) " + enemy.geteAttackPower() + "의 피해를 입었습니다." + pHealth + " 의 체력이 남았습니다.");
			System.out.println("내가 공격할 차례 입니다.");
			System.out.println("기본공격 = attack , 스킬 = skill 을 입력하여 공격할 수 있습니다.");
		}
	}

	// 아이템 선택
	public void useItem() {
		if (isRun) {
			System.out.println("도망쳤기 때문에 아이템을 획득할 수 없습니다.");
			isRun = true;
		} else {
			Item items = new Item();
			System.out.println(items.items2);
			System.out.println("HP = 1 , attack = 2 , berrior = 3");
			System.out.println("다음 스테이지로 넘어가기 전 아이템을 선택 해 주세요.");
			String item = sc.next();
			if (!item.equals("1") && !item.equals("2") && !item.equals("3")) {
				useItem();
			} else if (item.equals("1")) {
				pHealth += items.getHpPlus();
				System.out.println(pName + "의 체력이" + items.getHpPlus() + "만큼 증가하였습니다.");
				itemBox.add(items.getHpPlus());
			} else if (item.equals("2")) {
				pAttackPower += items.getAttackPlus();
				System.out.println(pName + "의 공격력이" + items.getAttackPlus() + "만큼 증가하였습니다.");
				itemBox.add(items.getHpPlus());

			} else if (item.equals("3")) {
				pBerrior += items.getBerrior();
				System.out.println(pName + "의 방어력이" + items.getBerrior() + "만큼 증가하였습니다.");
				itemBox.add(items.getHpPlus());
			}
		}
	}

	public void addDropItems() {
		item.dropItems(this,enemy);
	}
	public void showDropItems() {
		System.out.println(dropItemBox);
	}
}
