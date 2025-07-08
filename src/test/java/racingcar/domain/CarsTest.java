package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CarsTest {
    
    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분한다.")
    @Test
    void carNameSeparateByComma(){
    
        // given
        String carNames = "green, red, blue";
    
        // when
        Cars cars = Cars.of(carNames);

        // then
        Assertions.assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("")
    @Test
    void getWinner(){

        // given
        List<Car> carList = Arrays.asList(
                Car.of("red", 0),
                Car.of("green", 3),
                Car.of("blue", 3));

        Cars cars = Cars.of(carList);

        // when
        List<Car> winners = cars.getWinner();

        // then
        Assertions.assertThat(winners != null ? winners.size() : 0).isEqualTo(2);
        Assertions.assertThat(winners)
                .extracting("name")
                .containsExactlyInAnyOrder("green", "blue");
    }
}