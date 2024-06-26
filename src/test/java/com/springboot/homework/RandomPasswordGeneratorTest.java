package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        //n given
        int numberOfUpperCaseLetters = 3;
        int numberOfLowerCaseLetters = 7;
        int numberOfNumeric = 3;
        int numberOfSpecialChars = 2;

        int expectedPasswordLength = numberOfLowerCaseLetters +
                numberOfUpperCaseLetters +
                numberOfNumeric +
                numberOfSpecialChars;

        //n when
        String currentPassword = RandomPasswordGenerator.generate(
                numberOfUpperCaseLetters,
                numberOfLowerCaseLetters,
                numberOfNumeric,
                numberOfSpecialChars
        );

        //TODO 생성된 패스워드의 길이가 입력한 파라미터 숫자의 합과 일치하는지 검증
        //n then
        Assertions.assertEquals(expectedPasswordLength, currentPassword.length());

        //TODO 생성된 패스워드의 '알파벳 대문자' 개수가 입력한 파라미터(numberOfUpperCaseLetter) 숫자와 일치하는지 검증하세요.
        int expectedUpperCount = 0;
        char[] charArr = currentPassword.toCharArray();
        for(int i = 0; i < charArr.length; i++) {
            //N 대문자일 경우 expectedUpperCount 1씩 증가
            if(Character.isUpperCase(c)) expectedUpperCount++;
        }
        Assertions.assertEquals( expectedUpperCount, numberOfUpperCaseLetters);

        //TODO 생성된 패스워드의 '알파벳 소문자' 개수가 입력한 파라미터(numberOfLowerCaseLetter) 숫자와 일치하는지 검증하세요.
        int expectedLowerCount = 0;
        for (char c : charArr) {
            if(Character.isLowerCase(c)) expectedLowerCount++;
        }
        Assertions.assertEquals(expectedLowerCount, numberOfLowerCaseLetters);

        //TODO 생성된 패스워드의 '0 이상인 숫자' 개수가 입력한 파라미터(numberOfNumeric) 숫자와 일치하는지 검증하세요.
        int expectedNumberCount = 0;
        for (char c : charArr) {
            if(Character.isDigit(c)) expectedNumberCount++;
        }
        //TODO 생성된 패스워드의 '특수문자' 개수가 입력한 파라미터(numberOfSpecialChars) 숫자와 일치하는지 검증하세요.
        int expectedSpecialCount = 0;
        String specials = "!\"#$%&'()*+,-./'";
        for (char c : charArr) {
            //n 대문자일 경우 expectedUpperCount 1씩 증가
            if(specials.indexOf(c) != -1) expectedSpecialCount++;
        }
        Assertions.assertEquals(expectedSpecialCount, numberOfSpecialChars);
    }
}
