package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperandTest {
    
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "'1:2:3', ',|:'",
            "'//;\n1;2;3', ';'"
    })
    void makeOperand(String input, String expect){
    
        // given

        // when
        Operand operand = Operand.of(input);
        String delimiter = operand.getDelimiter();

        // then
        assertThat(delimiter).isEqualTo(expect);
    }

}