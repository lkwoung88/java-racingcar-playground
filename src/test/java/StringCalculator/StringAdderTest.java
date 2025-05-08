package StringCalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StringAdderTest {

    private static StringAdder stringAdder;

    @BeforeAll
    public static void setUp() {
        stringAdder = new StringAdder();
    }

    @DisplayName("숫자가 하나일 경우 해당 숫자만 반환한다.")
    @Test
    void spiltByDelimiterWithOneNumber(){

        // given
        String input = "1";

        // when
        List<Integer> integers = stringAdder.splitByDelimiter("1", ",|:");

        // then
        assertThat(integers).hasSize(1)
                .containsExactly(1);
    }

    @DisplayName("구분자 (,) 또는 (:)을 기준으로 각 숫자를 분리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    void splitByDelimiter(String input){

        // given

        // when
        List<Integer> numbers = stringAdder.splitByDelimiter(input, ",|:");

        // then
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @DisplayName("빈문자열, null 들어가면 0을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {""})
    @NullSource
    void spiltByDelimiterWithNullOrEmptyString (String input){

        // given

        // when
        List<Integer> numbers = stringAdder.splitByDelimiter(input, ",|:");

        // then
        assertThat(numbers).containsExactly(0);
    }

    @DisplayName("숫자 이외의 값이 들어온 경우 RuntimeException을 발생시킨다.")
    @Test
    void splitByDelimiterWithNotNumber(){

        // given
        String input = "a:1:2";

        // when, then
        assertThatThrownBy(() -> stringAdder.splitByDelimiter(input, ",|:")).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("음수의 값이 들어온 경우 RuntimeException을 발생시킨다.")
    @Test
    void splitByDelimiterWithNegativeNumber(){

        // given
        String input = "-1:1:2";

        // when, then
        assertThatThrownBy(() -> stringAdder.splitByDelimiter(input, ",|:")).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("리스트의 요소를 모두 덧셈한다.")
    @Test
    void addAllNumbers(){

        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        // when
        int result = stringAdder.addAll(numbers);

        // then
        assertThat(result).isEqualTo(6);
    }
}