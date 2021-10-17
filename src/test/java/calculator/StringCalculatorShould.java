package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for StringCalculator
 */
class StringCalculatorShould {

    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
        assertEquals(123, stringCalculator.add("123"));
    }

    @Test
    public void string_with_two_numbers_with_comma_delimiter_should_return_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void string_with_two_numbers_with_new_line_delimiter_should_return_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1\n2"));
    }

    @Test
    public void string_with_two_numbers_with_comma_and_new_line_delimiter_should_return_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1,2\n3"));
    }

    @Test
    public void string_with_two_numbers_with_user_specified_delimiter_should_return_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    public void string_with_negative_numbers_should_raise_exception() {
        StringCalculator stringCalculator = new StringCalculator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("-1,2,-3"));
        assertEquals("negatives not allowed: [-1, -3]", exception.getMessage());
    }

    @Test
    public void string_with_number_gt_1k_should_be_ignored() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(5, stringCalculator.add("2,1001,3,3000"));
    }

    @Test
    public void string_with_any_length_delimiter_should_return_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
        assertEquals(6, stringCalculator.add("//[,,,]\n1,,,2,,,3"));
    }

    @Test
    public void string_with_multiple_delimiters_should_return_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void string_with_multiple_delimiters_with_length_gt_1_should_return_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("//[***][%%]\n1***2%%3"));
    }
}
