package StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAdder {

    public List<Integer> splitByDelimiter(String input, String delimiters) throws RuntimeException {

        if (isZeroInput(input)) {
            return Arrays.asList(0);
        }

        String[] numbers = input.split(delimiters);

        List<Integer> numberList = new ArrayList<>();

        try{
            numberList = Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .toList();
        }catch (NumberFormatException e) {
            throw new RuntimeException("Invalid input: " + input, e);
        }

        numberList.stream()
                .filter(number -> number < 0)
                .findAny()
                .ifPresent( number -> {
                    throw new RuntimeException();
                });

        return numberList;
    }

    private boolean isZeroInput(String input) {
        return input == null || "".equals(input);
    }

    public int addAll(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}