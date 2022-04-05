package com.app.hpx.springbootcucumbermain.util;

import java.security.SecureRandom;
import java.util.Random;

public class RandomIntegerBasedUuidGenerator {
		
		private static final Integer DEFAULT_LENGTH = 6;
		
		private static final Integer DEFAULT_MIN = 1;
		private static final Integer DEFAULT_MAX = 999999;
		
		private static final Random RANDOM = new SecureRandom();
		
		public static int generateRandomIntegerUuidDefault(){
				return generateRandomIntegerUuid(DEFAULT_MIN, DEFAULT_MAX);
		}
		
		public static int generateRandomIntegerUuidRanged(int min, int max) {
				return generateRandomIntegerUuid(min, max);
		}
		
		private static int generateRandomIntegerUuid(int min, int max) {
				return RANDOM.nextInt(max - min) + min;
		}
}
