package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomPasswordGeneratorTest {
    private static String generatedPassword;
    private static int numberOfUpperCaseLetters;
    private static int numberOfLowerCaseLetters;
    private static int numberOfNumerics;
    private static int numberOfSpecialLetters;

    @BeforeAll
    public static void init(){
        numberOfUpperCaseLetters = 2;
        numberOfLowerCaseLetters = 5;
        numberOfNumerics = 2;
        numberOfSpecialLetters = 1;
        generatedPassword = RandomPasswordGenerator.generate(numberOfUpperCaseLetters,numberOfLowerCaseLetters,numberOfNumerics,numberOfSpecialLetters);
    }
    @DisplayName("길이 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        // given
        int expected = numberOfUpperCaseLetters + numberOfLowerCaseLetters + numberOfNumerics + numberOfSpecialLetters;
        // when
        int actual = generatedPassword.length();
        // then
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("알파벳 대문자 개수")
    public void numberOfUpperCaseTest(){
        // given
        int expected = numberOfUpperCaseLetters;
        // when
        /*int actual = 0;
        for(int i = 0; i< generatedPassword.length(); i++){
            if(Character.isUpperCase(generatedPassword.charAt(i))){
                actual ++;
            }
        }*/
        int actual = (int) generatedPassword.chars()
                .filter(c -> Character.isUpperCase(c))
                .count();
        // then
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("알파벳 소문자 개수")
    public void numberOfLowerCaseTest(){
        // given
        int expected = numberOfLowerCaseLetters;
        // when
        /*int actual = 0;
        for(int i = 0; i< generatedPassword.length(); i++){
            if(Character.isLowerCase(generatedPassword.charAt(i))){
                actual ++;
            }
        }*/
        int actual = (int) generatedPassword.chars()
                .filter(c -> Character.isLowerCase(c))
                .count();
        // then
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("0이상인 숫자의 개수")
    public void numberOfNumericTest(){
        // given
        int expected = numberOfNumerics;
        // when
        /*int actual = 0;
        for(int i = 0; i< generatedPassword.length(); i++){
            if(Character.isDigit(generatedPassword.charAt(i))){
                actual++;
            }
        }*/
        int actual = (int) generatedPassword.chars()
                .filter(c -> Character.isDigit(c))
                .count();
        // then
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("특수문자 개수")
    public void numberOfSpecialLettersTest(){
        // given
        int expected = numberOfSpecialLetters;
        // when
        /*int actual = 0;
        for(int i = 0; i< generatedPassword.length(); i++){
            if(!Character.isLetterOrDigit(generatedPassword.charAt(i))){
                actual ++;
            }
        }*/
        int actual = (int) generatedPassword.chars()
                .filter(c -> !Character.isLetterOrDigit(c))
                .count();
        // then
        Assertions.assertEquals(expected, actual);
    }
}
