package com.springboot.homework;

import com.springboot.helper.StampCalculator;
import com.springboot.order.entity.Order;
import com.springboot.order.entity.OrderCoffee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StampCalculatorTest {
    @Test
    @DisplayName("실습1: 스탬프 카운트 계산 단위 테스트")
    public void calculateStampCountTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        //given :
        int nowCount = 10;
        int earned = 3;

        //when :
        int actual = StampCalculator.calculateStampCount(nowCount, earned);
        int expected = 13;

        //then
        System.out.println(expected == actual);
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("실습1: 주문 후 누적 스탬프 카운트 계산 단위 테스트")
    public void calculateEarnedStampCountTest(){
        // TODO 여기에 테스트 케이스를 작성해주세요.
        //given
        Order order = new Order();
        OrderCoffee orderCoffee1 = new OrderCoffee();
        orderCoffee1.setQuantity(50);

        OrderCoffee orderCoffee2 = new OrderCoffee();
        orderCoffee2.setQuantity(5);

        order.setOrderCoffees(List.of(orderCoffee1, orderCoffee2));

        //when
        int expected = orderCoffee1.getQuantity() + orderCoffee2.getQuantity();
        int actual = 52;

        //then
        System.out.println(expected == actual);
        assertEquals(expected, actual);
    }
}
