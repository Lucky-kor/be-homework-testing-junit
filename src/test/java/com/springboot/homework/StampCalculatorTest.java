package com.springboot.homework;

import com.springboot.helper.StampCalculator;
import com.springboot.order.entity.Order;
import com.springboot.order.entity.OrderCoffee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StampCalculatorTest {
    @Test
    @DisplayName("실습1: 스탬프 카운트 계산 단위 테스트")
    public void calculateStampCountTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        // given
        int nowCount = 5;
        int earned = 3;

        // when
        int actual = StampCalculator.calculateStampCount(nowCount, earned);

        // then
        int expected = 8;
        assertEquals(expected, actual, "현재 스탬프 수와 획득한 스탬프 수의 합이 올바르게 계산되어야 합니다.");

        System.out.println("테스트 결과: " + (expected == actual));
    }

    @Test
    @DisplayName("실습1: 주문 후 누적 스탬프 카운트 계산 단위 테스트")
    public void calculateEarnedStampCountTest(){
        // TODO 여기에 테스트 케이스를 작성해주세요.
        // given
        OrderCoffee coffee1 = new OrderCoffee();
        OrderCoffee coffee2 = new OrderCoffee();
        OrderCoffee coffee3 = new OrderCoffee();

        coffee1.setQuantity(2);
        coffee2.setQuantity(1);
        coffee3.setQuantity(3);

        Order order = new Order();
        order.addOrderCoffee(coffee1);
        order.addOrderCoffee(coffee2);
        order.addOrderCoffee(coffee3);

        // when
        int actualStampCount = StampCalculator.calculateEarnedStampCount(order);

        // then
        int expectedStampCount = 6;
        assertEquals(expectedStampCount, actualStampCount, "획득한 스탬프 수가 주문한 커피 수량의 합과 일치해야 합니다.");

        System.out.println("테스트 결과: " + (expectedStampCount == actualStampCount));
    }
}
