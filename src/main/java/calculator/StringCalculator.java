package calculator;

import java.util.ArrayList;
import java.util.List;

class StringCalculator {

    public int add(String input) {
        // If input is blank
        if (input == null || input.trim().length() == 0) {
            return 0;
        }

        String delimiter = "[,\n]";

        if (input.startsWith("//") && input.charAt(3) == '\n') {
            delimiter = String.valueOf(input.charAt(2));
            input = input.substring(4);
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String n : numbers) {
            int number = Integer.parseInt(n);
            if (number < 0) {
                negativeNumbers.add(number);
            }
            if (number > 1000) {
                continue;
            }

            sum += number;
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negativeNumbers);
        }

        return sum;
    }
}