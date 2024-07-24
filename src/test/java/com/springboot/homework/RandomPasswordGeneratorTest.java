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
        // given
        int numberOfUpperCaseLetters = 2;
        int numberOfLowerCaseLetters = 5;
        int numberOfNumeric = 2;
        int numberOfSpecialChars = 1;

        // when
        String testPassword = RandomPasswordGenerator.generate(
                numberOfUpperCaseLetters,numberOfLowerCaseLetters,numberOfNumeric,numberOfSpecialChars);

        //then
        Assertions.assertEquals(10, testPassword.length());
        System.out.println(testPassword);
        // 위에 매개변수로 입력한 대문자의 개수가 맞게 들어갔는지 검증.
        // 스트림으로 열어서 필터링 -> 카운트
        // 필터로 대문자만 걸러내서 그 개수를 카운트.
        long findUpperWord =
                testPassword.chars()
                        .filter(Character::isUpperCase)
                        .count();
        Assertions.assertEquals(2, findUpperWord);

        // 소문자의 개수를 검증
        // 스트림열어서 문자열을 케릭터형으로 하니씩 쪼개서 소문자만 걸러서 카운팅.
        long findLowerWord =
                testPassword.chars()
                        .filter(Character::isLowerCase)
                        .count();
        Assertions.assertEquals(5, findLowerWord);

        long findNumber =
                testPassword.chars()
                        .filter(Character::isDigit) // 문자열에서 숫자 문자를 필터링 값 중 숫자(0-9)에 해당하는 값만 남깁. "ab12" -> '1', '2'
                        .map(c  -> c - '0') // 위에서 케릭터형으로 하나씩 쪼개놓은 숫자를, 실제 숫자로 변환. '1' -> 1
                        .filter(num -> num >= 0) // num >= 0 '0 이상인 숫자만 -> num에 할당'
                        .count(); // 0 이상인 숫자만 카운팅.
        Assertions.assertEquals(2, findNumber);

        String regex = "[ +!@#$%^&*()-,.\"':{}|]"; // 특수문자 검증 정규표현식
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(testPassword);
        int result = count(matcher);
        Assertions.assertEquals(result, numberOfSpecialChars);
    }

    // 개수만큼 카운팅 해주는 메서드
    public int count(Matcher matcher) {
        int result = 0;
        while (matcher.find()){
            result++;
        }
        return result;
    }
}
// for문을 이용한 대문자 개수 찾고, 검증하기
//int findUpperCount = 0;
//chat[] charArr = currentPassword.toChatArray();
//for(char c : chatArr) {
//    if(Character.isUpperCase(c)) findUpperCount++;
//}
//Assertions.assertEquals(findUpperCount, numberOfUpperCaseLetters);
