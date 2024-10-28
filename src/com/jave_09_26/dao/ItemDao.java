package com.jave_09_26.dao;
import java.util.ArrayList;

import com.java_09_26.container.Container;


public class ItemDao {

//	public ArrayList<Integer> heroItems(){ // 재료아이템 목록
//		return Container.itemBox;
//	}
//	public ArrayList<String> items2(){ // 드랍된 재료 아이템 목록
//		return Container.items2;
//	}
	public ArrayList<String> getHeroDropItemBox(){ // 드랍된 재료 아이템 목록
		return Container.dropItemBox;
	}
	public ArrayList<String> getHeromountableItem(){ // 장착 가능한 아이템 목록
		return Container.mountableItem;
	}
	public ArrayList<String> getHeroequippedItem(){ // 장착한 아이템 목록
		return Container.equippedItem;
	}
	
	public String[] getPotionItems() { // 소비 아이템 선택시
		return Container.items;
	}
	public String[] getDropItem() { // 적이 가지고 있는 아이템
		return Container.dropItem;
	}
	public String[] getMakeItem() { // 제작가능한 아이템
		return Container.makeItem;
	}
	
}
