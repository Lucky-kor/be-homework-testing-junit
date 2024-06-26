package com.springboot.homework;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.UpperCase;

import java.util.Locale;

public class RandomPasswordGeneratorTest {

    static int numberOfUpperCaseLetters;
    static int numberOfLowerCaseLetters;
    static int numberOfNumeric;
    static int numberOfSpecialChars;
    static String actualPassword;
    static int expectPasswordLength;

    @BeforeAll
    public static void init() {
        numberOfUpperCaseLetters = 2;
        numberOfLowerCaseLetters = 3;
        numberOfNumeric = 3;
        numberOfSpecialChars = 2;
        actualPassword = RandomPasswordGenerator.generate(numberOfUpperCaseLetters, numberOfLowerCaseLetters,
                numberOfNumeric, numberOfSpecialChars);
        expectPasswordLength = passwordLength(numberOfUpperCaseLetters, numberOfLowerCaseLetters,
                numberOfNumeric, numberOfSpecialChars);
    }


    @DisplayName("실습 1 : 비밀번호 길이 비교")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        Assertions.assertEquals(expectPasswordLength, actualPassword.length());
    }

    @DisplayName("실습 2 : 대문자 갯수 비교 ")
    @Test
    public void generateTest2() {
        // TODO 여기에 테스트 케이스를 작성해주세요.

        int expected = numberOfUpperCaseLetters;

//        Character.isUpperCase(CHAR) - B - char가 대문자가 맞다면 트루 -> actualPassword를 하나하나 돌면서 확인하고 트루면 갯수 +1
        int count = 0;
        if (actualPassword.length() == expectPasswordLength) {
            for (int i = 0; i < actualPassword.length(); i++) {
                if (Character.isUpperCase(actualPassword.charAt(i))) {
                    count++;
                }
            }
        }
        Assertions.assertEquals(expected, count);
    }

    @Test
    @DisplayName("실습 3 : 소문자 갯수 비교")

    public void generateTest3() {
        // TODO 여기에 테스트 케이스를 작성해주세요.

        int expected = numberOfLowerCaseLetters;
        int count = 0;
        if (actualPassword.length() == expectPasswordLength) {
            for (int i = 0; i < actualPassword.length(); i++) {
                if (Character.isLowerCase(actualPassword.charAt(i))) {
                    count++;
                }
            }
        }
        Assertions.assertEquals(expected, count);
    }

    @Test
    @DisplayName("실습 4 : 숫자 개수 비교 ")
    public void generateTest4() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
//        given

        int expected = numberOfNumeric;

        int count = 0;

        if (actualPassword.length() == expectPasswordLength) {
            for (int i = 0; i < actualPassword.length(); i++) {
                if (Character.isDigit(actualPassword.charAt(i))) {
                    count++;
                }
            }
        }
        Assertions.assertEquals(expected, count);
    }

    @Test
    @DisplayName("실습 5 : 특수 문자 비교 ")
    public void generateTest5() {

        int expected = numberOfSpecialChars;
        int count = 0;
        if (actualPassword.length() == expectPasswordLength)
            for (int i = 0; i < actualPassword.length(); i++) {
                if (!Character.isLetterOrDigit(actualPassword.charAt(i))) {
                    count++;
                }
            }
        Assertions.assertEquals(expected, count);
    }

    @Test
    @DisplayName("람다식 이용 대문자 검증")
    public void generateTest2Ver2() {
        long upperCase =
                actualPassword.chars()
                        .filter(Character::isUpperCase)
                        .count();
        Assertions.assertEquals(upperCase, numberOfUpperCaseLetters);
    }

    @Test
    @DisplayName("람다식 이용 소문자 검증")
    public void generateTest2Ver3() {
        long lowerCase =
                actualPassword.chars()
                        .filter(Character::isLowerCase)
                        .count();
        Assertions.assertEquals(lowerCase, numberOfLowerCaseLetters);
    }

    @Test
    @DisplayName("람다식 이용 숫자 검증")
    public void generateTest2Ver4() {
        long numberRic =
                actualPassword.chars()
                        .filter(Character::isDigit)
                        .count();
        Assertions.assertEquals(numberRic, numberOfNumeric);
    }

    @Test
    @DisplayName("람다식 이용 특수문자 검증")
    public void generateTest2Ver5() {
        long specialCase =
                actualPassword.chars()
                        .filter(c -> !Character.isLetterOrDigit(c))
                        .count();

        Assertions.assertEquals(specialCase, numberOfSpecialChars);
    }


    private static int passwordLength(int numberOfUpperCaseLetters, int numberOfLowerCaseLetters,
                                      int numberOfNumeric, int numberOfSpecialChars) {
        int passwordLength = numberOfUpperCaseLetters + numberOfLowerCaseLetters
                + numberOfNumeric + numberOfSpecialChars;
        return passwordLength;
    }

}