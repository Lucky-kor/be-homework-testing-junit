package com.springboot.homework;

import com.springboot.HomeworkJunitApplication;
import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomPasswordGeneratorTest {
    int numberOfUpperCaseLetters =2;
    int numberOfLowerCaseLetters = 5;
    int numberOfNumeric = 2;
    int numberOfSpecialChars =1;
    String actual =   RandomPasswordGenerator.generate(numberOfUpperCaseLetters,numberOfLowerCaseLetters,numberOfNumeric
            ,numberOfSpecialChars);

    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        //given

      int expected = 10 ;

      //whe
        // then
        Assertions.assertEquals(expected,actual.length());
    }

    @Test
    @DisplayName("대문자의 개수 구하기")
    public void upperCaseNum(){

        //given
       int expected =5;
        int count =0;
        for (int i = 0; i < actual.length() ; i++) {
            if (actual.charAt(i)> 96 && actual.charAt(i)< 123){
                count++;
            }
        }
        Assertions.assertEquals(expected, count);
        //when
        //then
    }

    @Test
    @DisplayName("소문자의 개수 구하기")
    public void LowerCaseNum(){

        //given
        int expected =2;
        int count =0;
        for (int i = 0; i < actual.length() ; i++) {
            if (actual.charAt(i)> 64 && actual.charAt(i)< 91){
                count++;
            }
        }
        Assertions.assertEquals(expected, count);
        //when
        //then
    }

    @Test
    @DisplayName("특수문자 개수 구하기")
    public  void  numberOfSpecialChars() {
        int expected = 1;
        int count = 0;
        for (int i = 0; i < actual.length(); i++) {
            char c = actual.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                count++;
            }
        }
        Assertions.assertEquals(expected, count);


    }

//Character isDigt 은 숫자인 것 고르는 것  //문자열에서 위에개수 빼면 특수기호 일 수 있다.
    @Test
    @DisplayName("숫자의 개수는")
    public void numberOfNumeric() {
        int expected = 2;
        int count = 0;
        for (int i = 0; i < actual.length(); i++) {
            char c = actual.charAt(i);
            if (Character.isDigit(c)) {
                count++;
            }
         } Assertions.assertEquals(expected,count);



    }}


