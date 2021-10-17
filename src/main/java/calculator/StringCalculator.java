package calculator;

class StringCalculator {

    public int add(String input) {
        // If input is blank
        if (input == null || input.trim().equals("")) {
            return 0;
        }

        String[] numbers = input.split(",");
        int sum = 0;
        for (String n : numbers) {
            sum += Integer.parseInt(n);
        }

        return sum;
    }

}