package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        //given : 준비
        int numberOfUpperCaseLetter = 1;
        int numberOfLowerCaseLetter = 6;
        int numberOfNumeric = 3;
        int numberOfSpecialChars = 2;



        //when : 동작, 결과값을 만드는 과정
        String randomPassword = RandomPasswordGenerator.generate(
                numberOfUpperCaseLetter, numberOfLowerCaseLetter, numberOfNumeric, numberOfSpecialChars);

        int actualUpperCaseCount = (int) randomPassword.chars()
                .filter(ch -> Character.isUpperCase(ch))
                .count();

        int actualLowerCaseCount = (int) randomPassword.chars()
                .filter(ch -> Character.isLowerCase(ch))
                .count();

        int actualNumCount = (int) randomPassword.chars()
                .filter(ch -> Character.isDigit(ch))
                .count();

        int actualSpecialCount = (int) randomPassword.chars()
                .filter(ch -> !Character.isLetterOrDigit(ch))
                .count();


        int actualSum = numberOfUpperCaseLetter + numberOfLowerCaseLetter + numberOfNumeric + numberOfSpecialChars;
        int expected = 12;
        //then : 검증

        assertEquals(numberOfUpperCaseLetter, actualUpperCaseCount);
        assertEquals(numberOfLowerCaseLetter, actualLowerCaseCount);
        assertEquals(numberOfNumeric, actualNumCount);
        assertEquals(numberOfSpecialChars, actualSpecialCount);
        assertEquals(expected, actualSum);

    }
}
