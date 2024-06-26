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
        int numberOfUpperCaseLetters = 2;
        int numberOfLowerCaseLetters = 5;
        int numberOfNumeric = 2;
        int numberOfSpecialChars = 1;

        //int passwordLength = 10;

        int passwordLength = numberOfUpperCaseLetters +
                numberOfLowerCaseLetters +
                numberOfNumeric +
                numberOfSpecialChars;


        // when
        String str = RandomPasswordGenerator.generate(
                numberOfUpperCaseLetters, numberOfLowerCaseLetters,
                numberOfNumeric, numberOfSpecialChars);


        //        int numberOfUpperCaseLettersCount = 0;
//        int numberOfLowerCaseLettersCount = 0;
//        int numberOfNumericCount = 0;
//        int numberOfSpecialCharsCount = 0;
//
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (Character.isUpperCase(c)) {
//                numberOfUpperCaseLettersCount++;
//            }
//            if (Character.isLowerCase(c)) {
//                numberOfLowerCaseLettersCount++;
//            }
//            if (Character.isDigit(c)) {
//                numberOfNumericCount++;
//            }
//            if (!Character.isLetterOrDigit(c)) {
//                numberOfSpecialCharsCount++;
//            }
//        }
//
//        long numberOfUpperCaseLettersCount = str.chars()
//                .filter(c -> Character.isUpperCase(c))
//                .count();
//
//        long numberOfLowerCaseLettersCount = str.chars()
//                .filter(c -> Character.isLowerCase(c))
//                .count();
//
//        long numberOfNumericCount = str.chars()
//                .filter(c -> Character.isDigit(c))
//                .count();
//
//        long numberOfSpecialCharsCount = str.chars()
//                .filter(c -> !Character.isLetterOrDigit(c))
//                .count();


        long numberOfUpperCaseLettersCount = str.chars()
                .filter(Character::isUpperCase)
                .count();
        long numberOfLowerCaseLettersCount = str.chars()
                .filter(Character::isLowerCase)
                .count();
        long numberOfNumericCount = str.chars()
                .filter(Character::isDigit)
                .count();
        long numberOfSpecialCharsCount = str.chars()
                .filter(c -> !Character.isLetterOrDigit(c))
                .count();


        // then
        Assertions.assertEquals(passwordLength, str.length());
        Assertions.assertEquals(numberOfUpperCaseLetters, numberOfUpperCaseLettersCount);
        Assertions.assertEquals(numberOfLowerCaseLetters, numberOfLowerCaseLettersCount);
        Assertions.assertEquals(numberOfNumeric, numberOfNumericCount);
        Assertions.assertEquals(numberOfSpecialChars, numberOfSpecialCharsCount);

    }
}
