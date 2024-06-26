package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import com.springboot.helper.StampCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        int numberOfUpperCaseLetters = 2;
        int numberOfLowerCaseLetters = 5;
        int numberOfNumeric = 2;
        int numberOfSpecialChars = 1;

        String password = RandomPasswordGenerator.generate(
                numberOfUpperCaseLetters,
                numberOfLowerCaseLetters,
                numberOfNumeric,
                numberOfSpecialChars
        );

        int expectedUpperCount = 0;
        int expectedLowerCount = 0;
        int expectedNumberCount = 0;
        int expectedSpecialCount = 0;

        String currentPassword = RandomPasswordGenerator.generate(
                numberOfUpperCaseLetters,
                numberOfLowerCaseLetters,
                numberOfNumeric,
                numberOfSpecialChars);
        String specials = "!\"#$%&'()*+, -. /'";
        for (char c : currentPassword.toCharArray()) {
         // 대문자일 경우 expectedUpperCount 1씩 증가
            if (Character.isUpperCase(c)) expectedUpperCount++;
            else if (Character.isLowerCase(c)) expectedLowerCount++;
            else if (Character.isDigit(c)) expectedNumberCount++;
            else if (specials.indexOf(c) != -1) expectedSpecialCount++;


            assertEquals(numberOfUpperCaseLetters, expectedUpperCount);
            assertEquals(numberOfLowerCaseLetters, expectedLowerCount);
            assertEquals(numberOfNumeric, expectedNumberCount);
            assertEquals(numberOfSpecialChars, expectedSpecialCount);

        }
    }}
