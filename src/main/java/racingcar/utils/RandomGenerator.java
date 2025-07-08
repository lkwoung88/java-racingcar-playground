package racingcar.utils;

import java.util.Random;

public class RandomGenerator {

    private static final int BOUND = 10; // 0 to 9 inclusive
    private static final Random random = new Random();

    private RandomGenerator() {
        // Prevent instantiation
    }

    public static int getRandomValueZeroToNine() {
        return random.nextInt(BOUND);
    }
}
