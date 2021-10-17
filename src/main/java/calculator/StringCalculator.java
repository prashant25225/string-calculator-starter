package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * StringCalculator class
 * Performs calculations on string
 */
class StringCalculator {

    /**
     * Performs the addition of numbers specified in the string separated by delimiter
     *
     * @param input String with numbers and delimiter
     * @return Addition of number
     */
    public int add(String input) {
        // If input is blank
        if (input == null || input.trim().length() == 0) {
            return 0;
        }

        String delimiter = "";

        if (input.startsWith("//")) {
            if (input.charAt(3) == '\n') {
                delimiter = String.valueOf(input.charAt(2));
            }

            if (input.charAt(2) == '[') {
                String delimiterString = input.substring(0, input.indexOf("\n"));

                Pattern p = Pattern.compile("\\[(.*?)]");
                Matcher m = p.matcher(delimiterString);

                Set<String> delimiters = new HashSet<>();
                while (m.find()) {
                    delimiters.add("\\Q" + m.group(1) + "\\E");
                }

                delimiter = String.join("|", delimiters);
            }

            input = input.substring(input.indexOf("\n") + 1);
        } else {
            delimiter = "[,\n]";
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