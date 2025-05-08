package StringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operand {
    public static final String DEFAULT_DELIMITER = ",|:";
    String delimiter;
    String input;

    private Operand(String delimiter, String input) {
        this.delimiter = delimiter;
        this.input = input;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getInput() {
        return input;
    }

    public static Operand of(String input) {
        String delimiter = DEFAULT_DELIMITER;
        String inputString = input;

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(1);
            inputString = matcher.group(2);
        }

        return new OperandBuilder()
                .delimiter(delimiter)
                .input(inputString)
                .build();
    }

    public static class OperandBuilder{
        private String delimiter;
        private String input;

        public OperandBuilder delimiter(String delimiter) {
            this.delimiter = delimiter;
            return this;
        }

        public OperandBuilder input(String input) {
            this.input = input;
            return this;
        }

        public Operand build() {
            return new Operand(delimiter, input);
        }
    }
}
