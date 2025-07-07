package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    private static RacingGame racingGame;

    @BeforeAll
    static void prepare() {
        Input input = new Input();
        View view = new View();
        racingGame = new RacingGame(input, view);
    }


    @DisplayName("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    @Test
    void getRacingCarsBy() {
        // given
        String carNames = "green, red, blue";

        // when
        RacingCars cars = racingGame.getRacingCarsBy(carNames, ",");

        // then
        assertThat(cars.getRacingCars()).hasSize(3);
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void carNameCanNotOverFiveLetters(){
        // given
        String carNames = "green, red, blue, rainbow";

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> racingGame.getRacingCarsBy(carNames, ","));
    }
}