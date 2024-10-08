
public class SceneManager {
	public static int stageNum = 0;
	Maps maps = new Maps();
	public SceneManager() {
		System.out.println("게임을 시작하겠습니다.");
	}

	public void playeGame() {
		if (stageNum % 2 == 0) {
			maps.makeMap();
		}
		System.out.println("=======" + (stageNum + 1) + " 스테이지 " + maps.getStage() + "지형 =======");
		stageNum++;
	}
	public int getStageNum() {
		return stageNum;
	}

}
