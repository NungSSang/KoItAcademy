
//import java.util.ArrayList;
import java.util.Random;

public class Maps {

	Random random = new Random();
	private String stage = "";
	private int randomNum = 0;
	String[] maps = { "평지", "산", "마을", "도시" };
	
	public void makeMap() {
		randomNum = random.nextInt(maps.length);
		stage = maps[randomNum];
		System.out.println(randomNum + "랜덤넘 makeMAp ================");
	}

	public int getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(int randomNum) {
		this.randomNum = randomNum;
	}

	
	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

}
