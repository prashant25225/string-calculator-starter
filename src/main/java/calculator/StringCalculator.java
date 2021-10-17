package calculator;

class StringCalculator {

    public int add(String input) {
        // If input is blank
        if (input == null || input.trim().equals("")) {
            return 0;
        }

        // If input contains only single number
        if (!input.contains(",")) {
            return Integer.parseInt(input);
        }

        return 0;
    }

}