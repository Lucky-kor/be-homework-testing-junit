package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        //given

        //when

        //then

        int expectUpperLengthCnt = new Random().nextInt(5);
        int expectLowerCaseCnt = new Random().nextInt(5);
        int expectNumCnt = new Random().nextInt(5);;
        int expectSpecialCnt = new Random().nextInt(5);
        int expectLeght = expectUpperLengthCnt + expectLowerCaseCnt + expectNumCnt + expectSpecialCnt;

        String result = RandomPasswordGenerator.generate(expectUpperLengthCnt, expectLowerCaseCnt, expectNumCnt, expectSpecialCnt);

        //생성된 패스워드의 길이가 입력한 파라미터 숫자의 합과 일치하는지 검증(Assertion)하세요.
        int actualLenght = result.length();
        Assertions.assertEquals(expectLeght, actualLenght);

        //생성된 패스워드의 ‘알파벳 대문자’ 개수가 입력한 파라미터(numberOfUpperCaseLetters ) 숫자와 일치하는지 검증하세요.
        int actualUpperLengthCnt = 0;
        for(int i = 0; i < result.length(); i++){
            if((int)result.charAt(i) >= 65 && (int)result.charAt(i) <= 90){
                actualUpperLengthCnt++;
            }
        }
        Assertions.assertEquals(expectUpperLengthCnt, actualUpperLengthCnt);

        //생성된 패스워드의 ‘알파벳 소문자’ 개수가 입력한 파라미터(numberOfLowerCaseLetters) 숫자와 일치하는지 검증하세요.
        int actualLowerLengthCnt = 0;
        for(int i = 0; i < result.length(); i++){
            if((int)result.charAt(i) >= 97 && (int)result.charAt(i) <= 122){
                actualLowerLengthCnt++;
            }
        }
        Assertions.assertEquals(expectLowerCaseCnt, actualLowerLengthCnt);

        //생성된 패스워드의 ‘0 이상인 숫자’의 개수가 입력한 파라미터(numberOfNumeric) 숫자와 일치하는지 검증하세요.
        int actualNumCnt = 0;
        for(int i = 0; i < result.length(); i++){
            if((int)result.charAt(i) >= 48 && (int)result.charAt(i) <= 57){
                actualNumCnt++;
            }
        }
        Assertions.assertEquals(expectNumCnt, actualNumCnt);

        //생성된 임시 패스워드의 ‘특수문자’ 개수가 입력한 파라미터(numberOfSpecialChars) 숫자와 일치하는지 검증하세요..
        int actualSpecialCnt = actualLenght - actualNumCnt - actualLowerLengthCnt - actualUpperLengthCnt;

        Assertions.assertEquals(expectSpecialCnt, actualSpecialCnt);

    }
}
