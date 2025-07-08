package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

class RandomGeneratorTest {

    @DisplayName("0에서 9 사이에서 random 값")
    @Test
    void randomValueTest(){

        // given
        Random random = new Random();

        // when
        int randomValue = random.nextInt(10);

        // then
        System.out.println("lessThenTen = " + randomValue);
        Assertions.assertThat(randomValue)
                .isGreaterThan(0)
                .isLessThan(10);
    }
}