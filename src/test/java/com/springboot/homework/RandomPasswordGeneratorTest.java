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
        //given
        int numberOfUpperCaseLetters = 2;
        int numberOfLowerCaseLetters = 5;
        int numberOfNumeric = 2;
        int numberOfSpecialChars = 1;

        int expectedPasswordLength = numberOfUpperCaseLetters +
                numberOfLowerCaseLetters +
                numberOfNumeric +
                numberOfSpecialChars;
        //when

        String currentPassword = RandomPasswordGenerator.generate(
                numberOfUpperCaseLetters,
                numberOfLowerCaseLetters,
                numberOfNumeric,
                numberOfSpecialChars);
        //then

        Assertions.assertEquals(expectedPasswordLength, currentPassword.length());


        //given

        int numberOfUpperCaseLettersCount = 0;
        int numberOfLowerCaseLettersCount = 0;
        int numberOfNumericCount = 0;
        int numberOfSpecialCharsCount = 0;
        //when

        for(int i = 0; i < currentPassword.length(); i++){
            if(65 <= currentPassword.charAt(i) && currentPassword.charAt(i) <= 90){
                numberOfUpperCaseLettersCount++;
            }
            else if(97 <= currentPassword.charAt(i) && currentPassword.charAt(i) <= 122){
                numberOfLowerCaseLettersCount++;
            }
            else if(33 <= currentPassword.charAt(i) && currentPassword.charAt(i) <= 47){
                numberOfSpecialCharsCount++;
            }
            else{
                numberOfNumericCount++;
            }
        }
        //then

        Assertions.assertEquals(2, numberOfUpperCaseLettersCount);
        Assertions.assertEquals(5, numberOfLowerCaseLettersCount);
        Assertions.assertEquals(2, numberOfNumericCount);
        Assertions.assertEquals(1, numberOfSpecialCharsCount);
    }



}
