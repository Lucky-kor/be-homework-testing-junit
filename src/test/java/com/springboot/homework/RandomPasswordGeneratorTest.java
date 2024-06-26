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
        int numberOfNumeric= 2; //0 이상의 숫자개수
        int numberOfUpperCaseLetters=3;
        int numberOfLowerCaseLetters=4;
        int numberOfSpecialChars=1; //특수문자 1개
        int length = numberOfLowerCaseLetters+numberOfNumeric+numberOfUpperCaseLetters+numberOfSpecialChars;

        //when
        String password = RandomPasswordGenerator.generate(numberOfUpperCaseLetters,numberOfLowerCaseLetters,numberOfNumeric,numberOfSpecialChars);

        //then
        Assertions.assertEquals(length, password.length());
        Assertions.assertEquals(countOfLower(password),numberOfLowerCaseLetters);
        Assertions.assertEquals(countOfUpper(password),numberOfUpperCaseLetters);
        Assertions.assertEquals(countOfNumber(password), numberOfNumeric);
        Assertions.assertEquals(countOfSpecial(password),numberOfSpecialChars);

    }

    private int countOfUpper(String password){
//        int count = 0;
//        for(char c: password.toCharArray()){
//            if (Character.isUpperCase(c)) {
//                count++;
//            }
//        }
//      return count;
        return (int) password.chars().filter(Character::isUpperCase).count();

    }

    private int countOfLower(String password){
//        int count=0;
//        for(char c: password.toCharArray()){
//            if(Character.isLowerCase(c)){
//                count++;
//            }
//        }
//        return count;
        return (int) password.chars().filter(Character::isLowerCase).count();
    }

    private int countOfNumber(String password){
//        int count =0;
//        String number="123456789";
//        for(char c : password.toCharArray()){
//            if(number.indexOf(c)!=-1){
//                count++;
//            }
//        }
//        return count;
        return (int) password.chars().filter(Character::isDigit).count();
    }

    private int countOfSpecial(String password){
        return (int) password.chars().filter( c -> !Character.isLetterOrDigit(c)).count();
    }

}

