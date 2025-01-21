package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        // given + when 중 대문자 개수, 소문자 개수, 0이상 숫자 개수, 특수문자 개수
        int expectedNumberOfUpperCaseLetters = 2;
        int expectedNumberOfLowerCaseLetters = 5;
        int expectedNumberOfNumeric = 2;
        int expectedNumberOfSpecialChars = 1;
        String randomPassword = RandomPasswordGenerator.generate(2, 5, 2, 1);

        // when
            // 패스워드의 길이가 입력한 파라미터 숫자의 합과 일치하는지
        int actualLength = randomPassword.length();
        int expectedLength = expectedNumberOfUpperCaseLetters + expectedNumberOfLowerCaseLetters + expectedNumberOfNumeric + expectedNumberOfSpecialChars;
            // 대문자 개수
        int actualNumberOfUpperCaseLetters = (int)randomPassword.chars().filter(ch -> Character.isUpperCase(ch)).count();
            // 소문자 개수
        int actualNumberOfLowerCaseLetters = (int)randomPassword.chars().filter(ch -> Character.isLowerCase(ch)).count();
            // 0 이상의 숫자 개수
        int actualNumberOfNumeric = (int)randomPassword.chars().filter(ch -> Character.isDigit(ch)).count();
            // 특수문자의 개수
        int actualNumberOfSpecialChars = (int)randomPassword.chars().filter(ch -> !Character.isLetterOrDigit(ch)).count();




        // then
            // 길이와 파라미터 숫자의 합
        assertEquals(expectedLength, actualLength);
            // 대문자 개수 비교
        assertEquals(expectedNumberOfUpperCaseLetters, actualNumberOfUpperCaseLetters);
            // 소문자 개수 비교
        assertEquals(expectedNumberOfLowerCaseLetters, actualNumberOfLowerCaseLetters);
            // 0 이상의 숫자 개수 비교
        assertEquals(expectedNumberOfNumeric, actualNumberOfNumeric);
            // 특수문자 개수 비교
        assertEquals(expectedNumberOfSpecialChars, actualNumberOfSpecialChars);


    }
}
