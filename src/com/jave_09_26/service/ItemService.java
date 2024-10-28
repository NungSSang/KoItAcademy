package com.jave_09_26.service;
import java.util.ArrayList;

import com.java_09_26.container.Container;
import com.jave_09_26.dao.ItemDao;
public class ItemService {
	ItemDao itemDao;
	
	public ArrayList<String> getHeroDropItemBox(){ // 드랍된 재료 아이템 목록
		return itemDao.getHeroDropItemBox();
	}
	public ArrayList<String> getHeromountableItem(){ // 장착 가능한 아이템 목록
		return itemDao.getHeromountableItem();
	}
	public ArrayList<String> getHeroequippedItem(){ // 장착한 아이템 목록
		return itemDao.getHeroequippedItem();
	}
	
	public String[] getPotionItems() { // 소비 아이템 선택시
		return itemDao.getPotionItems();
	}
	public String[] getDropItem() { // 적이 가지고 있는 아이템
		return itemDao.getDropItem();
	}
	public String[] getMakeItem() { // 제작가능한 아이템
		return itemDao.getMakeItem();
	}
}
