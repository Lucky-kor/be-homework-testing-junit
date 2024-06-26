package com.springboot.homework;

import com.springboot.helper.StampCalculator;
import com.springboot.order.entity.Order;
import com.springboot.order.entity.OrderCoffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StampCalculatorTest {
    @Test
    @DisplayName("실습1: 스탬프 카운트 계산 단위 테스트")
    public void calculateStampCountTest() {
        //given
        int nowCount = 5;
        int earned = 3;
        int expected = 7;

        //when
        int actual = StampCalculator.calculateStampCount(nowCount, earned);

        //then

        // 이렇게는 쓰면 안됨
        Assertions.assertTrue(expected == actual);

        //두 개의 값을 비교할 때에는 무조건! assertEquals.
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("실습1: 주문 후 누적 스탬프 카운트 계산 단위 테스트")
    public void calculateEarnedStampCountTest(){
        //given
        Order order = new Order();
        OrderCoffee orderCoffee1 = new OrderCoffee();
        orderCoffee1.setQuantity(3);
        OrderCoffee orderCoffee2 = new OrderCoffee();
        orderCoffee2.setQuantity(5);
        order.setOrderCoffees(List.of(orderCoffee1, orderCoffee2));

        int expected = orderCoffee1.getQuantity() + orderCoffee2.getQuantity();

        //when
        int actual = StampCalculator.calculateEarnedStampCount(order);

        // then
        // 검증만 다름.
        assertEquals(expected, actual);
    }
}
