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
        int numberOfUpperCaseLetters = 2;
        int numberOfLowerCaseLetters = 5;
        int numberOfNumeric = 2;
        int numberOfSpecialChars = 1;

        String randomPassword = RandomPasswordGenerator.generate(numberOfUpperCaseLetters, numberOfLowerCaseLetters, numberOfNumeric, numberOfSpecialChars);

        //when
        //- 생성된 패스워드의 길이가 입력한 파라미터 숫자의 합과 일치하는지 검증(Assertion)하세요.
        int actual = randomPassword.length();
        int expected = numberOfUpperCaseLetters + numberOfLowerCaseLetters + numberOfNumeric + numberOfSpecialChars;

        //- 생성된 패스워드의 ‘알파벳 대문자’ 개수가 입력한 파라미터(numberOfUpperCaseLetters ) 숫자와 일치하는지 검증하세요.
        // String 의 stream 은 chars()
        long upperActual = randomPassword.chars().filter(ch -> Character.isUpperCase(ch)).count();

        //- 생성된 패스워드의 ‘알파벳 소문자’ 개수가 입력한 파라미터(`numberOfLowerCaseLetters`) 숫자와 일치하는지 검증하세요.
        long lowerActual = randomPassword.chars().filter(ch -> Character.isLowerCase(ch)).count();

        //- 생성된 패스워드의 ‘0 이상인 숫자’의 개수가 입력한 파라미터(`numberOfNumeric`) 숫자와 일치하는지 검증하세요.
        long numberActual = randomPassword.chars().filter(ch -> Character.isDigit(ch)).count();

        //- 생성된 임시 패스워드의 ‘특수문자’ 개수가 입력한 파라미터(`numberOfSpecialChars`) 숫자와 일치하는지 검증하세요.
        long specialActual = randomPassword.chars().filter(ch -> !Character.isLetterOrDigit(ch)).count();

        //then
        assertEquals(expected, actual, "생성된 패스워드의 길이가 입력한 파라미터 숫자의 합과 일치 하는지");
        assertEquals(numberOfUpperCaseLetters, upperActual, "대문자 합 비교");
        assertEquals(numberOfLowerCaseLetters, lowerActual ,"소문자 합 비교");
        assertEquals(numberOfNumeric, numberActual ,"숫자 합 비교");
        assertEquals(numberOfSpecialChars, specialActual ,"특수문자 합 비교");

        System.out.println("테스트 결과1: " + (expected == actual) + " expected : " + expected + " actual : " + actual);
        System.out.println("테스트 결과2: " + (numberOfUpperCaseLetters == upperActual));
        System.out.println("테스트 결과3: " + (numberOfLowerCaseLetters == lowerActual));
        System.out.println("테스트 결과4: " + (numberOfNumeric == numberActual));
        System.out.println("테스트 결과5: " + (numberOfSpecialChars == specialActual));






    }
}
