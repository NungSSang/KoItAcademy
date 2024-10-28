package com.jave_09_26.util;

import java.util.Random;

public class Util {
	static Random random;
	
	public static int makeRandom(int range) {
		return random.nextInt(range);
	}
}
