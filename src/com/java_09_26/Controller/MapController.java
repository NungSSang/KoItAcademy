package com.java_09_26.Controller;

import com.jave_09_26.dto.MapDto;
public class MapController {

	private MapDto mapDto;
	
	public void makeMap() {
	mapDto.setStage(null);
	//stage = maps[randomNum];
	}
	public void gameStart() {
		System.out.println("게임을 시작하겠습니다.");
	}

	public void playeGame() {
		if (mapDto.getStageNum() % 2 == 0) {
			makeMap();
		}
		System.out.println("=============" + (mapDto.getStageNum() + 1) + " 스테이지 " + mapDto.getStage() + "지형 =============");
		mapDto.setStageNum(mapDto.getStageNum()+1);
	}
}
