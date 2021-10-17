package calculator;

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
        for (String n : numbers) {
            sum += Integer.parseInt(n);
        }

        return sum;
    }
}