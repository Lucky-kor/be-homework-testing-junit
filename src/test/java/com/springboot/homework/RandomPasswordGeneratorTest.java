package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        // given
        int numberOfUpperCaseLetters = 2;
        int numberOfLowerCaseLetters = 5;
        int numberOfNumeric = 2;
        int numberOfSpecialChars = 1;

        int expectedPasswordLength = numberOfUpperCaseLetters + numberOfLowerCaseLetters + numberOfNumeric + numberOfSpecialChars;

        // when
        String randomPassword = RandomPasswordGenerator
                                .generate(numberOfUpperCaseLetters,
                                          numberOfLowerCaseLetters,
                                          numberOfNumeric,
                                          numberOfSpecialChars);

        // then

        // 조건1
        assertEquals(expectedPasswordLength, randomPassword.length());

        // 조건2
        long expectedUpperCaseLetters = randomPassword.chars()
                .filter(c -> Character.isUpperCase((char) c))
                .count();

        assertEquals(expectedUpperCaseLetters, numberOfUpperCaseLetters);

        // 조건3
        long expectedLowerCaseLetters = randomPassword.chars()
                .filter(c -> Character.isLowerCase((char) c))
                .count();

        assertEquals(expectedLowerCaseLetters, numberOfLowerCaseLetters);

        // 조건 4
        long expectedNumeric = randomPassword.chars()
                .filter(c -> Character.isDigit((char) c))
                .count();

        assertEquals(expectedNumeric, numberOfNumeric);

        // 조건 5
        // 특수문자 : "[!@#$%^&*(),.?\":{}|<>]"
        // isLetterOrDigit : 문자 혹은 숫자인지 여부를 판단하여 true/false로 리턴
        long expectedSpecialChars = randomPassword.chars()
//                .filter(c -> "[!@#$%^&*(),.?\":{}|<>]".indexOf((char) c) >= 0)
                .filter((c -> !Character.isLetterOrDigit((char) c)))
                .count();

        assertEquals(expectedSpecialChars, numberOfSpecialChars);
    }
}
