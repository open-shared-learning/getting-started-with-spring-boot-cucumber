package com.app.hpx.springbootcucumbermain.util;

import java.security.SecureRandom;
import java.util.Random;

public class RandomPlainTextKeyGenerator {
		
		private static final Integer DEFAULT_LENGTH = 16;
		private static final String SEQUENCE =
				"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ#@+=-";
		
		private static final Random RANDOM = new SecureRandom();
		
		public static String getString() {
				return generateRandomPlainTextKey(DEFAULT_LENGTH);
		}
		
		public static String getString(int length) {
				return generateRandomPlainTextKey(length);
		}
		
		private static String generateRandomPlainTextKey(int length) {
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < length; i++) {
						
						builder.append(SEQUENCE.charAt(RANDOM.nextInt(SEQUENCE.length())));
				}
				return builder.toString();
		}
}
