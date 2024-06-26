package com.springboot.helper;

import com.springboot.order.entity.Order;
import com.springboot.order.entity.OrderCoffee;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StampCalculatorTest {

    @Test
    @DisplayName("CalculateStampCount_Test")
    void calculateStampCount() {
        int nowCount = 2;
        int earned = 5;

        int result = StampCalculator.calculateStampCount(nowCount,earned);
        int test_result = 7;

        assertEquals(result,test_result);
    }

    @Test
    @DisplayName("calculateEarnedStampCount_Test")
    void calculateEarnedStampCount() {
        Order order = new Order();
        OrderCoffee orderCoffee1 = new OrderCoffee();
        OrderCoffee orderCoffee2 = new OrderCoffee();
        orderCoffee1.setQuantity(3);
        orderCoffee2.setQuantity(5);
        order.setOrderCoffees(List.of(orderCoffee1,orderCoffee2));

        int result = StampCalculator.calculateEarnedStampCount(order);
        int test_result = 8;

        assertEquals(result,test_result);
    }
}