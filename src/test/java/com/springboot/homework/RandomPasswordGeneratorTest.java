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
        //given
        int numberOfUpperCaseLetters = 2;
        int numberOfLowerCaseLetters = 5;
        int numberOfNumeric = 2;
        int numberOfSpecialChars = 1;
        int passwordLength = numberOfNumeric + numberOfLowerCaseLetters + numberOfSpecialChars + numberOfUpperCaseLetters;

        //when
        String password = RandomPasswordGenerator.generate(numberOfUpperCaseLetters,
                numberOfLowerCaseLetters,numberOfNumeric,numberOfSpecialChars);
        int actualUpperCaseCount = (int) password.chars()
                .filter( ch -> Character.isUpperCase(ch) ).count();

        int actualLowerCaseCount = (int) password.chars()
                .filter(ch -> Character.isLowerCase(ch)).count();

        int actualNumberCount = (int) password.chars()
                .filter(ch -> Character.isDigit(ch)).count();

        int actualSpecialCount = (int) password.chars()
                .filter(ch -> !Character.isLetterOrDigit(ch)).count();

        //then
        assertEquals(passwordLength, password.length());
        assertEquals(numberOfUpperCaseLetters, actualUpperCaseCount);
        assertEquals(numberOfLowerCaseLetters, actualLowerCaseCount);
        assertEquals(numberOfNumeric, actualNumberCount);
        assertEquals(numberOfSpecialChars, actualSpecialCount);


    }
}
