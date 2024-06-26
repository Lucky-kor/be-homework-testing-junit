package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.*;

public class RandomPasswordGeneratorTest {
    public static String password;

    @BeforeAll
    public static void init() {
        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        password =
                RandomPasswordGenerator.generate(2,5,2,1);
    }

    @DisplayName("임시 패스워드 길이 확인")
    @Test
    public void generatePasswordLengthTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        int expected = 10;

        int actual = password.length();

        Assertions.assertEquals(actual,expected);
    }

    @DisplayName("알파벳 대문자 개수 확인")
    @Test
    public void generatePasswordUppercaseLengthTest() {
        int upperCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            }
        }


        int actual = upperCount;
        int expected = 2;

        Assertions.assertEquals(actual,expected);
    }

    @DisplayName("알파벳 소문자 개수 확인")
    @Test
    public void generatePasswordLowercaseLengthTest() {
        int lowerCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCount++;
            }
        }
        int actual = lowerCount;
        int expected = 5;

        Assertions.assertEquals(actual,expected);
    }

    @DisplayName("숫자 개수 확인")
    @Test
    public void generatePasswordNumberTest() {
        int numberCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                numberCount++;
            }
        }
        int actual = numberCount;
        int expected = 2;

        Assertions.assertEquals(actual,expected);
    }

    @DisplayName("특수문자 개수 확인")
    @Test
    public void generatePasswordSpecialCharTest() {
        int specialCharCount = 0;
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                specialCharCount++;
            }
        }
        int actual = specialCharCount;
        int expected = 1;

        Assertions.assertEquals(actual,expected);
    }
}
