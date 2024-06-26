package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(value = MethodOrderer.DisplayName.class)
public class RandomPasswordGeneratorTest {

    static String generate;
    static int numberOfUpperCaseLetters;
    static int numberOfLowerCaseLetters;
    static int numberOfNumeric;
    static int numberOfSpecialChars;

    @BeforeAll
    public static void init() {
        numberOfUpperCaseLetters = 2;
        numberOfLowerCaseLetters = 5;
        numberOfNumeric = 2;
        numberOfSpecialChars = 1;
        generate = RandomPasswordGenerator
                .generate(numberOfUpperCaseLetters, numberOfLowerCaseLetters, numberOfNumeric, numberOfSpecialChars);
    }

    @DisplayName("실습 1: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest_1() {
        assertEquals(generate.length(), 10);
    }

    @DisplayName("실습 2: 랜덤 패스워드 생성 테스트 - 대문자")
    @Test
    public void generateTest_2() {

        //given
        int upperCount = 0;
        for (int i = 0; i < generate.length(); i++) {
            if (generate.charAt(i) >= 65 && generate.charAt(i) <= 90) {
                upperCount++;
            }
        }
        // when

        // then
        assertEquals(upperCount, numberOfUpperCaseLetters);
    }

    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트 - 소문자")
    @Test
    public void generateTest_3() {

        //given
        long lowerCount = generate.chars()
                .filter(x -> Character.isLowerCase((char) x))
                .count();
        // when

        // then
        assertEquals(lowerCount, numberOfLowerCaseLetters);
    }

    @DisplayName("실습 4: 랜덤 패스워드 생성 테스트 - 숫자")
    @Test
    public void generateTest_4() {

        //given
        long numberCount = generate.chars()
                .filter(x -> Character.isDigit((char) x))
                .count();
        // when

        // then
        assertEquals(numberCount, numberOfNumeric);
    }

    @DisplayName("실습 5: 랜덤 패스워드 생성 테스트 - 특수문자")
    @Test
    public void generateTest_5() {

        //given
        long upperCount = generate.chars()
                .filter(x -> Character.isUpperCase((char) x))
                .count();
        long lowerCount = generate.chars()
                .filter(x -> Character.isLowerCase((char) x))
                .count();
        long numberCount = generate.chars()
                .filter(x -> Character.isDigit((char) x))
                .count();
        long specialCharsCount = generate.length() - upperCount - lowerCount - numberCount;
        // when

        // then
        assertEquals(specialCharsCount, numberOfSpecialChars);

    }
}