package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3-1: 랜덤 패스워드 길이 확인")
    @Test
    public void generateTest1() {
        // 3-1. 패스워드 길이 = 파라미터 숫자의 합.
//        given 준비
        String passWord = RandomPasswordGenerator.generate(1, 2, 3, 4);
        int numberOfUpperCaseLetters = 1;
        int numberOfLowerCaseLetter = 2;
        int numberOfNumber = 3;
        int numberOfSpecialChars = 4;
//        when 실행
        int totalExpect = 10;
        int totalActual = RandomPasswordGenerator.generate(numberOfUpperCaseLetters, numberOfLowerCaseLetter, numberOfNumber, numberOfSpecialChars).length();

//        then 검증
        assertEquals(totalExpect, totalActual);

    }
    @DisplayName("실습 3-2: 알파벳 대문자 개수 확인")
    @Test
    public void generateTest2() {
        // 3-2 알파벳 대문자 개수가 입력한 파라미터 숫자와 일치하는가
//        given 준비
        String password = RandomPasswordGenerator.generate(1,2,3,4);
        int numberOfUpperCaseLetters = 1;
        int numberOfLowerCaseLetter = 2;
        int numberOfNumber = 3;
        int numberOfSpecialChars = 4;

//        when 실행
        int expectUpperCaseLetters = 1;
        int actualUpperCase = (int)password.chars().filter(e-> Character.isUpperCase(e))
                .count();

//        then 검증
        assertEquals(expectUpperCaseLetters, actualUpperCase);
    }
    @DisplayName("실습 3-3: 알파벳 소문자 개수 확인")
    @Test
    public void generateTest3() {
//        소문자
//        given
        String password = RandomPasswordGenerator.generate(1,2,3,4);
        int numberOfUpperCaseLetters = 1;
        int numberOfLowerCaseLetter = 2;
        int numberOfNumber = 3;
        int numberOfSpecialChars = 4;
//        when
        int actualLowerCase = (int)password.chars().filter(i-> Character.isLowerCase(i))
                .count();
        int expectedLowerCase = 2;
//        then
        assertEquals(expectedLowerCase, actualLowerCase);
    }
    @DisplayName("실습 3-4: 숫자의 개수 확인")
    @Test
    public void generateTest4() {
//        소문자
//        given
        String password = RandomPasswordGenerator.generate(1,2,3,4);
        int numberOfUpperCaseLetters = 1;
        int numberOfLowerCaseLetter = 2;
        int numberOfNumber = 3;
        int numberOfSpecialChars = 4;
//        when
        int actualNumberCase = (int)password.chars().filter(i->Character.isDigit(i))
                .count();
        int expectedNumberCase = 3;
//        then
        assertEquals(expectedNumberCase, actualNumberCase);
    }
    @DisplayName("실습 3-5: 특수문자의 개수")
    @Test
    public void generateTest5() {
//        소문자
//        given
        String password = RandomPasswordGenerator.generate(1,2,3,4);
        int numberOfUpperCaseLetters = 1;
        int numberOfLowerCaseLetter = 2;
        int numberOfNumber = 3;
        int numberOfSpecialChars = 4;
//        when
        int actualNumberCase = (int)password.chars().filter(i->!Character.isLetterOrDigit(i))
                .count();
        int expectedNumberCase = 4;
//        then
        assertEquals(expectedNumberCase, actualNumberCase);
    }


}
