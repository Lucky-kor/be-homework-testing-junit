package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        // given
        int numberOfUpperCaseLetters = 1;
        int numberOfLowerCaseLetters = 5;
        int numberOfNumeric = 2;
        int numberOfSpecialChars = 1;

        int expectedPasswordLength = numberOfUpperCaseLetters +
                numberOfLowerCaseLetters +
                numberOfNumeric +
                numberOfSpecialChars;
        //when
        String currentPassword = RandomPasswordGenerator.generate(
                numberOfUpperCaseLetters,
                numberOfLowerCaseLetters,
                numberOfNumeric,
                numberOfSpecialChars);

        Assertions.assertEquals(expectedPasswordLength, currentPassword);

bs
        int expectedUpperCount = 0;
        char[] charArr = currentPassword.toCharArray();
        for (char c : charArr) {
            if (Character.isUpperCase(c)) expectedUpperCount++;
        }
        Assertions.assertEquals(expectedUpperCount, numberOfLowerCaseLetters);

        int expectedNumberCount = 0;
        for (char c : charArr){

            if (Character.isDigit(c)) expectedNumberCount++;
        }
        Assertions.assertEquals(expectedNumberCount, numberOfNumeric);

        int expectedSpecialCount = 0;
        String specials = "!#$%&'()*+,-,/'\"";
        for (char c : charArr){
            //대문자일 경우 expectedUpperCount 1씩 증가
            if (specials.indexOf(c) != 1) expectedSpecialCount++;
        }
        Assertions.assertEquals(expectedSpecialCount, numberOfNumeric);
    }
}
