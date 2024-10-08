import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String heroName;
		System.out.println("캐릭터의 이름을 입력 해 주세요.");
		heroName = sc.next();
		System.out.println("exit: 게임 종료 / next: 게임 진행 / showme: 캐릭터 정보 / attack: 공격 / 엔터누름 : 전투 진행 ");
		Character hero = new Character(heroName);
		Enemy enemy = new Enemy("",hero);
		Item item = new Item();
//		Maps maps = new Maps();
		Battle battle = new Battle(hero, enemy);
		System.out.println("캐릭터가 생성되었습니다.");
		SceneManager scene = new SceneManager();
		hero.printStatus();
		Boolean isBattle = false;
		Boolean isAttack = false;
		Boolean isBattleStarted = false;
		while (true) {
			String cmd = sc.nextLine();
			if (!isBattle && cmd.equals("")) {
				System.out.println("명령어를 입력해 주세요");
				continue;
			}
			if (cmd.equals("exit")) {
				System.out.println("게임을 종료합니다.");
				break;
			} else if (hero.getpHealth() <= 0) {
				System.out.println("게임을 종료합니다.");
				break;
			} else if (cmd.equals("back")) {
				continue;
//			} else if (SceneManager.stageNum > 2) {
//				text.finish();
//				break;
			} else if (cmd.equals("showme") && isAttack) { // 아군 캐릭터 프로필
				isAttack = false;
				hero.printStatus();
			}
			if (cmd.equals("item")) {
				hero.showDropItems();
			}
			
			if (cmd.equals("next") && !isBattle) { // 게임 진행
				isBattle = true;
				isAttack = false;
				hero.useItem();
				System.out.println("battle을 입력하여 전투 진입");
				continue;
			} else if (!isBattleStarted && (cmd.equals("attack") || cmd.equals("skill"))) {
				System.out.println("전투를 시작하지 않았습니다. 전투를 시작합니다.");
				scene.playeGame();
				enemy.makeEnemy();
				enemy.printStatus();
				isBattleStarted = true; // 전투 시작 플래그 설정
				continue;
			} else if (isBattle && cmd.equals("battle") && !isBattleStarted) { // 전투 시작
				scene.playeGame();
				enemy.makeEnemy();
				enemy.printStatus();
				isBattleStarted = true; // 전투가 시작되었음을 표시
				continue;
			}
			// 기본 공격
			if (isBattle && enemy.geteHealth() >= 0 && cmd.equals("attack") && isBattleStarted && !isAttack) {
				isAttack = true;
				battle.playerAttack(enemy); // 기본 공격
				if (enemy.geteHealth() <= 0) {
					item.dropItems(hero,enemy);
					isAttack = true;
					isBattle = false;
					isBattleStarted = false; // 전투 종료 후 전투 시작 상태 초기화
					continue;
				} // 스킬 공격
			} else if (isBattle && enemy.geteHealth() >= 0 && cmd.equals("skill") && isBattleStarted && !isAttack) {
				isAttack = true;
				battle.playerSkillAttack(enemy); // 스킬 공격
				if (enemy.geteHealth() <= 0) {
					item.dropItems(hero,enemy);
					isAttack = true;
					isBattle = false;
					isBattleStarted = false; // 전투 종료 후 전투 시작 상태 초기화
					continue;
				}
			} else if (isBattle && cmd.equals("") && isAttack) { // 적군 턴
				System.out.println("적군턴");
				System.out.println(isBattle);
				battle.enemyAttack(enemy);
				isAttack = false;
			} else if (isBattle && enemy.geteHealth() <= 0 && (cmd.equals("attack") || cmd.equals(""))) {
				isAttack = false;
				System.out.println("의미없는 클릭");
				continue;
			}

		}

	}
}
