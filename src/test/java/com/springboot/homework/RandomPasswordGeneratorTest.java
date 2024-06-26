package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class RandomPasswordGeneratorTest {

    static RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
    static String randomString;
    @BeforeAll
    public static void init(){
        randomString = randomPasswordGenerator.generate(
                2, 5, 2, 1);
    }


    @DisplayName("실습 3")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        //given
        int numberOfUpperCaseLetters = 2;
        int numberOfLowerCaseLetters = 5;
        int numberOfNumeric = 2;
        int numberOfSpecialChars = 1;

        int expectedLength = 10;
        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;
        int specialCount = 0;


//        long upperCount = randomString.chars()
//                .filter(Character :: isUpperCase)
//                .count();
//        long lowerCount = randomString.chars()
//                .filter(Character :: isLowerCase)
//                .count();
//        long digitCount = randomString.chars()
//                .filter(Character :: isDigit)
//                .count();
//        long specialCount = randomString.chars()
//                .filter(c -> !Character.isLetterOrDigit(c))
//                .count();

        //when
        char[] charArr = randomString.toCharArray();
        for(char c: charArr){
            //대문자일 경우
            if(Character.isUpperCase(c)) upperCount++;
            else if(Character.isLowerCase(c)) lowerCount++;
            else if(Character.isDigit(c)) digitCount++;
            else if(!Character.isLetterOrDigit(c)) specialCount++;
        }


//        for(int i=0; i<randomString.length(); i++){
//            if(randomString.charAt(i) >= 65 && (int)randomString.charAt(i) <= 90){
//                upperCount++;
//            }
//            else if(randomString.charAt(i) >= 97 && (int)randomString.charAt(i) <= 122){
//                lowerCount++;
//            }
//            else if(randomString.charAt(i) >=48 && (int)randomString.charAt(i)<=57){
//                digitCount++;
//            }
//            else specialCount++;
//        }
        //test
        Assertions.assertEquals(expectedLength, randomString.length());
        Assertions.assertEquals(upperCount, numberOfUpperCaseLetters);
        Assertions.assertEquals(lowerCount, numberOfLowerCaseLetters);
        Assertions.assertEquals(digitCount, numberOfNumeric);
        Assertions.assertEquals(specialCount, numberOfSpecialChars);
    }
}