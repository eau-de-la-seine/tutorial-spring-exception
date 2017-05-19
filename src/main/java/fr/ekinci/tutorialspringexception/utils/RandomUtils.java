package fr.ekinci.tutorialspringexception.utils;

import java.util.Random;

/**
 * @author Gokan EKINCI
 */
public class RandomUtils {

	public static int between(int a, int b) {
		final Random r = new Random();
		return r.nextInt(b - a + 1) + a;
	}
}
