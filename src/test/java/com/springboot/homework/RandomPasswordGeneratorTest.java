package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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


        // when
        String randomPassWord = RandomPasswordGenerator.generate(numberOfUpperCaseLetters
                ,numberOfLowerCaseLetters,numberOfNumeric,numberOfSpecialChars);
        long totalLength = randomPassWord.length();

        long upperCaseCount = randomPassWord.chars().filter(ch -> Character.isUpperCase(ch)).count();

        long lowerCaseCount = randomPassWord.chars().filter(ch -> Character.isLowerCase(ch)).count();

        long numericCount = randomPassWord.chars().filter(ch -> Character.isDigit(ch)).count();

        long specialCharsCount = randomPassWord.chars().filter(ch -> !Character.isLetterOrDigit(ch)).count();

        // then
        assertNotNull(randomPassWord, "비번은 Null이면 안됨");

        assertEquals(totalLength, randomPassWord.length(), "패스워드 길이가 예상이랑 다른뎀");

        assertEquals(numberOfUpperCaseLetters, upperCaseCount, "대문자 개수가 일치하지 않습니다.");

        assertEquals(numberOfLowerCaseLetters, lowerCaseCount, "소문자 개수가 일치하지 않습니다.");

        assertEquals(numberOfNumeric, numericCount, "0이상의 숫자 개수가 일치하지 않습니다.");

        assertEquals(numberOfSpecialChars, specialCharsCount, "특수문자 개수가 일치하지 않습니다.");
    }
}
