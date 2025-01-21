package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        int actual = 10;
        int expected = RandomPasswordGenerator.generate(2,3,3,2).length();


        assertEquals(actual,expected);
    }
    @DisplayName("생성된 패스워드의 '알파벳 대문자' 개수")
    @Test
    public void generateTest2() {
        String passWord = RandomPasswordGenerator.generate(2,3,3,2);

        int expected = (int)passWord.chars().filter(e -> Character.isUpperCase(e)).count();
        int acutal = 2;

        assertEquals(expected,acutal);
    }
    @DisplayName("생성된 패스워드의 '알파벳 소문자' 개수")
    @Test
    public void generateTest3() {
        String passWord = RandomPasswordGenerator.generate(2,3,3,2);

        int expected = (int)passWord.chars().filter(e -> Character.isLowerCase(e)).count();
        int acutal = 3;

        assertEquals(expected,acutal);
    }
    @DisplayName("생성된 패스워드의 '숫자' 개수")
    @Test
    public void generateTest4() {
        String passWord = RandomPasswordGenerator.generate(2,3,3,2);

        int expected = (int)passWord.chars().filter(e -> Character.isDigit(e)).count();
        int acutal = 3;

        assertEquals(expected,acutal);
    }
    @DisplayName("생성된 패스워드의 '특수문자' 개수")
    @Test
    public void generateTest5() {
        String passWord = RandomPasswordGenerator.generate(2,3,3,2);

        int expected = (int)passWord.chars().filter(e -> !Character.isLetterOrDigit(e)).count();
        int acutal = 2;

        assertEquals(expected,acutal);
    }
}
