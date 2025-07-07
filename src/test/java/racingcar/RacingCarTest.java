package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.\n")
    @Test
    void moveForwardIfRandomValueGreaterThanThree(){

        // given
        RacingCar green = RacingCar.of("green");

        // when
        green.move(4);

        // then
        assertAll(
                () -> assertEquals("green", green.getName()),
                () -> assertEquals(1, green.getPosition())
        );
    }

    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.\n")
    @Test
    void canNotMoveIfRandomValueLessThenFour(){

        // given
        RacingCar green = RacingCar.of("green");

        // when
        green.move(3);

        // then
        assertAll(
                () -> assertEquals("green", green.getName()),
                () -> assertEquals(0, green.getPosition())
        );
    }

}