package com.springboot.helper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomPasswordGeneratorTest {
    static int numberOfUpperCaseLetters;
    static int numberOfLowerCaseLetters;
    static int numberOfNumeric;
    static int numberOfSpecialChars;
    static int expectedPasswordLength;
    static String currentPassword;

    @BeforeAll
    public static void init() {
        numberOfUpperCaseLetters = 2;
        numberOfLowerCaseLetters = 5;
        numberOfNumeric = 2;
        numberOfSpecialChars = 1;
        expectedPasswordLength =
            numberOfUpperCaseLetters+
                    numberOfLowerCaseLetters+
                    numberOfNumeric+
                    numberOfSpecialChars;
        currentPassword = RandomPasswordGenerator.generate(
                numberOfUpperCaseLetters,
                numberOfLowerCaseLetters,
                numberOfNumeric,
                numberOfSpecialChars);
    }
    @Test
    @DisplayName("생성된 패스워드의 길이가 입력한 파라미터 숫자의 합과 일치하는지 검증")
    public void expectedPasswordLengthTest() {
        Assertions.assertEquals(expectedPasswordLength, currentPassword.length());
    }
    @Test
    @DisplayName("생성된 패스워드의 대문자 개수가 입력한 파라미터의 대문자 개수와 일치하는지 검증")
    public void numberOfUpperCaseLettersTest(){
        long expectedUpperCaseLetters = currentPassword.chars()
                .filter(c -> Character.isUpperCase(c))
                .count();
        Assertions.assertEquals(expectedUpperCaseLetters,numberOfUpperCaseLetters);

    }
    @Test
    @DisplayName("생성된 패스워드의 소문자 개수가 입력한 파라미터의 소문자 개수와 일치하는지 검증")
    public void numberOfLowerCaseLettersTest() {
        long expectedLowerCaseLetters = currentPassword.chars()
                .filter(c -> Character.isLowerCase(c))
                .count();
        Assertions.assertEquals(expectedLowerCaseLetters,numberOfLowerCaseLetters);

    }
    @Test
    @DisplayName("생성된 패스워드의 숫자 개수가 입력한 파라미터의 숫자 개수와 일치하는지 검증")
    public void numberOfNumericTest() {
        long expectedNumeric = currentPassword.chars()
                .filter(c -> Character.isDigit(c))
                .count();
        Assertions.assertEquals(expectedNumeric,numberOfNumeric);

    }
    @Test
    @DisplayName("생성된 패스워드의 특수문자 개수가 입력한 파라미터의 특수문자 개수와 일치하는지 검증")
    public void numberOfSpecialCharsTest() {
        long expectedSpecialChars = currentPassword.chars()
                .filter(c -> !Character.isLetterOrDigit(c))
                .count();
        long expectedSpecialChars2 = currentPassword.chars()
                .filter(this::isValidSpecial)
                .count();
        Assertions.assertEquals(expectedSpecialChars,numberOfSpecialChars);
        Assertions.assertEquals(expectedSpecialChars2,numberOfSpecialChars);
    }
    private boolean isValidSpecial(int c) {
        return c >= 33 && c <= 47;
    }
}