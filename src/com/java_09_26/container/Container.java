package com.java_09_26.container;

import java.util.ArrayList;

public class Container {
	// 캐릭터
	
	//적군
	public static String[] enem = { "마법사", "전사", "괴물", "엔트", "용" };
	public static int[] ehealth = { 100, 110, 120, 110, 150 };
	public static int[] eattackPower = { 10, 10, 10, 20, 30 };
	public static ArrayList<String> attackPatterns;
	
	//맵
	public static String[] maps = { "평지", "산", "마을", "도시" };
	
	//아이템
	public static String[] items = { "hpPlus", "attackPlus", "berrior" };
	public static String[] dropItem = { "마법사의 로브", "전사의 몽둥이", "엔트의 사과", "괴물의 이빨", "용의 심장" };
	public static String[] makeItem = { "마법사의 황금사과", "이빨장식 몽둥이", "드래곤 소드" };
	public static ArrayList<String> items2;

	public static ArrayList<Integer> itemBox;
	public static ArrayList<String> dropItemBox;
	public static ArrayList<String> mountableItem;
	public static ArrayList<String> equippedItem;
}
