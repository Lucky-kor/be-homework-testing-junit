package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        //given
        int numberOfUpperCaseLetters = 3;
        int numberOfLowerCaseLetters = 7;
        int numberOfNumeric = 5;
        int numberOfSpecialChars = 1;
        int expected = numberOfUpperCaseLetters+numberOfLowerCaseLetters+numberOfNumeric+numberOfSpecialChars;

        //when
        String actual = RandomPasswordGenerator.generate(numberOfUpperCaseLetters,numberOfLowerCaseLetters,numberOfNumeric,numberOfSpecialChars);

        //then
        Pattern upper = Pattern.compile("[A-Z]");
        Pattern lower = Pattern.compile("[a-z]");
        Pattern number = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[!\"#$%&'()*+,-./]");

        Matcher upperMatcher = upper.matcher(actual);
        Matcher lowerMatcher = lower.matcher(actual);
        Matcher numberMatcher = number.matcher(actual);
        Matcher specialMatcher = special.matcher(actual);

        int countUpperCaseLetters = count(upperMatcher);
        int countLowerCaseLetters = count(lowerMatcher);
        int countNumeric = count(numberMatcher);
        int countSpecialChars = count(specialMatcher);

        Assertions.assertEquals(expected,actual.length());
        Assertions.assertEquals(countUpperCaseLetters,numberOfUpperCaseLetters);
        Assertions.assertEquals(countLowerCaseLetters,numberOfLowerCaseLetters);
        Assertions.assertEquals(countNumeric,numberOfNumeric);
        Assertions.assertEquals(countSpecialChars,numberOfSpecialChars);

    }
    public int count(Matcher matcher){
        int result = 0;
        while (matcher.find()){
            result++;
        }
        return result;
    }
}
