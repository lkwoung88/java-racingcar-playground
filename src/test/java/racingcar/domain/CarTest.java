package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void carNameShouldNotExceedFiveCharacters() {
        // given
        String name = "ferrari";

        // when
        // then
        Assertions.assertThatThrownBy(() ->  Car.of(name)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Name cannot be longer than five characters");
    }

    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    @ParameterizedTest
    @CsvSource(value = {
            "3,0",
            "4,1",
            "9,1",
            "0,0"
    })
    void carMoveWhenValueGreaterThen3(int randomValue, int expectedPosition) {
        // given
        Car car = Car.of("benz");

        // when
        int position = car.move(randomValue);

        // then
        Assertions.assertThat(position).isEqualTo(expectedPosition);
    }
}
