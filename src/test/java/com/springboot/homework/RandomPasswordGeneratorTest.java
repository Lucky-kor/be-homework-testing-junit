package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomPasswordGeneratorTest {
    private static String randomPassword;
    private static int numberOfUpperCaseLetters;
    private static int numberOfLowerCaseLetters;
    private static int numberOfNumeric;
    private static int numberOfSpecialChars;

    @BeforeAll
    public static void init(){
        numberOfUpperCaseLetters =3;
        numberOfLowerCaseLetters= 4;
        numberOfNumeric= 8;
        numberOfSpecialChars= 9;
        randomPassword = RandomPasswordGenerator.generate(numberOfUpperCaseLetters, numberOfLowerCaseLetters,
                numberOfNumeric, numberOfSpecialChars);
    }


    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        int actualLength = numberOfUpperCaseLetters + numberOfLowerCaseLetters
                + numberOfNumeric + numberOfSpecialChars;
        int expectedLength = randomPassword.length();

        //then
        Assertions.assertEquals(expectedLength, actualLength);
    }

    @DisplayName("대문자 개수 일치 테스트")
    @Test
    public void upperCountTest(){
        long actualUpperCount = 0;
//        for(char c : randomPassword.toCharArray()){
//            if(Character.isUpperCase(c)){
//                actualUpperCount++;
//            }
//        }
        actualUpperCount = randomPassword.chars()
                        .filter(c-> Character.isUpperCase(c))
                        .count();
        Assertions.assertEquals(numberOfUpperCaseLetters, actualUpperCount);
    }

    @DisplayName("소문자 개수 일치 테스트")
    @Test
    public void lowerCountTest(){
        long actualLowerCount = 0;
//        for(char c : randomPassword.toCharArray()){
//            if(Character.isLowerCase(c)){
//                actualLowerCount++;
//            }
//        }
        actualLowerCount = randomPassword.chars()
                        .filter(c -> Character.isLowerCase(c))
                        .count();
        Assertions.assertEquals(numberOfLowerCaseLetters, actualLowerCount);
    }

    @DisplayName("숫자 개수 일치 테스트")
    @Test
    public void numberCountTest(){
        long actualNumberCount = 0;
//        for(char c : randomPassword.toCharArray()){
//            if(Character.isDigit(c)){
//                actualNumberCount++;
//            }
//        }
        actualNumberCount = randomPassword.chars()
                        .filter(c -> Character.isDigit(c))
                        .count();
        Assertions.assertEquals(numberOfNumeric, actualNumberCount);
    }

    @DisplayName("특수 문자 개수 일치 테스트")
    @Test
    public void specialCountTest(){
        long actualSpecialCount = 0;
//        for(char c : randomPassword.toCharArray()){
//            if(!Character.isLetterOrDigit(c)){
//                actualSpecialCount++;
//            }
//        }
        actualSpecialCount = randomPassword.chars()
                .filter(c -> (c >= 33 && c<=47) || (c >=58 && c<=64) || (c>=91 && c<=96))
                .count();
        Assertions.assertEquals(numberOfSpecialChars, actualSpecialCount);
    }
}
