package com.springboot.helper;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RandomPasswordGeneratorTest {
    @DisplayName(" 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // 임의이 숫자를 지정
        int numberOfUpperCaseLetters = 1;
        int numberOfLowerCaseLetters = 1;
        int numberOfNumeric = 1;
        int numberOfSpecialChars = 1;

        int expectedPassword = numberOfUpperCaseLetters + numberOfLowerCaseLetters + numberOfNumeric + numberOfSpecialChars;
        // 랜덤 패스워드 생성
        String password = RandomPasswordGenerator.generate
                (numberOfUpperCaseLetters, numberOfLowerCaseLetters, numberOfNumeric, numberOfSpecialChars);

        // 길이 검증 하기
        assertEquals(expectedPassword, password.length());

        // [각각의 문자가 몇개인지 검증하기]
        // 대문자
        long countUpperCaseLetters = password.chars().filter(Character::isUpperCase).count();
        // 소문자
        long countLowerCaseLetters = password.chars().filter(Character::isLowerCase).count();
        // 숫자
        long countNumeric = password.chars().filter(Character::isDigit).count();
        // 특수문자 (숫자, 대문자, 소문자를 제외한 나머지)
        long countSpecialChars = password.length() - countUpperCaseLetters - countLowerCaseLetters - countNumeric;

        assertEquals(numberOfUpperCaseLetters, countUpperCaseLetters); // 대문자
        assertEquals(numberOfLowerCaseLetters, countLowerCaseLetters); // 소문자
        assertEquals(numberOfNumeric, countNumeric);                   // 숫자
        assertEquals(numberOfSpecialChars, countSpecialChars);         // 특수문자
    }
}