package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    @BeforeAll
    public static void generateTest() {

        int numberOfUpperCaseLetters = 3;
        int numberOfLowerCaseLetters = 2;
        int numberOfNumeric = 2;
        int numberOfSpecialChars = 1;

        int expectedPasswordLength = numberOfUpperCaseLetters + numberOfLowerCaseLetters +
                numberOfNumeric +
                numberOfSpecialChars;

        int expectedUpperCount = 0;
        int expectedLowerCount = 0;
        int expectedNumberCount = 0;
        int expectedSpecialCharCount = 0;

        String actualPassword = RandomPasswordGenerator.generate(
                        numberOfUpperCaseLetters,
                        numberOfLowerCaseLetters,
                        numberOfNumeric,
                        numberOfSpecialChars);

        // 생성된 패스워드의 길이가 입력한 파라미터 숫자의 합과 일치하는지 검증(Assertion)하세요.
        Assertions.assertEquals(expectedPasswordLength, actualPassword.length());
        // 생성된 패스워드의 ‘알파벳 대문자’ 개수가 입력한 파라미터(`numberOfUpperCaseLetters` ) 숫자와 일치하는지 검증하세요.
        Assertions.assertEquals(actualPassword.chars().filter(Character:: isUpperCase).count(), numberOfUpperCaseLetters);
        // 생성된 패스워드의 ‘알파벳 소문자’ 개수가 입력한 파라미터(`numberOfLowerCaseLetters`) 숫자와 일치하는지 검증하세요.
        Assertions.assertEquals(actualPassword.chars().filter(Character:: isLowerCase).count(), numberOfLowerCaseLetters);
        // 생성된 패스워드의 ‘0 이상인 숫자’의 개수가 입력한 파라미터(`numberOfNumeric`) 숫자와 일치하는지 검증하세요.
        Assertions.assertEquals(actualPassword.chars().filter(Character:: isDigit).count(), numberOfNumeric);
        // 생성된 임시 패스워드의 ‘특수문자’ 개수가 입력한 파라미터(`numberOfSpecialChars`) 숫자와 일치하는지 검증하세요..

    }
}
