package com.springboot.helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomPasswordGeneratorTest {
    @Test
    @DisplayName("generateTest")
    public void generate() {
        // given
        int numberOfUpperCaseLetters = 2;
        int numberOfLowerCaseLetters = 5;
        int numberOfNumeric = 2;
        int numberOfSpecialChars = 1;

        String randomPasswordStr = RandomPasswordGenerator.generate(numberOfUpperCaseLetters, numberOfLowerCaseLetters,
                numberOfNumeric, numberOfSpecialChars);

        char[] randomPasswordChar = randomPasswordStr.toCharArray();

        int countOfUpperCaseLetters = 0;
        int countOfLowerCaseLetters = 0;
        int countOfDigits = 0;
        int countOfSpecialChars = 0;

        for (char ch : randomPasswordChar) {
            if (Character.isUpperCase(ch)) {
                countOfUpperCaseLetters++;
            } else if (Character.isLowerCase(ch)) {
                countOfLowerCaseLetters++;
            } else if (Character.isDigit(ch)) {
                countOfDigits++;
            } else {
                countOfSpecialChars++;
            }
        }

        // when
        int expected = numberOfUpperCaseLetters + numberOfLowerCaseLetters + numberOfNumeric + numberOfSpecialChars;
        int actual = randomPasswordStr.length();
        int numberOfActualUpperCaseLetter = countOfUpperCaseLetters;
        int numberOfActualLowerCaseLetters = countOfLowerCaseLetters;
        int numberOfActualNumeric = countOfDigits;
        int numberOfActualSpecialChars = countOfSpecialChars;

        // then
        assertEquals(actual, expected);  // 길이 테스트
        assertEquals(numberOfUpperCaseLetters, numberOfActualUpperCaseLetter);
        assertEquals(numberOfLowerCaseLetters, numberOfActualLowerCaseLetters);
        assertEquals(numberOfNumeric, numberOfActualNumeric);
        assertEquals(numberOfSpecialChars, numberOfActualSpecialChars);
    }
}