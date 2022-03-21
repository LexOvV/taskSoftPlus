package local.alexios.tasks;

import java.util.Arrays;

public class Validator {
    public static void validateInteger(int... input) throws IllegalArgumentException {
        if (Arrays.stream(input).anyMatch(i -> i < 0)) {
            throw new IllegalArgumentException("Integer can't be less than zero");
        }
    }
    public static void validatePriceArray(int[] input) throws IllegalArgumentException {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Array of prices is null or empty");
        }
        if (Arrays.stream(input).anyMatch(i -> i < 0)) {
            throw new IllegalArgumentException("Some number in an array is less than zero. Price can't be less than zero");
        }
    }
    public static void validateWhichMoreThanZero(int... input) throws IllegalArgumentException {
        if (Arrays.stream(input).anyMatch(i -> i < 1)) {
            throw new IllegalArgumentException("This integer can't be less than one");
        }
    }
    public static void validateDiscount(int... input) throws IllegalArgumentException {
        if (Arrays.stream(input).anyMatch(i -> i < 1 || i > 99)) {
            throw new IllegalArgumentException("Discount must be from 1 to 99 (%)");
        }
    }
}