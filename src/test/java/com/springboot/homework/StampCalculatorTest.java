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
//        give 준비
        int nowCount = 3;
        int earned = 5;
//        when 실행
//        실제 실행되는 로직
        int actual = StampCalculator.calculateStampCount(nowCount, earned);
        int expected = 8;
//        then 검증
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("실습2: 주문 후 누적 스탬프 카운트 계산 단위 테스트")
    public void calculateEarnedStampCountTest(){
//        given 준비
        Order order = new Order();

        OrderCoffee orderCoffee1 = new OrderCoffee();
        orderCoffee1.setQuantity(4);

        OrderCoffee orderCoffee2 = new OrderCoffee();
        orderCoffee2.setQuantity(2);

        order.setOrderCoffees(List.of(orderCoffee1,orderCoffee2));

//        when 실행
        int actual = StampCalculator.calculateEarnedStampCount(order);
        int expected = orderCoffee1.getQuantity() + orderCoffee2.getQuantity();

//        then 검증
        assertEquals(expected, actual);
    }
}
