package com.springboot.homework;

import com.springboot.helper.StampCalculator;
import com.springboot.order.entity.Order;
import com.springboot.order.entity.OrderCoffee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StampCalculatorTest {
    @Test
    @DisplayName("실습1: 스탬프 카운트 계산 단위 테스트")
    public void calculateStampCountTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.

        int actual = 7;
        int expected = StampCalculator.calculateStampCount(3,4);

        assertEquals(actual, expected);

    }

    @Test
    @DisplayName("실습1: 주문 후 누적 스탬프 카운트 계산 단위 테스트")
    public void calculateEarnedStampCountTest(){
        // TODO 여기에 테스트 케이스를 작성해주세요.

        OrderCoffee orderCoffee = new OrderCoffee();
        orderCoffee.setQuantity(3);

        OrderCoffee orderCoffee2 = new OrderCoffee();
        orderCoffee2.setQuantity(6);

        List<OrderCoffee> orderCoffees = new ArrayList<>();
        orderCoffees.add(orderCoffee);
        orderCoffees.add(orderCoffee2);

        Order order = new Order();
        order.setOrderCoffees(orderCoffees);

        int actual = StampCalculator.calculateEarnedStampCount(order);
        int expected = 9;

        assertEquals(expected, actual);

    }
}
